package com.junkj.module.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.jfinal.kit.HashKit;
import com.jfinal.kit.HttpKit;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.JsTicket;
import com.jfinal.weixin.sdk.api.JsTicketApi;
import com.jfinal.weixin.sdk.api.PaymentApi;
import com.jfinal.weixin.sdk.api.SnsAccessToken;
import com.jfinal.weixin.sdk.api.SnsAccessTokenApi;
import com.jfinal.weixin.sdk.api.SnsApi;
import com.jfinal.weixin.sdk.kit.PaymentKit;
import com.junkj.common.IdGen.IdGenerate;
import com.junkj.common.action.BaseAction;
import com.junkj.common.config.Global;
import com.junkj.common.lang.DateUtils;
import com.junkj.common.lang.ObjectUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.common.utils.IpUtils;
import com.junkj.common.utils.JsonUtils;
import com.junkj.common.utils.MemberUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.cash.biz.CashMoneyBiz;
import com.junkj.module.cash.entity.CashMoney;
import com.junkj.module.company.biz.ActivityBiz;
import com.junkj.module.company.biz.ActivityEnrollBiz;
import com.junkj.module.company.biz.CardsBiz;
import com.junkj.module.company.biz.ComMemberBiz;
import com.junkj.module.company.entity.Activity;
import com.junkj.module.company.entity.ActivityEnroll;
import com.junkj.module.company.entity.Cards;
import com.junkj.module.company.entity.ComMember;
import com.junkj.module.file.utils.FileUploadUtils;
import com.junkj.module.member.biz.MemberBiz;
import com.junkj.module.member.biz.MemberCardBiz;
import com.junkj.module.member.entity.Member;
import com.junkj.module.sys.biz.SysPayBiz;
import com.junkj.module.sys.entity.SysPay;
import com.junkj.module.weixin.biz.WxUserBiz;
import com.junkj.module.weixin.entity.WxConfig;
import com.junkj.module.weixin.entity.WxUser;

@Controller
@RequestMapping(value = "${wxPath}")
public class WeiXinAction extends BaseAction {

	@Autowired
	private ActivityBiz activityBiz;
	@Autowired
	private CardsBiz cardsBiz;
	@Autowired
	private SysPayBiz sysPayBiz;
	@Autowired
	private ActivityEnrollBiz activityEnrollBiz;
	@Autowired
	private MemberCardBiz memberCardBiz;
	@Autowired
	private MemberBiz memberBiz;
	@Autowired
	private ComMemberBiz comMemberBiz;
	@Autowired
	private WxUserBiz wxUserBiz;
	@Autowired
	private CashMoneyBiz cashMoneyBiz;

	/**
	 * 活动
	 */
	private static final String PAY_ACTIVITY = "activity";
	/**
	 * 会员卡
	 */
	private static final String PAY_CARDS = "cards";

	// 微信用户登录
	@RequestMapping(value = "/isLogin", method = RequestMethod.GET)
	@ResponseBody
	public JsonVo isLogin(String state) {
		if (Global.isDev()) {
			WxUser user = MemberUtils.getWxUser(Global.devUser());
			MemberUtils.setWxUser(user);
			return sendOk();
		}
		String openid = MemberUtils.getOpenid();
		if (null == openid) {
			return sendError(402, "登录失效2");
		}
		return sendOk();
	}

	// 微信用户登录
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String oauth2(HttpServletRequest request, String state) {
		WxConfig c = ComUtils.getWxConfig();
		if (c == null) {
			return sendRedirect("/404");
		}

		String redirect_uri = ComUtils.getMobileUrl("/wx/code/" + c.getComId());
		String redirect = SnsAccessTokenApi.getAuthorizeURL(c.getAppid(), redirect_uri, state, false);
		return sendRedirect(redirect);
	}

	// 微信用户信息
	@RequestMapping(value = "code/{comId}", method = RequestMethod.GET)
	public String code(HttpServletRequest request, @PathVariable String comId, String code, String state) {
		ComUtils.setComId(comId);

		String redirect_uri = ComUtils.getComUrl("/wx/getUserInfo/" + comId + "?code=" + code + "&state=" + state);
		return sendRedirect(redirect_uri);
	}

	// 微信用户信息
	@RequestMapping(value = "getUserInfo/{comId}", method = RequestMethod.GET)
	public String getUserInfo(HttpServletRequest request, @PathVariable String comId, String code, String state) {
		ComUtils.setComId(comId);

		WxConfig c = ComUtils.getWxConfig();
		if (c == null) {
			return sendRedirect(state, "loginError=企业公众号未配置");
		}
		String appid = c.getAppid();
		String appsecret = c.getAppsecret();

		// 获取token
		SnsAccessToken token = SnsAccessTokenApi.getSnsAccessToken(appid, appsecret, code);
		if (token.getErrorCode() == null) {
			String openId = token.getOpenid();
			WxUser user = wxUserBiz.get(openId);
			if (user == null) {
				// 获取用户信息
				ApiResult apiResult = SnsApi.getUserInfo(token.getAccessToken(), token.getOpenid());
				if (apiResult.isSucceed()) {
					user = JsonUtils.toObject(apiResult.getJson(), WxUser.class);
					user.setAppid(appid);
					user.setCompanyId(comId);
					// user.setNickname(EmojiParser.parseToAliases(user.getNickname()));
					user.setNickname(user.getNickname());
					user.setCreateTime(DateUtils.getNow());
					user.setUpdateTime(user.getCreateTime());

					// 保存会员
					String memberId = createMember(user, comId);

					// 保存wxUser
					user.setMemberId(memberId);
					wxUserBiz.insert(user);

					String headimgurl = user.getHeadimgurl();
					new Thread() {
						public void run() {
							try {
								String headImg = null;
								if (StrUtils.notBlank(headimgurl)) {
									headImg = FileUploadUtils.downloadImg(headimgurl);
								}
								// 更新微信用户
								WxUser update = new WxUser();
								update.setOpenid(openId);
								update.setHeadImg(headImg);
								wxUserBiz.update(update);
							} catch (Exception e) {
								logger.error("获取微信用户头像失败", e);
							}
						}
					}.start();
				}
			} else {
				if (StrUtils.isBlank(user.getMemberId())) {
					// 保存会员
					String memberId = createMember(user, comId);

					// 保存wxUser
					user.setMemberId(memberId);
					wxUserBiz.update(user);

				} else {
					ComMember where = new ComMember();
					where.setComId(c.getComId());
					where.setMemberId(user.getMemberId());
					where = comMemberBiz.get(where);
					if (where == null) {
						// 保存企业关联
						ComMember cm = new ComMember();
						cm.setComId(c.getComId());
						cm.setMemberId(user.getMemberId());
						cm.setLevelId("0");
						cm.setPoints(0L);
						cm.setSource(ComMember.SOURCE_2);
						cm.setCreateTime(new Date());
						cm.setUpdateTime(cm.getCreateTime());
						comMemberBiz.insert(cm);
					}
				}

			}
			if (user != null) {
				MemberUtils.setWxUser(user);
				return sendRedirect(state);
			}
		}
		return sendRedirect(state, "&error=" + token.getErrorMsg());
	}

	private String createMember(WxUser user, String comId) {
		// 保存会员
		Member member = new Member();
		member.setOpenId(user.getOpenid());
		member.setName(user.getNickname());
		member.setSex(ObjectUtils.toString(user.getSex()));
		member.preInsert();
		memberBiz.insert(member);

		// 保存企业关联
		ComMember cm = new ComMember();
		cm.setComId(comId);
		cm.setMemberId(member.getId());
		cm.setLevelId("0");
		cm.setPoints(0L);
		cm.setSource(ComMember.SOURCE_2);
		cm.setCreateTime(new Date());
		cm.setUpdateTime(cm.getCreateTime());
		comMemberBiz.insert(cm);

		return member.getId();
	}

	/**
	 * 支付=-/
	 */
	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Object wxPay(HttpServletRequest request, HttpServletResponse response, String url, String data)
			throws IOException {
		data = HtmlUtils.htmlUnescape(data);
		Map<String, Object> map = JsonUtils.toObject(data, Map.class);
		// 业务id
		String bizId = map.get("id").toString();
		// 支付金额
		Double payMoney = 0d;
		// 订单描述
		String body = "";
		// 活动支付/会员卡支付
		if (PAY_ACTIVITY.equals(map.get("type"))) {
			Activity activity = activityBiz.get(bizId);
			// 活动报名验证
			ActivityEnroll activityEnroll = new ActivityEnroll();
			activityEnroll.setActivityId(bizId);
			activityEnroll.setMemberId(MemberUtils.getMemberId());
			activityEnroll.setEnrollTime(DateUtils.getNow());
			JsonVo vo = activityEnrollBiz.activityEnrollCheck(activityEnroll, activity);
			if (!"1".equals(vo.get("code").toString())) {
				return vo;
			}
			// 等位处理
			if (ActivityEnroll.ENROLLSTATUS_4.equals(activityEnroll.getEnrollStatus())) {
				activityEnroll.setPayState(ActivityEnroll.PAY_STATE_1);
				activityEnrollBiz.saveActivityEnroll(activityEnroll);
				return sendError(3, "报名等位成功,等位序号为：" + activityEnroll.getWaitNum());
			}
			// 价格0直接报名成功
			payMoney = activity.getMoney();
			if (payMoney == 0) {
				activityEnroll.setPayState(ActivityEnroll.PAY_STATE_2);
				activityEnrollBiz.saveActivityEnroll(activityEnroll);
				// 活动价格0添加消费
				CashMoney cashMoney = new CashMoney();
				cashMoney.setBizId(activityEnroll.getId());
				cashMoney.setBizType(CashMoney.BIZTYPE_COM_ACTIVITY_ENROLL);
				cashMoney.setMoney(payMoney);
				cashMoney.setBuyType(CashMoney.BUYTYPE_43);
				cashMoney.setType(CashMoney.TYPE_4);
				cashMoneyBiz.save(cashMoney);
				return sendError(3, "报名成功");
			}

			// 店面支付直接报名成功
			String mode = map.get("mode").toString();
			if (Activity.PAY_STATUS_2.equals(mode)) {
				activityEnroll.setPayState(ActivityEnroll.PAY_STATE_1);
				activityEnrollBiz.saveActivityEnroll(activityEnroll);
				// 活动到店支付添加消费
				CashMoney cashMoney = new CashMoney();
				cashMoney.setBizId(activityEnroll.getId());
				cashMoney.setBizType(CashMoney.BIZTYPE_COM_ACTIVITY_ENROLL);
				cashMoney.setMoney(payMoney);
				cashMoney.setBuyType(CashMoney.BUYTYPE_13);
				cashMoney.setType(CashMoney.TYPE_1);
				cashMoneyBiz.save(cashMoney);
				return sendError(3, "报名成功");
			}
			body = "活动报名费：" + activity.getName();
		} else if (PAY_CARDS.equals(map.get("type"))) {
			// 会员卡购买
			Cards cards = cardsBiz.get(bizId);
			payMoney = cards.getMoney();

			body = "会员卡购买：" + cards.getName();
		}

		String payCode = IdGenerate.uuid();

		WxConfig c = ComUtils.getWxConfig();
		if (c == null) {
			return sendError("企业公众号未配置");
		}
		String appid = c.getAppid();// appid
		String appsecret = c.getAppsecret();// appsecret
		String mchId = c.getMchId();// 商户号
		String mchKey = c.getMchKey();// 商秘钥
		String openid = MemberUtils.getOpenid();// 会员openid
		Double total_fee = payMoney * 100; // 订单金额
		String webPath = "http://" + Global.mobileUri() + "/wx/payBack/" + c.getComId() + "/" + map.get("type");// 回调地址

		Map<String, String> params = new HashMap<String, String>();
		params.put("appid", appid);
		params.put("mch_id", mchId);
		params.put("body", body);
		params.put("out_trade_no", payCode);
		params.put("total_fee", total_fee.intValue() + "");
		params.put("spbill_create_ip", IpUtils.getRealIp(request));
		params.put("trade_type", PaymentApi.TradeType.JSAPI.name());
		params.put("nonce_str", IdGenerate.uuid());
		params.put("notify_url", webPath);
		params.put("openid", openid);

		// 生成签名
		String sign = PaymentKit.createSign(params, mchKey);
		params.put("sign", sign);
		// 统一下单
		String xmlResult = PaymentApi.pushOrder(params);
		// 返回结果
		Map<String, String> result = PaymentKit.xmlToMap(xmlResult);
		String return_code = result.get("return_code");
		if (StrUtils.isBlank(return_code) || !"SUCCESS".equals(return_code)) {
			String return_msg = result.get("return_msg");
			return sendError(return_msg);
		}
		String result_code = result.get("result_code");
		if (StrUtils.isBlank(result_code) || !"SUCCESS".equals(result_code)) {
			String err_code_des = result.get("err_code_des");
			return sendError(err_code_des);
		}

		// 微信支付单号
		String prepay_id = result.get("prepay_id");

		SysPay where = new SysPay();
		where.setPayId(prepay_id);
		SysPay pay = sysPayBiz.getByEntity(where);
		if (pay == null) {
			pay = new SysPay();
			if (PAY_ACTIVITY.equals(map.get("type"))) {
				pay.setBizType(SysPay.BIZ_TYPE_HD);
			} else if (PAY_CARDS.equals(map.get("type"))) {
				pay.setBizType(SysPay.BIZ_TYPE_KA);
			}
			// 创建支付记录
			pay.setMemberId(MemberUtils.getMemberId());
			pay.setPayId(prepay_id);
			pay.setBizId(bizId);
			pay.setPayCode(payCode);
			pay.setPayMoney(payMoney);
			pay.setPayType(SysPay.PAY_TYPE_1);
			pay.setPayStatus(SysPay.PAY_STATUS_1);
			pay.setCreateTime(new Date());
			sysPayBiz.save(pay);
		}

		String timeStamp = System.currentTimeMillis() / 1000 + "";
		String nonceStr = IdGenerate.uuid();

		Map<String, String> packageParams = new HashMap<String, String>();
		packageParams.put("appId", appid);
		packageParams.put("timeStamp", timeStamp);
		packageParams.put("nonceStr", nonceStr);
		packageParams.put("package", "prepay_id=" + prepay_id);
		packageParams.put("signType", "MD5");

		// 生成签名
		String paySign = PaymentKit.createSign(packageParams, mchKey);
		packageParams.put("paySign", paySign);

		// wx.config 签名
		String signature = getSignature(appid, appsecret, url, nonceStr, timeStamp);
		packageParams.put("signature", signature);

		return sendData(packageParams);
	}

	// wx.config 签名
	public String getSignature(String appId, String appsecret, String url, String noncestr, String timeStamp) {
		ApiConfig ac = new ApiConfig();
		ac.setAppId(appId);
		ac.setAppSecret(appsecret);
		ApiConfigKit.putApiConfig(ac);

		ApiConfigKit.setThreadLocalAppId(appId);
		String _wxJsApiTicket = "";
		try {
			JsTicket jsTicket = JsTicketApi.getTicket(JsTicketApi.JsApiType.jsapi);
			_wxJsApiTicket = jsTicket.getTicket();
		} finally {
			ApiConfigKit.removeThreadLocalAppId();
		}

		Map<String, String> _wxMap = new TreeMap<String, String>();
		_wxMap.put("noncestr", noncestr);
		_wxMap.put("timestamp", timeStamp);
		_wxMap.put("jsapi_ticket", _wxJsApiTicket);
		_wxMap.put("url", url);
		// 加密获取signature
		StringBuilder _wxBaseString = new StringBuilder();
		for (Entry<String, String> param : _wxMap.entrySet()) {
			_wxBaseString.append(param.getKey()).append("=").append(param.getValue()).append("&");
		}
		String _wxSignString = _wxBaseString.substring(0, _wxBaseString.length() - 1);
		return HashKit.sha1(_wxSignString);

	}

	// 商品支付成功通知
	@RequestMapping(value = "/payBack/{comId}/{type}", method = RequestMethod.POST)
	public void pay_goods_back(HttpServletRequest request, HttpServletResponse response, @PathVariable String comId,
			@PathVariable String type) throws IOException {
		ComUtils.setComId(comId);

		// 支付结果通用通知文档:
		// https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7
		String xmlMsg = HttpKit.readData(request);

		Map<String, String> params = PaymentKit.xmlToMap(xmlMsg);

		String result_code = params.get("result_code");
		// 微信订单号
		String wxId = params.get("transaction_id");
		// 商户订单号
		String payCode = params.get("out_trade_no");

		// 注意重复通知的情况，同一订单号可能收到多次通知，请注意一定先判断订单状态
		// 避免已经成功、关闭、退款的订单被再次更新

		WxConfig c = ComUtils.getWxConfig();
		String partnerkey = c.getMchKey();

		/**
		 * 消费模板消息
		 */
		PrintWriter out = response.getWriter();
		if (PaymentKit.verifyNotify(params, partnerkey)) {
			if (("SUCCESS").equals(result_code)) {
				// 支付回调处理
				if (PAY_ACTIVITY.equals(type)) {
					activityEnrollBiz.payBack(payCode, wxId);

				} else if (PAY_CARDS.equals(type)) {
					memberCardBiz.payBack(payCode, wxId);
				}

				Map<String, String> xml = new HashMap<String, String>();
				xml.put("return_code", "SUCCESS");
				xml.put("return_msg", "OK");
				out.print(PaymentKit.toXml(xml));
				out.close();
				return;
			}
		}
		out.print("");
		out.close();
	}

}
