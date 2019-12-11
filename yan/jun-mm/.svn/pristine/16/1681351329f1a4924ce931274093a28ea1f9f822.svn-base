package com.junkj.common.excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ncepri
 *
 */
public class ReportHeader {
	private static final Logger logger = LoggerFactory.getLogger(ReportHeader.class);
	/**
	 * @param file 报表文件名称
	 * @param reportTitle 报表的标题
	 * @param reporter 制表人
	 * @param _dateTime 数据时间
	 */
	public ReportHeader(String file,String reportTitle,String reporter,Date _dateTime,Integer margin_left,Integer margin_top) {
		 
		// TODO Auto-generated constructor stub
		this.setFileName(file);
		this.setReportTitle(reportTitle);
		this.setReporter(reporter);
		this.setDataTime(_dateTime);
		this.setMargin_left(margin_left);
		this.setMargin_top(margin_top);
	}
	/**
	 * @param file 报表文件名称
	 * @param reportTitle 报表的标题
	 * @param reporter 制表人
	 * @param _dateTime 数据时间
	 */
	public ReportHeader(String reportTitle,String reporter) {
		this(reportTitle,reportTitle,reporter,new Date(System.currentTimeMillis()),new Integer(0),new Integer(3));
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param file 报表文件名称
	 * @param reportTitle 报表的标题
	 * @param reporter 制表人
	 * @param _dateTime 数据时间
	 */
	public ReportHeader(String reportTitle,String reporter,Integer margin_left,Integer margin_top) {
		this(reportTitle,reportTitle,reporter,new Date(System.currentTimeMillis()),margin_left,margin_top);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param file 报表文件名称
	 * @param reportTitle 报表的标题
	 * @param reporter 制表人
	 * @param _dateTime 数据时间
	 */
	public ReportHeader(String reportTitle,String reporter,Date _dateTime) {
		this(reportTitle,reportTitle,reporter,_dateTime,new Integer(0),new Integer(2));
		// TODO Auto-generated constructor stub
	}
	private boolean isExiOrder=false;
	private String filename;
	private String reportTitle;
	private String reporter;
	private Date dataTime;
	private Integer rownums = new Integer(0);
	private Integer colnums = new Integer(0);
	private Integer margin_left = new Integer(0);
	private Integer margin_top = new Integer(3);//上边缘距离 ==0没有标题
	/**
	 * 报表头属性集合;
	 */
	private List headerTitleList = new ArrayList();
	/**
	 * 报表头HeaderCell集合;
	 */
	private List headerCellList = new ArrayList();
	
	public void addHeaderCell(ReportHeaderCell headerCell){
		logger.debug(headerCell.getHeadTitle()+" 孩子节点的属性 ："+headerCell.getBeanPropertyList().size()+" 最大孩子节点数 ："+headerCell.getMaxChildren());
		//headcells
		this.getHeaderCellList().add(headerCell);
		//rownums
		if(headerCell.getMaxFloor().intValue()>this.getRownums().intValue())
			this.setRownums(headerCell.getMaxFloor());
		//beanproperty
		if(headerCell.getChildrenList().size()>0){
			this.getHeaderTitleList().addAll(headerCell.getBeanPropertyList());
		}else{
			this.getHeaderTitleList().add(headerCell);
		}
		//colnums
		this.setColnums(new Integer(this.getHeaderTitleList().size()));
		
	}
	public void addHeaderCells(List headerCells){
		Iterator headerIter = headerCells.iterator();
		ReportHeaderCell headerCell = null;
		while(headerIter.hasNext()){
			headerCell = (ReportHeaderCell)headerIter.next();
			this.addHeaderCell(headerCell);
		}
		this.cleanUpHeaderCells();
	}
	public void cleanUpHeaderCells(){
		List headerCells = this.getHeaderCellList();
		for(int headerIndex=0;headerIndex<headerCells.size();headerIndex++){
			ReportHeaderCell  headerCell = (ReportHeaderCell)headerCells.get(headerIndex);
			List headerChildren = headerCell.getChildrenList();
			headerCell.setRowFrom(new Integer(headerCell.getCurFloor().intValue()-1));
			headerCell.setColFrom(new Short((short)(headerIndex==0? 0:((ReportHeaderCell)headerCells.get(headerIndex-1)).getColTo().intValue()+1)));
			if(headerChildren.size()>0){
				headerCell.setRowTo(new Integer(headerCell.getCurFloor().intValue()-1));
				this._cleanUpHeaderCells(headerChildren);
			}else{
				headerCell.setRowTo(new Integer(this.rownums.intValue()-1));
			}
			headerCell.setColTo(new Short((short)(headerCell.getColFrom().intValue()+headerCell.getMaxChildren().intValue()-1)));
		}
	}
	private void _cleanUpHeaderCells(List headerCells){
		
		for(int headerIndex=0;headerIndex<headerCells.size();headerIndex++){
			ReportHeaderCell  headerCell = (ReportHeaderCell)headerCells.get(headerIndex);
			List headerChildren = headerCell.getChildrenList();
			headerCell.setRowFrom(new Integer(headerCell.getCurFloor().intValue()-1));
			headerCell.setColFrom(new Short((short)(headerIndex==0? headerCell.getParentHeaderCell().getColFrom().intValue():((ReportHeaderCell)headerCells.get(headerIndex-1)).getColTo().intValue()+1)));
			if(headerChildren.size()>0){
				headerCell.setRowTo(new Integer(headerCell.getCurFloor().intValue()-1));
				this._cleanUpHeaderCells(headerChildren);
			}else{
				headerCell.setRowTo(new Integer(this.rownums.intValue()-1));
			}
			headerCell.setColTo(new Short((short)(headerCell.getColFrom().intValue()+(headerCell.getMaxChildren().intValue()-1))));
		}
	}
	
	public List getHeaderCellList() {
		return headerCellList;
	}
	public Map getReportHeaderCells() {
		Map reportHeader = new TreeMap();
		List headerCells = this.getHeaderCellList();
		for (Iterator iter = headerCells.iterator(); iter.hasNext();) {
			ReportHeaderCell headerCell = (ReportHeaderCell) iter.next();
			Integer curFloor = headerCell.getCurFloor();
			List headerList = (List)reportHeader.get(curFloor);
			if(headerList==null){
				headerList = new ArrayList();
				reportHeader.put(curFloor,headerList);
			}
			headerList.add(headerCell);
			List headChildren = headerCell.getChildrenList();
			if(headChildren.size()>0){
				this._getReportHeaderCells(reportHeader,headChildren);
			}
		}
		return reportHeader;
	}
	private void _getReportHeaderCells(Map reportHeader,List headerCells) {
		for (Iterator iter = headerCells.iterator(); iter.hasNext();) {
			ReportHeaderCell headerCell = (ReportHeaderCell) iter.next();
			Integer curFloor = headerCell.getCurFloor();
			List headerList = (List)reportHeader.get(curFloor);
			if(headerList==null){
				headerList = new ArrayList();
				reportHeader.put(curFloor,headerList);
			}
			headerList.add(headerCell);
			List headChildren = headerCell.getChildrenList();
			if(headChildren.size()>0){
				this._getReportHeaderCells(reportHeader,headChildren);
			}
		}
	}
	public void setHeaderCellList(List headerCellList) {
		this.headerCellList = headerCellList;
	}
	public List getHeaderTitleList() {
		return headerTitleList;
	}
	
	public void setHeaderTitleList(List headerTitleList) {
		this.headerTitleList = headerTitleList;
	}
	public Integer getColnums() {
		return colnums;
	}
	public void setColnums(Integer colnums) {
		this.colnums = colnums;
	}
	public Integer getRownums() {
		return rownums;
	}
	public void setRownums(Integer rownums) {
		this.rownums = rownums;
	}
	public Integer getMargin_left() {
		return margin_left;
	}
	public void setMargin_left(Integer margin_left) {
		this.margin_left = margin_left;
	}
	public Integer getMargin_top() {
		return margin_top;
	}
	public void setMargin_top(Integer margin_top) {
		this.margin_top = margin_top;
	}
	public Date getDataTime() {
		return dataTime;
	}
	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}
	public String getFileName() {
		return filename;
	}
	public void setFileName(String file) {
		if(!file.endsWith(".xlsx"))
			file += ".xlsx";
		this.filename = file;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public boolean isExiOrder() {
		return isExiOrder;
	}
	/**
	 * 
	 * append default report record sequence when isExiOrder is false;
	 * @param isExiOrder
	 * @param orderTitle
	 */
	public void setIsExiOrder(boolean isExiOrder,String orderTitle) {
		this.isExiOrder = isExiOrder;
		logger.debug("before adding default sequence number titlelist size is "+this.getHeaderTitleList().size());
		if(!this.isExiOrder){
			ReportHeaderCell CelSeqNumber =  new ReportHeaderCell(orderTitle,"isExistOrder");
			CelSeqNumber.setColsWidth(new Integer(8));
			if(this.getHeaderCellList().size()>0){
				List reHeaderList = new ArrayList();
				//set header cells
				reHeaderList.add(CelSeqNumber);
				reHeaderList.addAll(this.getHeaderCellList());
				logger.debug("add default sequence number title into the headertitlelist");
				this.setHeaderCellList(reHeaderList);
//				set header titles
				reHeaderList = new ArrayList();
				//set header cells
				reHeaderList.add(CelSeqNumber);
				reHeaderList.addAll(this.getHeaderTitleList());
				this.setHeaderTitleList(reHeaderList);
				this.setColnums(new Integer(this.getHeaderTitleList().size()));
				this.cleanUpHeaderCells();
			}else
				this.addHeaderCell(CelSeqNumber);
		}
		logger.debug("after adding default sequence number titlelist size is "+this.getHeaderTitleList().size());
		
	}
	/**
	 * append default report record sequence when isExiOrder is false
	 * @param isExiOrder
	 * @param orderTitle
	 */
	public void setIsExiOrder(boolean isExiOrder) {
		this.setIsExiOrder(isExiOrder,ReportUtilsKey.DEFAULT_SEQUENCENUMBER_TITLE);
	}

}
