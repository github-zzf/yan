package com.junkj.module.sys.biz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.UserUtils;
import com.junkj.module.sys.dao.SysComMsgDao;
import com.junkj.module.sys.entity.SysComMsg;
import com.junkj.module.sys.entity.SysComMsgRecord;
import com.junkj.module.sys.entity.SysCompany;
import com.junkj.module.sys.entity.SysUser;

/**
 * 系统消息biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月11日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SysComMsgBiz extends CrudBiz<SysComMsgDao, SysComMsg> {

	@Autowired
	private SysComMsgRecordBiz sysComMsgRecordBiz;
	@Autowired
	private SysCompanyBiz sysCompanyBiz;
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<SysComMsg> findPage(SysComMsg sysComMsg) {
		return super.findPage(sysComMsg);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<SysComMsg> findList(SysComMsg sysComMsg) {
		return super.findList(sysComMsg);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SysComMsg sysComMsg) {
		sysComMsg.setContent(HtmlUtils.htmlUnescape(sysComMsg.getContent()));
		boolean tt = false;
		if(sysComMsg.getIsNewT()){
			SysUser sysUser = UserUtils.getUser();
			if(sysUser != null){
				if(StrUtils.isBlank(sysComMsg.getSendId())){
					sysComMsg.setSendId(sysUser.getId());
				}
				if(StrUtils.isBlank(sysComMsg.getSendName())){
					sysComMsg.setSendName(sysUser.getName());
				}
				if(StrUtils.isBlank(sysComMsg.getSendDate())){
					sysComMsg.setSendDate(new Date());
				}
			}
			tt= true;
		}
		super.save(sysComMsg);
		if(tt){
			if(sysComMsg.getReceiveType().equals(SysComMsg.RECEIVETYPE_0)){
				List<SysCompany> list = sysCompanyBiz.findList(new SysCompany());
				for (SysCompany sysCompany : list) {
					SysComMsgRecord sysComMsgRecord = new SysComMsgRecord();
					sysComMsgRecord.setMsgId(sysComMsg.getId());
					sysComMsgRecord.setComId(sysCompany.getComId());
					sysComMsgRecord.setComName(sysCompany.getComName());
					sysComMsgRecordBiz.save(sysComMsgRecord);
				}
			}else if(sysComMsg.getReceiveType().equals(SysComMsg.RECEIVETYPE_1)){
				String[] comIds = sysComMsg.getReceiveIds().split(",");
				String[] comNames = sysComMsg.getReceiveNames().split(",");
				for(int i = 0; i< comIds.length; i++){
					SysComMsgRecord sysComMsgRecord = new SysComMsgRecord();
					sysComMsgRecord.setMsgId(sysComMsg.getId());
					sysComMsgRecord.setComId(comIds[i]);
					sysComMsgRecord.setComName(comNames[i]);
					sysComMsgRecordBiz.save(sysComMsgRecord);
				}
			}
		}else{
			SysComMsgRecord where = new SysComMsgRecord();
			where.setMsgId(sysComMsg.getId());
			List<SysComMsgRecord> listSysComMsgRecord = sysComMsgRecordBiz.findList(where);
			for (SysComMsgRecord sysComMsgRecord : listSysComMsgRecord) {
				sysComMsgRecordBiz.delete(sysComMsgRecord);
			}
			if(sysComMsg.getReceiveType().equals(SysComMsg.RECEIVETYPE_0)){
				List<SysCompany> list = sysCompanyBiz.findList(new SysCompany());
				for (SysCompany sysCompany : list) {
					SysComMsgRecord sysComMsgRecord = new SysComMsgRecord();
					sysComMsgRecord.setMsgId(sysComMsg.getId());
					sysComMsgRecord.setComId(sysCompany.getComId());
					sysComMsgRecord.setComName(sysCompany.getComName());
					sysComMsgRecordBiz.save(sysComMsgRecord);
				}
			}else if(sysComMsg.getReceiveType().equals(SysComMsg.RECEIVETYPE_1)){
				String[] comIds = sysComMsg.getReceiveIds().split(",");
				String[] comNames = sysComMsg.getReceiveNames().split(",");
				for(int i = 0; i< comIds.length; i++){
					SysComMsgRecord sysComMsgRecord = new SysComMsgRecord();
					sysComMsgRecord.setMsgId(sysComMsg.getId());
					sysComMsgRecord.setComId(comIds[i]);
					sysComMsgRecord.setComName(comNames[i]);
					sysComMsgRecordBiz.save(sysComMsgRecord);
				}
			}
		}
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SysComMsg sysComMsg) {
		SysComMsgRecord where = new SysComMsgRecord();
		where.setMsgId(sysComMsg.getId());
		List<SysComMsgRecord> list = sysComMsgRecordBiz.findList(where);
		for (SysComMsgRecord sysComMsgRecord : list) {
			sysComMsgRecordBiz.delete(sysComMsgRecord);
		}
		super.delete(sysComMsg);
	}
	
}
