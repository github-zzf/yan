package com.junkj.module.company.entity;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.sys.entity.SysBeanData;
import com.junkj.module.sys.entity.SysUser;
import com.junkj.module.weixin.entity.WxUser;

/**
 * 员工请假表实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月27日
 * @version: 1.0.0
 */
@Table(name = "com_leave", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "content", attrName = "content"),
		@Column(name = "staff_id", attrName = "staffId"),
		@Column(name = "start_time", attrName = "startTime"),
		@Column(name = "end_time", attrName = "endTime"),
		@Column(name = "checkState", attrName = "checkState"),
		@Column(name = "checkRemark", attrName = "checkRemark"),
		@Column(name = "checkTime", attrName = "checkTime"),
		@Column(name = "checkStaffId", attrName = "checkStaffId"),
		@Column(name = "type", attrName = "type"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime"),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime"),
		@Column(sql = "(select GROUP_CONCAT(name) from sys_user f where FIND_IN_SET(f.id,a.checkStaffId)) as checkStaffName", isUpdate = false, isQuery = false),
		@Column(includeEntity = BaseEntity.class)
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysUser.class, alias = "b", on = "b.id = a.staff_id ", columns = {
			@Column(name = "name", attrName = "staffTxt", queryType = QueryType.EQ) 
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysBeanData.class, alias = "c", on = "c.bean_key='leave_checkState' and c.bean_val = a.checkState", columns = {
				@Column(name = "bean_txt", attrName = "checkStateTxt", queryType = QueryType.LIKE) 
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysBeanData.class, alias = "e", on = "e.bean_key='leave_type' and e.bean_val = a.type", columns = {
				@Column(name = "bean_txt", attrName = "typeTxt", queryType = QueryType.LIKE) 
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = WxUser.class, alias = "wx", on = "wx.staff_id = a.staff_id ", columns = {
				@Column(name = "head_img", attrName = "headImg", queryType = QueryType.EQ) 
		})
	}, orderBy = "a.id DESC"
)
public class Leave extends DataEntity<Leave> {

	private static final long serialVersionUID = 1L;
	
	public static final String LEAVE_TYPE = "leave_type";
	
	// 是否是审批人
	/**
	 * 0否
	 */
	public static final String CHECKSTATETYPE_0 = "0";
	/**
	 * 1是
	 */
	public static final String CHECKSTATETYPE_1 = "1";
	
	// 是否是审批人
	/**
	 * 1待审批
	 */
	public static final String CHECKSTATE_1 = "1";
	/**
	 * 2未通过
	 */
	public static final String CHECKSTATE_2 = "2";
	/**
	 * 3已通过
	 */
	public static final String CHECKSTATE_3 = "3";
	/**
	 * 4已取消
	 */
	public static final String CHECKSTATE_4 = "4";

	private String staffId; // 员工
	private Date startTime; // 请假开始时间
	private Date endTime; // 请假结束时间
	private String content; // 请假事由
	private String checkState; // 审批状态(1待审批,2未通过,3已通过)
	private String checkRemark; // 审批内容
	private Date checkTime; // 审批时间
	private String checkStaffId; // 审批人
	private String type; // 请假类型
	
	// 业务字段
	private String staffTxt;// 员工
	private String typeTxt;// 请假类型
	private String checkStateTxt;// 审批状态
	private String checkStaffName;// 审批人
	private String checkStateType; // 是否是审批人
	private String headImg; // 头像
	
	@NotEmpty(message="员工不能为空")
	@Length(min=0, max=32, message="员工长度不能超过32个字符")
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	@NotNull(message="请假开始时间级别不能为空")
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@NotNull(message="请假结束时间不能为空")
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStaffTxt() {
		return staffTxt;
	}
	public void setStaffTxt(String staffTxt) {
		this.staffTxt = staffTxt;
	}
	
	@NotEmpty(message="请假事由不能为空")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	public String getCheckRemark() {
		return checkRemark;
	}
	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public String getCheckStaffId() {
		return checkStaffId;
	}
	public void setCheckStaffId(String checkStaffId) {
		this.checkStaffId = checkStaffId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeTxt() {
		return typeTxt;
	}
	public void setTypeTxt(String typeTxt) {
		this.typeTxt = typeTxt;
	}
	public String getCheckStateTxt() {
		return checkStateTxt;
	}
	public void setCheckStateTxt(String checkStateTxt) {
		this.checkStateTxt = checkStateTxt;
	}
	public String getCheckStaffName() {
		return checkStaffName;
	}
	public void setCheckStaffName(String checkStaffName) {
		this.checkStaffName = checkStaffName;
	}
	public String getCheckStateType() {
		return checkStateType;
	}
	public void setCheckStateType(String checkStateType) {
		this.checkStateType = checkStateType;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	
}