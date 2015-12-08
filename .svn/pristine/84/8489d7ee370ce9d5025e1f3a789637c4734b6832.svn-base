package com.business.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.business.entity.Action;
import com.business.entity.ActionGroup;
import com.business.entity.ActivityDetail;
import com.business.entity.Department;
import com.business.entity.DepartmentRole;
import com.business.entity.Dictionary;
import com.business.entity.Group;
import com.business.entity.Menu;
import com.business.entity.MenuGroup;
import com.business.entity.Relationship;
import com.business.entity.ResourceGroup;
import com.business.entity.Role;
import com.business.entity.User;
import com.business.entity.UserDepartment;
import com.business.entity.UserGroup;
import com.business.entity.WorkflowStartGroup;
import com.business.entity.WorkflowViewGroup;
import com.business.entity.base.BaseDocumentConfig;
import com.business.service.TableService;
import com.kernal.utils.DateUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.StringUtil;

@Controller(value = "tableController")
@RequestMapping(value = "/**/table")
public class TableController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(TableController.class);

	@Resource(name = "tableService")
	private TableService tableService;

	@RequestMapping(value = "/getTree2TableJsonInfo.action")
	public String getTree2TableJsonInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String dictTableName = model.get("dictTableName");
		String savedDataKey = model.get("savedDataKey");
		String dictTableDataName = model.get("dictDataTableName");
		String rootDictId = model.get("rootDictId");
		boolean isLoadDictData = Boolean.parseBoolean(model.get("isLoadDictData"));
		String returnJsonInfo = tableService.createTree2TableJsonString(savedDataKey, dictTableName, dictTableDataName, rootDictId,
				isLoadDictData, model);
		this.output(response, returnJsonInfo);
		return null;
	}

	@RequestMapping(value = "/savedTree2TableData.action")
	public String savedTree2TableData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String savedDataKey = model.get("savedDataKey");
		String savedData = model.get("savedDataDetailJson");
		String returnJsonInfo = tableService.savedTree2TableData(savedDataKey, savedData, model);
		this.output(response, returnJsonInfo);
		return null;
	}

	@RequestMapping(value = "/getTableData.action")
	public String getTableData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String xmlFileNameOrPath = model.get("xmlFileName");
		String jsonData = this.tableService.getTableJsonData(xmlFileNameOrPath, model);
		this.output(response, jsonData);
		return null;
	}

	@RequestMapping(value = "/importExcel.action")
	public String importExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		String currentTableId = modelData.get("currentTableId");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("tableImportExcel");
		String returnInfo = this.tableService.importExcel(multipartFile, modelData);
		String ajaxCallBackScript = "<script type='text/javascript'>window.parent.importExcelFormCallBack('" + returnInfo + "','"
				+ currentTableId + "');</script>";
		this.ajaxReturn(response, ajaxCallBackScript);
		return null;
	}

	@RequestMapping(value = "/getTreeData.action")
	public String getTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String xmlFileNameOrPath = model.get("xmlFileName");
		String jsonData = this.tableService.getTreeJsonData(xmlFileNameOrPath, model);
		this.output(response, jsonData);
		return null;
	}

	// #####################
	@RequestMapping(value = "/getDeptTreeData.action")
	public String getDeptTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		String selectedUserIds = model.get("selectedUserIds");
		String queryText = model.get("queryText");
		if (null != queryText) {
			String hsql = " FROM Department u  WHERE 1= 1 ";
			String whereCondition = " AND ( UPPER(u.name) like ?  OR  UPPER(u.code) like ?  OR  UPPER(u.description) like ? ) ";
			hsql += whereCondition;
			String whereValue = "%{0}%".replace("{0}", queryText.toUpperCase());
			List<Department> depts = this.tableService.findResultsByHSQL(hsql, whereValue, whereValue, whereValue);

			JSONArray jsonArrayChildren = new JSONArray();
			for (Department dept : depts) {
				boolean isPassed = true;
				if (null != selectedUserIds) {
					for (String selectedUserId : selectedUserIds.split(",")) {
						if (dept.getId().equals(selectedUserId)) {
							isPassed = false;
							break;
						}
					}
				}
				if (!isPassed)
					continue;
				JSONObject userJsonObj = this.getJsonObjectDept(dept, false, "opened");
				jsonArrayChildren.put(userJsonObj);
			}
			this.output(response, jsonArrayChildren.toString());
			return null;
		}
		Department dept = (Department) this.tableService.findEntityByID(Department.class, pid);
		boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = dept.getChildrenJsonArray(isInit).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getDeptWithUserTreeData.action")
	public String getDeptWithUserTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		String selectedUserIds = model.get("selectedUserIds");
		String queryDeptText = model.get("queryDeptText");
		if (null != queryDeptText) {
			String hsql = " FROM Department u  WHERE 1= 1 ";
			String whereCondition = " AND ( UPPER(u.name) like ?  OR  UPPER(u.code) like ?  ) ";
			hsql += whereCondition;
			String whereValue = "%{0}%".replace("{0}", queryDeptText.toUpperCase());
			List<Department> depts = this.tableService.findResultsByHSQL(hsql, whereValue, whereValue);
			JSONArray jsonArrayChildren = new JSONArray();
			for (Department dept : depts) {
				JSONObject deptJsonObj = dept.getJsonObjectDept(dept, true, null);
				JSONArray jsonArray = new JSONArray();
				deptJsonObj.put("children", jsonArray);
				jsonArrayChildren.put(deptJsonObj);
				for (UserDepartment userDept : dept.getUserDepts()) {
					String currentUserId = userDept.getUser().getId();
					boolean isPassed = true;
					if (null != selectedUserIds) {
						for (String selectedUserId : selectedUserIds.split(",")) {
							if (currentUserId.equals(selectedUserId)) {
								isPassed = false;
							}
						}
					}
					if (isPassed) {
						JSONObject userJsonObj = dept.getJsonObjectUser(userDept);
						jsonArray.put(userJsonObj);
					}
				}
			}
			this.output(response, jsonArrayChildren.toString());
			return null;
		}
		String queryText = model.get("queryText");
		String dealerdistrictText = model.get("dealerdistrictText");
		if (null != queryText) {
			String hsql = " FROM User u  WHERE 1= 1 ";
			String whereCondition = " AND ( UPPER(u.username) like ?  OR  UPPER(u.code) like ?  OR  UPPER(u.realname) like ?) ";
			hsql += whereCondition;
			String whereValue = "%{0}%".replace("{0}", queryText.toUpperCase());
			List<User> users = this.tableService.findResultsByHSQL(hsql, whereValue, whereValue, whereValue);

			JSONArray jsonArrayChildren = new JSONArray();
			for (User user : users) {
				boolean isPassed = true;
				if (null != selectedUserIds) {
					for (String selectedUserId : selectedUserIds.split(",")) {
						if (user.getId().equals(selectedUserId)) {
							isPassed = false;
							break;
						}
					}
				}
				if (!isPassed)
					continue;
				JSONObject userJsonObj = this.getJsonObjectUser(user);
				jsonArrayChildren.put(userJsonObj);
			}
			this.output(response, jsonArrayChildren.toString());
			return null;
		}else if(null != dealerdistrictText){
			String hsql = " FROM User u  WHERE 1= 1 ";
			String whereCondition = " AND (UPPER(u.dealerDistrict.name) like ?) ";
			hsql += whereCondition;
			String whereValue = "%{0}%".replace("{0}", dealerdistrictText.toUpperCase());
			List<User> users = this.tableService.findResultsByHSQL(hsql,whereValue);

			JSONArray jsonArrayChildren = new JSONArray();
			for (User user : users) {
				boolean isPassed = true;
				if (null != selectedUserIds) {
					for (String selectedUserId : selectedUserIds.split(",")) {
						if (user.getId().equals(selectedUserId)) {
							isPassed = false;
							break;
						}
					}
				}
				if (!isPassed)
					continue;
				JSONObject userJsonObj = this.getJsonObjectUser(user);
				jsonArrayChildren.put(userJsonObj);
			}
			this.output(response, jsonArrayChildren.toString());
			return null;
		}
		Department dept = (Department) this.tableService.findEntityByID(Department.class, pid);
		boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = dept.getChildrenWithUsersJsonArray(isInit, null, selectedUserIds).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getDeptWithRoleTreeData.action")
	public String getDeptWithRoleTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		String selectedUserIds = model.get("selectedUserIds");
		String queryText = model.get("queryText");
		if (null != queryText) {
			String hsql = " SELECT dr FROM DepartmentRole dr left join dr.role u WHERE 1= 1 ";
			String whereCondition = " AND ( UPPER(u.name) like ?  OR  UPPER(u.code) like ?  OR  UPPER(u.description) like ? ) ";
			hsql += whereCondition;
			String whereValue = "%{0}%".replace("{0}", queryText.toUpperCase());
			List<DepartmentRole> deptRoles = this.tableService.findResultsByHSQL(hsql, whereValue, whereValue, whereValue);

			JSONArray jsonArrayChildren = new JSONArray();
			for (DepartmentRole deptRole : deptRoles) {
				boolean isPassed = true;
				if (null != selectedUserIds) {
					for (String selectedUserId : selectedUserIds.split(",")) {
						if (deptRole.getId().equals(selectedUserId)) {
							isPassed = false;
							break;
						}
					}
				}
				if (!isPassed)
					continue;
				JSONObject userJsonObj = this.getJsonObjectDepartmentRole(deptRole);
				jsonArrayChildren.put(userJsonObj);
			}
			this.output(response, jsonArrayChildren.toString());
			return null;
		}
		Department dept = (Department) this.tableService.findEntityByID(Department.class, pid);
		boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = dept.getChildrenWithRolesJsonArray(isInit, selectedUserIds).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	// #####################
	public JSONObject getJsonObjectDept(Department dept, boolean isInit, String state) throws Exception {
		String currentState = isInit ? "opened" : "closed";// (!isInit && dept.isHasChildren()) ? "closed" : "opened";
		if ((0 == dept.getUserDepts().size()) && (0 == dept.getChildrenDepts().size())) {
			currentState = "opened";
		}
		if (null != state) {
			currentState = state;
		}
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", dept.getId());
		jsonObj.put("text", dept.getName() + "（" + dept.getCode() + "）");
		jsonObj.put("iconCls", "icon-home");
		jsonObj.put("state", currentState);
		JSONObject attributesJsonObj = new JSONObject();
		attributesJsonObj.put("deptId", dept.getId());
		attributesJsonObj.put("type", "dept");
		attributesJsonObj.put("userEntityClassName", "UserDepartment");
		attributesJsonObj.put("deptEntityClassName", "Department");
		attributesJsonObj.put("menuEntityClassName", "MenuDepartment");
		jsonObj.put("attributes", attributesJsonObj);
		return jsonObj;
	}

	public JSONObject getJsonObjectDepartmentRole(DepartmentRole deptRole) throws Exception {
		String currentState = "opened";
		JSONObject jsonObj = new JSONObject();
		Role role = deptRole.getRole();
		jsonObj.put("id", deptRole.getId());
		jsonObj.put("text", deptRole.getDept().getName() + " < " + role.getName() + "（" + role.getCode() + "） > ");
		jsonObj.put("iconCls", "icon-contact");
		jsonObj.put("state", currentState);
		JSONObject attributesJsonObj = new JSONObject();
		attributesJsonObj.put("type", "deptRole");
		attributesJsonObj.put("userEntityClassName", "UserDepartmentRole");
		attributesJsonObj.put("deptEntityClassName", "DepartmentRole");
		attributesJsonObj.put("menuEntityClassName", "MenuDepartmentRole");
		attributesJsonObj.put("deptRoleId", deptRole.getId());
		attributesJsonObj.put("deptId", deptRole.getDept().getId());
		attributesJsonObj.put("roleId", role.getId());
		jsonObj.put("attributes", attributesJsonObj);
		return jsonObj;
	}

	@RequestMapping(value = "/getMenuDeptAllTreeData.action")
	public String getMenuDeptAllTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		String menuId = model.get("menuId");
		Department dept = (Department) this.tableService.findEntityByID(Department.class, pid);
		// boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = dept.getChildrenWithAllMenuJsonArray(menuId).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getResourceDeptAllTreeData.action")
	public String getResourceDeptAllTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		String menuId = model.get("menuId");
		Department dept = (Department) this.tableService.findEntityByID(Department.class, pid);
		// boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = dept.getChildrenWithAllResourceJsonArray(menuId).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getActionDeptAllTreeData.action")
	public String getActionDeptAllTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		String menuId = model.get("menuId");
		Department dept = (Department) this.tableService.findEntityByID(Department.class, pid);
		// boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = dept.getChildrenWithAllActionJsonArray(menuId).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getWorkflowStartDeptAllTreeData.action")
	public String getWorkflowStartDeptAllTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		String menuId = model.get("menuId");
		Department dept = (Department) this.tableService.findEntityByID(Department.class, pid);
		// boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = dept.getChildrenWithAllWorkflowStartJsonArray(menuId).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getWorkflowViewDeptAllTreeData.action")
	public String getWorkflowViewDeptAllTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		String menuId = model.get("menuId");
		Department dept = (Department) this.tableService.findEntityByID(Department.class, pid);
		// boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = dept.getChildrenWithAllWorkflowViewJsonArray(menuId).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getUserDeptAllTreeData.action")
	public String getUserDeptAllTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		String userId = model.get("userId");
		Department dept = (Department) this.tableService.findEntityByID(Department.class, pid);
		/*
		 * boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		 * String treeDatasJsonString = dept.getChildrenWithAllUserJsonArray(isInit,userId,null).toString();
		 */
		String treeDatasJsonString = dept.getChildrenWithAllDeptRoleJsonArray(userId).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getMenuWithUserTreeData.action")
	public String getMenuWithUserTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		Menu menu = (Menu) this.tableService.findEntityByID(Menu.class, pid);
		boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = menu.getChildrenWithUsersJsonArray(isInit, null).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getMenuWithUserRoleTreeData.action")
	public String getMenuWithUserRoleTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String type = model.get("type");
		String treeDatasJsonString = "";
		if ("department".equalsIgnoreCase(type)) {
			Menu menu = (Menu) this.tableService.findEntityByID(Menu.class, pid);
			treeDatasJsonString = menu.getChildrenWithUsersJsonArray(isInit, "closed").toString();
		} else if ("user".equalsIgnoreCase(type)) {
			User user = (User) this.tableService.findEntityByID(User.class, pid);
			treeDatasJsonString = user.getChildrenWithRolesJsonArray().toString();
		}
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getDictionaryTreeData.action")
	public String getDictionaryTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String queryText = StringUtil.nullToString(model.get("queryText")).trim();
		String treeDatasJsonString = "";
		if (queryText.isEmpty()) {
			String pid = model.get("pid");
			Dictionary dictionary = (Dictionary) this.tableService.findEntityByID(Dictionary.class, pid);
			boolean isInit = "true".equalsIgnoreCase(model.get("init"));
			treeDatasJsonString = dictionary.getChildrenJsonArray(isInit).toString();
		} else {
			JSONArray jsonArray = new JSONArray();
			String hsql = "select d from Dictionary d where upper(d.name) like :queryText or upper(d.code) like :queryText ";
			List<Dictionary> dicts = this.tableService.findResultsByNamedParamHSQL(hsql, new String[] { "queryText" }, new String[] { "%"
					+ queryText + "%" });
			for (Dictionary dict : dicts) {
				String state = dict.isHasChildren() ? "closed" : "opened";
				JSONObject jsonObj = dict.getJsonObjectDictionary(dict, false, state);
				jsonArray.put(jsonObj);
			}
			treeDatasJsonString = jsonArray.toString();
		}
		this.output(response, treeDatasJsonString);
		return null;

	}

	@RequestMapping(value = "/getBaseDocumentConfigTreeData.action")
	public String getBaseDocumentConfigTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		BaseDocumentConfig baseDocumentConfig = (BaseDocumentConfig) this.tableService.findEntityByID(BaseDocumentConfig.class, pid);
		boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = baseDocumentConfig.getChildrenJsonArray(isInit).toString();
		this.output(response, treeDatasJsonString);
		return null;

	}

	@RequestMapping(value = "/getMenuTreeData.action")
	public String getMenuTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		Menu menu = (Menu) this.tableService.findEntityByID(Menu.class, pid);
		boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = menu.getChildrenJsonArray(isInit).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getResourceTreeData.action")
	public String getResourceTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		com.business.entity.Resource resource = (com.business.entity.Resource) this.tableService.findEntityByID(
				com.business.entity.Resource.class, pid);
		boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = resource.getChildrenJsonArray(isInit).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getActionTreeData.action")
	public String getActionTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String pid = model.get("pid");
		Action action = (Action) this.tableService.findEntityByID(Action.class, pid);
		boolean isInit = "true".equalsIgnoreCase(model.get("init"));
		String treeDatasJsonString = action.getChildrenJsonArray(isInit).toString();
		this.output(response, treeDatasJsonString);
		return null;
	}

	@RequestMapping(value = "/getMenuGroupTreeData.action")
	public String getMenuGroupTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String menuId = model.get("menuId");
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("enabled", Boolean.TRUE);
		List<Group> groups = (List<Group>) this.tableService.findEntityByProperties(Group.class, propertiesMap);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Group group : groups) {
			JSONObject groupJsonObj = this.getJsonObjectGroup(group);
			groupJsonObj.getJSONObject("attributes").put("menuId", menuId);
			if (null != menuId) {
				groupJsonObj.put("checked", this.isMenuGroupChecked(group, menuId));
			}
			jsonArrayChildren.put(groupJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getResourceGroupTreeData.action")
	public String getResourceGroupTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String menuId = model.get("menuId");
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("enabled", Boolean.TRUE);
		List<Group> groups = (List<Group>) this.tableService.findEntityByProperties(Group.class, propertiesMap);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Group group : groups) {
			JSONObject groupJsonObj = this.getJsonObjectGroup(group);
			groupJsonObj.getJSONObject("attributes").put("menuId", menuId);
			if (null != menuId) {
				groupJsonObj.put("checked", this.isResourceGroupChecked(group, menuId));
			}
			jsonArrayChildren.put(groupJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getActionGroupTreeData.action")
	public String getActionGroupTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String menuId = model.get("menuId");
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("enabled", Boolean.TRUE);
		List<Group> groups = (List<Group>) this.tableService.findEntityByProperties(Group.class, propertiesMap);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Group group : groups) {
			JSONObject groupJsonObj = this.getJsonObjectGroup(group);
			groupJsonObj.getJSONObject("attributes").put("menuId", menuId);
			if (null != menuId) {
				groupJsonObj.put("checked", this.isActionGroupChecked(group, menuId));
			}
			jsonArrayChildren.put(groupJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getWorkflowStartGroupTreeData.action")
	public String getWorkflowStartGroupTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String menuId = model.get("menuId");
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("enabled", Boolean.TRUE);
		List<Group> groups = (List<Group>) this.tableService.findEntityByProperties(Group.class, propertiesMap);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Group group : groups) {
			JSONObject groupJsonObj = this.getJsonObjectGroup(group);
			groupJsonObj.getJSONObject("attributes").put("menuId", menuId);
			if (null != menuId) {
				groupJsonObj.put("checked", this.isWorkflowStartGroupChecked(group, menuId));
			}
			jsonArrayChildren.put(groupJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getWorkflowViewGroupTreeData.action")
	public String getWorkflowViewGroupTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String menuId = model.get("menuId");
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("enabled", Boolean.TRUE);
		List<Group> groups = (List<Group>) this.tableService.findEntityByProperties(Group.class, propertiesMap);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Group group : groups) {
			JSONObject groupJsonObj = this.getJsonObjectGroup(group);
			groupJsonObj.getJSONObject("attributes").put("menuId", menuId);
			if (null != menuId) {
				groupJsonObj.put("checked", this.isWorkflowViewGroupChecked(group, menuId));
			}
			jsonArrayChildren.put(groupJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getGroupTreeData.action")
	public String getGroupTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = model.get("selectedUserIds");
		String queryText = model.get("queryText");
		String hsql = " FROM Group u WHERE enabled = 1";
		List<String> params = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();

		if (null != selectedUserIds) {
			hsql += " AND id not in(:ids) ";
			params.add("ids");
			values.add(selectedUserIds.split(","));
		}
		if (null != queryText) {
			params.add("queryText");
			values.add("%" + queryText.toUpperCase() + "%");
			String whereCondition = " AND ( UPPER(u.name) like :queryText  OR  UPPER(u.code) like :queryText  OR  UPPER(u.description) like :queryText ) ";
			hsql += whereCondition;
		}
		String[] paramsArr = new String[params.size()];
		paramsArr = params.toArray(paramsArr);
		Object[] valuesArr = new Object[values.size()];
		valuesArr = values.toArray(valuesArr);
		List<Group> groups = this.tableService.findResultsByNamedParamHSQL(hsql, paramsArr, valuesArr);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Group group : groups) {
			JSONObject groupJsonObj = this.getJsonObjectGroup(group);
			jsonArrayChildren.put(groupJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	/**
	 * Modified by Simon for New Relation Design
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getRelationTreeData.action")	
	public String getRelationTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = model.get("selectedUserIds");
		String queryText = model.get("queryText");
		String hsql = " FROM Role u WHERE enabled = 1";
		// String hsql = "FROM DictionaryData u WHERE enabled = 1 and u.belongDictionary.id = :pid";
		List<String> params = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		/*
		 * params.add("pid");
		 * values.add("root.Relation");
		 */
		if (null != selectedUserIds) {
			hsql += " AND id not in(:ids) ";
			params.add("ids");
			values.add(selectedUserIds.split(","));
		}
		if (null != queryText) {
			params.add("queryText");
			values.add("%" + queryText.toUpperCase() + "%");
			String whereCondition = " AND ( UPPER(u.name) like :queryText  OR  UPPER(u.code) like :queryText  OR  UPPER(u.description) like :queryText ) ";
			hsql += whereCondition;
		}
		String[] paramsArr = new String[params.size()];
		paramsArr = params.toArray(paramsArr);
		Object[] valuesArr = new Object[values.size()];
		valuesArr = values.toArray(valuesArr);
		List<Role> roles = this.tableService.findResultsByNamedParamHSQL(hsql, paramsArr, valuesArr);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Role role : roles) {
			JSONObject roleJsonObj = this.getJsonObjectRelationRole(role);
			jsonArrayChildren.put(roleJsonObj);
		}
		/*
		 * List<DictionaryData> dictDatas = this.tableService.findResultsByNamedParamHSQL(hsql, paramsArr, valuesArr);
		 * JSONArray jsonArrayChildren = new JSONArray();
		 * for(DictionaryData dictData : dictDatas){
		 * JSONObject dictionaryDataJsonObj = dictData.getJsonObjectDictionaryData(dictData);
		 * dictionaryDataJsonObj.put("state","opened");
		 * JSONObject attributesJsonObj = new JSONObject();
		 * attributesJsonObj.put("type", "relation");
		 * dictionaryDataJsonObj.put("attributes", attributesJsonObj);
		 * jsonArrayChildren.put(dictionaryDataJsonObj);
		 * }
		 */
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getDefinedRelationTreeData.action")
	public String getDefinedRelationTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Relationship> relations = this.tableService.findResultsByHSQL("from Relationship r order by r.relationName");
		JSONArray jsonArrayChildren = new JSONArray();
		for (Relationship relation : relations) {
			jsonArrayChildren.put(this.getJsonObjectRelation(relation,"definedRelation"));
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	public JSONObject getJsonObjectRelation(Relationship relation,String type) throws JSONException {

		JSONObject json = new JSONObject();
		json.put("id", relation.getId());
		json.put("text", relation.getRelationName());
		json.put("iconCls", "icon-connect");
		json.put("state", "open");
		JSONObject attributesJson = new JSONObject();
		attributesJson.put("type", type);
		attributesJson.put("relationId", relation.getId());
		json.put("attributes", attributesJson);
		return json;
	}

		
	public JSONObject getJsonObjectRelationRole(Role role) throws Exception {
		String currentState = "opened";
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", role.getId());
		jsonObj.put("text", role.getName() + "（" + role.getCode() + "）");
		jsonObj.put("iconCls", "icon-contact");
		jsonObj.put("state", currentState);
		JSONObject attributesJsonObj = new JSONObject();
		attributesJsonObj.put("type", "relation");
		attributesJsonObj.put("roleId", role.getId());
		jsonObj.put("attributes", attributesJsonObj);
		return jsonObj;
	}

	@RequestMapping(value = "/getStepTreeData.action")
	public String getStepTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = model.get("selectedUserIds");
		String queryText = model.get("queryText");
		String hsql = "FROM ActivityDetail u WHERE (case u.enabled when 0 then 0 else 1 end )= 1 and u.deploymentImpl.dbid = :deployId and u.activityType !=:start and u.activityType !=:end and u.id != :currentActivityDetailId";
		List<String> params = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		params.add("deployId");
		params.add("start");
		params.add("end");
		params.add("currentActivityDetailId");
		Long deployId = Long.parseLong(model.get("deployId"));
		values.add(deployId);
		values.add("start");
		values.add("end");
		values.add(model.get("currentActivityDetailId"));

		if (null != selectedUserIds) {
			hsql += " AND id not in(:ids) ";
			params.add("ids");
			values.add(selectedUserIds.split(","));
		}
		if (null != queryText) {
			params.add("queryText");
			values.add("%" + queryText.toUpperCase() + "%");
			String whereCondition = " AND ( UPPER(u.activityName) like :queryText ";
			hsql += whereCondition;
		}
		hsql += " order by u.activityName ";
		String[] paramsArr = new String[params.size()];
		paramsArr = params.toArray(paramsArr);
		Object[] valuesArr = new Object[values.size()];
		valuesArr = values.toArray(valuesArr);
		List<ActivityDetail> activityDetails = this.tableService.findResultsByNamedParamHSQL(hsql, paramsArr, valuesArr);
		String rootText = "根元素";
		List<Object> l = this.tableService.findResultsByHSQL("from DeploymentImpl where dbid = ? ", deployId);
		if (l.size() > 0) {
			rootText = ((DeploymentImpl) l.get(0)).getJbpmWorkflowDesigner().getWorkflowDefinition();
		}
		JSONObject rootJsonObj = new JSONObject();
		rootJsonObj.put("id", "WorflowRoot");
		rootJsonObj.put("text", rootText);
		rootJsonObj.put("iconCls", "icon-home");
		rootJsonObj.put("state", "opened");
		JSONObject rootAttributesJsonObj = new JSONObject();
		rootAttributesJsonObj.put("type", "WorkflowDefinition");
		rootJsonObj.put("attributes", rootAttributesJsonObj);
		JSONArray jsonArrayChildren = new JSONArray();
		rootJsonObj.put("children", jsonArrayChildren);
		for (ActivityDetail activityDetail : activityDetails) {
			JSONObject activityDetailJsonObj = activityDetail.getJsonObjectActivityDetail(activityDetail);
			activityDetailJsonObj.put("state", "opened");
			JSONObject attributesJsonObj = new JSONObject();
			attributesJsonObj.put("type", "step");
			activityDetailJsonObj.put("attributes", attributesJsonObj);
			jsonArrayChildren.put(activityDetailJsonObj);
		}
		JSONArray rootArrayChildren = new JSONArray();
		rootArrayChildren.put(rootJsonObj);
		this.output(response, rootArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getUserGroupTreeData.action")
	public String getUserGroupTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String userId = model.get("userId");
		String queryText = model.get("queryText");
		List<Group> groups = (List<Group>) this.tableService.findEntities(Group.class);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Group group : groups) {
			JSONObject groupJsonObj = this.overridegetJsonObjectUser(group, queryText);
			if("{}".equals(groupJsonObj.toString()))continue;
			groupJsonObj.getJSONObject("attributes").put("userId", userId);
			if (null != userId) {
				groupJsonObj.put("checked", this.isUserGroupChecked(group, userId));
			}
			jsonArrayChildren.put(groupJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getDeptRoleTreeData.action")
	public String getDeptRoleTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String deptId = model.get("deptId");
		List<Role> roles = (List<Role>) this.tableService.findEntities(Role.class);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Role role : roles) {
			JSONObject groupJsonObj = this.getJsonObjectRole(role);
			groupJsonObj.getJSONObject("attributes").put("deptId", deptId);
			if (null != deptId) {
				groupJsonObj.put("checked", this.isDepartmentRoleChecked(role, deptId));
			}
			jsonArrayChildren.put(groupJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getDeptUserTreeData.action")
	public String getDeptUserTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String deptId = model.get("deptId");
		String notIncludeUserIds = model.get("notIncludeUserIds");
		String queryText = model.get("queryText");
		//去除已离职的用户
		String hsql = " FROM User u  WHERE u.enabled=1 and u.id NOT IN(SELECT ud.user.id FROM UserDepartment ud WHERE  ud.dept.id = ?)";
		List<User> users = null;
		if (null != queryText) {
			String whereCondition = " AND ( UPPER(u.username) like ?  OR  UPPER(u.code) like ?  OR  UPPER(u.realname) like ? ) ";
			hsql += whereCondition;
			String whereValue = "%{0}%".replace("{0}", queryText);
			users = this.tableService.findResultsByHSQL(hsql, deptId, whereValue, whereValue, whereValue);
		} else {
			users = this.tableService.findResultsByHSQL(hsql, deptId);
		}
		JSONArray jsonArrayChildren = new JSONArray();
		for (User user : users) {
			boolean isPassed = true;
			if (null != notIncludeUserIds) {
				for (String notIncludeUserId : notIncludeUserIds.split(",")) {
					if (user.getId().equals(notIncludeUserId)) {
						isPassed = false;
						break;
					}
				}
			}
			if (!isPassed)
				continue;
			JSONObject userJsonObj = this.getJsonObjectUser(user);
			userJsonObj.getJSONObject("attributes").put("deptId", deptId);
			if (null != deptId) {
				userJsonObj.put("checked", this.isUserDepartmentChecked(user, deptId));
			}
			jsonArrayChildren.put(userJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getUserTreeData.action")
	public String getUserTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = model.get("selectedUserIds");
		if (null == selectedUserIds) {
			this.output(response, "[]");
			return null;
		}
		String[] ids = selectedUserIds.split(",");
		List<?> users = this.tableService.findEntityByIDArray(User.class, ids);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Object userObj : users) {
			User user = (User) userObj;
			JSONObject userJsonObj = this.getJsonObjectUser(user);
			jsonArrayChildren.put(userJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getDeptSelectedTreeData.action")
	public String getDeptSelectedTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = model.get("selectedUserIds");
		if (null == selectedUserIds) {
			this.output(response, "[]");
			return null;
		}
		String[] ids = selectedUserIds.split(",");
		List<?> users = this.tableService.findEntityByIDArray(Department.class, ids);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Object userObj : users) {
			Department user = (Department) userObj;
			JSONObject userJsonObj = this.getJsonObjectDept(user, false, "opened");
			jsonArrayChildren.put(userJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getGroupSelectedTreeData.action")
	public String getGroupSelectedTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = model.get("selectedUserIds");
		if (null == selectedUserIds) {
			this.output(response, "[]");
			return null;
		}
		String[] ids = selectedUserIds.split(",");
		List<?> users = this.tableService.findEntityByIDArray(Group.class, ids);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Object userObj : users) {
			Group user = (Group) userObj;
			JSONObject userJsonObj = this.getJsonObjectGroup(user);
			jsonArrayChildren.put(userJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}
	
	@RequestMapping(value = "/getRelationSelectedTreeData.action")
	public String getRelationSelectedTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = model.get("selectedUserIds");
		if (null == selectedUserIds) {
			this.output(response, "[]");
			return null;
		}
		String[] ids = selectedUserIds.split(",");
		/*
		 * List<?> users = this.tableService.findEntityByIDArray(DictionaryData.class, ids);
		 * JSONArray jsonArrayChildren = new JSONArray();
		 * for(Object userObj : users){
		 * DictionaryData dictionaryData = (DictionaryData)userObj;
		 * JSONObject dictionaryDataJsonObj = dictionaryData.getJsonObjectDictionaryData(dictionaryData);
		 * dictionaryDataJsonObj.put("state","opened");
		 * JSONObject attributesJsonObj = new JSONObject();
		 * attributesJsonObj.put("type", "relation");
		 * dictionaryDataJsonObj.put("attributes", attributesJsonObj);
		 * jsonArrayChildren.put(dictionaryDataJsonObj);
		 * }
		 */
		List<Role> roles = this.tableService.findEntityByIDArray(Role.class, ids);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Role role : roles) {
			JSONObject roleJsonObj = this.getJsonObjectRelationRole(role);
			jsonArrayChildren.put(roleJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getDefinedRelationSelectedTreeData.action")
	public String getDefinedRelationSelectedTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = model.get("selectedUserIds");
		if (null == selectedUserIds) {
			this.output(response, "[]");
			return null;
		}
		String[] ids = selectedUserIds.split(",");
		List<Relationship> relations = this.tableService.findEntityByIDArray(Relationship.class, ids);

		JSONArray jsonArrayChildren = new JSONArray();
		for (Relationship relation : relations) {
			jsonArrayChildren.put(this.getJsonObjectRelation(relation,"definedRelation"));
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getStepSelectedTreeData.action")
	public String getStepSelectedTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = model.get("selectedUserIds");
		if (null == selectedUserIds) {
			this.output(response, "[]");
			return null;
		}
		String[] ids = selectedUserIds.split(",");
		List<?> users = this.tableService.findEntityByIDArray(ActivityDetail.class, ids);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Object userObj : users) {
			ActivityDetail activityDetail = (ActivityDetail) userObj;
			JSONObject dictionaryDataJsonObj = activityDetail.getJsonObjectActivityDetail(activityDetail);
			dictionaryDataJsonObj.put("state", "opened");
			JSONObject attributesJsonObj = new JSONObject();
			attributesJsonObj.put("type", "step");
			dictionaryDataJsonObj.put("attributes", attributesJsonObj);
			jsonArrayChildren.put(dictionaryDataJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	@RequestMapping(value = "/getRoleTreeData.action")
	public String getRoleTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = model.get("selectedUserIds");
		if (null == selectedUserIds) {
			this.output(response, "[]");
			return null;
		}
		String[] ids = selectedUserIds.split(",");
		List<?> users = this.tableService.findEntityByIDArray(DepartmentRole.class, ids);
		JSONArray jsonArrayChildren = new JSONArray();
		for (Object userObj : users) {
			DepartmentRole user = (DepartmentRole) userObj;
			JSONObject userJsonObj = this.getJsonObjectDepartmentRole(user);
			jsonArrayChildren.put(userJsonObj);
		}
		this.output(response, jsonArrayChildren.toString());
		return null;
	}

	/**
	 * @deprecated Use {@link com.business.entity.Group#getJsonObjectGroup()} instead
	 */
	public JSONObject getJsonObjectGroup(Group group) throws Exception {
		return group.getJsonObjectGroup();
	}
	public JSONObject overridegetJsonObjectUser(Group group,String queryText)throws Exception  {
		return group.getJsonObjectGroup(queryText);
	}
	public JSONObject getJsonObjectUser(User user) throws Exception {
		String currentState = "opened";
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", user.getId());
		jsonObj.put("text", user.getRealname() + "（" + user.getUsername() + "）");
		jsonObj.put("iconCls", "icon-users");
		jsonObj.put("state", currentState);
		JSONObject attributesJsonObj = new JSONObject();
		attributesJsonObj.put("type", "user");
		attributesJsonObj.put("deptEntityClassName", "UserDepartment");
		attributesJsonObj.put("userId", user.getId());
		jsonObj.put("attributes", attributesJsonObj);
		return jsonObj;
	}

	public JSONObject getJsonObjectRole(Role role) throws Exception {
		String currentState = "opened";
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", role.getId());
		jsonObj.put("text", role.getName() + "（" + role.getCode() + "）");
		jsonObj.put("iconCls", "icon-contact");
		jsonObj.put("state", currentState);
		JSONObject attributesJsonObj = new JSONObject();
		attributesJsonObj.put("type", "role");
		attributesJsonObj.put("deptEntityClassName", "DepartmentRole");
		attributesJsonObj.put("roleId", role.getId());
		jsonObj.put("attributes", attributesJsonObj);
		return jsonObj;
	}

	public boolean isMenuGroupChecked(Group group, String menuId) throws Exception {
		boolean isChecked = false;
		for (MenuGroup menuGroup : group.getMenuGroups()) {
			String currentMenuId = menuGroup.getMenu().getId();
			if (menuId.equals(currentMenuId)) {
				isChecked = true;
				break;
			}
		}
		return isChecked;
	}

	public boolean isResourceGroupChecked(Group group, String resourceId) throws Exception {
		boolean isChecked = false;
		for (ResourceGroup resourceGroup : group.getResourceGroups()) {
			String currentResourceId = resourceGroup.getResource().getId();
			if (resourceId.equals(currentResourceId)) {
				isChecked = true;
				break;
			}
		}
		return isChecked;
	}

	public boolean isActionGroupChecked(Group group, String actionId) throws Exception {
		boolean isChecked = false;
		for (ActionGroup actionGroup : group.getActionGroups()) {
			String currentMenuId = actionGroup.getAction().getId();
			if (actionId.equals(currentMenuId)) {
				isChecked = true;
				break;
			}
		}
		return isChecked;
	}

	public boolean isWorkflowStartGroupChecked(Group group, String workflowStartId) throws Exception {
		boolean isChecked = false;
		for (WorkflowStartGroup workflowStartGroup : group.getWorkflowStartGroups()) {
			String currentMenuId = workflowStartGroup.getWorkflowStart().getId();
			if (workflowStartId.equals(currentMenuId)) {
				isChecked = true;
				break;
			}
		}
		return isChecked;
	}

	public boolean isWorkflowViewGroupChecked(Group group, String workflowViewId) throws Exception {
		boolean isChecked = false;
		for (WorkflowViewGroup workflowViewGroup : group.getWorkflowViewGroups()) {
			String currentMenuId = workflowViewGroup.getWorkflowView().getId();
			if (workflowViewId.equals(currentMenuId)) {
				isChecked = true;
				break;
			}
		}
		return isChecked;
	}

	public boolean isUserGroupChecked(Group group, String userId) throws Exception {
		boolean isChecked = false;
		for (UserGroup userGroup : group.getUserGroups()) {
			String currentUserId = userGroup.getUser().getId();
			if (userId.equals(currentUserId)) {
				isChecked = true;
				break;
			}
		}
		return isChecked;
	}

	public boolean isUserDepartmentChecked(User user, String deptId) throws Exception {
		boolean isChecked = false;
		for (UserDepartment userDept : user.getUserDepts()) {
			String currentDeptId = userDept.getDept().getId();
			if (deptId.equals(currentDeptId)) {
				isChecked = true;
				break;
			}
		}
		return isChecked;
	}

	public boolean isDepartmentRoleChecked(Role role, String deptId) throws Exception {
		boolean isChecked = false;
		for (DepartmentRole deptRole : role.getDeptRoles()) {
			String currentDeptId = deptRole.getDept().getId();
			if (deptId.equals(currentDeptId)) {
				isChecked = true;
				break;
			}
		}
		return isChecked;
	}

	@RequestMapping(value = "/getExcelExportData.action")
	public String getExcelExportData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapNoAjax(request);
		String xmlFileNameOrPath = model.get("xmlFileName");
		String fileTitleName = model.get("excelTitleName");
		String exportExcelVersion = StringUtil.nullToString(model.get("exportExcelVersion"), "2007");
		String extent = ".xlsx";
		if (exportExcelVersion.trim().equals("2003")) {
			extent = ".xls";
		}
		fileTitleName += "_" + DateUtil.getSystemDateTime().replaceAll("\\s", "-").replaceAll(":", "-") + extent;
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		// fileTitleName = URLDecoder.decode(fileTitleName, "utf-8").trim();
		String browserType = model.get("BrowserType");
		fileTitleName = QueryUtil.getFilenameAssociateBrowser(browserType, fileTitleName);
		response.setHeader("Content-disposition", "attachment; filename=" + fileTitleName);
		boolean isExportTitle = !("false".equals(model.get("isExportTitle")));
		boolean isOnlyExportByXmlFile = "true".equalsIgnoreCase(StringUtil.nullToString(model.get("isOnlyExportByXmlFile")).trim());
		this.tableService.doExportExcel(xmlFileNameOrPath, model, isExportTitle, response.getOutputStream(), isOnlyExportByXmlFile);
		return null;
	}
}
