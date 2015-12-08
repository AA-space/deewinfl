package com.business.service.financeReport;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;

import com.business.entity.base.BaseFile;
import com.business.entity.base.FinanceReportBean;
import com.business.entity.base.FinanceReportParamBean;
import com.business.entity.cust.CustInfo;

public interface FinanceReportService {
     public  String insertFinanceReport(HttpServletRequest request, HttpServletResponse response) throws Exception;
     public  Map<String,FinanceReportBean> getClassFieldExcel(String targerTalbe,String className) throws Exception;
     public  List<FinanceReportParamBean> getImportParams(String params) throws Exception;
     public <T> Collection<T> getFinanceReprotEntitysByConfig(Sheet sheet,Map<String,FinanceReportBean> financebean,FinanceReportParamBean financeParam,BaseFile bf,CustInfo ci) throws Exception;
     public  String getExcelTableField(String headerTitle,String rowIndex,Map<String,FinanceReportBean> financebean,Boolean flag) throws Exception;
}
