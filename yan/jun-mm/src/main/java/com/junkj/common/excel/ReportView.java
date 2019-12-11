package com.junkj.common.excel;

import java.io.File;
import java.util.List;

public interface ReportView {
	
	public void init(ReportHeader reportHeader , List repertData);
	
	public File doExportReport(); 
}
