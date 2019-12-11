package com.junkj.module.sys.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.common.utils.ComUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.sys.biz.SysComMsgRecordBiz;
import com.junkj.module.sys.entity.SysComMsg;
import com.junkj.module.sys.entity.SysComMsgRecord;

/**
 * 系统消息发送记录action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月11日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysComMsgRecord")
public class SysComMsgRecordAction extends BaseAction {

	@Autowired
	private SysComMsgRecordBiz sysComMsgRecordBiz;

    @RequestMapping("")
	public String index() {
		return "/module/sys/sysComMsgRecord";
	}

	/**
	 * 分页数据
	 */
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysComMsgRecord> listPage(SysComMsgRecord sysComMsgRecord) {
		Page<SysComMsgRecord> page = sysComMsgRecordBiz.findPage(sysComMsgRecord);
		return page;
	}
	
	/**
	 * 分页数据
	 */
	@RequestMapping(value = "listMyPage")
	@ResponseBody
	public Page<SysComMsgRecord> listMyPage(SysComMsgRecord sysComMsgRecord) {
		sysComMsgRecord.setComId(ComUtils.getCurrentComId());
		Page<SysComMsgRecord> page = sysComMsgRecordBiz.findPage(sysComMsgRecord);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysComMsgRecord> findList(SysComMsgRecord sysComMsgRecord) {
		List<SysComMsgRecord> list = sysComMsgRecordBiz.findList(sysComMsgRecord);
		return list;
	}
	
	/**
	 * 消息数量
	 */
	@RequestMapping(value = "selectMessageNum")
	@ResponseBody
	public Object selectMessageNum(SysComMsgRecord sysComMsgRecord) {
		sysComMsgRecord.setComId(ComUtils.getCurrentComId());
		sysComMsgRecord.setReadState(SysComMsgRecord.READSTATE_2);
		Long num = sysComMsgRecordBiz.findCount(sysComMsgRecord);
		return sendData(num);
	}

	/**
	 * 添加或更新
	 */
	@RequiresPermissions("sys:sysComMsgRecord:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(SysComMsgRecord sysComMsgRecord) {
		sysComMsgRecordBiz.save(sysComMsgRecord);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysComMsgRecord:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysComMsgRecord sysComMsgRecord) {
		sysComMsgRecordBiz.delete(sysComMsgRecord);
		return sendOk("删除成功！");
	}
	
	/**
	 * 标记为已读
	 */
	@RequestMapping(value = "updateSysComMsgRecordStates")
	@ResponseBody
	public JsonVo updateSysComMsgRecordStates(SysComMsgRecord sysComMsgRecord) {
		sysComMsgRecordBiz.updateSysComMsgRecordStates(sysComMsgRecord);
		return sendOk("标记成功！");
	}

}