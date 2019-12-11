
package com.junkj.common.excel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * DataObject representing the column header. The header cell contains all the
 * properties common to cells in the same column.
 * 
 * @author Fabrizio Giustina
 * @version $Revision: 1.1 $ ($Author: chengxu $)
 */

/**
 * @author ncepri
 * 
 */
public class ReportHeaderCell {
	private static final Logger logger = LoggerFactory.getLogger(ReportHeaderCell.class);

	public ReportHeaderCell(String headTitle, String beanPropertyName) {
		this.headTitle = headTitle;
		this.beanPropertyName = beanPropertyName;
		if(this.isBottomOrParent())
			this.getBeanPropertyList().add(this);
	}
	
	public ReportHeaderCell(String headTitle) {
		this.headTitle = headTitle;
		this.beanPropertyName = "beanPropertyName";
		if(this.isBottomOrParent())
			this.getBeanPropertyList().add(this);
	}
	private Integer colsWidth=new Integer(0);
	/**
	 * column headTitle.
	 */
	private String headTitle;

	/**
	 * column beanPropertyName.
	 */
	private String beanPropertyName = "";

	/**
	 * 当前树的所有子节点的对应的类的属性名称;
	 */
	private List beanPropertyList = new ArrayList();

	/**
	 * 父节点;
	 */
	private ReportHeaderCell parentHeaderCell = null;

	/**
	 * 当前节点的孩子分支节点的总数;
	 */
	private List childrenList = new ArrayList();

	/**
	 * 当前节点下所有的分支以及分支延续的分支 除去含有分支的节点 共有多少个子节点
	 */
	private Integer maxChildren = new Integer(1);

	/**
	 * 根节点；
	 */
	private boolean isRoot = true;

	/**
	 * 是否是叶子几点 ture 是叶子节点 false 非叶子节点；
	 */
	private boolean isBottomOrParent = true;

	/**
	 * 当前节点的层数
	 */
	private Integer curFloor = new Integer(1);

	/**
	 * 最大节点的层数
	 */
	private Integer maxFloor = new Integer(1);;

	/**
	 * column colPos 报表标题的位置 处在某行的第几列;
	 */
	private Integer colPos;

	/**
	 * 设置报表标题头的范围
	 */
	private Integer rowFrom; // 从第几行开始;

	private Short colFrom; // 从第几列开始;

	private Integer rowTo; // 到第几行结束;

	private Short colTo; // 到第几列结束;

	public void addHeaderCell(ReportHeaderCell header) {

		this.getChildrenList().add(header);

		// 设置父节点 parentHeaderCell
		header.setParentHeaderCell(this);

		// maxFloor curfloor;
		header.setCurFloor(new Integer(this.getCurFloor().intValue() + 1));
		if (header.getCurFloor().intValue() > this.getMaxFloor().intValue()) {
			this.setMaxFloor(header.getCurFloor());
		}
		header.setMaxFloor(this.getMaxFloor());

		// maxchildren
		if (this.maxChildren.intValue() == 1) {
 			this.maxChildren = new Integer(this.getChildrenList().size());
		} else {
			this.maxChildren = new Integer(this.maxChildren.intValue() + 1);
		}

		// 与子节点同步maxfloor 以及 curfloor
		List headerChildren = header.getChildrenList();
		if (headerChildren.size() > 0) {
			this.chageHeaderCellState(header, false);
			this.maxChildren = new Integer(this.maxChildren.intValue() - 1 + headerChildren.size());
			this.evalCurFloor(headerChildren, header);
		} else { 
			// 默认值 1 ;
			// header.maxChildren = new Integer(1);
			this.chageHeaderCellState(header, true);
		}

		// 与子节点同步maxfloor
		ReportHeaderCell parHeaderCell = this.getParentHeaderCell();
		if (parHeaderCell != null) {
			this.chageHeaderCellState(parHeaderCell, false);
			parHeaderCell.setMaxFloor(this.getMaxFloor());
			if (this.getChildrenList().size() != 1)
				parHeaderCell.maxChildren = new Integer(parHeaderCell.maxChildren.intValue() + 1);
			this.evalMaxFloor(parHeaderCell);
		}
		this.chageHeaderCellState(this);
//		logger.debug(this.headTitle+" "+this.maxChildren);
	}

	/**
	 * 反方向计算maxFloor
	 * 
	 * @param headerCell
	 */
	private void evalMaxFloor(ReportHeaderCell headerCell) {
		ReportHeaderCell parHeaderCell = headerCell.getParentHeaderCell();
		if (parHeaderCell != null) {
			this.chageHeaderCellState(parHeaderCell, false);
			parHeaderCell.setMaxFloor(this.getMaxFloor());
			if (this.getChildrenList().size() != 1)
				parHeaderCell.maxChildren = new Integer(parHeaderCell.maxChildren.intValue() + 1);
			this.evalMaxFloor(parHeaderCell);
		}
	}

	/**
	 * 正方向计算curFloor
	 * 
	 * @param headerCell
	 */
	private void evalCurFloor(List headerList, ReportHeaderCell parHeaderCell) {
		for (Iterator iter = headerList.iterator(); iter.hasNext();) {
			ReportHeaderCell headerCell = (ReportHeaderCell) iter.next();
			headerCell.setCurFloor(new Integer(parHeaderCell.getCurFloor().intValue() + 1));
			if (headerCell.getCurFloor().intValue() > this.getMaxFloor().intValue())
				this.setMaxFloor(headerCell.getCurFloor());
			headerCell.setMaxFloor(this.getMaxFloor());
			parHeaderCell.setMaxFloor(this.getMaxFloor());
			List headerChildren = headerCell.getChildrenList();
			if (headerChildren.size() > 0) {
				this.chageHeaderCellState(headerCell, false);
				this.maxChildren = new Integer(this.maxChildren.intValue() - 1
						+ headerChildren.size());
				this.evalCurFloor(headerChildren, headerCell);
			} else {
				this.chageHeaderCellState(headerCell, true);
			}
		}

	}

	/**
	 * 初始化该节点的相关信息;ture 是叶子节点 false 非叶子节点；
	 */
	private void chageHeaderCellState(ReportHeaderCell headerCell) {
		// 是否是根节点
		headerCell.setRoot(headerCell.getParentHeaderCell() == null ? true
				: false);
		// 是不是叶子节点;
		headerCell.setBottomOrParent(headerCell.getChildrenList().size() == 0 ? true
				: false);
		this.addBeanPropertyToBeanPropertyList(headerCell);
	}

	/**
	 * 初始化该节点的相关信息;ture 是叶子节点 false 非叶子节点；
	 */
	private void chageHeaderCellState(ReportHeaderCell headerCell,
			boolean isBottomOrParent) {
		// 是否是根节点
		headerCell.setRoot(headerCell.getParentHeaderCell() == null ? true
				: false);
		// 是不是叶子节点;
		headerCell.setBottomOrParent(isBottomOrParent);
		this.addBeanPropertyToBeanPropertyList(headerCell);
	}

	/**
	 * 将该树字节点对应的属性名称加入该树的节点属性集合中;
	 * 
	 * @param headerCell
	 */
	private void addBeanPropertyToBeanPropertyList(ReportHeaderCell headerCell) {
		// if true 叶子节点 （判断是否存在此headercell 若不存在加入否则无操作）
		// if false 非叶子节点 （判断是否存在此headercell 若存在删除否则无操作）
//		logger.debug("判断是否是叶子节点 :"+headerCell.getHeadTitle()+" "+headerCell.isBottomOrParent());
		ReportHeaderCell parHeaderCell = this.findTopHeaderCell(this);
		if (headerCell.isBottomOrParent()) {
			if (!parHeaderCell.getBeanPropertyList().contains(headerCell)){
				parHeaderCell.getBeanPropertyList().add(headerCell);
				logger.debug(parHeaderCell.getHeadTitle()+" "+parHeaderCell.getBeanPropertyList().size()+"加入<>判断是否是叶子节点 :"+headerCell.getHeadTitle()+" "+headerCell.isBottomOrParent());
			}
		} else {
			if (parHeaderCell.getBeanPropertyList().contains(headerCell)){
				parHeaderCell.getBeanPropertyList().remove(headerCell);
				logger.debug(parHeaderCell.getHeadTitle()+" "+parHeaderCell.getBeanPropertyList().size()+"删除<>判断是否是叶子节点 :"+headerCell.getHeadTitle()+" "+headerCell.isBottomOrParent());
			}
		}
	}
	private ReportHeaderCell findTopHeaderCell(ReportHeaderCell headerCell){
		ReportHeaderCell parHeaderCell = headerCell.getParentHeaderCell();
		if(parHeaderCell==null && headerCell.isRoot())
			return headerCell;
		else 
			return this.findTopHeaderCell(parHeaderCell);
	}
	public String getBeanPropertyName() {
		return beanPropertyName;
	}

	public void setBeanPropertyName(String beanPropertyName) {
		this.beanPropertyName = beanPropertyName;
	}

	public List getChildrenList() {
		return childrenList;
	}

	public void setChildrenList(List childrenList) {
		this.childrenList = childrenList;
	}

	public Short getColFrom() {
		return colFrom;
	}

	public void setColFrom(Short colFrom) {
		this.colFrom = colFrom;
	}

	public Integer getColPos() {
		return colPos;
	}

	public void setColPos(Integer colPos) {
		this.colPos = colPos;
	}

	public Short getColTo() {
		return colTo;
	}

	public void setColTo(Short colTo) {
		this.colTo = colTo;
	}

	public Integer getCurFloor() {
		return curFloor;
	}

	public void setCurFloor(Integer curFloor) {
		this.curFloor = curFloor;
	}

	public String getHeadTitle() {
		return headTitle;
	}

	public void setHeadTitle(String headTitle) {
		this.headTitle = headTitle;
	}

	public boolean isBottomOrParent() {
		return isBottomOrParent;
	}

	public void setBottomOrParent(boolean isBottomOrParent) {
		this.isBottomOrParent = isBottomOrParent;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	public Integer getMaxFloor() {
		return maxFloor;
	}

	public void setMaxFloor(Integer maxFloor) {
		this.maxFloor = maxFloor;
	}

	public ReportHeaderCell getParentHeaderCell() {
		return parentHeaderCell;
	}

	public void setParentHeaderCell(ReportHeaderCell parentHeaderCell) {
		this.parentHeaderCell = parentHeaderCell;
	}

	public Integer getRowFrom() {
		return rowFrom;
	}

	public void setRowFrom(Integer rowFrom) {
		this.rowFrom = rowFrom;
	}

	public Integer getRowTo() {
		return rowTo;
	}

	public void setRowTo(Integer rowTo) {
		this.rowTo = rowTo;
	}

	public Integer getMaxChildren() {
		return maxChildren;
	}

	public void setMaxChildren(Integer maxChildren) {
		this.maxChildren = maxChildren;
	}

	public List getBeanPropertyList() {
		return beanPropertyList;
	}

	public void setBeanPropertyList(List beanPropertyList) {
		this.beanPropertyList = beanPropertyList;
	}

	public Integer getColsWidth() {
		return colsWidth;
	}

	public void setColsWidth(Integer colsWidth) {
		this.colsWidth = colsWidth;
	}

}