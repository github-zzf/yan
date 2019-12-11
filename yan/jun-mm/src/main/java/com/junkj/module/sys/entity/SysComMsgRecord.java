package com.junkj.module.sys.entity;

import java.util.Date;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

/**
 * 系统消息发送记录实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月11日
 * @version: 1.0.0
 */
@Table(name = "sys_com_msg_record", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "com_id", attrName = "comId"),
		@Column(name = "com_name", attrName = "comName"),
		@Column(name = "msg_id", attrName = "msgId"),
		@Column(name = "read_state", attrName = "readState"),
		@Column(name = "read_time", attrName = "readTime"),
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysBeanData.class, alias = "b", on = "b.bean_key='msg_read_state' and b.bean_val = a.read_state", columns = {
				@Column(name = "bean_txt", attrName = "readStateTxt", queryType = QueryType.LIKE) 
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysComMsg.class, alias = "c", on = "c.id = a.msg_id", columns = {
				@Column(name = "title", attrName = "title", queryType = QueryType.LIKE),
				@Column(name = "content", attrName = "content", queryType = QueryType.LIKE)
		})
	}, orderBy = "a.id DESC"
)
public class SysComMsgRecord extends DataEntity<SysComMsgRecord> {

	private static final long serialVersionUID = 1L;
	// 阅读状态（1待发送、2未读、3已读）
	/**
	 * 1待发送
	 */
	public static final String READSTATE_1 = "1";
	/**
	 * 2未读
	 */
	public static final String READSTATE_2 = "2";
	/**
	 * 3已读
	 */
	public static final String READSTATE_3 = "3";

	private String comId; // 接收者id
	private String comName; // 接收者Name
	private String msgId; // 标题
	private String readState; // 阅读状态（1待发送、2未读、3已读）
	private Date readTime; // 阅读时间
	
	// 业务字段
	private String readStateTxt; // 阅读状态
	private String title; // 标题
	private String content; // 内容

	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getReadState() {
		return readState;
	}
	public void setReadState(String readState) {
		this.readState = readState;
	}

	public Date getReadTime() {
		return readTime;
	}
	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
	public String getReadStateTxt() {
		return readStateTxt;
	}
	public void setReadStateTxt(String readStateTxt) {
		this.readStateTxt = readStateTxt;
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

}