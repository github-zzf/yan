package com.junkj.module.excel.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.excel.CheckExcleUtil;
import com.junkj.module.excel.dao.ExcelTplDao;
import com.junkj.module.excel.entity.ExcelTpl;

@Service
@Transactional(readOnly = true)
public class ExcelTplBiz extends CrudBiz<ExcelTplDao, ExcelTpl> {
	
	@Autowired
	private ExcelTplDao excelTplDao;
	
	@SuppressWarnings("rawtypes")
	public Map<String, Object> checkTemplate(MultipartFile excelFile, String tableCode, Class cls) {
		//对应关系
		Map<String,Object> colMap = new HashMap<String,Object>();
		//验证规则
		Map<String,Object> ruleMap = new HashMap<String,Object>();
		//获取Xml模板
		ExcelTpl tpl = excelTplDao.getExcelTplByCode(tableCode);
		List<Map<String, Object>>  colList = excelTplDao.getTemplateCol(tpl.getTplId());
		List<Map<String, Object>>  ruleList= excelTplDao.getTemplateRule(tableCode);
		for (Map<String, Object> col : colList) {
			String title = col.get("colSort").toString();
			String colCode = col.get("colCode").toString();
			colMap.put(title, col);
			List<Map<String, Object>> colRuleList = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> rule : ruleList) {
				if(colCode.equals(rule.get("colCode"))){
					colRuleList.add(rule);
				}
			}
			ruleMap.put(title, colRuleList);
		}
		CheckExcleUtil checkUtil = new CheckExcleUtil(excelFile,tpl.getTitleIndex(), colMap, ruleMap, cls);
		return checkUtil.getDataMap();
	}
	

	public Map<String, Object> checkTemplateTitle(MultipartFile excelFile, String tableCode, Class cls) {
		//对应关系
		Map<String,Object> colMap = new HashMap<String,Object>();
		//验证规则
		Map<String,Object> ruleMap = new HashMap<String,Object>();
		//获取Xml模板
		ExcelTpl tpl = excelTplDao.getExcelTplByCode(tableCode);
		List<Map<String, Object>>  colList = excelTplDao.getTemplateCol(tpl.getTplId());
		List<Map<String, Object>>  ruleList= excelTplDao.getTemplateRule(tableCode);
		for (Map<String, Object> col : colList) {
			String title = col.get("colTitle").toString();
			String colCode = col.get("colCode").toString();
			colMap.put(title, col);
			List<Map<String, Object>> colRuleList = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> rule : ruleList) {
				if(colCode.equals(rule.get("colCode"))){
					colRuleList.add(rule);
				}
			}
			ruleMap.put(title, colRuleList);
		}
		CheckExcleUtil checkUtil = new CheckExcleUtil(excelFile,tpl.getTitleIndex(), colMap, ruleMap, cls);
		return checkUtil.getDataMap();
	}

	public List<Map<String, Object>> checkTemplate(MultipartFile excelFile, String[] tableCode, Class[] cls) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		for(int i = 0;i < tableCode.length;i++){
			//对应关系
			Map<String,Object> colMap = new HashMap<String,Object>();
			//验证规则
			Map<String,Object> ruleMap = new HashMap<String,Object>();
			//获取Xml模板
			ExcelTpl tpl = excelTplDao.getExcelTplByCode(tableCode[i]);
			List<Map<String, Object>>  colList = excelTplDao.getTemplateCol(tpl.getTplId());
			List<Map<String, Object>>  ruleList= excelTplDao.getTemplateRule(tableCode[i]);
			for (Map<String, Object> col : colList) {
				String title = col.get("colTitle").toString();
				String colCode = col.get("colCode").toString();
				colMap.put(title, col);
				List<Map<String, Object>> colRuleList = new ArrayList<Map<String, Object>>();
				for (Map<String, Object> rule : ruleList) {
					if(colCode.equals(rule.get("colCode"))){
						colRuleList.add(rule);
					}
				}
				ruleMap.put(title, colRuleList);
			}
			
			CheckExcleUtil checkUtil = new CheckExcleUtil(excelFile,tpl.getTitleIndex(), colMap, ruleMap, cls[i],i);
			resultList.add(checkUtil.getDataMap());
		}
		
		return resultList;
	}
	
}
