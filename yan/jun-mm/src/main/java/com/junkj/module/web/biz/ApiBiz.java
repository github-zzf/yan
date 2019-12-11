package com.junkj.module.web.biz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.junkj.common.IdGen.IdGenerate;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.DateUtils;
import com.junkj.common.lang.ObjectUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.common.utils.MemberUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.cms.biz.ArticlesBiz;
import com.junkj.module.cms.biz.ArttypeBiz;
import com.junkj.module.cms.entity.Articles;
import com.junkj.module.cms.entity.Arttype;
import com.junkj.module.company.biz.ActivityBiz;
import com.junkj.module.company.biz.ActivityEnrollBiz;
import com.junkj.module.company.biz.AlbumBiz;
import com.junkj.module.company.biz.CardsBiz;
import com.junkj.module.company.biz.ComConfigBiz;
import com.junkj.module.company.biz.CourseBiz;
import com.junkj.module.company.biz.CourseEnrollBiz;
import com.junkj.module.company.biz.FeedbackBiz;
import com.junkj.module.company.biz.MobileSettingBiz;
import com.junkj.module.company.biz.StaffNoticeSettingBiz;
import com.junkj.module.company.biz.WorkMsgBiz;
import com.junkj.module.company.entity.Activity;
import com.junkj.module.company.entity.ActivityEnroll;
import com.junkj.module.company.entity.Album;
import com.junkj.module.company.entity.Cards;
import com.junkj.module.company.entity.Course;
import com.junkj.module.company.entity.CourseEnroll;
import com.junkj.module.company.entity.Feedback;
import com.junkj.module.company.entity.MobileSetting;
import com.junkj.module.file.biz.FileUploadBiz;
import com.junkj.module.file.entity.FileUpload;
import com.junkj.module.file.entity.FileUploadParams;
import com.junkj.module.member.biz.CardChangeBiz;
import com.junkj.module.member.biz.GrowupBiz;
import com.junkj.module.member.biz.MemberBiz;
import com.junkj.module.member.biz.MemberCardBiz;
import com.junkj.module.member.biz.PointsBiz;
import com.junkj.module.member.entity.CardChange;
import com.junkj.module.member.entity.Growup;
import com.junkj.module.member.entity.Member;
import com.junkj.module.member.entity.MemberCard;
import com.junkj.module.member.entity.Points;
import com.junkj.module.sys.entity.SysUser;
import com.junkj.module.weixin.biz.WxUserBiz;
import com.junkj.module.weixin.entity.WxUser;

/**
 * 员工端biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月19日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class ApiBiz {

	@Autowired
	private MobileSettingBiz mobileSettingBiz;
	@Autowired
	private ArttypeBiz arttypeBiz;
	@Autowired
	private ArticlesBiz articlesBiz;
	@Autowired
	private CourseBiz courseBiz;
	@Autowired
	private CourseEnrollBiz courseEnrollBiz;
	@Autowired
	private ActivityBiz activityBiz;
	@Autowired
	private ActivityEnrollBiz activityEnrollBiz;
	@Autowired
	private CardsBiz cardsBiz;
	@Autowired
	private MemberCardBiz memberCardBiz;
	@Autowired
	private CardChangeBiz cardChangeBiz;
	@Autowired
	private AlbumBiz albumBiz;
	@Autowired
	private FileUploadBiz fileUploadBiz;
	@Autowired
	private GrowupBiz growupBiz;
	@Autowired
	private MemberBiz memberBiz;
	@Autowired
	private FeedbackBiz feedbackBiz;
	@Autowired
	private PointsBiz pointsBiz;
	@Autowired
	private ComConfigBiz comConfigBiz;
	@Autowired
	private WorkMsgBiz workMsgBiz;
	@Autowired
	private StaffNoticeSettingBiz staffNoticeSettingBiz;
	@Autowired
	private WxUserBiz wxUserBiz;
	@Autowired
	private MemberCardBiz cardBiz;

	/*******************************************************
	 * 首页
	 */
	/**
	 * 轮播
	 */
	public List<MobileSetting> listHomeImg() {
		MobileSetting setting = new MobileSetting();
		setting.setType(MobileSetting.TYPE_1);
		return mobileSettingBiz.findList(setting);
	}

	// 会员卡提示
	@SuppressWarnings("static-access")
	public Object getTiShi() {

		JsonVo vo = new JsonVo();
		// 储值参数
		String chuzhi = comConfigBiz.getByKey("com_chuzhi");
		// 储次参数
		String chuci = comConfigBiz.getByKey("com_chuci");
		// 会员卡过期参数
		String cardTime = comConfigBiz.getByKey("com_cardTime");

		Map<String, Object> map = memberBiz.getMemberInfo(MemberUtils.getMemberId(), ComUtils.getCurrentComId());

		if (map != null && chuzhi != null) {
			if (map.get("chuzhi") != null) {
				if (Double.parseDouble(map.get("chuzhi").toString()) <= Double.parseDouble(chuzhi)) {
					return vo.sendError("您的储值余额不足,请充值");
				}
			}
		}
		if (map != null && chuci != null) {
			if (map.get("chuci") != null) {
				if (Double.parseDouble(map.get("chuci").toString()) <= Double.parseDouble(chuci)) {
					return vo.sendError("您的储值次余额不足,请充值");
				}
			}
		}
		MemberCard memberCard = new MemberCard();
		memberCard.setMemberId(MemberUtils.getMemberId());
		// 查询会员卡
		List<MemberCard> memberCards = memberCardBiz.findList(memberCard);
		for (MemberCard mc : memberCards) {

			if (StrUtils.isNoneBlank(cardTime)) {
				Date date = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.HOUR, Integer.parseInt(cardTime));
				String time = DateUtils.format(cal.getTime());
				boolean temp = DateUtils.before(DateUtils.format(mc.getInvalidTime()), time, "yyyy-MM-dd");
				if (temp) {
					return vo.sendError("您的会员卡即将过期,请续费");
				}

			}
		}
		return vo;
	}

	/*******************************************************
	 * 文章
	 */
	// 栏目
	public Page<Arttype> pageArttype(Arttype arttype) {
		return arttypeBiz.findPage(arttype);
	}

	// 文章
	public Page<Articles> pageArticles(Articles activity) {
		if (StrUtils.notBlank(activity.getTypeType())) {
			Arttype where = new Arttype();
			where.setTypeType(activity.getTypeType());
			Arttype type = arttypeBiz.getByEntity(where);
			if (null != type) {
				activity.setTypeId(type.getId());
				return articlesBiz.findPage(activity);
			}
		}
		List<Articles> list = new ArrayList<>();
		Page<Articles> vo = new Page<>();
		vo.setList(list);
		return vo;
	}

	// 文章详情
	@Transactional(readOnly = false)
	public Articles infoArticles(String id) {
		Articles articles = articlesBiz.get(id);
		FileUpload where = new FileUpload();
		where.setBizType(Articles.FILE_TYPE);
		where.setBizId(id);
		articles.setFileUpload(fileUploadBiz.findList(where));
		articles.setClicks(articles.getClicks() + 1);
		articlesBiz.save(articles);
		return articles;
	}

	// 电话导航
	public Map<String, Object> getComInfo() {
		// id
		String comId = ComUtils.getCurrentComId();
		// 名称
		String comName = ComUtils.getCurrentComName();
		// 电话
		String phone = ComUtils.getCache(comId, "com_phone");
		// 坐标
		String address = ComUtils.getCache(comId, "com_coordinate");
		// 预约提示
		String tishi = ComUtils.getCache(comId, "com_tishi");
		// 储值余额提示
		String chuzhi = ComUtils.getCache(comId, "com_chuzhi");
		// 储次提示
		String chuci = ComUtils.getCache(comId, "com_chuci");

		Map<String, Object> map = new HashMap<>();
		map.put("comName", ObjectUtils.toString(comName));
		map.put("phone", ObjectUtils.toString(phone));
		map.put("address", ObjectUtils.toString(address));
		map.put("tishi", ObjectUtils.toString(tishi));
		map.put("chuzhi", ObjectUtils.toString(chuzhi));
		map.put("chuci", ObjectUtils.toString(chuci));
		return map;
	}

	/*******************************************************
	 * 服务预约
	 */
	// 课程列表
	public List<Course> listCourse(Course course) {
		return courseBiz.findDayCourse(course);
	}

	// 老师
	public List<SysUser> listTeacher() {
		String comId = ComUtils.getCurrentComId();
		return courseBiz.findListTeacher(comId);
	}

	// 我的预约
	public Page<CourseEnroll> pageMyCourse() {
		CourseEnroll courseEnroll = new CourseEnroll();
		courseEnroll.setMemberId(MemberUtils.getMemberId());
		return courseEnrollBiz.findPage(courseEnroll);
	}

	// 保存评价
	@Transactional(readOnly = false)
	public void saveComment(CourseEnroll enroll) {
		CourseEnroll update = new CourseEnroll();
		update.setId(enroll.getId());
		update.setCommentLevel(enroll.getCommentLevel());
		update.setCommentContent(enroll.getCommentContent());
		update.setCommentTime(DateUtils.getNow());
		update.setStatus(CourseEnroll.status_5);
		courseEnrollBiz.update(update);
	}

	// 取消预约
	@Transactional(readOnly = false)
	public JsonVo cancelMyCourse(CourseEnroll enroll) {
		CourseEnroll whereCourseEnroll = courseEnrollBiz.get(enroll.getId());
		// 获取课程信息
		Course course = courseBiz.get(whereCourseEnroll.getCourseId());
		// 获取取消时间限制
		Integer time = ObjectUtils.toInteger(comConfigBiz.getByKey("course_cancel_time"));
		// 计算取消时间
		Calendar cl = Calendar.getInstance();
		cl.setTime(course.getStartTime());
		cl.add(Calendar.HOUR_OF_DAY, -time);
		String date1 = DateUtils.format(course.getCourseDate()) + " " + DateUtils.format(cl.getTime(), "HH:mm:ss");
		// 小于当前时间可与取消
		if (DateUtils.before(DateUtils.getDateTime(), date1, "yyyy-MM-dd HH:mm:ss")) {
			CourseEnroll update = new CourseEnroll();
			update.setId(enroll.getId());
			courseEnrollBiz.quxiao(update);
		} else {
			return JsonVo.sendError(date1 + "前可以取消!");
		}
		return JsonVo.sendOk();
	}

	// 保存预约
	@Transactional(readOnly = false)
	public JsonVo saveCourseEnroll(CourseEnroll enroll) {

		// 创建课程
		Course course = courseBiz.get(enroll.getCourseId());
		if (course.getIsWeek().equals(Course.isWeek_1)
				&& !DateUtils.format(course.getCourseDate()).equals(enroll.getCourseDate())) {
			Course kc = courseEnrollBiz.getCopyKc(course.getId(), enroll.getCourseDate());
			if (kc == null) {
				kc = new Course();
				BeanUtils.copyProperties(course, kc);
				kc.setId(IdGenerate.nextId());
				kc.setParentId(course.getId());
				kc.setIsWeek(Course.isWeek_0);
				kc.setCourseDate(enroll.getCourseDate());
				courseBiz.insert(kc);
				kc.setId(kc.getId());
			}
			course = kc;
		}
		enroll.setCourseId(course.getId());
		CourseEnroll enrollWhere = enroll;
		enroll.setWhere("a.status <> 2");
		List<CourseEnroll> list = courseEnrollBiz.findList(enroll);
		if (list.size() >= course.getPeopleMax()) {
			return JsonVo.sendError("课程预约已达到上限");
		}
		enrollWhere.setMemberId(MemberUtils.getMemberId());
		CourseEnroll courseEnroll = courseEnrollBiz.getByEntity(enrollWhere);
		if (courseEnroll != null) {
			if (courseEnroll.getStatus().equals(CourseEnroll.status_1)
					|| courseEnroll.getStatus().equals(CourseEnroll.status_4)
					|| courseEnroll.getStatus().equals(CourseEnroll.status_5)) {
				return JsonVo.sendError("您已预约成功，请勿重复预约");
			} else if (CourseEnroll.status_2.equals(courseEnroll.getStatus())) {
				return JsonVo.sendError("您已取消该课程预约");
			}
		}

		// 获取课程
		String mcId = null;
		if (StrUtils.notBlank(course.getCardsTypeId())) {
			MemberCard cardWhere = new MemberCard();
			cardWhere.setCardsTypeId(course.getCardsTypeId());
			cardWhere.setMemberId(MemberUtils.getMemberId());
			// 查询会员会员卡
			List<MemberCard> cardList = cardBiz.getMemberCardList(cardWhere);
			if (cardList.size() > 0) {
				for (MemberCard mCard : cardList) {
					// 判断余额
					if (mCard.getStoredNum() < course.getCardNum()) {
						continue;
					}
					mcId = mCard.getId();
				}
				if (mcId == null) {
					return JsonVo.sendError("会员卡余额不足!");
				}
			} else {
				return JsonVo.sendError("没有满足条件的会员卡!");
			}
		}

		enroll.setStatus(CourseEnroll.status_1);
		enroll.setCreateTime(new Date());
		courseEnrollBiz.save(enroll);

		return JsonVo.sendOk("保存成功！");
	}

	/*******************************************************
	 * 活动
	 */

	// 活动列表
	public Page<Activity> pageActity(Activity activity) {
		return activityBiz.findPage(activity);
	}

	// 我的活动
	public Page<Activity> pageMyActity(Activity activity) {
		return activityBiz.pageMyActity(activity);
	}

	// 活动详情
	public Activity actityInfo(String id) {
		Activity activity = activityBiz.get(id);
		FileUpload where = new FileUpload();
		where.setBizType(Activity.FILE_TYPE);
		where.setBizId(id);
		activity.setFileUpload(fileUploadBiz.findList(where));

		ActivityEnroll enrollWhere = new ActivityEnroll();
		enrollWhere.setActivityId(id);
		enrollWhere.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_0);
		List<ActivityEnroll> enrollList = activityEnrollBiz.findList(enrollWhere);
		activity.setEnrollList(enrollList);

		enrollWhere = new ActivityEnroll();
		enrollWhere.setActivityId(id);
		enrollWhere.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_4);
		List<ActivityEnroll> waitList = activityEnrollBiz.findList(enrollWhere);
		activity.setWaitList(waitList);

		enrollWhere = new ActivityEnroll();
		enrollWhere.setActivityId(id);
		enrollWhere.setMemberId(MemberUtils.getMemberId());
		ActivityEnroll enroll = activityEnrollBiz.getByEntity(enrollWhere);
		if (enroll != null) {
			activity.setMyEnrollState("yes");
			// 0、正常 1、取消
			activity.setEnrollState(enroll.getEnrollStatus());
		} else {
			activity.setMyEnrollState("no");
		}

		return activity;
	}

	// 活动报名列表
	public Page<ActivityEnroll> pageActityEnroll(ActivityEnroll activityEnroll) {
		return activityEnrollBiz.findPage(activityEnroll);
	}

	// 活动报名
	@Transactional(readOnly = false)
	public JsonVo saveActityEnroll(ActivityEnroll activityEnroll) {
		activityEnroll.setId(null);
		activityEnroll.setMemberId(MemberUtils.getMemberId());
		activityEnroll.setEnrollTime(new Date());
		return activityEnrollBiz.saveActivityEnroll(activityEnroll);
	}

	// 我的活动取消
	@Transactional(readOnly = false)
	public JsonVo updateCancelMyEnroll(ActivityEnroll activityEnroll) {
		// 获取课程信息
		Activity activity = activityBiz.get(activityEnroll.getActivityId());
		// 获取取消时间限制
		Integer time = ObjectUtils.toInteger(comConfigBiz.getByKey("activity_cancel_time"));
		// 计算取消时间
		Calendar cl = Calendar.getInstance();
		cl.setTime(activity.getStartTime());
		cl.add(Calendar.HOUR_OF_DAY, -time);
		// 小于当前时间可与取消
		if (DateUtils.before(new Date(), cl.getTime())) {
			activityEnroll.setMemberId(MemberUtils.getMemberId());
			activityEnrollBiz.updateEnrollStatus(activityEnroll);
		} else {
			String date1 = DateUtils.format(cl.getTime(), "yyyy-MM-dd HH:mm:ss");
			return JsonVo.sendError(date1 + "前可以取消!");
		}
		return JsonVo.sendOk();
	}

	/*******************************************************
	 * 会员卡
	 */
	// 会员卡
	public Page<Cards> pageCards(Cards cards) {
		return cardsBiz.findPage(cards);
	}

	// 会员卡明细
	public Cards infoCards(String id) {
		return cardsBiz.get(id);
	}

	// // 会员卡购买
	// @Transactional(readOnly = false)
	// public void buyCards(CashBuy cashBuy) {
	// cashBuy.setId(null);
	// cashBuyBiz.save(cashBuy);
	// }

	// 我的卡包
	public Page<MemberCard> pageMyCards(MemberCard card) {
		card.setMemberId(MemberUtils.getMemberId());
		return memberCardBiz.findPage(card);
	}

	// 我的会员卡详情
	public MemberCard infoMyCards(String id) {
		return memberCardBiz.get(id);
	}

	// 我的会员卡消费记录
	public Page<CardChange> pageMyCardsChange(String id) {
		CardChange where = new CardChange();
		where.setMcId(id);
		where.setComId(where.getComId());
		return cardChangeBiz.findPage(where);
	}

	/*******************************************************
	 * 相册
	 */
	// 相册
	public Page<Album> pageAlbum(Album album) {
		return albumBiz.findPage(album);
	}

	// 相册详情
	@Transactional(readOnly = false)
	public Album infoAlbum(String id) {
		Album album = albumBiz.get(id);
		FileUpload where = new FileUpload();
		where.setBizType(Album.FILE_TYPE);
		where.setBizId(id);
		album.setFileUpload(fileUploadBiz.findList(where));
		album.setClicks(album.getClicks() + 1);
		albumBiz.save(album);
		return album;
	}

	// 相册图片
	public List<FileUpload> listAlbumImg(String id) {
		FileUpload where = new FileUpload();
		where.setBizId(id);
		where.setBizType(Album.FILE_TYPE);
		return fileUploadBiz.findList(where);
	}

	/*******************************************************
	 * 成长记录
	 */
	// 我的成长记录
	public Page<Growup> pageMyGrowup() {
		Growup where = new Growup();
		where.setMemberId(MemberUtils.getMemberId());
		return growupBiz.findMyPage(where);
	}

	// 保存成长记录
	@Transactional(readOnly = false)
	public void saveGrowupImg(String id, MultipartFile files) {
		fileUploadBiz.uploadFile(files, id, Growup.FILE_TYPE);
	}

	// 保存成长记录
	@Transactional(readOnly = false)
	public String saveGrowup(Growup growup) {
		growup.setMemberId(MemberUtils.getMemberId());
		growupBiz.save(growup);
		return growup.getId();
	}

	// 删除成长记录
	@Transactional(readOnly = false)
	public void deletGropup(Growup growup) {
		growupBiz.delete(growup);
	}

	/*******************************************************
	 * 我的
	 */
	// 我的数据
	public Object getMemberInfo() {
		return memberBiz.getMemberInfo(MemberUtils.getMemberId(), ComUtils.getCurrentComId());
	}

	// 修改我的数据
	@Transactional(readOnly = false)
	public void updateMember(Member member) {
		member.setId(MemberUtils.getMemberId());
		memberBiz.update(member);
	}

	// 意见反馈
	@Transactional(readOnly = false)
	public String saveFeedback(Feedback feedback) {
		feedback.setBizId(MemberUtils.getMemberId());
		feedback.setBizType(Feedback.BIZ_TYPE_1);
		feedbackBiz.save(feedback);
		return feedback.getId();
	}

	// 意见反馈上传
	@Transactional(readOnly = false)
	public void saveFeedbackImg(String id, MultipartFile files) {
		fileUploadBiz.uploadFile(files, id, Feedback.FILE_TYPE);
	}

	// 上传头像
	@Transactional(readOnly = false)
	public void uploadMemberHead(MultipartFile files) {

		if (StrUtils.notBlank(MemberUtils.getOpenid())) {
			FileUploadParams params = new FileUploadParams();
			params.setFile(files);
			params.setBizId(MemberUtils.getOpenid());
			params.setBizType(WxUser.FILE_TYPE);
			FileUpload upload = fileUploadBiz.uploadFile(params);

			if (StrUtils.notBlank(upload)) {
				WxUser update = new WxUser();
				update.setId(MemberUtils.getOpenid());
				update.setHeadImg(upload.getFileUrl());
				wxUserBiz.update(update);
			}
		}
	}

	// 我的积分
	public Page<Points> pageMyPoints() {
		Points where = new Points();
		where.setMemberId(MemberUtils.getMemberId());
		return pointsBiz.findPage(where);
	}

	// 我的信息
	public Member infoMyData() {
		return MemberUtils.getMember();
	}

	// 绑定用户
	@Transactional(readOnly = false)
	public void bindMember(WxUser user) {
		wxUserBiz.update(user);

		Member comm = memberBiz.get(user.getMemberId());
		comm.setOpenId(user.getOpenid());
		memberBiz.update(comm);

		// 更新会员相关数据
		wxUserBiz.updateMemberId(ComUtils.getCurrentComId(), user.getMemberId(), user.getDelMemberId());

	}

	// 解绑用户
	@Transactional(readOnly = false)
	public void unBindMember(WxUser user) {
		String memberId = user.getMemberId();
		Member member = memberBiz.get(memberId);
		member.setOpenId("");
		memberBiz.update(member);
		user.setMemberId("");
		wxUserBiz.update(user);
	}
}
