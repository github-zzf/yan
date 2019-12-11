package com.junkj.common.utils;

import org.apache.shiro.session.Session;

import com.junkj.common.exception.SpringUtils;
import com.junkj.module.member.biz.MemberBiz;
import com.junkj.module.member.entity.Member;
import com.junkj.module.weixin.biz.WxUserBiz;
import com.junkj.module.weixin.entity.WxUser;

/**
 * 获取request、session中的会员数据
 */
public class MemberUtils {

	private static MemberBiz memberBiz = SpringUtils.getBean(MemberBiz.class);
	private static WxUserBiz wxUserBiz = SpringUtils.getBean(WxUserBiz.class);

	// OPNEID
	public static final String CACHE_OPENID_ = "OPENID_";
	// 会员id
	public static final String CACHE_MEMBER_ID_ = "MEMBER_ID_";
	// 员工id
	public static final String CACHE_STAFF_ID_ = "STAFF_ID_";
	// 导购id
	public static final String CACHE_SALE_ID_ = "SALE_ID_";

	public static Member getMember() {
		return getMember(getMemberId());
	}

	public static Member getMember(String id) {
		return memberBiz.get(id);
	}

	public static WxUser getWxUser() {
		return getWxUser(getOpenid());
	}

	public static WxUser getWxUser(String openid) {
		return wxUserBiz.get(openid);
	}

	public static String getMemberId() {
		return getSessionCache(CACHE_MEMBER_ID_);
	}

	public static String getStaffId() {
		return getSessionCache(CACHE_STAFF_ID_);
	}

	public static String getSaleId() {
		return getSessionCache(CACHE_SALE_ID_);
	}

	public static String getOpenid() {
		return getSessionCache(CACHE_OPENID_);
	}

	public static void setWxUser(WxUser user) {
		putSessionCache(MemberUtils.CACHE_OPENID_, user.getOpenid());
		putSessionCache(MemberUtils.CACHE_MEMBER_ID_, user.getMemberId());
		putSessionCache(MemberUtils.CACHE_STAFF_ID_, user.getStaffId());
		putSessionCache(MemberUtils.CACHE_SALE_ID_, user.getSaleId());
	}

	@SuppressWarnings("unchecked")
	private static <V> V getSessionCache(String key) {
		V v = null;
		Session session = UserUtils.getSession();
		if (session != null) {
			Object obj = session.getAttribute(key);
			if (obj != null) {
				v = (V) obj;
			}
		}
		return v;
	}

	private static void putSessionCache(String key, Object value) {
		Session session = UserUtils.getSession();
		if (session != null) {
			session.setAttribute(key, value);
		}
	}

}
