/**
 * 
 */
package com.junkj.common.excel;

/**
 * @author ncepri
 *
 */
public class ReportViewFactory {
 
	 /**
     * Singleton.
     */
    private static ReportViewFactory instance;


    /**
     * Private constructor.
     */
    private ReportViewFactory()  {
        
    }

    /**
     * Returns the simgleton for this class.
     * @return ExportViewFactory instance
     */
    public static synchronized ReportViewFactory getInstance()
    {
        if (instance == null)
        {
            instance = new ReportViewFactory();
        }
        return instance;
    }
    
    public ReportView getReportView(){
    	ReportView reportView = new ReportViewExcel();
    	return reportView;
    }

}
