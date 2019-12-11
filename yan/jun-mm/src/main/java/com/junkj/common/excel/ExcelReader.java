package com.junkj.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * 读excel文件 Company:
 * 
 * @author lwg
 * @version 1.0
 */
public class ExcelReader {
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private InputStream fis;
	private StringBuffer msg = null;
	private int firstrowindex;
	private int lastrowindex;
	private int firstcolindex;
	private int lastcolindex;

	// 构造器
	public ExcelReader(File excelFile) throws IOException {
		fis = new FileInputStream(excelFile);
		workbook = new HSSFWorkbook(fis);
		msg = new StringBuffer();
	}

	// 解决是从struts中的 FormFile得到的excel文件
	public ExcelReader(InputStream fis1) throws IOException {
		this.setFis(fis1);
		workbook = new HSSFWorkbook(new POIFSFileSystem(fis));
		msg = new StringBuffer();
	}

	public void destory() {
		try {
			msg = null;
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 读取第几个工作表
	public boolean setCurSheet(int sheetIndex) {
		// 设置当前的sheet
		if (workbook != null && sheetIndex < workbook.getNumberOfSheets()) {
			try {
				sheet = workbook.getSheetAt(sheetIndex);
				HSSFRow row = sheet.getRow(0);
				if (row != null) {
					this.firstrowindex = sheet.getFirstRowNum();
					this.lastrowindex = sheet.getLastRowNum();
					this.firstcolindex = row.getFirstCellNum();
					this.lastcolindex = row.getLastCellNum();
					if (lastrowindex == firstrowindex)
						return false;
					return true;
				} else {
					return false;
				}
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 将一个sheet中的指定内容以一个二维的表格返回
	 * 
	 * @param sheetIndex
	 *            int 工作表号
	 * @param firstrowindex
	 *            int 首行号
	 * @param lastrowindex
	 *            int 末行号
	 * @param firstcolindex
	 *            int 首列号
	 * @param lastcolindex
	 *            int 末列号
	 * @return String[][] 返回数组
	 */

	public String[][] getSheetAsTable(int sheetIndex) {
		String[][] cells = null;
		if (setCurSheet(sheetIndex)) {
			cells = new String[lastrowindex - firstrowindex + 1][lastcolindex - firstcolindex];
			int row = 0;
			for (int c1 = firstrowindex; c1 <= lastrowindex; c1++, row++) {
				int col = 0;
				for (int c2 = firstcolindex; c2 < lastcolindex; c2++) {
					if (sheet.isColumnHidden(c2) == false) {// 判断该列是否隐藏，如果隐藏则不读取此列信息
															// wjh 2010-04-15
						try {
							cells[row][col++] = getCellAsStringByIndex(c1, c2);
						} catch (Exception ex) {
							cells[row][col++] = "";
						}
					}
				}
			}
		}
		return cells;
	}

	public String dateToString(Date date, String pattern) {
		DateFormat format = new SimpleDateFormat(pattern);
		String str = format.format(date);
		return str;
	}

	public String getCellAsStringByIndex(int rowIndex, int colIndex) {
		// 以字符中方式返回当前sheet中的一个cell
		String cellStr = "";
		if (sheet != null && rowIndex < sheet.getLastRowNum() + 1) {
			try { // sheet为空将执出错误，就是因为上面的那个+1导致的
				HSSFRow row = sheet.getRow(rowIndex);
				if (row != null) {
					if (colIndex < row.getLastCellNum()) {
						HSSFCell cell = row.getCell((short) colIndex);
						if (cell != null) {
							try {
								if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									if (HSSFDateUtil.isCellDateFormatted(cell)) {// 是否为日期型
										String str = dateToString(cell.getDateCellValue(), "yyyy-MM-dd");
									}
								}

								switch (cell.getCellType()) {
								case HSSFCell.CELL_TYPE_NUMERIC: { // CELL_TYPE_NUMERIC
									if (HSSFDateUtil.isCellDateFormatted(cell)) {// 是否为日期型
										cellStr = dateToString(cell.getDateCellValue(), "yyyy-MM-dd");
									} else {// 是否为数值型
										double d = cell.getNumericCellValue();
										if (d - (int) d < Double.MIN_VALUE) { // 是否为int型
											cellStr = Integer.toString((int) d);
										} else { // 是否为double型
											cellStr = Double.toString(cell.getNumericCellValue());
										}
									}
									break;
								}
								case HSSFCell.CELL_TYPE_BOOLEAN: {// 是否为布尔型
									cellStr = Boolean.toString(cell.getBooleanCellValue());
									break;
								}
								case HSSFCell.CELL_TYPE_STRING: {// 是否为字符串型
									cellStr = cell.getRichStringCellValue().toString();
									break;
								}
								case 2: { // CELL_TYPE_FORMULA
											// DATE(),USDOLLAR(),SUM()
									String formula = cell.getCellFormula();
									if (formula.indexOf("DATE(") >= 0) {
										cellStr = HSSFDateUtil.getJavaDate(cell.getNumericCellValue()).toString();
									} else if (formula.indexOf("SUM(") >= 0) {
										cellStr = Double.toString(cell.getNumericCellValue());
									} else {
										cellStr = cell.getStringCellValue();
									}
									break;
								}
								default: {
									cellStr = new String("");
								}
									if (cellStr == null) {
										cellStr = "";
									}
								} // end switch
							} catch (Exception ex) {
								cellStr = "";
							}
						}
					}
				}
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
		}
		return cellStr;
	}

	public String getCellAsStringByIndex(int sheetIndex, int rowIndex, int colIndex) {
		if (setCurSheet(sheetIndex)) {
			return getCellAsStringByIndex(rowIndex, colIndex);
		}
		return "";
	}

	public String getErrorMessage() {
		return msg.toString();
	}

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public HSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(HSSFSheet sheet) {
		this.sheet = sheet;
	}

	public InputStream getFis() {
		return fis;
	}

	public void setFis(InputStream fis) {
		this.fis = fis;
	}

	public StringBuffer getMsg() {
		return msg;
	}

	public void setMsg(StringBuffer msg) {
		this.msg = msg;
	}

}
