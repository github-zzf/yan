/**
 * 
 */
package com.junkj.common.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;

import com.junkj.common.lang.NumUtils;
import com.junkj.common.lang.StrUtils;



/**
 * 导出excel报表实现类
 * 
 */
public class ReportViewExcel implements ReportView  {

	private HSSFWorkbook workBook;
	private ReportHeader reportHeader ;
	private List reportData;

	private File execelfile;
 
	
	public ReportViewExcel() {
		super();
	}

	/* 初始化 参数：表头 集合数据
	 */
	public void init(ReportHeader _reportHeader, List _repertData) {
		this.setReportData(_repertData);
		this.setReportHeader(_reportHeader);
	}
	
	/* 生成excel
	 */
	public File doExportReport() {
		return produceReport();
	}
	/*
	 * (non-Javadoc)
	 *   
	 */
	protected  File produceReport() {
		synchronized (this) {
			this.init();
			HSSFSheet sheet = workBook.createSheet();
			workBook.setSheetName(0,getReportHeader().getReportTitle());
			if(!new Integer(0).equals(getReportHeader().getMargin_top()))
				this.produceReportTitle(sheet);
			this.produceReportHeader(sheet);
			this.produceReportBody(sheet);
			FileOutputStream fileOut;
			try {
				fileOut = new FileOutputStream(this.execelfile);
				workBook.write(fileOut);
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return execelfile;
	}
		
	private void init() {
		this.workBook = new HSSFWorkbook();
		File tempDir = new File(ReportUtilsKey.DEFAULT_FILE_DIRECTORY);
		if(!tempDir.exists())
			tempDir.mkdirs();
		String repFilName = ReportUtilsKey.DEFAULT_FILE_DIRECTORY+ System.currentTimeMillis()+"_"+getReportHeader().getFileName();
		this.execelfile = new File(repFilName);
		
	}
	
	private void produceReportTitle(HSSFSheet sheet){
		//单元格样式
		HSSFCellStyle style = workBook.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		//style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//打印预览左竖线
		style.setLeftBorderColor(HSSFColor.GREEN.index);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(HSSFColor.BLUE.index);
		//style.setBorderTop(HSSFCellStyle.BORDER_THIN);//打印预览上横线
		style.setTopBorderColor(HSSFColor.BLACK.index);
		style.setFillBackgroundColor(HSSFColor.YELLOW.index);
		//style.setWrapText(true);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont font = workBook.createFont();
		font.setFontHeight((short)( ( 5*6.5 ) / ( (double) 1 / 10 ) ));
		style.setFont(font);
		//生成标题
		int margin_left = getReportHeader().getMargin_left().intValue();
		int margin_top = getReportHeader().getMargin_top().intValue();
		int colnums = getReportHeader().getColnums().intValue();
		//margion大于0，可以产生表头;
		HSSFRow titleRow ;
		HSSFCell cell ; 
		for (int rowIndex = 0; rowIndex < 1; rowIndex++) {
			titleRow = sheet.createRow((short) rowIndex);
			titleRow.setHeight((short) 0x280);
			for (int colIndex = margin_left; colIndex < colnums+margin_left; colIndex++) {
				cell = titleRow.createCell((short) colIndex);
				if(rowIndex==0 && colIndex==margin_left) {
					HSSFRichTextString textStr = new HSSFRichTextString(getReportHeader().getReportTitle());
					cell.setCellValue(textStr);
					cell.setCellStyle(style);

				}else
					cell.setCellValue("");
			}
		}
		if(margin_top > 0){
			Region titleRegion = new Region(0,(short)margin_left,margin_top-1,(short)(colnums+margin_left-1));
			sheet.addMergedRegion(titleRegion);
		}
	}

	private void produceReportHeader(HSSFSheet sheet) {
		//单元格样式定义
		HSSFCellStyle style = workBook.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		style.setFillBackgroundColor(HSSFColor.YELLOW.index);
		style.setWrapText(true);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont fond = workBook.createFont();
		fond.setBoldweight((short) 25);
		style.setFont(fond);
		//生成表头
		Map headerCellMap = getReportHeader().getReportHeaderCells();
		int margin_left = getReportHeader().getMargin_left().intValue();
		int margin_top = getReportHeader().getMargin_top().intValue();
		int rownums = getReportHeader().getRownums().intValue();
		int colnums = getReportHeader().getColnums().intValue();
		int colwidth = 0;
		HSSFRow headerRow ;
		HSSFCell cell ; 
		for (int rowIndex = margin_top; rowIndex < rownums+margin_top; rowIndex++) {
			headerRow = sheet.createRow((short) rowIndex);
			headerRow.setHeight((short) 0x280);
			List rowTitleList = (List)headerCellMap.get(new Integer(rowIndex-margin_top + 1));
			Iterator rowTitleIter = rowTitleList.iterator();
			if (rowTitleIter.hasNext()) {
				ReportHeaderCell headerCell = (ReportHeaderCell) rowTitleIter.next();
				for (int colIndex = margin_left; colIndex < colnums+margin_left; colIndex++) {
					cell = headerRow.createCell((short) colIndex);
					//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					if (headerCell.getColFrom().intValue()+margin_left == colIndex) {
						cell.setCellValue(headerCell.getHeadTitle());
//						modify colwidth
						colwidth =  headerCell.getColsWidth().intValue();
						if(colwidth!=0){
							 sheet.setColumnWidth( (short) colIndex, (short) ( ( colwidth * 8 ) / ( (double) 1 / 20 ) ) );
							}
						if (rowTitleIter.hasNext())
							headerCell = (ReportHeaderCell) rowTitleIter.next();
					} else{
						cell.setCellValue("");
					}
					cell.setCellStyle(style);
				}
			}

		}
		//merge region 
		for (int rowIndex = margin_top; rowIndex < rownums+margin_top; rowIndex++) {
			List rowTitleList = (List) headerCellMap.get(new Integer(rowIndex-margin_top + 1));
			for (Iterator iterator = rowTitleList.iterator(); iterator.hasNext();) {
				ReportHeaderCell headerCell = (ReportHeaderCell) iterator.next();
				sheet.addMergedRegion(new Region(
						headerCell.getRowFrom().intValue()+margin_top,
						(short)(headerCell.getColFrom().intValue()+margin_left),
						headerCell.getRowTo().intValue()+margin_top,
						(short)(headerCell.getColTo().intValue()+margin_left)));
			}
		}
	}

	private void produceReportBody(HSSFSheet sheet) {
		//单元格样式
		HSSFCellStyle style = workBook.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setFillBackgroundColor(HSSFColor.YELLOW.index);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    //文本区域随内容多少自动调整
		style.setWrapText(true);
		style.setHidden(false);
		
		//单元格样式2
		HSSFCellStyle style2 = workBook.createCellStyle();
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setFillBackgroundColor(HSSFColor.YELLOW.index);
		style2.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    //文本区域随内容多少自动调整
		style2.setWrapText(true);
		style2.setHidden(false);
		
		//单元格样式3
		HSSFCellStyle style3 = workBook.createCellStyle();
		style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style3.setFillBackgroundColor(HSSFColor.YELLOW.index);
		style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    //文本区域随内容多少自动调整
		style3.setWrapText(true);
		style3.setHidden(false);
		
		int headRowNums = getReportHeader().getRownums().intValue();
		int margin_left = getReportHeader().getMargin_left().intValue();
		int margin_top = getReportHeader().getMargin_top().intValue();
		String propertyValue = "";
		String beanProperty = null;
		ReportHeaderCell headerCell = null;
		List dataList = getReportData();
		List titleList = getReportHeader().getHeaderTitleList();
	 	for(int rowIndex=headRowNums+margin_top;rowIndex<dataList.size()+headRowNums+margin_top;rowIndex++){
			HSSFRow bodyRow = sheet.createRow((short)rowIndex);
			Object obj = dataList.get(rowIndex-(headRowNums+margin_top));
			for(int colIndex=margin_left;colIndex<titleList.size()+margin_left;colIndex++){
				headerCell = (ReportHeaderCell)titleList.get(colIndex-margin_left);
				HSSFCell cell = bodyRow.createCell((short)colIndex);
				beanProperty = headerCell.getBeanPropertyName();
				if(beanProperty.equals("beanPropertyName")){
					cell.setCellValue(propertyValue);
				}else if(beanProperty.equals("isExistOrder")){
					cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					cell.setCellValue(rowIndex-(margin_top+headRowNums-1));
				}else{
					try {
						propertyValue = BeanUtils.getProperty(obj,beanProperty);
						//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
						//此处是为了解决导出excel后数字中出现绿色三角并且不能用∑运算问题 09.05.07 zyf
						//问题原因是由于导出时转为了文本类型,这里调用一个方法用异常来做校验是否能转成Double行
						//wcg 但是此处将字符型数字转换成数值型带来了令一个问题就是如专利申请号等长文本字符型数字
						//被转换为数值型后导出excel变为了科学计数法所有如果不希望变成科学计数法可以在propertyValue末尾手工加上一个空格
						if(BeanUtils.getProperty(obj, beanProperty)!=null){
							//不是以空格结尾的 不是以0开头的 数字
							if(!propertyValue.endsWith(" ") && !propertyValue.startsWith("0")&&NumUtils.isNumber(propertyValue)){
								cell.setCellValue(propertyValue.equals("-1")? 0.0:Double.valueOf(propertyValue));
							}else{
								cell.setCellValue(propertyValue.equals("-1")? "0":propertyValue);
							}
						}else{
							cell.setCellValue("");
						}
					} catch (IllegalAccessException e) {
						cell.setCellValue(propertyValue);  
					} catch (InvocationTargetException e) {
						cell.setCellValue(propertyValue);
					} catch (NoSuchMethodException e) {
						cell.setCellValue(propertyValue);
					} 
				}
				//以"%"结尾的符串，居右显示 wjh 2010-07-31
				if(propertyValue!=null&&propertyValue.endsWith("%")){
					cell.setCellStyle(style2);
				}else if(beanProperty.equals("isExistOrder")){
					     cell.setCellStyle(style3);
				     }else{
				    	 cell.setCellStyle(style);
				     }
				propertyValue = "";
			}
		}
	}
	
	
	protected List getReportData() {
		return reportData;
	}

	protected void setReportData(List reportData) {
		if (reportData == null)
			reportData = new ArrayList();
		this.reportData = reportData;
	}

	protected ReportHeader getReportHeader() {
		return reportHeader;
	}

	protected void setReportHeader(ReportHeader reportHeader) {
		this.reportHeader = reportHeader;
	}
	
}
