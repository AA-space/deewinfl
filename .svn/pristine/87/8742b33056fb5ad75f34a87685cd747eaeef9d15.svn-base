package com.tenwa.report.controller;

import static com.kernal.utils.StringUtil.booleanToString;
import static com.kernal.utils.StringUtil.nullToString;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.tuple.MutablePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.business.service.BaseService;
import com.kernal.utils.ClassUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.EnumUtil;
import com.kernal.utils.QueryUtil;
import com.tenwa.report.annotation.DialectName;
import com.tenwa.report.entity.Report;
import com.tenwa.report.entity.ReportChart;
import com.tenwa.report.entity.ReportDataSource;
import com.tenwa.report.entity.ReportFilter;
import com.tenwa.report.entity.ReportPage;
import com.tenwa.report.entity.ReportTable;
import com.tenwa.report.entity.TenwaReport;
import com.tenwa.report.enums.ChartType;
import com.tenwa.report.enums.ContentType;
import com.tenwa.report.enums.FusionChart;
import com.tenwa.report.query.DataSourceFactory;
import com.tenwa.report.query.dialect.AbstractSQLDialect;
import com.tenwa.report.service.ReportService;

import edu.emory.mathcs.backport.java.util.Collections;

@Controller("reportConfigController")
@RequestMapping(value = "/**/report/config")
public class ReportConfigController {
	private static final Logger log = LoggerFactory.getLogger(ReportConfigController.class);
	@Resource(name = "reportService")
	private ReportService reportService;
	@Resource(name = "baseService")
	private BaseService baseService;

	/********************** Report *******************************/
	@RequestMapping(value = "/saveReport.action")
	@ResponseBody
	public String saveReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String id = model.get("id");

		Report report;

		if (null == id || "".equals(id)) {
			report = new Report();
		} else {
			report = (Report) this.reportService.findEntityByID(Report.class, id);
		}

		Map<String, String> classField = new HashMap<String, String>();
		classField.put("parentid", "");
		classField.put("code", "REPORT_");
		this.reportService.copyAndOverrideExistedValueFromStringMap(model, report, classField, false);
		if (null == report.getCode() || "".equals(report.getCode())) {
			report.setCode("REPORT_CODE_" + Calendar.getInstance().getTimeInMillis());
		}
		String rootMenuId = model.get("reportMenuRoot");
		this.reportService.saveReport(report, rootMenuId);

		return report.getId();
	}

	@RequestMapping(value = "/removeReport.action")
	@ResponseBody
	public String removeReport(@RequestParam String reportId) {
		String result = "TRUE";
		try {
			this.reportService.removeReport(reportId);
		} catch (Exception e) {
			log.error("", e);
			result = getErrorMessage(e);
		}
		return result;
	}

	/**
	 * @param parent
	 *            父节点
	 * @param showHidden
	 *            是否显示不可用的报表
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryReportTree.action")
	@ResponseBody
	public String queryReportTree(@RequestParam String parent, @RequestParam(required = false) Boolean showHidden,
			@RequestParam(required = false) Boolean init) throws Exception {
		String str = this.reportService.updateAndQueryReportTree(parent);

		return str;

	}

	@RequestMapping(value = "/export.action")
	public void reportExport(HttpServletResponse response, @RequestParam String browser, @RequestParam(required = false) String id)
			throws Exception {
		String fileName = "report_export_" + DateUtil.getSystemTimeByFormat("yyyyMMdd_HHmm") + ".xml";
		String start = "0";
		if (!"".equals(nullToString(id))) {
			start = id;
		}
		TenwaReport tp = this.reportService.exportAll(start);

		JAXBContext ctx = JAXBContext.newInstance(TenwaReport.class);

		Marshaller marshaller = ctx.createMarshaller();

		fileName = QueryUtil.getFilenameAssociateBrowser(browser, fileName);
		response.reset();
		response.setContentType("application/xml;charset=UTF-8");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(tp, response.getOutputStream());

	}

	@RequestMapping(value = "/uploadimportfile.action")
	@ResponseBody
	public String uploadReports(MultipartHttpServletRequest request) throws JSONException {
		log.debug("rootMenuId:{},timestamp:{}", request.getParameter("rootMenuId"), request.getParameter("timestamp"));

		MultipartFile multipartFile = null;

		for (String fileName : request.getMultiFileMap().keySet()) {
			multipartFile = request.getFile(fileName);
			if (multipartFile != null) {
				break;
			}
		}

		// String uploadFilePath = uploadDir + "/" + multipartFile.getName();

		InputStream in = null;

		JSONObject jsResult = new JSONObject();
		try {
			in = multipartFile.getInputStream();
			// ResourceUtil.getFileUploadOperation().uploadFile(uploadFilePath, in, null);

			JAXBContext ctx = JAXBContext.newInstance(TenwaReport.class);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			TenwaReport tp = (TenwaReport) unmarshaller.unmarshal(in);
			String parentId = "0";
			if (!"".equals(nullToString(request.getParameter("parentId")))) {
				parentId = request.getParameter("parentId");
			}
			this.reportService.uploadReport(tp, request.getParameter("rootMenuId"), parentId, request.getParameter("timestamp"));

			// jsResult.put("reports",compareResult);
			// jsResult.put("file", uploadFilePath);
			jsResult.put("result", "TRUE");
		} catch (Exception e) {
			log.error("", e);
			jsResult.put("result", "FALSE");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error("", e);
				}
			}
			in = null;
		}

		return jsResult.toString();
	}

	@RequestMapping(value = "/importPrgress.action")
	@ResponseBody
	public String getImportProgress(@RequestParam String timestamp) throws JSONException {
		Queue<String> message = this.reportService.getUploadMessage(timestamp);

		JSONArray jsonMessages = new JSONArray();
		String strMsg = "";
		while (message != null && (strMsg = message.poll()) != null) {
			JSONObject jsonMessage = new JSONObject();
			jsonMessage.put("msg", strMsg);
			if (strMsg.equalsIgnoreCase("TRUE")) {
				this.reportService.removeUploadMessage(timestamp);
			}
			jsonMessages.put(jsonMessage);
		}
		return jsonMessages.toString();

	}

	/********************** DataSource ********************************/
	@RequestMapping(value = "/addReportDataSource.action")
	public void addReportDataSource(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String formData = model.get("formData");
		log.debug(formData);

		JSONObject jsObj = new JSONObject(formData);

		ReportDataSource rds = new ReportDataSource();
		// this.reportService.
		// this.reportService(jsObj, rds, null);
		rds = this.reportService.copyAndOverrideExistedValueFromJSONObject(jsObj, rds, null, false);
		// this.reportService.copyAndOverrideExistedValueFromStringMap(model, rds, null, false);
		String dialectClass = rds.getDialect();
		Class<?> cl = Class.forName(dialectClass);
		rds.setDialectName(cl.getAnnotation(DialectName.class).name());
		switch (rds.getDataSourceType()) {
		case JDBC:
			rds.setJndi("");
			break;
		case JNDI:
		case SPRING:
			rds.setUrl("");
			rds.setUsername("");
			rds.setPassword("");
			rds.setDriverName("");
			break;
		default:
			break;
		}
		this.reportService.saveEntity(rds);
	}

	@RequestMapping(value = "/checkDataSourceValidate.action")
	@ResponseBody
	public String checkDataSourceValidate(HttpServletRequest request, HttpServletResponse response) {
		String result = "FALSE";
		Connection conn = null;
		try {
			Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
			ReportDataSource rds = new ReportDataSource();
			this.reportService.copyAndOverrideExistedValueFromStringMap(model, rds, null, false);
			conn = DataSourceFactory.getConnection(rds, false);
			if (conn != null)
				result = "TRUE";
		} catch (Exception e) {
			result = getErrorMessage(e);
			log.error("", e);
		} finally {
			DataSourceFactory.close(conn);
		}
		return result;
	}

	@RequestMapping(value = "/queryDataSource.action")
	@ResponseBody
	public String queryDataSource() throws Exception {
		List<ReportDataSource> rds = this.reportService.findEntities(ReportDataSource.class);
		JSONArray json = new JSONArray();
		for (ReportDataSource ds : rds) {
			JSONObject jsObj = new JSONObject();
			jsObj.put("value", ds.getId());
			jsObj.put("text", ds.getDataSourceName());
			json.put(jsObj);
		}

		return json.toString();
	}
	
	@RequestMapping(value="loadDataSourceTable.action")
	@ResponseBody
	public String loadDataSourceTable() throws Exception{
		return this.reportService.getDataSourceAsTableJson();
	}

	@RequestMapping(value = "/getAllDialectAsJson.action")
	@ResponseBody
	public String getAllDialectAsJson() throws Exception {
		JSONArray jsonResult = new JSONArray();
		Package pkg = AbstractSQLDialect.class.getPackage();

		Set<Class<?>> cls = ClassUtil.getClasses(pkg);
		SortedMap<String, String> dialects = new TreeMap<String, String>();
		for (Class<?> cl : cls) {
			if (AnnotationUtils.isAnnotationDeclaredLocally(DialectName.class, cl)) {
				DialectName dn = cl.getAnnotation(DialectName.class);
				dialects.put(dn.name(), cl.getName());
			}
		}
		for (String dialectName : dialects.keySet()) {
			JSONObject jsonDialect = new JSONObject();
			jsonDialect.put("name", dialectName);
			jsonDialect.put("value", dialects.get(dialectName));
			jsonResult.put(jsonDialect);
		}

		return jsonResult.toString();
	}

	@RequestMapping(value = "/getAllDatasourcetypeAsJson.action")
	@ResponseBody
	public String getAllDatasourcetypeAsJson() throws Exception {
		String json = EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.DataSourceType.class);

		return json;
		// return jsonResult.toString();
	}

	@RequestMapping(value = "/updateReportDataSource.action")
	public void updateReportDataSource(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String id = model.get("id");
		ReportDataSource rds = (ReportDataSource) this.reportService.findEntityByID(ReportDataSource.class, id);
		String formData = model.get("formData");
		JSONObject object = new JSONObject(formData);
		this.reportService.copyAndOverrideExistedValueFromJSONObject(object, rds, null, false);
		String dialectClass = rds.getDialect();
		Class<?> cl = Class.forName(dialectClass);
		rds.setDialectName(cl.getAnnotation(DialectName.class).name());
		switch (rds.getDataSourceType()) {
		case JDBC:
			rds.setJndi("");
			break;
		case JNDI:
		case SPRING:
			rds.setUrl("");
			rds.setUsername("");
			rds.setPassword("");
			rds.setDriverName("");
			break;
		default:
			break;
		}

		this.reportService.updateEntity(rds);
	}

	@RequestMapping(value = "/removeReportDataSource.action")
	public void removeReportDataSource(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String id = model.get("id");
		this.reportService.removeEntityById(ReportDataSource.class, id);
	}

	/********************* Layout ***********************/
	@RequestMapping(value = "/changeLayout.action")
	@ResponseBody
	public String changeLayout(@RequestParam String reportId, @RequestParam String layoutId, @RequestParam String contentId,
			@RequestParam String contentType, @RequestParam String action) {

		try {
			this.reportService.updateLayout(reportId, layoutId, contentId, contentType, action);

		} catch (Exception e) {
			log.error("", e);
			return "FALSE";
		}
		return "TRUE";
	}

	/************* Table,Chart,Page ***************/
	@RequestMapping(value = "/queryTableAndChart.action")
	@ResponseBody
	public String queryTableAndChartTree(@RequestParam String reportId) {
		log.debug("load TableAndChart");
		JSONArray treeJsonObj = new JSONArray();
		try {
			treeJsonObj = this.reportService.getReportContentTreeAsJson(reportId);
		} catch (Exception e) {
			log.error("", e);
		}

		return treeJsonObj.toString();
	}

	@RequestMapping(value = "/updatePosition.action")
	@ResponseBody
	public String updatePosition(@RequestParam String id, @RequestParam String pid, @RequestParam Integer position,
			@RequestParam String entityClass, @RequestParam String parentField, @RequestParam String rootMenuId) {
		String result = "TRUE";

		try {
			this.reportService.updatePosition(entityClass, id, pid, parentField, position, rootMenuId);

		} catch (Exception e) {
			log.error("", e);
			result = getErrorMessage(e);
		}
		return result;
	}

	@RequestMapping("/removeTableAndChart.action")
	@ResponseBody
	public String removeTableAndChart(@RequestParam ContentType contentType, @RequestParam String contentId) {
		String result = "TRUE";
		try {
			switch (contentType) {
			case TABLE:
				ReportTable table = this.reportService.findEntityByID(ReportTable.class, contentId);

				this.reportService.removeEntity(table);
				break;
			case CHART:
				ReportChart chart = this.reportService.findEntityByID(ReportChart.class, contentId);
				this.reportService.removeEntity(chart);
				break;
			case PAGE:
				this.reportService.removeEntityById(ReportPage.class, contentId);
				break;
			}
			// Remove layout
			String layoutQL = "delete from ReportLayout l where l.contentId=? or l.contentId is null";
			this.reportService.updateByHSQL(layoutQL, contentType.name() + "#" + contentId);
		} catch (Exception e) {
			log.error("", e);
			result = getErrorMessage(e);
		}
		return result;
	}

	/************* Table ******************/
	@RequestMapping(value = "/loadTable.action")
	@ResponseBody
	public String loadTable(@RequestParam String id) throws Exception {

		JSONObject tableForm = new JSONObject();
		ReportTable table = this.reportService.findEntityByID(ReportTable.class, id);

		tableForm.put("table_id", table.getId());
		tableForm.put("table_name", nullToString(table.getName()));
		if (table.getReportDataSource() == null)
			tableForm.put("table_datasource", "");
		else
			tableForm.put("table_datasource", table.getReportDataSource().getId());

		if (table.getQueryType() == null)
			tableForm.put("table_sqlType", "");
		else
			tableForm.put("table_sqlType", table.getQueryType().name());
		tableForm.put("table_sql", nullToString(table.getSql()));
		tableForm.put("table_sqlParamValue", nullToString(table.getSqlParamValue()));
		tableForm.put("table_showRowNumber", booleanToString(table.getShowRowNumber(), "1", "0"));
		tableForm.put("table_showTotalTitle", booleanToString(table.getShowTotalTitle(), "1", "0"));
		tableForm.put("table_isScale", booleanToString(table.getIsScale(), "1", "0"));
		tableForm.put("table_pageSize", table.getPageSize());

		return tableForm.toString();
	}

	@RequestMapping(value = "/saveTable.action")
	@ResponseBody
	public String saveTable(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request, null);
		return this.reportService.saveTable(model);
	}

	@RequestMapping(value = "/saveChart.action")
	@ResponseBody
	public String saveChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		return this.reportService.saveChart(model);
	}

	@RequestMapping(value = "/validateSQL.action")
	@ResponseBody
	public String validateSQL(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rtv = "FALSE";
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String datasource = model.get("datasource");
		String sql = model.get("sql");
		String currentDealerCustInfoId = model.get("currentDealerCustInfoId");
		if (currentDealerCustInfoId !=null){
			sql =sql.replace("@", currentDealerCustInfoId);
		}
		String queryType = model.get("queryType");
		String paramValue = model.get("paramValue");

		List<MutablePair<String, String>> params = new ArrayList<MutablePair<String, String>>();
		try {
			if (!"".equals(nullToString(paramValue))) {
				JSONArray jsonParams = new JSONArray(paramValue);
				for (int i = 0; i < jsonParams.length(); i++) {
					JSONObject jsonParam = (JSONObject) jsonParams.get(i);

					MutablePair<String, String> pair = new MutablePair<String, String>();
					pair.setLeft(jsonParam.getString("name"));
					pair.setRight(jsonParam.getString("value"));
					params.add(pair);
				}
			}
			this.reportService.validateSQL(datasource, sql, queryType, params);
			rtv = "TRUE";
		} catch (Exception e) {
			rtv = getErrorMessage(e);
			log.error("{}", e);
		}
		return rtv;
	}

	@RequestMapping(value = "/queryColumns.action")
	@ResponseBody
	public String queryColumns(HttpServletRequest request) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String contentType = model.get("contentType");
		String id = model.get("id");
		String datasource = model.get("datasource");
		String queryType = model.get("queryType");
		String sql = model.get("sql");
		String params = model.get("params");
		List<MutablePair<String, String>> paramValues = new ArrayList<MutablePair<String, String>>();
		if (!"".equals(nullToString(params))) {
			JSONArray jsonParams = new JSONArray(params);
			for (int i = 0; i < jsonParams.length(); i++) {
				JSONObject jsonParam = (JSONObject) jsonParams.get(i);

				MutablePair<String, String> pair = new MutablePair<String, String>();
				pair.setLeft(jsonParam.getString("name"));
				pair.setRight(jsonParam.getString("value"));
				paramValues.add(pair);
			}
		}
		JSONArray columnsJson = new JSONArray();
		if ("TABLE".equals(contentType)) {
			columnsJson = this.reportService.getTableColumnsAsTreeJson(id, datasource, sql, queryType, paramValues);
		} else if ("CHART".equals(contentType)) {
			columnsJson = this.reportService.getChartColumnsAsTreeJson(id, datasource, sql, queryType, paramValues);
		}

		return columnsJson.toString();
	}

	@RequestMapping(value = "/queryContentNodes.action")
	@ResponseBody
	public String queryContentNodes(@RequestParam String type) throws Exception {
		JSONArray result = new JSONArray();
		if (type.equalsIgnoreCase(ContentType.TABLE.name())) {
			List<ReportTable> tables = this.reportService.findEntities(ReportTable.class);
			Collections.sort(tables, new Comparator<Object>() {
				@Override
				public int compare(Object t1, Object t2) {
					if (t1 instanceof ReportTable && t2 instanceof ReportTable) {
						return ((ReportTable) t1).getName().compareTo(((ReportTable) t2).getName());
					}
					return t1.toString().compareTo(t2.toString());
				}

			});

			for (ReportTable t : tables) {
				JSONObject nodeJson = new JSONObject();
				nodeJson.put("id", t.getId());
				nodeJson.put("name", t.getName());
				result.put(nodeJson);
			}
		} else if (type.equalsIgnoreCase(ContentType.CHART.name())) {
			List<ReportChart> charts = this.reportService.findEntities(ReportChart.class);
			Collections.sort(charts, new Comparator<Object>() {
				@Override
				public int compare(Object t1, Object t2) {
					if (t1 instanceof ReportChart && t2 instanceof ReportChart) {
						return ((ReportChart) t1).getName().compareTo(((ReportChart) t2).getName());
					}
					return t1.toString().compareTo(t2.toString());
				}

			});

			for (ReportChart t : charts) {
				JSONObject nodeJson = new JSONObject();
				nodeJson.put("id", t.getId());
				nodeJson.put("name", t.getName());
				result.put(nodeJson);
			}
		}
		JSONObject comboJson = new JSONObject();
		comboJson.put("datas", result);
		return comboJson.toString();
	}

	@RequestMapping(value = "/queryFilters.action")
	@ResponseBody
	public String queryFilters(@RequestParam String id, @RequestParam String contentType) {
		JSONArray filtersJson = new JSONArray();
		try {
			if ("TABLE".equals(contentType)) {
				filtersJson = this.reportService.getTableFiltersAsTreeJson(id);
			} else if ("CHART".equals(contentType)) {
				filtersJson = this.reportService.getChartFiltersAsTreeJson(id);
			}
		} catch (Exception e) {
			log.error("", e);
		}
		return filtersJson.toString();
	}

	@RequestMapping(value = "/removeFilter")
	@ResponseBody
	public String removeFilter(String filterId) {
		String result = "TRUE";
		try {
			this.reportService.removeEntityById(ReportFilter.class, filterId);
		} catch (Exception e) {
			log.error("", e);
			result = "ERROR:" + getErrorMessage(e);
		}
		return result;
	}

	/************ Page *******************/

	@RequestMapping(value = "/loadPage.action")
	@ResponseBody
	public String loadPage(@RequestParam String pageId) throws Exception {

		JSONObject pageObject = new JSONObject();
		ReportPage page = (ReportPage) this.reportService.findEntityByID(ReportPage.class, pageId);
		pageObject.put("page_id", page.getId());
		pageObject.put("page_name", page.getName());
		pageObject.put("page_url", page.getUrl());

		return pageObject.toString();
	}

	@RequestMapping(value = "/savePage.action")
	@ResponseBody
	public String savePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request, null);
		return this.reportService.savePage(model);
	}

	private String getErrorMessage(Exception e) {
		return e.getMessage();
	}

	/********* Chart *******/
	/**
	 * 
	 * @param id
	 * @return JSON Result
	 * @throws Exception
	 */
	@RequestMapping("/loadChart.action")
	@ResponseBody
	public String loadChart(@RequestParam String id) throws Exception {
		JSONObject formData = new JSONObject();
		ReportChart chart = null;
		if (!"".equals(id)) {
			chart = this.reportService.findEntityByID(ReportChart.class, id);
			formData.putOpt("chart_name", chart.getName());
			formData.putOpt("chart_caption", chart.getCaption());
			formData.putOpt("chart_subcaption", chart.getSubCaption());
			formData.putOpt("chart_chartType", nullToString(chart.getChartType()));
			formData.putOpt("chart_chartType2", nullToString(chart.getFusionChart()));
			formData.putOpt("chart_datasource", chart.getDataSource() == null ? "" : chart.getDataSource().getId());
			formData.putOpt("chart_id", chart.getId());
			formData.putOpt("chart_xAxisName", nullToString(chart.getxAxisName()));
			formData.putOpt("chart_yAxisName", nullToString(chart.getyAxisName()));
			formData.putOpt("chart_sAxisName", nullToString(chart.getsAxisName()));
			formData.putOpt("chart_sqlType", nullToString(chart.getQueryType()));
			formData.putOpt("chart_sql", nullToString(chart.getQuery()));
			formData.putOpt("chart_sqlParamValue", nullToString(chart.getQueryParamValue()));

		}
		return formData.toString();
	}

	@RequestMapping("listChartsByType.action")
	@ResponseBody
	public String listChartsByType(@RequestParam String chartType) {
		JSONArray chartsJson = new JSONArray();
		JSONObject jsonCombox = new JSONObject();
		try {
			ChartType ct = Enum.valueOf(ChartType.class, chartType);
			List<FusionChart> charts = FusionChart.findChartsByType(ct);
			for (FusionChart c : charts) {
				JSONObject chartJson = EnumUtil.getEnumConstantAsJson(c);
				chartsJson.put(chartJson);
			}
			jsonCombox.put("datas", chartsJson);
		} catch (Exception e) {
			log.error("", e);
		}

		return jsonCombox.toString();
	}
}
