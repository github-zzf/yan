package com.junkj.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.junkj.common.reflect.ReflectUtils;

/**
 * Excel util, create excel sheet, cell and style.
 * 
 * @param <T>
 *            generic class.
 */
public class ExcelUtils<T> {
	public final static SimpleDateFormat YMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat YMD = new SimpleDateFormat("yyyy年MM月dd日");

	public XSSFCellStyle getCellStyle(XSSFWorkbook workbook, boolean isTitle) {
		// 普通字体设置
		XSSFFont commonFont = workbook.createFont();
		commonFont.setFontName("仿宋_GB2312");
		if (isTitle) {
			commonFont.setFontHeightInPoints((short) 11);
		} else {
			commonFont.setFontHeightInPoints((short) 10);
		}
		commonFont.setColor(XSSFFont.COLOR_NORMAL);
		// 创建列标题样式 不加粗居中底部无网格线
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setFont(commonFont);
		style.setWrapText(true);// 自动换行
		return style;
	}

	public void setTitle(XSSFWorkbook workbook, XSSFSheet sheet, String title, int colSize) {
		// 标题字体设置
		XSSFFont headFont = workbook.createFont();
		headFont.setFontName("仿宋_GB2312");
		headFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
		headFont.setFontHeightInPoints((short) 15);
		headFont.setColor(XSSFFont.COLOR_NORMAL);
		// 创建一个标题样式
		XSSFCellStyle headStyle = workbook.createCellStyle();
		headStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		headStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		headStyle.setFont(headFont);
		// 标题行
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, colSize - 1));
		XSSFRow headRow = sheet.createRow(0);
		XSSFCell headCell = headRow.createCell(0);
		headRow.setHeight((short) 500);
		headCell.setCellValue(title);
		headCell.setCellStyle(headStyle);
	}

	public void setColTitle(XSSFWorkbook workbook, XSSFSheet sheet, String[] headerColumns) {
		// 标题字体设置
		XSSFFont headFont = workbook.createFont();
		headFont.setFontName("仿宋_GB2312");
		headFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
		headFont.setColor(XSSFFont.COLOR_NORMAL);

		XSSFCellStyle style = getCellStyle(workbook, true);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setFont(headFont);

		Row row = sheet.createRow(1);
		row.setHeight((short) 500);
		for (int i = 0; i < headerColumns.length; i++) {
			Cell cell = row.createCell(i);
			String[] column = headerColumns[i].split("_#_");
			sheet.setColumnWidth(i, Integer.valueOf(column[1]));
			cell.setCellValue(column[0]);
			cell.setCellStyle(style);
		}
	}

	public void setColTitle(XSSFWorkbook workbook, XSSFSheet sheet, String[] headerColumns, Integer rowNum) {
		// 标题字体设置
		XSSFFont headFont = workbook.createFont();
		headFont.setFontName("仿宋_GB2312");
		headFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
		headFont.setColor(XSSFFont.COLOR_NORMAL);

		XSSFCellStyle style = getCellStyle(workbook, true);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setFont(headFont);

		Row row = sheet.createRow(rowNum);
		row.setHeight((short) 500);
		for (int i = 0; i < headerColumns.length; i++) {
			Cell cell = row.createCell(i);
			String[] column = headerColumns[i].split("_#_");
			Integer columnWidth = sheet.getColumnWidth(i);
			if (columnWidth < Integer.valueOf(column[1])) {
				sheet.setColumnWidth(i, Integer.valueOf(column[1]));
			}
			cell.setCellValue(column[0]);
			cell.setCellStyle(style);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public XSSFSheet creatAuditSheet(XSSFWorkbook workbook, String sheetName, List<T> dataset, String[] headerColumns,
			String[] fieldColumns) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException,
					InvocationTargetException {

		XSSFSheet sheet = workbook.createSheet(sheetName);
		setTitle(workbook, sheet, sheetName, headerColumns.length);
		setColTitle(workbook, sheet, headerColumns);

		XSSFCellStyle style = getCellStyle(workbook, false);
		int rowNum = 1;
		for (T t : dataset) {
			rowNum++;
			Row row = sheet.createRow(rowNum);
			row.setHeight((short) 2000);
			for (int i = 0; i < fieldColumns.length; i++) {
				String fieldName = fieldColumns[i];
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					Class clazz = t.getClass();
					Method getMethod;
					getMethod = clazz.getMethod(getMethodName, new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});
					String cellValue = "";
					if (value instanceof Date) {
						Date date = (Date) value;
						cellValue = YMDHMS.format(date);
					} else {
						cellValue = null != value ? value.toString() : "";
					}
					Cell cell = row.createCell(i);
					cell.setCellStyle(style);
					cell.setCellValue(cellValue);

				} catch (Exception e) {

				}
			}
		}
		return sheet;
	}

	public void creatAuditSheetforT(XSSFWorkbook workbook, String sheetName, List<?> dataset, String[] headerColumns,
			String[] fieldColumns) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException,
					InvocationTargetException {

		XSSFSheet sheet = workbook.createSheet(sheetName);
		setTitle(workbook, sheet, sheetName, headerColumns.length);
		setColTitle(workbook, sheet, headerColumns);

		XSSFCellStyle style = getCellStyle(workbook, false);
		int rowNum = 1;
		int sheetNum = 1;
		for (int index = 0; index < dataset.size(); index++) {
			if (rowNum > 50000) {
				rowNum = 0;
				sheetNum++;
				sheet = workbook.createSheet(sheetName + sheetNum);
				setColTitle(workbook, sheet, headerColumns);
			}
			rowNum++;
			Row row = sheet.createRow(rowNum);
			row.setHeight((short) 500);
			for (int i = 0; i < fieldColumns.length; i++) {
				String fieldName = fieldColumns[i];
				try {
					Object value = ReflectUtils.invokeGetter(dataset.get(index), fieldName);
					String cellValue = "";
					if (value instanceof Date) {
						Date date = (Date) value;
						cellValue = YMDHMS.format(date);
					} else {
						cellValue = null != value ? value.toString() : "";
					}
					Cell cell = row.createCell(i);
					cell.setCellStyle(style);
					cell.setCellValue(cellValue);
				} catch (Exception e) {

				}
			}
		}
	}

	public void creatAuditSheetforMap(XSSFWorkbook workbook, String sheetName, List<Map<String, Object>> dataset,
			String[] headerColumns, String[] fieldColumns) throws NoSuchMethodException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException {

		XSSFSheet sheet = workbook.createSheet(sheetName);
		setTitle(workbook, sheet, sheetName, headerColumns.length);
		setColTitle(workbook, sheet, headerColumns);

		XSSFCellStyle style = getCellStyle(workbook, false);
		int rowNum = 1;
		int sheetNum = 1;
		for (Map<String, Object> t : dataset) {
			if (rowNum > 50000) {
				rowNum = 0;
				sheetNum++;
				sheet = workbook.createSheet(sheetName + sheetNum);
				setColTitle(workbook, sheet, headerColumns);
			}
			rowNum++;
			Row row = sheet.createRow(rowNum);
			row.setHeight((short) 500);
			for (int i = 0; i < fieldColumns.length; i++) {
				String fieldName = fieldColumns[i];
				try {
					Object value = t.get(fieldName);
					String cellValue = "";
					if (value instanceof Date) {
						Date date = (Date) value;
						cellValue = YMDHMS.format(date);
					} else {
						cellValue = null != value ? value.toString() : "";
					}
					Cell cell = row.createCell(i);
					cell.setCellStyle(style);
					cell.setCellValue(cellValue);
				} catch (Exception e) {

				}
			}
		}
	}

	public void creatAuditSheetforDetail(XSSFWorkbook workbook, String sheetName, List<Map<String, Object>> dataAllo,
			String[] headerColumns, String[] fieldColumns, List<Map<String, Object>> dataDet, String[] headerColumnsDet,
			String[] fieldColumnsDet) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException,
					InvocationTargetException {

		XSSFSheet sheet = workbook.createSheet(sheetName);
		setTitle(workbook, sheet, sheetName, headerColumns.length);
		setColTitle(workbook, sheet, headerColumns);

		XSSFCellStyle style = getCellStyle(workbook, false);
		int rowNum = 1;
		int sheetNum = 1;
		for (Map<String, Object> t : dataAllo) {
			if (rowNum > 50000) {
				rowNum = 0;
				sheetNum++;
				sheet = workbook.createSheet(sheetName + sheetNum);
				setColTitle(workbook, sheet, headerColumns);
			}
			rowNum++;
			Row row = sheet.createRow(rowNum);
			row.setHeight((short) 500);
			for (int i = 0; i < fieldColumns.length; i++) {
				String fieldName = fieldColumns[i];
				try {
					Object value = t.get(fieldName);
					String cellValue = "";
					if (value instanceof Date) {
						Date date = (Date) value;
						cellValue = YMDHMS.format(date);
					} else {
						cellValue = null != value ? value.toString() : "";
					}
					Cell cell = row.createCell(i);
					cell.setCellStyle(style);
					cell.setCellValue(cellValue);
				} catch (Exception e) {

				}
			}
		}

		rowNum++;
		setColTitle(workbook, sheet, headerColumnsDet, rowNum);
		for (Map<String, Object> t : dataDet) {
			if (rowNum > 50000) {
				rowNum = 0;
				sheetNum++;
				sheet = workbook.createSheet(sheetName + sheetNum);
				setColTitle(workbook, sheet, headerColumnsDet);
			}
			rowNum++;
			Row row = sheet.createRow(rowNum);
			row.setHeight((short) 500);
			for (int i = 0; i < fieldColumnsDet.length; i++) {
				String fieldName = fieldColumnsDet[i];
				try {
					Object value = t.get(fieldName);
					String cellValue = "";
					if (value instanceof Date) {
						Date date = (Date) value;
						cellValue = YMDHMS.format(date);
					} else {
						cellValue = null != value ? value.toString() : "";
					}
					Cell cell = row.createCell(i);
					cell.setCellStyle(style);
					cell.setCellValue(cellValue);
				} catch (Exception e) {

				}
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void creatDeliveryOrder(XSSFWorkbook workbook, String sheetName, List<Map<String, Object>> dataset)
			throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		XSSFSheet sheet = workbook.createSheet(sheetName);
		setTitle(workbook, sheet, sheetName, 4);// 页面标题
		int rowNum = 0;
		int sheetNum = 1;
		String shopCode = "";// 用于判断是否需要创建门店行
		for (Map<String, Object> t : dataset) {
			if (rowNum > 50000) {// 换页
				rowNum = 0;
				sheetNum++;
				sheet = workbook.createSheet(sheetName + sheetNum);
			}
			String[] shopData = { t.get("shopName").toString(), t.get("shopCode").toString() };
			if (!shopCode.equals(t.get("shopCode").toString())) {
				rowNum++;
				setShopRow(workbook, sheet, shopData, rowNum);// 门店行
			}
			rowNum++;
			Object[] alloData = { "订单号：", t.get("allocationCode"), "出货日期", t.get("allocationTime") };
			setStandardRow(workbook, sheet, alloData, rowNum);// 订单行
			rowNum++;
			String[] proData = { "序号", "产品名称", "数量" };
			setProRow(workbook, sheet, proData, rowNum);// 产品行
			rowNum++;
			List<Map<String, Object>> list = (List<Map<String, Object>>) t.get("proList");
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> pro = list.get(i);
				String[] data = { String.valueOf(i + 1), pro.get("proName").toString(),
						pro.get("allocationNum").toString() };
				setProRow(workbook, sheet, data, rowNum);// 产品信息
				rowNum++;
			}
			String[] manageData = { "收货人：", "", "发货人：", "" };
			setStandardRow(workbook, sheet, manageData, rowNum);// 库管标题
			rowNum = rowNum + 2;
			shopCode = t.get("shopCode").toString();
		}
	}

	/**
	 * 设置标题样式
	 * 
	 * @param workbook
	 * @param sheet
	 */
	private XSSFCellStyle setTitleStyle(XSSFWorkbook workbook, XSSFSheet sheet) {
		// 标题字体设置
		XSSFFont headFont = workbook.createFont();
		headFont.setFontName("仿宋_GB2312");
		headFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
		headFont.setColor(XSSFFont.COLOR_NORMAL);

		XSSFCellStyle style = getCellStyle(workbook, true);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setFont(headFont);

		return style;
	}

	/**
	 * 设置门店行
	 * 
	 * @param workbook
	 * @param sheet
	 * @param shopData
	 * @param rowNum
	 */
	public void setShopRow(XSSFWorkbook workbook, XSSFSheet sheet, String[] shopData, Integer rowNum) {
		// 标题字体设置
		XSSFCellStyle style = setTitleStyle(workbook, sheet);

		sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 0, 2));
		Row row = sheet.createRow(rowNum);
		row.setHeight((short) 500);

		Cell cell1 = row.createCell(0);
		sheet.setColumnWidth(0, 16500);
		cell1.setCellValue(shopData[0]);
		cell1.setCellStyle(style);

		Cell cell2 = row.createCell(1);
		cell2.setCellStyle(style);
		Cell cell3 = row.createCell(2);
		cell3.setCellStyle(style);

		Cell cell4 = row.createCell(3);
		sheet.setColumnWidth(3, 5500);
		cell4.setCellValue(shopData[1]);
		cell4.setCellStyle(style);
	}

	/**
	 * 设置标准行
	 * 
	 * @param workbook
	 * @param sheet
	 * @param data
	 * @param rowNum
	 */
	public void setStandardRow(XSSFWorkbook workbook, XSSFSheet sheet, Object[] data, Integer rowNum) {
		// 标题字体设置
		XSSFCellStyle style = setTitleStyle(workbook, sheet);

		Row row = sheet.createRow(rowNum);
		row.setHeight((short) 600);

		for (int i = 0; i < data.length; i++) {
			Cell cell = row.createCell(i);
			sheet.setColumnWidth(i, 5500);

			String cellValue = "";
			if (data[i] instanceof Date) {
				Date date = (Date) data[i];
				cellValue = YMD.format(date);
			} else {
				cellValue = null != data[i] ? data[i].toString() : "";
			}
			cell.setCellValue(cellValue);
			cell.setCellStyle(style);
		}
	}

	/**
	 * 设置产品行
	 * 
	 * @param workbook
	 * @param sheet
	 * @param ProData
	 * @param rowNum
	 */
	public void setProRow(XSSFWorkbook workbook, XSSFSheet sheet, String[] ProData, Integer rowNum) {
		// 标题字体设置
		XSSFCellStyle style = setTitleStyle(workbook, sheet);

		sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 1, 2));
		Row row = sheet.createRow(rowNum);
		row.setHeight((short) 500);

		Cell cell1 = row.createCell(0);
		sheet.setColumnWidth(0, 5500);
		cell1.setCellValue(ProData[0]);
		cell1.setCellStyle(style);

		Cell cell2 = row.createCell(1);
		sheet.setColumnWidth(1, 11000);
		cell2.setCellValue(ProData[1]);
		cell2.setCellStyle(style);

		Cell cell3 = row.createCell(2);
		cell3.setCellStyle(style);

		Cell cell4 = row.createCell(3);
		sheet.setColumnWidth(3, 5500);
		cell4.setCellValue(ProData[2]);
		cell4.setCellStyle(style);
	}

}