package com.junkj.module.sys.entity;

import java.util.Date;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

/**
 * 系统消息实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月11日
 * @version: 1.0.0
 */
@Table(name = "sys_com_msg", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "type", attrName = "type"),
		@Column(name = "title", attrName = "title"),
		@Column(name = "content", attrName = "content"),
		@Column(name = "receive_type", attrName = "receiveType"),
		@Column(name = "receive_ids", attrName = "receiveIds"),
		@Column(name = "receive_names", attrName = "receiveNames"),
		@Column(name = "send_id", attrName = "sendId"),
		@Column(name = "send_name", attrName = "sendName"),
		@Column(name = "send_date", attrName = "sendDate"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime"),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime"),
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysBeanData.class, alias = "e", on = "e.bean_key='sysComMsg_type' and e.bean_val = a.type", columns = {
				@Column(name = "bean_txt", attrName = "typeTxt", queryType = QueryType.LIKE) 
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysBeanData.class, alias = "f", on = "f.bean_key='receive_type' and f.bean_val = a.receive_type", columns = {
				@Column(name = "bean_txt", attrName = "receiveTypeTxt", queryType = QueryType.LIKE) 
		}) 
	}, orderBy = "a.id DESC"
)
public class SysComMsg extends DataEntity<SysComMsg> {

	private static final long serialVersionUID = 1L;
	
	// 接受者类型（0全部 1用户）
	/**
	 * 0全部
	 */
	public static final String RECEIVETYPE_0 = "0";
	/**
	 * 1用户
	 */
	public static final String RECEIVETYPE_1 = "1";
	
	// 消息类型（1产品消息、2服务消息、3活动消息）
	/**
	 * 1产品消息
	 */
	public static final String TYPE_1 = "1";
	/**
	 * 2服务消息
	 */
	public static final String TYPE_2 = "2";
	/**
	 * 3活动消息
	 */
	public static final String TYPE_3 = "3";

	private String type; // 消息类型（1产品消息、2服务消息、3活动消息）
	private String title; // 标题
	private String content; // 内容
	private String receiveType; // 接受者类型（0全部 1用户）
	private String receiveIds; // 接受者字符串
	private String receiveNames; // 接受者名称字符串
	private String sendId; // 发送者
	private String sendName; // 发送者
	private Date sendDate; // 发送时间
	
	// 业务字段
	private String typeTxt; // 消息类型
	private String receiveTypeTxt; // 接受者类型 


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getReceiveType() {
		return receiveType;
	}
	public void setReceiveType(String receiveType) {
		this.receiveType = receiveType;
	}

	public String getReceiveIds() {
		return receiveIds;
	}
	public void setReceiveIds(String receiveIds) {
		this.receiveIds = receiveIds;
	}

	public String getReceiveNames() {
		return receiveNames;
	}
	public void setReceiveNames(String receiveNames) {
		this.receiveNames = receiveNames;
	}

	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getTypeTxt() {
		return typeTxt;
	}
	public void setTypeTxt(String typeTxt) {
		this.typeTxt = typeTxt;
	}
	public String getReceiveTypeTxt() {
		return receiveTypeTxt;
	}
	public void setReceiveTypeTxt(String receiveTypeTxt) {
		this.receiveTypeTxt = receiveTypeTxt;
	}

}