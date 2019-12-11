package com.junkj.common.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.junkj.common.lang.DateUtils;
import com.junkj.common.lang.StrUtils;



public class CheckExcleUtil {

	private InputStream fis;
	private Integer titleIndex;
	private Map<String,Object> tplCol;
	private Map<String,Object> tplRule;
	private Class t;
	
	private HSSFWorkbook workBook;
	private XSSFWorkbook xwBook;
	private HSSFSheet sheet;
	private XSSFSheet xsheet;
	private Map<Integer,String> titleMap;
	private String colvalue = null;
	
	/** 返回数据 **/
	private Map<String,Object> dataMap;
	
	/**
	 * 
	 * @param excelFile Excel文件
	 * @param titileIndex 表头所在行
	 * @param colMap	对应关系,key表头value对应列信息
	 * @param ruleMap	验证规则,key表头value规则集合
	 * @param cls	指定实例化类
	 */
	public CheckExcleUtil(MultipartFile excelFile,Integer titleIndex, Map<String,Object> colMap, Map<String,Object> ruleMap,Class cls) {
		try {
			if (excelFile == null) {
				throw new FileNotFoundException();
			}
			this.fis = excelFile.getInputStream();
			this.titleIndex = titleIndex-1;
			this.tplCol = colMap;
			this.tplRule = ruleMap;
			this.t = cls;
			if(excelFile.getOriginalFilename().endsWith("xls")){
				workBook = new HSSFWorkbook(fis);
				readExcel2003();
			}else if(excelFile.getOriginalFilename().endsWith("xlsx")) {
				xwBook =  new XSSFWorkbook(fis);
				readExcel2007();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param excelFile Excel文件
	 * @param titileIndex 表头所在行
	 * @param colMap	对应关系,key表头value对应列信息
	 * @param ruleMap	验证规则,key表头value规则集合
	 * @param cls	指定实例化类
	 * @param sheetIndex sheet页
	 */
	public CheckExcleUtil(MultipartFile excelFile,Integer titleIndex, Map<String,Object> colMap, Map<String,Object> ruleMap,Class cls,int sheetIndex) {
		try {
			if (excelFile == null) {
				throw new FileNotFoundException();
			}
			this.fis = excelFile.getInputStream();
			this.titleIndex = titleIndex-1;
			this.tplCol = colMap;
			this.tplRule = ruleMap;
			this.t = cls;
			if(excelFile.getOriginalFilename().endsWith("xls")){
				workBook = new HSSFWorkbook(fis);
				readExcel2003(sheetIndex);
			}else if(excelFile.getOriginalFilename().endsWith("xlsx")) {
				xwBook =  new XSSFWorkbook(fis);
				readExcel2007(sheetIndex);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 开始从excel读取数据 **/
	public void readExcel2003() {
		int sheetSize = 1;
		for (int i = 0; i < sheetSize; i++) {
			sheet = workBook.getSheetAt(i);
			//sheet页名称
			String entityName = workBook.getSheetName(i);
			readSheetData(sheet, entityName);
		}
	}
	
	/** 开始从excel读取数据 **/
	public void readExcel2007() {
		int sheetSize = 1;
		for (int i = 0; i < sheetSize; i++) {
			xsheet = xwBook.getSheetAt(i);
			//sheet页名称
			String entityName = xwBook.getSheetName(i);
			readSheetData(xsheet, entityName);
		}
	}
	
	/** 开始从excel读取数据 **/
	public void readExcel2003(int sheetIndex) {
		sheet = workBook.getSheetAt(sheetIndex);
		//sheet页名称
		String entityName = workBook.getSheetName(sheetIndex);
		readSheetData(sheet, entityName);
	}

	/** 开始从excel读取数据 **/
	public void readExcel2007(int sheetIndex) {
		xsheet = xwBook.getSheetAt(sheetIndex);
		//sheet页名称
		String entityName = xwBook.getSheetName(sheetIndex);
		readSheetData(xsheet, entityName);
	}
	
	/** 读每个sheet页的数据 **/
	public void readSheetData(Sheet sheet, String entityName) {
		
		int rowNumbers = sheet.getPhysicalNumberOfRows();
		if (rowNumbers == 0) {
//			checkMsg.append(ParseConstans.ERROR_EXCEL_NULL);
			return;
		}
		int xmlRowNum = tplCol.size();
		Row excelRow = sheet.getRow(0);
		int excelFirstRow = excelRow.getFirstCellNum();
		int excelLastRow = excelRow.getLastCellNum();
		if (xmlRowNum != (excelLastRow - excelFirstRow)) {
//			checkMsg.append(ParseConstans.ERROR_EXCEL_COLUMN_NOT_EQUAL);
		}
		readSheetHeadData(sheet);
		readSheetColumnData(sheet, entityName);
	}
	
	/** 读取sheet页中的表头信息 **/
	public void readSheetHeadData(Sheet sheet) {
		Row excelheadRow = sheet.getRow(titleIndex);
		int excelLastRow = excelheadRow.getLastCellNum();
		String headTitle = "";
		titleMap = new HashMap<Integer, String>();
		for (int i = 0; i < excelLastRow; i++) {
			Cell cell = excelheadRow.getCell(i);
			headTitle = this.getStringCellValue(cell);
			headTitle.replace("*", "");
			titleMap.put(i, headTitle);
		}
	}
	
	/** 读取sheet页里面的数据 **/
	public void readSheetColumnData(Sheet sheet, String entityName) {
		Row excelheadRow = sheet.getRow(titleIndex);
		int excelLastcell = excelheadRow.getLastCellNum(); // excel总列数
		int excelRowNum = sheet.getLastRowNum(); // excel总行数
		dataMap = new HashMap<String,Object>();  // 返回数据
		dataMap.put("titleIndex", titleIndex);
		dataMap.put("totalCount", excelRowNum-titleIndex);
		try {
			for (int i = titleIndex+1; i < excelRowNum+1 ; i++) {// 行循环
				Row columnRow = sheet.getRow(i);
				if (columnRow != null) {
					String colError = "";
					Integer rowIndex = i + 1;
					//创建Bean
					Object bean = t.newInstance();
					for (int j = 0; j < excelLastcell; j++) { // 列循环
						int colIndex = j + 1;
						//获取表头
						String headTitle = titleMap.get(j).toString();
						//获取关联信息
						Map colMap = (Map) tplCol.get(j+1+"");
						if(StrUtils.notBlank(colMap) && headTitle.equals(colMap.get("colTitle"))){
							String curColCode = (String) colMap.get("colCode");
							String curColType = (String) colMap.get("colType");
							//列值
							colvalue = CheckExcleUtil.getStringCellValue(columnRow.getCell(j));
							
							/** 验证cell数据 **/
							String error = validateCellData(rowIndex, colIndex, entityName, headTitle);
							if(StrUtils.isBlank(error)){
								try {
									//赋值
									Object value = toType(colvalue, curColType);
									try {
										Field field = t.getDeclaredField(curColCode);
										field.setAccessible(true);
										field.set(bean, value);
									} catch (Exception e) {
										colError += "第"+ rowIndex + "行第" + colIndex+ "列：导入模版不包含该列"+headTitle+"<br>";
									}
								} catch (Exception e) {
									//修改 。验证数字类型提示信息
									if(curColType.equals("Double")){
										curColType="数字";
									}
									colError += "第"+ rowIndex + "行第" + colIndex+ "列："+headTitle+"列内容应为"+curColType+"类型<br>";
								}
							}else{
								colError += error;
							}
						}else{
							colError += "第"+ rowIndex + "行第" + colIndex+ "列：当前使用模板不包含该列"+headTitle+"<br>";
						}
					}
					if(StrUtils.isBlank(colError)){
						dataMap.put(rowIndex.toString(), bean);
					}else{
						dataMap.put(rowIndex.toString(), colError);
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 验证单元格数据 **/
	public String validateCellData(int curRow, int curCol, String entityName, String headTitle) {
		String errorMsg = "";
		//获取字段验证规则
		List<Map<String, Object>> rulList = (List<Map<String, Object>>) tplRule.get(curCol+"");
		if (rulList != null && rulList.size() > 0) {
			for (int i = 0; i < rulList.size(); i++) {
				Map<String, Object> rulM = (Map<String, Object>) rulList.get(i);
				String ruleType = (String) rulM.get("ruleType");
				String ruleMsg = (String) rulM.get("ruleMsg");
				Long ruleValue = 0L;
				Integer numValue =0;
				if(StrUtils.notBlank(rulM.get("ruleValue"))){
					ruleValue = Long.valueOf(rulM.get("ruleValue").toString());
				}
				boolean NOTNULL = true;
				if (StrUtils.isBlank(colvalue)) {
					NOTNULL = false;
				}
				//验证规则
				if (CheckConstans.RULE_NAME_NOTNULL.equals(ruleType)) {
					if (!NOTNULL) {
						errorMsg += "第"+ curRow + "行第" + curCol+ "列：" + ruleMsg + "<br>";
					}
				}else if(NOTNULL && CheckConstans.RULE_NAME_MAXSIZE.equals(ruleType)){
					if(colvalue.length()>ruleValue){
						errorMsg += "第"+ curRow + "行第" + curCol+ "列：" + ruleMsg + "<br>";
					}
				}else if(NOTNULL && CheckConstans.RULE_NAME_MINSIZE.equals(ruleType)){
					if(colvalue.length()<ruleValue){
						errorMsg += "第"+ curRow + "行第" + curCol+ "列：" + ruleMsg + "<br>";
					}
				}else if(NOTNULL && CheckConstans.RULE_NAME_MAX.equals(ruleType)){
					try {
						Double value = Double.valueOf(colvalue);
						if(value>ruleValue){
							errorMsg += "第"+ curRow + "行第" + curCol+ "列：" + ruleMsg + "<br>";
						}
					} catch (Exception e) {
						errorMsg += "第"+ curRow + "行第" + curCol+ "列："+headTitle+"列值应为数字类型<br>";
					}
				}else if(NOTNULL && CheckConstans.RULE_NAME_MIN.equals(ruleType)){
					try {
						Double value = Double.valueOf(colvalue);
						if(value<ruleValue){
							errorMsg += "第"+ curRow + "行第" + curCol+ "列：" + ruleMsg + "<br>";
						}
					} catch (Exception e) {
						errorMsg += "第"+ curRow + "行第" + curCol+ "列："+headTitle+"列值应为数字类型<br>";
					}
				}else if(NOTNULL && CheckConstans.RULE_NAME_SEX.equals(ruleType)){
					if("男".equals(colvalue)){
						colvalue = "1";
					}else if("女".equals(colvalue)){
						colvalue = "2";
					}else{
						errorMsg += "第"+ curRow + "行第" + curCol+ "列：" + ruleMsg + "<br>";
					}
				}else if(NOTNULL && CheckConstans.RULE_NAME_YES.equals(ruleType)){
					if("否".equals(colvalue)){
						colvalue = "0";
					}else if("是".equals(colvalue)){
						colvalue = "1";
					}else{
						errorMsg += "第"+ curRow + "行第" + curCol+ "列：" + ruleMsg + "<br>";
					}
				}else if(NOTNULL && CheckConstans.RULE_NAME_NUM.equals(ruleType)){
					try {
						Long value = Long.valueOf(colvalue);
						if(value<numValue){
							errorMsg += "第"+ curRow + "行第" + curCol+ "列：" + ruleMsg + "<br>";
						}
					} catch (Exception e) {
						errorMsg += "第"+ curRow + "行第" + curCol+ "列："+headTitle+"列值应为数字类型<br>";
					}
				}else if(NOTNULL && CheckConstans.RULE_NAME_DATE.equals(ruleType)){
					Date d = DateUtils.parseDate(colvalue);
					if(d==null){
						errorMsg += "第"+ curRow + "行第" + curCol+ "列：" + ruleMsg + "<br>";
					}
				}else if(NOTNULL && CheckConstans.RULE_NAME_DOU.equals(ruleType)){
					
					Double value = Double.valueOf(colvalue);
					if(value==null){
						errorMsg += "第"+ curRow + "行第" + curCol+ "列：" + ruleMsg + "<br>";
					}
				}else if(NOTNULL && CheckConstans.RULE_NAME_EMAIL.equals(ruleType)){
					//email校验
				}else if(NOTNULL && CheckConstans.RULE_NAME_REGEXP.equals(ruleType)){
					//正则校验
				}
			}
		}
		return errorMsg;
	}

	/** 数据类型转换 **/
	public Object toType(String colValue, String colType) throws Exception {
		if(StrUtils.isBlank(colValue)){
			return null;
		}else if("String".equals(colType)){
			return colValue;
		}else if("Integer".equals(colType)){
			Double d = Double.parseDouble(colValue);
			return d.intValue();
		}else if("Double".equals(colType)){
			return Double.parseDouble(colValue);
		}else if("Date".equals(colType)){
			return DateUtils.parseDate(colValue);
		}else if("DateTime".equals(colType)){
			return DateUtils.parseDate(colValue);
		}else if("Short".equals(colType)){
			return Short.parseShort(colValue);
		}
		return null;
	}
	
	/**
	 * 获得单元格字符串
	 * 
	 * @throws UnSupportedCellTypeException
	 */
	public static String getStringCellValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		String result = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_BOOLEAN:
			result = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				result = DateUtils.formatDate(cell.getDateCellValue());
			} else {
				BigDecimal db = new BigDecimal( cell.getNumericCellValue() );  
				result = db.toPlainString() ; 
			}
			break;
		case HSSFCell.CELL_TYPE_STRING:
			if (cell.getRichStringCellValue() == null) {
				result = null;
			} else {
				result = cell.getRichStringCellValue().getString();
			}
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			result = null;
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			try {
				result = String.valueOf(cell.getNumericCellValue());
			} catch (Exception e) {
				result = cell.getRichStringCellValue().getString();
			}
			break;
		default:
			result = "";
		}
		if (result != null) {
			result = result.trim();
		}
		return result;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}


}
