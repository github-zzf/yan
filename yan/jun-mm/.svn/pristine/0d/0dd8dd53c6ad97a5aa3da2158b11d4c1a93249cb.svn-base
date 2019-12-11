package com.junkj.module.shop.entity;

import java.util.Date;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;

/**
 * 商品兑换记录实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月27日
 * @version: 1.0.0
 */
@Table(name = "shop_gift_exchange", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "com_id", attrName = "comId"),
		@Column(name = "member_id", attrName = "memberId"),
		@Column(name = "gift_id", attrName = "giftId"),
		@Column(name = "gift_name", attrName = "giftName"),
		@Column(name = "gift_num", attrName = "giftNum"),
		@Column(name = "gift_points", attrName = "giftPoints"),
		@Column(name = "gift_img", attrName = "giftImg"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime"),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime"),
	}, orderBy = "a.id DESC"
)
public class GiftExchange extends DataEntity<GiftExchange> {

	private static final long serialVersionUID = 1L;

	private String comId; // 企业
	private String memberId; // 会员
	private String giftId; // 积分商品
	private String giftName; // 积分商品名称
	private Long giftNum; // 积分商品数量
	private Long giftPoints; // 兑换积分数
	private String giftImg; // 商品图片


	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGiftId() {
		return giftId;
	}
	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}

	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public Long getGiftNum() {
		return giftNum;
	}
	public void setGiftNum(Long giftNum) {
		this.giftNum = giftNum;
	}

	public Long getGiftPoints() {
		return giftPoints;
	}
	public void setGiftPoints(Long giftPoints) {
		this.giftPoints = giftPoints;
	}

	public String getGiftImg() {
		return giftImg;
	}
	public void setGiftImg(String giftImg) {
		this.giftImg = giftImg;
	}

}