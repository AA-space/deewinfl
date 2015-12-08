<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix='spring' uri='/WEB-INF/tlds/spring.tld' %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>德银融资租赁管理系统</title>
		<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/cloud.js"></script>
		 <!--css sheet-->
	   <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
	   <script type="text/javascript">
		if (window != window.top) 
		{
		   window.top.location.href = "${pageContext.request.contextPath}/acl/index.acl"; 
		}
		function MM_swapImgRestore() { //v3.0
		  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
		}
		function MM_preloadImages() { //v3.0
		    var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
		    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
		    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
            var userInput    = document.getElementById("j_username");
            var userPassword = document.getElementById("j_password");
		    userInput.value = getCookie("SECURITY_USER_NAME_SAVE_KEY");
			if('true' == '${param.login_password_error}')
			{
				userPassword.focus();
		    }else{
		    	userInput.focus();
			}
		}
		
		function MM_findObj(n, d) { //v4.01
		  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
		    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
		  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
		  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
		  if(!x && d.getElementById) x=d.getElementById(n); return x;
		}
		
		function MM_swapImage() { //v3.0
		  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
		   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
		}
		function setCookie(name,value)//两个参数，一个是cookie的名子，一个是值
		{
		 var Days = 30; //此 cookie 将被保存 30 天
		 var exp   = new Date(); //new Date("December 31, 9998");
		 exp.setTime(exp.getTime() + Days*24*60*60*1000);
		 document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
		}

		function getCookie(name)//取cookies函数       
		{
		    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
		    if(arr != null) return unescape(arr[2]); return "";
		}
		function login()
		{
			var inputUsername = document.getElementById("j_username");
			username = inputUsername.value.replace(/(^\s{1,})|(\s{1,}$)/gim,"");
			inputUsername.value = username;
			setCookie("SECURITY_USER_NAME_SAVE_KEY",username);
			if(!username){
			   alert("用户名不能为空！");
               return false;
			}
			document.getElementById("login_form_").submit();
		}
		document.onkeyup = loginAction;
		function loginAction(evt)
		{
			var e=window.event||evt;
			if(e.keyCode==13)
			{
			 	login();
		    }
		}
     </script>
</head>
<body  style="background-color: #1c77ac; background-image: url(${pageContext.request.contextPath}/images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">
		<div id="mainBody">
			<div id="cloud1" class="cloud"></div>
			<div id="cloud2" class="cloud"></div>
		</div>
		<div class="logintop" style="height:47px;">
			<span>欢迎登录系统</span>
		</div>
		<form name="login_form_" id="login_form_" action="<c:url value='j_spring_security_check'/>" method="post" >
			<div class="loginbody">
				<span class="systemlogo"></span>
				<div class="loginbox" id='id_loginBox'>
					<ul>
						<li><input name="j_username" id='j_username' type="text" class="loginuser"/></li>
						<li><input name="j_password" id='j_password' type="password" class="loginpwd" /></li>
						<li style="float:right;margin-right:70px;"><input name="" type="button" class="loginbtn" value="登录"onclick="javascript:login();" /></li>
					</ul>
				</div>
				<script type="text/javascript">
				    var loginBox = document.getElementById("id_loginBox");
				    var all_width = document.documentElement.clientWidth;
				    with(loginBox){
				    	style.position = "absolute";
				    	style.left     = (all_width-692)/2+"px";
				    }
				    window.onresize = function(e){
					    with(loginBox){
					    	style.position = "absolute";
					    	style.left     = (all_width-692)/2+"px";
					    }
				    };
				</script>
			</div>
		<form>
		<div class="loginbm" style="display:none">版权所有 2014</div>
		<script type="text/javascript">
		<!--
		 var loadInfo = function(){
			if('empty' == '${param.checkUniqueComputerPass}')
			{
				alert("未检测到该机器的硬盘号，请检查是否已安装所需浏览器插件，或者没有加入受信站点！");
		    }
			if('false' == '${param.checkUniqueComputerPass}')
			{
				alert("请使用已注册的电脑登录（${param.checkUserName}）");
		    }
			if('true' == '${param.login_username_error}')
			{
				alert("您输入的用户不存在，请重新输入！");
		    }
			if('true' == '${param.login_password_error}')
			{
				alert("您输入的密码有误，请重新输入！");
		    }
		 };
		 setTimeout("loadInfo()",200);
		//-->
	 </script>
	</body>
	</html>