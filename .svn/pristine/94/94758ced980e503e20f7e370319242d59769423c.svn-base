package com.tenwa.report;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kernal.utils.WebUtil;
import com.tenwa.report.controller.ReportConfigController;
import com.tenwa.report.controller.ReportController;
import com.tenwa.report.entity.TestData;
import com.tenwa.report.enums.ContentType;
import com.tenwa.report.service.ReportService;
import com.tenwa.test.BaseMVCTest;

public class TestReport extends BaseMVCTest {
	private static final Logger log = LoggerFactory.getLogger(TestReport.class);
	@Autowired
	private ReportConfigController reportConfigController;

	@Autowired
	private ReportController reportController;
	@Autowired
	private ReportService reportService;

	// @Test
	public void testNull() {

	}

	// @Test
	public void testAddReportDataSource() throws Exception {
		request.setRequestURI("/report/addReportDataSource.action");
		request.setMethod(HttpMethod.POST.name());

		request.setParameter("datasourcename", "1");
		request.setParameter("datasourcetype", "JNDI");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "addReportDataSource", HttpServletRequest.class, HttpServletResponse.class));
	}

	// @Test
	public void testUpdateReportDataSource() throws Exception {
		request.setRequestURI("/report/updateReportDataSource.action");
		request.setMethod(HttpMethod.POST.name());
		request.setParameter("id", "402880813fa35182013fa35389a30000");
		request.setParameter("datasourcename", "1");
		request.setParameter("datasourcetype", "JDBC");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "updateReportDataSource", HttpServletRequest.class, HttpServletResponse.class));
	}

	// @Test
	// @Transactional
	public void testQueryReportMenu() throws Exception {
		request.setRequestURI("/report/queryReportTree.action");
		request.setParameter("parent", "0");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "queryReportMenu", String.class, Boolean.class, Boolean.class));
	}

	// @Test
	// @Transactional
	public void testAddReport() throws Exception {
		request.setRequestURI("/report/saveReport.action");
		request.setParameter("id", "402880813febd70e013febe1aadc0003");
		request.setParameter("parentReport", "0");
		request.setParameter("reportType", "REPORT");
		request.setParameter("description", "aadsfasdf");
		request.setParameter("name", "1");
		request.setParameter("code", "asdf");
		request.setParameter("reportMenuRoot", "d87f8d9b3afcedfb013afde4e403001e");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "saveReport", HttpServletRequest.class, HttpServletResponse.class));
	}

	// @Test
	// @Transactional
	public void testQueryTableAndChart() throws Exception {
		request.setRequestURI("/report/queryTableAndChart.action");
		request.setParameter("reportId", "402881344129ad6e014129b21c080000");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "queryTableAndChartTree", String.class));
	}

	// @Test
	// @Transactional
	public void testQueryColumns() throws Exception {
		request.setRequestURI("/report/config/queryColumns.action");
		request.setParameter("tableId", "4028814a41008a1d014100e3a127001b");
		request.setParameter("datasource", "4028814a41008a1d0141008ec2010002");
		request.setParameter("sql", "select 1+1 t  from report_report");
		request.setParameter("params", "[]");
		request.setParameter("queryType", "SIMPLESQL");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "queryColumns", String.class, String.class, String.class, String.class, String.class));
	}

	// @Test
	// @Transactional
	public void testDeleteTableAndChart() throws Exception {
		request.setRequestURI("/report/removeTableAndChart.action");
		request.setParameter("contentType", "TABLE");
		request.setParameter("contentId", "3333");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "removeTableAndChart", ContentType.class, String.class));

	}

	// @Test
	// public void testJsonConfig() throws Exception{
	// this.reportService.removeEntityById(Menu.class,"40288081407bceab01407bcfbeb00001");
	// }

	// @Test
	// @Transactional
	public void loadTableData() throws Exception {
		request.setRequestURI("/report/loadTableData.action");
		request.setParameter("tableId", "2");

		handlerAdapter.handle(request, response, new HandlerMethod(reportController, "loadTableData", String.class, Integer.class, Integer.class, String.class));

	}

	// @Test
	public void testQueryFilter() throws Exception {

		request.setRequestURI("/report/config/queryFilters.action");
		request.setParameter("tableId", "4028808140a6122c0140a616782c0067");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "queryFilters", String.class));
	}

	public void initTestTable() throws SQLException {
		DataSource ds = (DataSource) WebUtil.getApplicationContext().getBean("dataSourceJDBC");
		Connection conn = ds.getConnection();
		Statement st = conn.createStatement();

		StringBuffer sql = new StringBuffer();
		sql.append("create table Report_Test (");
		for (int i = 0; i < 100; i++) {
			if (i > 0)
				sql.append(",");
			sql.append("name").append(i).append(" varchar2(20)");

		}
		st.execute(sql.toString());

	}

	// @Test
	public void saveTable() throws NoSuchMethodException, Exception {
		request.setRequestURI("/report/saveTable.action");
		request.setParameter("tableId", "4028808140a5c08c0140a5c4a9f90001");
		request.setParameter("sqlType", "SIMPLESQL");
		request.setParameter("datasource", "4028808140a5b4270140a5b8e0a60002");
		request.setParameter("sql", "select%201%2B1%20t%20from%20report_report");
		request.setParameter("name", "1111");
		request.setParameter("datasource", "4028808140a5b4270140a5b8e0a60002");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "saveTable", HttpServletRequest.class, HttpServletResponse.class));

	}

	// @Test
	// public void testEnumUtil(){
	// String t = EnumUtil.getEnumConstantsAsJson(ContentType.class);
	// }

	// @Test
	public void testValidateSQL() throws Exception {

		request.setRequestURI("/report/config/validateSQL.action");
		request.setParameter("queryType", "SQL");
		request.setParameter("sql", "select * from report_test where id={id} order by data1");
		request.setParameter("paramValue", "[{\"name\":\"id\",\"value\":\"1\"}]");
		request.setParameter("datasource", "4028808140a5b4270140a5b8e0a60002");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "validateSQL", String.class, String.class, String.class, String.class));
	}

	@Test
	public void initReportTestData() throws Exception {
		String base = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		TestData test = new TestData();
		Calendar c = Calendar.getInstance();
		Set<Currency> ms = new HashSet<Currency>();
		Currency[] msArray = new Currency[]{};
		msArray = ms.toArray(msArray);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int k = 0; k < 1000; k++) {
			Double f = new Double(Math.random() * 60);
			int fi = f.intValue();

			try {
				StringBuffer sb = new StringBuffer();

				for (int i = 0; i < 5 + fi % 5; i++) {
					sb.append(base.charAt((new Double(Math.random() * 60)).intValue() % base.length()));
				}
				test.setStringData(sb.toString());
				test.setBooleanData((k % 3 < f * 6) ? true : false);
				c.set(2000 + fi % 14, fi % 12, fi % 29, fi % 24, fi % 60, fi % 60);
				String dd = sdf.format(c.getTime());
				test.setCalendarData(c);
				int currencyIndex = (new Double(Math.random()*1000)).intValue() % 10;
				//test.setCurrencyData(msArray[currencyIndex]);
				f = new Double(Math.random() * 100);
				fi = f.intValue();
				c.set(2000 + fi % 14, fi % 12, fi % 29, fi % 24, fi % 60, fi % 60);
				test.setDateData(c.getTime());
				test.setDecimalData(new BigDecimal(f * 100000.000));
				test.setDoubleData(Math.random() * 200054.0434);
				test.setFloatData((float) (Math.random() * 5234523));
				test.setIntData(fi * 1024);
				test.setLongData(fi * 20488402);
				log.debug("第{}个:{}", k, test);
				this.reportService.saveEntity(test);
			} catch (Exception e) {
				log.error("{}", e);
				continue;
			}

		}
	}

	// @Test
	public void testJsonArray() throws JSONException {
		String j = "{'#ddd':'{a}','#fff':'{a}-{b}>{c}'}";
		JSONObject jo = new JSONObject(j);
		jo.toString();
	}
	//@Test
	public void testTable() throws Exception {

		request.setRequestURI("/report/loadTableData2.action");
		request.setParameter("id", "40288146438f17be01438f1cf8fb0004");
		request.setParameter("limit", "20");
		request.setParameter("start", "0");

		handlerAdapter.handle(request, response, new HandlerMethod(reportController, "loadTableData2", String.class, Integer.class, Integer.class, Integer.class, String.class,
				String.class));
	}

	@Test
	public void testExportExcel() throws NoSuchMethodException, Exception {

		request.setParameter(
				"exportParams",
				"[{\"id\":\"40288146438f17be01438f1cf8fb0004\",\"type\":\"TABLE\"}]");
		request.setParameter("browser", "Chrome");
		request.setParameter("reportName", "");
		handlerAdapter.handle(request, response, new HandlerMethod(reportController, "exportExcel", HttpServletRequest.class, HttpServletResponse.class, String.class,
				String.class, String.class));
	}

	// @Test
	public void testAllExport() throws Exception {
		request.setRequestURI("/report/config/reportExport.action");
		request.setParameter("browser", "Chrome");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "reportExport", HttpServletResponse.class, String.class));
	}

	// @Test
	public void testUploadFile() throws Exception {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("/Users/simon/Downloads/report_export_20131203_1749.xml")));

		MockMultipartFile mmpf = new MockMultipartFile("report_export_20131105_1536.xml", in);
		MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
		request.addFile(mmpf);
		request.addParameter("rootMenuId", "B1");
		request.setRequestURI("/report/config/uploadimportfile.action");

		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "uploadReports", MultipartHttpServletRequest.class));

	}

	// @Test
	public void testGetHeader() throws NoSuchMethodException, Exception {

		request.setParameter("id", "40288134412a5c0701412a5ca1420000");
		request.setParameter("pageWidth", "1554");
		request.setRequestURI("/report/getHeader.action");
		handlerAdapter.handle(request, response, new HandlerMethod(reportController, "getHeader", String.class, Integer.class));
	}
	
	//@Test
	public void dumpTest(){
		
	}

	
	//@Test
	public void testUpdateLayout() throws Exception {
		request.setRequestURI("/report/changeLayout.action");
		request.setParameter("layoutId", "4028813842b7e3190142b7e3b74a0064");
		request.setParameter("reportId", "40288131420c1be201420c2a66780003");
		request.setParameter("contentType", "TABLE");
		request.setParameter("contentId", "4028098141497174014149fd9e9a000c");
		request.setParameter("action","remove");
		handlerAdapter.handle(request, response, new HandlerMethod(reportConfigController, "changeLayout", String.class, String.class, String.class, String.class, String.class));
	}
	
	//@Test
	public void testLoadChart() throws Exception{
		
	}
}
