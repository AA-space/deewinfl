package com.business.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import com.business.entity.Action;
import com.business.entity.Department;
import com.business.entity.Dictionary;
import com.business.entity.DictionaryData;
import com.business.entity.Group;
import com.business.entity.LoginInfo;
import com.business.entity.Menu;
import com.business.entity.Role;
import com.business.entity.User;
import com.business.entity.UserDepartment;
import com.business.entity.WorkflowDesignerReject;
import com.business.entity.base.BaseDocumentConfig;
import com.business.entity.base.BaseDocumentConfigData;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerDeptInfo;
import com.business.service.AclService;
import com.kernal.utils.DateUtil;
import com.kernal.utils.MD5Util;
import com.kernal.utils.PermissionUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.RemoteUtil;
import com.kernal.utils.ResourceUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.StringUtil;
import com.kernal.utils.WebUtil;
import com.kernal.utils.XMLDataUtil;


 /**
 * 类名称：     AclController
 * 类描述：     用于用户管理、菜单管理、角色管理
 * 创建人：     tracywindy
 * 修改人：     tracywindy
 * 修改时间：2012-9-19 上午11:46:32
 * 修改备注：
 * @version 1.0.0
 **/
@Controller(value="aclController")
@RequestMapping(value="/**/acl")
public class AclController extends BaseController
{
   Log logger = LogFactory.getLog(this.getClass());
   
   @Resource(name="aclService")
   private AclService aclService;
   //shiro start
   private final  String LoginURL            = "login.jsp";
   private final  String LoginSuccessURL     = "acl/index.acl";
   private final  String LoginOutSuccessURL  = "login.jsp";
   
   @RequestMapping(value="/login.acl")
   public String login(HttpServletRequest request,HttpServletResponse response) 
   {
	    Map<String, String> loginMap = null;
		try {
			loginMap = QueryUtil.getRequestParameterMapNoAjax(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String username = loginMap.get("j_username");
		String password = loginMap.get("j_password");
		boolean rememberMe = "true".equalsIgnoreCase(loginMap.get("rememberMe"));
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(rememberMe);
		token.setHost(request.getRemoteHost());
		Subject subject = SecurityUtils.getSubject();
		boolean success = true;
		Exception e = null;
		String reloadPageUrl = LoginSuccessURL;
        try {
        	subject.login(token);
        } catch (UnknownAccountException uae) {
            success = false;
            e = uae;
            reloadPageUrl = LoginURL+"?login_username_error=true";
        } catch (IncorrectCredentialsException ice) {
        	success = false;
        	e = ice;
        	reloadPageUrl = LoginURL+"?login_password_error=true";
        } catch (LockedAccountException lae) {
        	success = false;
        	e = lae;
        	reloadPageUrl = LoginURL+"?login_locked_error=true";
        } catch (ExcessiveAttemptsException eae) {
        	success = false;
        	e = eae;
        	reloadPageUrl = LoginURL+"?login_excessiveAttempts_error=true";
        } catch (Exception ee) {
        	success = false;
        	e = ee;
        	reloadPageUrl = LoginURL+"?error=true";
        }
        if(success){
            Session session = subject.getSession(false);//request.getSession(false);
            User user = (User)SecurityUtil.getPrincipal();
            session.setAttribute("isHasUserLoginedUserName",user.getUsername());
            session.setAttribute("login_userid", user.getId());
            session.setAttribute("login_userpassword", user.getId());
            session.setAttribute("login_username", user.getUsername());
            session.setAttribute("login_realname", user.getRealname());
            session.setAttribute("login_usertelephone", user.getTelephone());
            session.setAttribute("login_useremail", user.getEmail());
            session.setAttribute("currentAllAuthoritiesString",user.getAllAuthoritiesString());
            
            session.setAttribute("loginUser",user);
            List<String> userDeptList = new ArrayList<String>();
            String dealerCustInfoId     = "";
            String dealerCustInfoName   = "";
            for(UserDepartment userDept : user.getUserDepts()){
            	Department dept = userDept.getDept();
            	dept.toString();
            	userDeptList.add(dept.getId());
            	if("".equals(dealerCustInfoId)){
                	for(DealerDeptInfo ddi : dept.getDealerDeptInfos()){
                		CustInfo custInfo = ddi.getCustId();
                		if(null != custInfo){
                			dealerCustInfoId = custInfo.getId();
                			dealerCustInfoName = custInfo.getCustName();
                		}
                	}
            	}
            	session.setAttribute("loginUserDeptObj", dept);
            }
            session.setAttribute("userDeptListStr", StringUtil.join(userDeptList, ","));
            session.setAttribute("userDeptListSqlStr", StringUtil.join(userDeptList, ",", "'", "'"));
            //代理商信息
    		session.setAttribute("currentDealerCustInfoId", dealerCustInfoId);
    		session.setAttribute("currentDealerCustInfoName",  dealerCustInfoName);
            
            Date lastUpdatePasswordDate = DateUtil.getTimeByFormat(StringUtil.empty2Other(user.getLastUpdatePasswordDate(),"1900-01-01"),"yyyy-MM-dd");
            int intervalDays = DateUtil.getIntervalDays(lastUpdatePasswordDate, new Date());
            String isForceUpdatePassword = (intervalDays >= ResourceUtil.getUpdatePasswordDays()) ? "true":"false";
            session.setAttribute("isForceUpdatePassword",isForceUpdatePassword);
            session.setAttribute("isOccuredUserLoginBySystem", "true");
            //设置session中的locale
            WebUtil.setSessionLocale(WebUtil.getLocaleResolver().resolveLocale(request));
        }
        //System.out.println("登录信息:"+String.format("who %s , where %s , warn : %s", ((User)SecurityUtil.getPrincipal()).getRealname(), token.getHost(), e));
        return "redirect:/"+reloadPageUrl;
   }
   @RequestMapping(value="/loginOut.acl")
   public String loginOut(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Subject subject = SecurityUtils.getSubject();
	   subject.logout();
	   System.out.println("###注销:"+((User)SecurityUtil.getPrincipal()).getRealname());
	   return "redirect:/"+LoginOutSuccessURL;
   }
   //shiro finish
   @RequestMapping(value="/changeLocale.acl")
   public String changeLocale(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
		Locale currentLocale = new Locale(request.getParameter("locale").split("_")[0],request.getParameter("locale").split("_")[1]);
		WebUtils.setSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, currentLocale);
		WebUtil.setSessionLocale(currentLocale);
		String reloadPageUrl= StringUtil.empty2Other(request.getParameter("reloadPageUrl"),"login.jsp");
		return "redirect:/"+reloadPageUrl;
   }
   @RequestMapping(value="/updateSystemMode.acl")
   public String updateSystemMode(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   ResourceUtil.setDebug(!ResourceUtil.isDebug());
	   return null;
   }
	@RequestMapping(value="/index.acl")
	public String getCurrentUserIndexPageUrl(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		List<LoginInfo> onlineUsers = aclService.findResultsByHSQL("select li from LoginInfo li");//((SessionRegistry)WebUtil.getApplicationContext().getBean("sessionRegistry")).getAllPrincipals();
		int online_user_count = onlineUsers.size();
		request.setAttribute("online_user_count", online_user_count);
		request.setAttribute("onlineUsers", onlineUsers);
		String pageUrlPath = this.aclService.getCurrentUserIndexPageUrl();
		String currentIndex = "top_menu_index.jsp";
		if("left".equalsIgnoreCase(ResourceUtil.getMenuType()))
		{
			currentIndex = "left_menu_index.jsp";
		}
		if("leftTreeMenu".equalsIgnoreCase(ResourceUtil.getMenuType()))
		{
			currentIndex = "left_tree_menu_index.jsp";
		}
		String url = "/solutions/acl/"+currentIndex+"?pageUrlPath="+pageUrlPath;
		logger.debug(url);
		Locale locale = WebUtil.getSessionLocale();
		if(null == locale){
			locale = WebUtil.getLocaleResolver().resolveLocale(request);
			WebUtil.setSessionLocale(locale);
		}
		request.setAttribute("currentLoginSessionLanguage", StringUtil.nullToString(locale.getLanguage()).toUpperCase());
		return "/solutions/acl/"+currentIndex+"?pageUrlPath="+pageUrlPath;
	}
   //###################
   @RequestMapping(value="/addUser.acl")
   public String addUser(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
       String returnInfo  = this.aclService.addUser(model);	   
       this.output(response, returnInfo);
	   if(logger.isInfoEnabled())
	   {
		   logger.info("注册新用户【用户："+model.get("realname")+"<"+model.get("username")+">】");
	   }
	   return null;
   }
	@RequestMapping(value="/updateUser.acl")
   public String updateUser(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String userId = model.get("id");
       String returnInfo  = this.aclService.updateUser(userId, model)  ;
       this.output(response, returnInfo);
	   return null;
   }
   
   @RequestMapping(value="/removeUser.acl")
   public String removeUser(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = model.get("id");
	   Assert.notNull(id);
	   User user = (User)this.aclService.findEntityByID(User.class, id);
	   this.aclService.removeEntity(user);
	   return null;
   }
   
   @RequestMapping(value="/resetPassword.acl")
   public String resetPassword(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = model.get("id");
	   Assert.notNull(id);
	   User user = (User)this.aclService.findEntityByID(User.class, id);
	   String resetPassword = MD5Util.getMD5EncodedPasswordWithSalt("111111", id);
	   user.setPassword(resetPassword);
	   user.setLastUpdatePasswordDate(null);
	   this.aclService.updateEntity(user);
	   return null;
   }
   @RequestMapping(value="/updateUserEnabled.acl")
   public String updateUserEnabled(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = model.get("id");
	   Assert.notNull(id);
	   User user = (User)this.aclService.findEntityByID(User.class, id);
	   user.setEnabled(!user.isEnabled());
	   this.aclService.updateEntity(user);
	   return null;
   }
   //###############
   //################
   
   @RequestMapping(value="/updatePosition.acl")
   public String updatePosition(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	    String entityClassSimpleName = model.get("entityClassSimpleName");
	    String pid          = model.get("parentId");
	    String position     = model.get("currentPosition");
	    String id           = model.get("id");
	    if("Menu".equalsIgnoreCase(entityClassSimpleName)){
	    	 Menu menu = (Menu)this.aclService.findEntityByID(Menu.class, id);
	    	 menu.setParentMenu((Menu)this.aclService.findEntityByID(Menu.class, pid));
	    	 this.aclService.saveOrUpdateMenuWithPosition(menu, pid, position);
	    }
	    else if("Resource".equalsIgnoreCase(entityClassSimpleName)){
	    	com.business.entity.Resource resource = (com.business.entity.Resource)this.aclService.findEntityByID(com.business.entity.Resource.class, id);
	    	resource.setParentResource((com.business.entity.Resource)this.aclService.findEntityByID(com.business.entity.Resource.class, pid));
	    	this.aclService.saveOrUpdateResourceWithPosition(resource, pid, position);
	    }
	    else if("Action".equalsIgnoreCase(entityClassSimpleName)){
	    	Action action = (Action)this.aclService.findEntityByID(Action.class, id);
	    	action.setParentAction((Action)this.aclService.findEntityByID(Action.class, pid));
	    	this.aclService.saveOrUpdateActionWithPosition(action, pid, position);
	    }
	    else if("Dept".equalsIgnoreCase(entityClassSimpleName)){
	    	Department dept = (Department)this.aclService.findEntityByID(Department.class, id);
	    	dept.setParentDept((Department)this.aclService.findEntityByID(Department.class, pid));
	    	this.aclService.saveOrUpdateDeptWithPosition(dept, pid, position);
	    }
	    else if("Dictionary".equalsIgnoreCase(entityClassSimpleName)){
	    	Dictionary dictionary = (Dictionary)this.aclService.findEntityByID(Dictionary.class, id);
	    	dictionary.setParentDictionary((Dictionary)this.aclService.findEntityByID(Dictionary.class,pid));
	        this.aclService.saveOrUpdateDictionaryWithPosition(dictionary, pid, position);
	    }
	    else if("BaseDocumentConfig".equalsIgnoreCase(entityClassSimpleName)){
	    	BaseDocumentConfig baseDocumentConfig = (BaseDocumentConfig)this.aclService.findEntityByID(BaseDocumentConfig.class, id);
	    	baseDocumentConfig.setParentBaseDocumentConfig((BaseDocumentConfig)this.aclService.findEntityByID(BaseDocumentConfig.class,pid));
	    	this.aclService.saveOrUpdateBaseDocumentConfigWithPosition(baseDocumentConfig, pid, position);
	    }
 	    return null;
   }
   //##########
   @RequestMapping(value="/addMenu.acl")
   public String addMenu(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	    String pid          = model.get("parentMenu");
	    String position     = model.get("currentPosition");
	    Menu menu  = new Menu();
	    this.aclService.copyAndOverrideExistedValueFromStringMap(model, menu,null);
	    this.aclService.saveOrUpdateMenuWithPosition(menu, pid, position);
 	    return null;
   }
   @RequestMapping(value="/updateMenu.acl")
   public String updateMenu(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	    String pid          = model.get("parentMenu");
	    String position     = model.get("currentPosition");
	    String id           = model.get("id");
	    Assert.notNull(id);
	    Menu menu  = (Menu)this.aclService.findEntityByID(Menu.class,id);
	    this.aclService.copyAndOverrideExistedValueFromStringMap(model, menu,null);
	    this.aclService.saveOrUpdateMenuWithPosition(menu, pid, position);
 	    return null;
   }
   @RequestMapping(value="/removeMenu.acl")
   public String removeMenu(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id       = model.get("id");
	   Assert.notNull(id);
	   this.aclService.removeMenu(id);
	   return null;
   }
   @RequestMapping(value="/queryMenus.acl")
   public String getMenusTreeMenu(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Locale locale = WebUtil.getSessionLocale();
	   String returnInfo = this.aclService.getMenusTreeMenu(locale); 
	   if(null == returnInfo){this.output(response, "");return null;};
	   this.output(response, returnInfo);
	   return null;
   }
   //查询快捷操作
	@RequestMapping(value="/getUserQuickMenuTreeData.acl")
	public String getUserQuickMenuTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		   Locale locale = WebUtil.getSessionLocale();
		   String returnInfo = this.aclService.getMenusTreeMenu(locale); 
		   if(null == returnInfo){this.output(response, "");return null;};
		   JSONObject menuRoot = new JSONObject(returnInfo);
		   this.output(response, menuRoot.getJSONArray("children").toString());
		   return null;
	}
   //###############
   @RequestMapping(value="/addResource.acl")
   public String addResource(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	    String pid          = model.get("parentResource");
	    String position     = model.get("currentPosition");
	    com.business.entity.Resource resource  = new com.business.entity.Resource();
	    this.aclService.copyAndOverrideExistedValueFromStringMap(model, resource,null);
	    this.aclService.saveOrUpdateResourceWithPosition(resource, pid, position);
 	    return null;
   }
   @RequestMapping(value="/updateResource.acl")
   public String updateResource(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	    String pid          = model.get("parentResource");
	    String position     = model.get("currentPosition");
	    String id           = model.get("id");
	    Assert.notNull(id);
	    com.business.entity.Resource resource  = (com.business.entity.Resource)this.aclService.findEntityByID(com.business.entity.Resource.class,id);
	    this.aclService.copyAndOverrideExistedValueFromStringMap(model, resource,null);
	    this.aclService.saveOrUpdateResourceWithPosition(resource, pid, position);
 	    return null;
   }
   @RequestMapping(value="/removeResource.acl")
   public String removeResource(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id       = model.get("id");
	   Assert.notNull(id);
	   this.aclService.removeResource(id);
	   return null;
   }
   //###############
   //###############
   @RequestMapping(value="/addAction.acl")
   public String addAction(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	    String pid          = model.get("parentAction");
	    String position     = model.get("currentPosition");
	    Action action  = new Action();
	    this.aclService.copyAndOverrideExistedValueFromStringMap(model, action,null);
	    this.aclService.saveOrUpdateActionWithPosition(action, pid, position);
 	    return null;
   }
   @RequestMapping(value="/updateAction.acl")
   public String updateAction(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	    String pid          = model.get("parentAction");
	    String position     = model.get("currentPosition");
	    String id           = model.get("id");
	    Assert.notNull(id);
	    Action action  = (Action)this.aclService.findEntityByID(Action.class,id);
	    this.aclService.copyAndOverrideExistedValueFromStringMap(model, action,null);
	    this.aclService.saveOrUpdateActionWithPosition(action, pid, position);
 	    return null;
   }
   @RequestMapping(value="/removeAction.acl")
   public String removeAction(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id       = model.get("id");
	   Assert.notNull(id);
	   this.aclService.removeAction(id);
	   return null;
   }
   //###############
   @RequestMapping(value="/addDept.acl")
   public String addDept(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	    String pid          = model.get("parentDept");
	    String position     = model.get("currentPosition");
	    Department dept  = new Department();
	    this.aclService.copyAndOverrideExistedValueFromStringMap(model, dept,null);
	    this.aclService.saveOrUpdateDeptWithPosition(dept, pid, position);
 	    return null;
   }
   @RequestMapping(value="/updateDept.acl")
   public String updateDept(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	    String pid          = model.get("parentDept");
	    String position     = model.get("currentPosition");
	    String id           = model.get("id");
	    Assert.notNull(id);
	    Department dept  = (Department)this.aclService.findEntityByID(Department.class,id);
	    this.aclService.copyAndOverrideExistedValueFromStringMap(model, dept,null);
	    this.aclService.saveOrUpdateDeptWithPosition(dept, pid, position);
 	    return null;
   }
   @RequestMapping(value="/removeDept.acl")
   public String removeDept(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id       = model.get("id");
	   Assert.notNull(id);
	   this.aclService.removeDept(id);
	   return null;
   }
   //###############
   
   @RequestMapping(value="/modifyUserPassword.acl")
   public String modifyUserPassword(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String currentUserId     = model.get("currentUserId");
	   String oldPassword       = model.get("oldPassword");
	   String newPassword       = model.get("newPassword");
	   String telephone         = model.get("telephone");
	   String email             = model.get("email");
	   
	   String returnInfo   = this.aclService.modifyUserPassword(currentUserId, oldPassword, newPassword, telephone, email);
	   this.output(response, returnInfo);
	   HttpSession session = request.getSession(false);
	   session.setAttribute("login_usertelephone",telephone);
	   session.setAttribute("login_useremail",email);
	   return null;
   }
   
   //#################
   @RequestMapping(value="/addGroup.acl")
   public String addGroup(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   Group group = new Group();
	   this.aclService.copyAndOverrideExistedValueFromStringMap(model, group, null);
	   this.aclService.saveEntity(group);
	   if(logger.isInfoEnabled())
	   {
		   logger.info("注册新群组【群组："+group.getName()+" < "+group.getCode()+" > 】");
	   }
	   return null;
   }
	@RequestMapping(value="/updateGroup.acl")
   public String updateGroup(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = model.get("id");
	   Assert.notNull(id);
	   Group group = (Group)this.aclService.findEntityByID(Group.class, id);
	   this.aclService.copyAndOverrideExistedValueFromStringMap(model, group, null);
	   this.aclService.updateEntity(group);
	   return null;
   }
   
   @RequestMapping(value="/removeGroup.acl")
   public String removeGroup(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = model.get("id");
	   Assert.notNull(id);
	   Group group = (Group)this.aclService.findEntityByID(Group.class, id);
	   this.aclService.removeEntity(group);
	   return null;
   }
   @RequestMapping(value="/updateGroupEnabled.acl")
   public String updateGroupEnabled(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = model.get("id");
	   Assert.notNull(id);
	   Group group = (Group)this.aclService.findEntityByID(Group.class, id);
	   group.setEnabled(!group.getEnabled());
	   this.aclService.updateEntity(group);
	   return null;
   }
   //###############
   //#################
   @RequestMapping(value="/addRole.acl")
   public String addRole(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   Role role = new Role();
	   this.aclService.copyAndOverrideExistedValueFromStringMap(model, role, null);
	   this.aclService.saveEntity(role);
	   if(logger.isInfoEnabled())
	   {
		   logger.info("注册新群组【群组："+role.getName()+" < "+role.getCode()+" > 】");
	   }
	   return null;
   }
	@RequestMapping(value="/updateRole.acl")
   public String updateRole(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = model.get("id");
	   Assert.notNull(id);
	   Role role = (Role)this.aclService.findEntityByID(Role.class, id);
	   this.aclService.copyAndOverrideExistedValueFromStringMap(model, role, null);
	   this.aclService.updateEntity(role);
	   return null;
   }
   
   @RequestMapping(value="/removeRole.acl")
   public String removeRole(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = model.get("id");
	   Assert.notNull(id);
	   Role role = (Role)this.aclService.findEntityByID(Role.class, id);
	   this.aclService.removeEntity(role);
	   return null;
   }
   @RequestMapping(value="/updateRoleEnabled.acl")
   public String updateRoleEnabled(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = model.get("id");
	   Assert.notNull(id);
	   Role role = (Role)this.aclService.findEntityByID(Role.class, id);
	   role.setEnabled(!role.getEnabled());
	   this.aclService.updateEntity(role);
	   return null;
   }
   //###############
   //##################################
	   @RequestMapping(value="/addDictionary.acl")
	   public String addDictionary(HttpServletRequest request,HttpServletResponse response) throws Exception
	   {
		    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
		    String pid          = model.get("parentDictionary");
		    String position     = model.get("currentPosition");
		    Dictionary dict  = new Dictionary();
		    this.aclService.copyAndOverrideExistedValueFromStringMap(model, dict,null);
		    this.aclService.saveOrUpdateDictionaryWithPosition(dict, pid, position);
	 	    return null;
	   }
	   @RequestMapping(value="/updateDictionary.acl")
	   public String updateDictionary(HttpServletRequest request,HttpServletResponse response) throws Exception
	   {
		    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
		    String pid          = model.get("parentDictionary");
		    String position     = model.get("currentPosition");
		    String id           = model.get("id");
		    Assert.notNull(id);
		    Dictionary dict  = (Dictionary)this.aclService.findEntityByID(Dictionary.class,id);
		    this.aclService.copyAndOverrideExistedValueFromStringMap(model, dict,null);
		    this.aclService.saveOrUpdateDictionaryWithPosition(dict, pid, position);
	 	    return null;
	   }
	   @RequestMapping(value="/removeDictionary.acl")
	   public String removeDictionary(HttpServletRequest request,HttpServletResponse response) throws Exception
	   {
		   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
		   String id       = model.get("id");
		   Assert.notNull(id);
		   this.aclService.removeDictionary(id);
		   return null;
	   }
		@RequestMapping(value="/addDictionaryData.acl")
		   public String addDictionaryData(HttpServletRequest request,HttpServletResponse response) throws Exception
		   {
			    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			    String pid          = model.get("belongDictionary");
			    String position     = model.get("currentPosition");
			    Assert.notNull(pid);
			    DictionaryData dictionaryData = new DictionaryData();
			    this.aclService.copyAndOverrideExistedValueFromStringMap(model, dictionaryData,null);
			    dictionaryData.setPosition(1);
			    this.aclService.saveOrUpdateDictionaryDataWithPosition(dictionaryData, pid, position);
				if(logger.isInfoEnabled())
				{
					   logger.info("注册新字典数据【字典数据："+dictionaryData.getName()+" < "+dictionaryData.getCode()+" > 】");
				}
		 	    return null;
		   }
		   @RequestMapping(value="/updateDictionaryData.acl")
		   public String updateDictionaryData(HttpServletRequest request,HttpServletResponse response) throws Exception
		   {
			    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			    String pid          = model.get("belongDictionary");
			    String position     = model.get("currentPosition");
			    String id           = model.get("id");
			    Assert.notNull(pid);
			    Assert.notNull(id);
			    DictionaryData dictionaryData  = (DictionaryData)this.aclService.findEntityByID(DictionaryData.class,id);
			    this.aclService.copyAndOverrideExistedValueFromStringMap(model, dictionaryData,null);
			    this.aclService.saveOrUpdateDictionaryDataWithPosition(dictionaryData, pid, position);
			   
			   return null;
		   }
		@RequestMapping(value="/removeDictionaryData.acl")
		public String removeDictionaryData(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			String id    = model.get("id");
			Assert.notNull(id);
			this.aclService.removeEntityById(DictionaryData.class,id);
			return null;
		}
		@RequestMapping(value="/queryDictionarys.acl")
		public String getDictionariesTreeMenu(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			   String rootParentDictId = model.get("rootParentDictionaryId");
			   String returnInfo = this.aclService.getDictionariesTreeMenu(rootParentDictId); 
			   this.output(response, returnInfo);
			   return null;
		}
		@RequestMapping(value="/updateDictionaryDataEnabled.acl")
		public String updateDictionaryDataEnabled(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			   String id = model.get("id");
			   Assert.notNull(id);
			   DictionaryData dictionaryData = (DictionaryData)this.aclService.findEntityByID(DictionaryData.class, id);
			   dictionaryData.setEnabled(!dictionaryData.getEnabled());
			   this.aclService.updateEntity(dictionaryData);
			   return null;
		}
		//#########################
		//#########################
		@RequestMapping(value="/addBaseDocumentConfig.acl")
		   public String addBaseDocumentConfig(HttpServletRequest request,HttpServletResponse response) throws Exception
		   {
			    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			    String pid          = model.get("parentBaseDocumentConfig");
			    String position     = model.get("currentPosition");
			    BaseDocumentConfig baseDocumentConfig  = new BaseDocumentConfig();
			    this.aclService.copyAndOverrideExistedValueFromStringMap(model, baseDocumentConfig,null);
			    this.aclService.saveOrUpdateBaseDocumentConfigWithPosition(baseDocumentConfig, pid, position);
		 	    return null;
		   }
		   @RequestMapping(value="/updateBaseDocumentConfig.acl")
		   public String updateBaseDocumentConfig(HttpServletRequest request,HttpServletResponse response) throws Exception
		   {
			    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			    String pid          = model.get("parentBaseDocumentConfig");
			    String position     = model.get("currentPosition");
			    String id           = model.get("id");
			    Assert.notNull(id);
			    BaseDocumentConfig baseDocumentConfig  = (BaseDocumentConfig)this.aclService.findEntityByID(BaseDocumentConfig.class,id);
			    this.aclService.copyAndOverrideExistedValueFromStringMap(model, baseDocumentConfig,null);
			    this.aclService.saveOrUpdateBaseDocumentConfigWithPosition(baseDocumentConfig, pid, position);
		 	    return null;
		   }
		   @RequestMapping(value="/removeBaseDocumentConfig.acl")
		   public String removeBaseDocumentConfig(HttpServletRequest request,HttpServletResponse response) throws Exception
		   {
			   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			   String id       = model.get("id");
			   Assert.notNull(id);
			   this.aclService.removeBaseDocumentConfig(id);
			   return null;
		   }
			@RequestMapping(value="/addBaseDocumentConfigData.acl")
			   public String addBaseDocumentConfigData(HttpServletRequest request,HttpServletResponse response) throws Exception
			   {
				    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
				    String pid          = model.get("belongDocument");
				    String position     = model.get("currentPosition");
				    Assert.notNull(pid);
				    BaseDocumentConfigData dictionaryData = new BaseDocumentConfigData();
				    this.aclService.copyAndOverrideExistedValueFromStringMap(model, dictionaryData,null);
				    dictionaryData.setPosition(1);
				    this.aclService.saveOrUpdateBaseDocumentConfigDataWithPosition(dictionaryData, pid, position);
					if(logger.isInfoEnabled())
					{
						   logger.info("注册新字典数据【字典数据："+dictionaryData.getName()+" < "+dictionaryData.getCode()+" > 】");
					}
			 	    return null;
			   }
			   @RequestMapping(value="/updateBaseDocumentConfigData.acl")
			   public String updateBaseDocumentConfigData(HttpServletRequest request,HttpServletResponse response) throws Exception
			   {
				    Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
				    String pid          = model.get("belongDocument");
				    String position     = model.get("currentPosition");
				    String id           = model.get("id");
				    Assert.notNull(pid);
				    Assert.notNull(id);
				    BaseDocumentConfigData dictionaryData  = (BaseDocumentConfigData)this.aclService.findEntityByID(BaseDocumentConfigData.class,id);
				    this.aclService.copyAndOverrideExistedValueFromStringMap(model, dictionaryData,null);
				    this.aclService.saveOrUpdateBaseDocumentConfigDataWithPosition(dictionaryData, pid, position);
				   
				   return null;
			   }
			@RequestMapping(value="/removeBaseDocumentConfigData.acl")
			public String removeBaseDocumentConfigData(HttpServletRequest request,HttpServletResponse response) throws Exception
			{
				Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
				String id    = model.get("id");
				Assert.notNull(id);
				this.aclService.removeEntityById(BaseDocumentConfigData.class,id);
				return null;
			}
			@RequestMapping(value="/getBaseDocumentConfigsTreeMenu.acl")
			public String getBaseDocumentConfigsTreeMenu(HttpServletRequest request,HttpServletResponse response) throws Exception
			{
				   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
				   String rootParentDictId = model.get("rootParentDictionaryId");
				   String returnInfo = this.aclService.getBaseDocumentConfigsTreeMenu(rootParentDictId); 
				   this.output(response, returnInfo);
				   return null;
			}
			@RequestMapping(value="/updateBaseDocumentConfigDataEnabled.acl")
			public String updateBaseDocumentConfigDataEnabled(HttpServletRequest request,HttpServletResponse response) throws Exception
			{
				   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
				   String id = model.get("id");
				   Assert.notNull(id);
				   BaseDocumentConfigData dictionaryData = (BaseDocumentConfigData)this.aclService.findEntityByID(BaseDocumentConfigData.class, id);
				   dictionaryData.setEnabled(!dictionaryData.getEnabled());
				   this.aclService.updateEntity(dictionaryData);
				   return null;
			}
		//#########################
		@RequestMapping(value="/addOrRemoveDistribute.acl")
		public String addOrRemoveDistribute(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			String entityClassName = model.get("entityClassName");
			String leftFieldName = model.get("leftFieldName");
			String leftId = model.get("leftId");
			String rightFieldName = model.get("rightFieldName");
			String rightId = model.get("rightId");
			this.aclService.addOrRemoveDistribute(entityClassName, leftFieldName, leftId, rightFieldName, rightId,model);
			return null;
		}
		@RequestMapping(value="/addOrRemoveQuickMenuDistribute.acl")
		public String addOrRemoveQuickMenuDistribute(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			String entityClassName = model.get("entityClassName");
			String leftFieldName = model.get("leftFieldName");
			String leftId = model.get("leftId");
			String rightFieldName = model.get("rightFieldName");
			String rightId = model.get("rightId");
			this.aclService.addOrRemoveQuickMenuDistribute(entityClassName, leftFieldName, leftId, rightFieldName, rightId,model);
			return null;
		}
		//#########################
		@RequestMapping(value="/updatePermission.acl")
		public String updatePermission(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			PermissionUtil.cachedAllUserTreeMenus(true);
			return null;
		}
		//#########################
		@RequestMapping(value="/updateXmlData.acl")
		public String updateXmlData(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			Map<String,Map<String,String>> allXMLTable =  XMLDataUtil.getAllXMLTable();
		    WebUtil.setAllXMLTable(allXMLTable);
			Map<String,Map<String,String>> allXMLChart = XMLDataUtil.getAllXMLChart();
			WebUtil.setAllXMLChart(allXMLChart);
			RemoteUtil.remoteXmlDataSynchronized(allXMLTable,allXMLChart);
			return null;
		}
		//#########################
		@RequestMapping(value="/queryRoleUsers.acl")
		public String queryRoleUsers(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			String hsql = "select distinct u from UserDepartmentRole udr left join udr.user u left join udr.deptRole dr left join dr.role drr where drr.id = ? order by u.username ";
			String id   = model.get("id");
			StringBuffer  rs = new StringBuffer();
			List<User> users = this.aclService.findResultsByHSQL(hsql, id);
			int index = 0;
			for(User user : users){
				if(index++ > 0){
					rs.append("&nbsp;,&nbsp;");
				}
				String displayUser = "<font color='red'>"+user.getRealname()+"（"+user.getUsername()+"）</font>";
				rs.append(displayUser+"[&nbsp;");
				int innerIndex = 0;
				for(UserDepartment ud : user.getUserDepts()){
					if(innerIndex++ > 0){
						rs.append("&nbsp;,&nbsp;");
					}
					StringBuffer sb = new StringBuffer();
					this.recursorDept(ud.getDept(), sb,0);
					rs.append(sb.toString());
				}
				rs.append("&nbsp;]");
			}
			this.output(response, rs.toString());
			return null;
		}
		@RequestMapping(value="/queryGroupUsers.acl")
		public String queryGroupUsers(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			String hsql = "select u from UserGroup dr left join dr.user u  where dr.group.id = ? order by u.username ";
			String id   = model.get("id");
			StringBuffer  rs = new StringBuffer();
			List<User> users = this.aclService.findResultsByHSQL(hsql, id);
			int index = 0;
			for(User user : users){
				if(index++ > 0){
					rs.append("&nbsp;,&nbsp;");
				}
				String displayUser = "<font color='red'>"+user.getRealname()+"（"+user.getUsername()+"）</font>";
				rs.append(displayUser+"[&nbsp;");
				int innerIndex = 0;
				for(UserDepartment ud : user.getUserDepts()){
					if(innerIndex++ > 0){
						rs.append("&nbsp;,&nbsp;");
					}
					StringBuffer sb = new StringBuffer();
					this.recursorDept(ud.getDept(), sb,0);
					rs.append(sb.toString());
				}
				rs.append("&nbsp;]");
			}
			this.output(response, rs.toString());
			return null;
		}
		public void recursorDept(Department dept,StringBuffer sb,int index) throws Exception{
			if(null != dept){
				//if("0".equals(dept.getId()))return;
				if(index > 0){
					sb.insert(0,"/");
				}
				sb.insert(0,dept.getName()/*+"（"+dept.getCode()+"）"+*/ );
				Department parent = dept.getParentDept();
				this.recursorDept(parent, sb , index+1);
			}
		}
	//#########################
		@RequestMapping(value="/updateRejectQueryCondition.acl")
		public String updateRejectQueryCondition(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			String id = model.get("id");
			WorkflowDesignerReject wdr  = (WorkflowDesignerReject)this.aclService.findEntityByID(WorkflowDesignerReject.class, id);
			this.aclService.copyAndOverrideExistedValueFromStringMap(model, wdr, null);
			this.aclService.updateEntity(wdr);
			return null;
		}
		//#########################
		@RequestMapping(value="/uploadLicenseInfo.acl")
		public String uploadLicenseInfo(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			String returnInfo = "验证成功！";
			String redirectUrl = "/login.jsp";
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
			MultipartFile privateKeyMultipartFile    = multipartRequest.getFile("privateKey");
			MultipartFile authorizeInfoMultipartFile = multipartRequest.getFile("authorizeInfo");
			try{
			   String dealineDate = this.aclService.updateAndCheckLicenseInfo(privateKeyMultipartFile, authorizeInfoMultipartFile, null);
			   returnInfo+="有效期至 "+dealineDate;
			}catch(Exception e){
				returnInfo  = "验证失败";
				redirectUrl = "/acl/licenseUpload.bi";
			}
			this.ajaxReturn(response, "<script type='text/javascript'>alert('"+returnInfo+"');window.top.location.href='"+WebUtil.getWebContextPath()+redirectUrl+"';</script>");
			return null;
		}
		@RequestMapping(value="/updateAllPasswordToSixOne.acl")
		public String updateAllPasswordToSixOne(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			this.ajaxReturn(response, this.aclService.updateAllPasswordToSixOne());
			return null;
		}
		@RequestMapping(value="/removeUserSession.acl")
		public String removeUserSession(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			String removedUserid = request.getParameter("userId");
			HttpSession session = request.getSession(false);
			session.removeAttribute("isHasExistUser");
			String sessionId = session.getId();
			List<LoginInfo> li_list = aclService.findResultsByHSQL("select li from LoginInfo li where li.loginUser.id = ?", removedUserid);
			LoginInfo logInfo = li_list.get(0);
			String removedSessionId = logInfo.getSessionId();
	        String currentTime = DateUtil.getSystemDateTime();
	        Calendar now = Calendar.getInstance();
	        now.add(Calendar.SECOND, session.getMaxInactiveInterval());
	        String expireTime  = DateUtil.getDateTime(now.getTime());
        	logInfo.setLoginTime(currentTime);
        	logInfo.setSessionId(sessionId);
        	if(!sessionId.equals(removedSessionId)){
         	   logInfo.setRemovedSessionId(removedSessionId);
         	}
        	logInfo.setExpireTime(expireTime);
        	aclService.updateEntity(logInfo);
			return null;
		}
		@RequestMapping(value="/updateAdSynchronizedUsers.acl")
		public String updateAdSynchronizedUsers(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			this.aclService.updateAdSynchronizedUsers();
			this.ajaxReturn(response, "用户信息同步完成");
			return null;
		}
		@RequestMapping(value="/updateChangeIsException.acl")
		public String updateChangeIsException(HttpServletRequest request,HttpServletResponse response) throws Exception
		{
			Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			String userId = model.get("userId");
			User user = this.aclService.findEntityByID(User.class,userId);
			user.setIsExcepted(!user.getIsExcepted());
			this.aclService.updateEntity(user);
			return null;
		}
		
}
