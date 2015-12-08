package com.tenwa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.TestingAuthenticationProvider;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.business.dao.AclDao;
import com.business.entity.User;
import com.kernal.utils.FreeMarkerUtil;
import com.kernal.utils.PermissionUtil;
import com.kernal.utils.ResourceUtil;
import com.kernal.utils.WebUtil;
import com.kernal.utils.XMLDataUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml", "classpath:springmvc-servlet.xml", "classpath:applicationContext-security.xml",
		"classpath:applicationContext-jbpm.xml" })
public abstract class BaseMVCTest extends BaseTest {
	private static Logger						log	= LoggerFactory.getLogger(BaseMVCTest.class);

	@Autowired
	protected RequestMappingHandlerAdapter		handlerAdapter;

	protected static MockHttpServletRequest		request;
	protected static MockHttpServletResponse	response;
	
	@Autowired	
	protected ApplicationContext ctx;
		
	@Autowired
	private AclDao aclDao;

	@Autowired
	@Qualifier("_authenticationManager")
	private AuthenticationManager authenticationManager;

	@BeforeClass
	public static void beforeClass() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		log.debug("Request and Response mock OK!");		
	}
	
	@Before
	public void before() throws Exception{
		
		MockServletContext sc = new MockServletContext();
		WebUtil.setServletContext(sc);
        WebUtil.setApplicationContext(ctx);
        WebUtil.setWebContextPath(sc.getContextPath());
        WebUtil.setSessionLocale(Locale.CHINA);
        WebUtil.setWebContextRealPath(sc.getRealPath("/")+"/");
        //initialize the framework's config-file
        ResourceUtil.init();
        //initialize the charts's info
        FreeMarkerUtil.init();
        //缓存用户菜单
		if(log.isInfoEnabled())
		{
			log.info("正在缓存用户菜单...");			
		}
		
		try {
			PermissionUtil.cachedAllUserTreeMenus(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//缓存xml
        if(!ResourceUtil.isDebug())
        {
    		try 
    		{
    			long startMilis = System.currentTimeMillis();
    			if(log.isInfoEnabled())
    			{
    				log.info("正在缓存xml文件...");			
    			}
    			Map<String,Map<String,String>> allXmlTable = XMLDataUtil.getAllXMLTable();
    			WebUtil.setAllXMLTable(allXmlTable);
    			Map<String,Map<String,String>> allXmlChart = XMLDataUtil.getAllXMLChart();
    			WebUtil.setAllXMLChart(allXmlChart);
    			if(log.isInfoEnabled())
    			{
    				log.info("开始缓存xml文件完毕,共用时:"+(System.currentTimeMillis()-startMilis)/1000+" 秒 ");			
    			}
    		} catch (Exception e2) {
    			e2.printStackTrace();
    		}
        }	
		User user = aclDao.findUserByUserName("admin");
		
		Authentication authToken = new TestingAuthenticationToken(user,"111111",new GrantedAuthority[]{new GrantedAuthorityImpl("ROLE_USER")});
		ProviderManager providerManager = (ProviderManager)authenticationManager;
		List<TestingAuthenticationProvider> list = new ArrayList<TestingAuthenticationProvider>();
		list.add(new TestingAuthenticationProvider());
		providerManager.setProviders(list);
		SecurityContext context = new SecurityContextImpl();
		context.setAuthentication(authToken);		
		SecurityContextHolder.setContext(context);
		
		
		
	}

}
