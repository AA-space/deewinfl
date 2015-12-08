<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户主页</title>
		<!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/main.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/charts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/charts/js/FusionChartsExportComponent.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyChart.js"></script>
	<style type="text/css">
	
	.redlink  { 
	color:#000000 ; 
	text-decoration:none; 
	} 
	</style>
    <script type="text/javascript">
       var loadMask = null;
       var pendingLoaded   = false;
       var noticeLoaded    = false;
       var quickMenuLoaded = false;
       
       var currentDate = getCurDate(); 
       function showLoadMask(){
    	   if(!loadMask){
    		   loadMask = new tracywindyLoadMask(document.body,"数据加载中  请稍后...");
    	   }
    	   loadMask.show();
       }
       function hideLoadMask(){
    	   loadMask.hide();
       }
       function loadPendingInfo(){
    	  pendingLoaded = false;
    	  showLoadMask();
          //待办事宜
	      ajaxRequest({
		        url:"${pageContext.request.contextPath}/table/getTableData.action",
		        async:true,
		        success:function(response)
		        {    
		        	var rt = (response.responseText);
		        	var jsonData = JsonUtil.decode(rt);
		        	var $topLeftContentDiv = jQuery("#id_top_left_content_div");
		        	$topLeftContentDiv.html("");
		            if((typeof(jsonData.norecord)!='undefined')&&(jsonData.norecord=='true'))
		    	    {
		            	$topLeftContentDiv.html("暂无需要处理的待办任务!");
		    	    }
		            else
		            {
			            var datas = jsonData.datas;
			            var pendingTable = document.createElement("table");
			            var $pendingTable = jQuery(pendingTable);
			            $pendingTable.css({width:'100%'});
			            $topLeftContentDiv[0].appendChild(pendingTable);
			            var pendingTbody = document.createElement("tbody");
			            pendingTable.appendChild(pendingTbody);
			            var idx=0;
			            for(var i=0;i<datas.length;i++){
			               var pendingTr          =  document.createElement("tr");
				  		   var bgClass ="x-panel-table-data-row-";
				  		 	 if((i+1)%2==0)
				  		 	 {
				  		 		bgClass+="even";
				  		 	 }
				  		 	 else
				  		 	 {
				  		 		bgClass+="odd";
				  		 	 }
				  		 	pendingTr.className = bgClass;
		                    pendingTbody.appendChild(pendingTr);
	                       var data             = datas[i];
	                       var projectname      = data["projectname"]||"";
	                       var workflowname     = data["workflowname"];
	                       var taskname         = data["taskname"];
	                       var taskstart        = data["taskstart"];
	                       var tasktype         = data["tasktype"];
	                       var taskid           = data["taskid"];
	                       var actorid          = data["actorid"];
	                       var taskTypeChineseName = getTaskTypeChineseName(tasktype);
	                       var content          = "[ "+taskTypeChineseName+" ( "+taskstart+" ) "+"]&nbsp;";
	                       content+=workflowname+" -> "+taskname+" -> "+projectname ;
	                       if (data["sourcetype"] =="退回")
	                       {
	                    	   var    tempHtml = '<a   href="javascript:void(0);"  style="color:red"  onclick="toProcessForm('+taskid+',\''+actorid+'\',\''+tasktype+'\')">'+content+'-@^_^@被退回</a>';
	                       }
	                       else
	                    	{
	                   	          tempHtml = '<a href="javascript:void(0);"    onclick="toProcessForm('+taskid+',\''+actorid+'\',\''+tasktype+'\')">'+content+'</a>';
	                    	 }
	                   	   var pendingTd          =  document.createElement("td");
	                   	   pendingTd.innerHTML    = tempHtml;
	                   	   pendingTr.appendChild(pendingTd);
		                 }
		            }
    	            pendingLoaded   = true;
    	            if(noticeLoaded && quickMenuLoaded){
    	            	hideLoadMask();
    	            }
		        },
		        failure:function(response){ },
		        params:{
		        	xmlFileName:'/jbpm/queryPendingTasks.xml',
		      		USERID:"${sessionScope['login_userid']}",
		      		NOTPROCESSINSTANCESTATE:'Draft',
		      		queryText:jQuery("#id_queryPendingsTableInput").val(),
		      		PENDING:true
			    }
		     });
            }
	        function toProcessForm(currentTaskId,planActorId,tasktype)
	        {
	        	var url = "${pageContext.request.contextPath}/jbpm/requestProcessTaskForm.action?currentTaskId="+currentTaskId+"&jbpmWorkflowHistoryInfoUserId="+planActorId+"&currentRequestTaskType="+tasktype;
	        	openFullScreenWindow(url);
	        }
	    var newsNoticeContentPrefix = "id_newsNoticeContent_";
	    function loadNoticeInfo(){
	    	noticeLoaded = false;
	    	showLoadMask();
	        //公告通知
		      ajaxRequest({
		        url:"${pageContext.request.contextPath}/table/getTableData.action",
		        async:true,
		        success:function(response)
		        {    
		        	var rt = (response.responseText);
		        	var jsonData = JsonUtil.decode(rt);
		        	var $topMiddleContentDiv = jQuery("#id_top_middle_content_div");
		            if((typeof(jsonData.norecord)!='undefined')&&(jsonData.norecord=='true'))
		    	    {
		            	$topMiddleContentDiv.html("暂未发布新公告!");
		    	    }
		            else
		            {
			            var datas = jsonData.datas;
			            var noticeTable = document.createElement("table");
			            var $noticeTable = jQuery(noticeTable);
			            $noticeTable.css({width:'100%'});
			            $topMiddleContentDiv[0].appendChild(noticeTable);
			            var noticeTbody = document.createElement("tbody");
			            noticeTable.appendChild(noticeTbody);
			            for(var i=0;i<datas.length;i++){
			               var noticeTr          =  document.createElement("tr");
				  		   var bgClass ="x-panel-table-data-row-";
				  		 	 if((i+1)%2==0)
				  		 	 {
				  		 		bgClass+="even";
				  		 	 }
				  		 	 else
				  		 	 {
				  		 		bgClass+="odd";
				  		 	 }
				  		   noticeTr.className = bgClass;
		                   noticeTbody.appendChild(noticeTr);
	                       var data        = datas[i];
	                       var title       = data["title"]||"";
	                       var content     = data["content"];
	                       var publishDate = data["publishdate"];
	                       var noticeTitleTd          =  document.createElement("td");
	                       /*content = content.replace(/(\r|\n)/gim,"");
	                       content = content.replace(/\"/gim,'&quot;');
	                       content = content.replace(/\'/gim,"&acute");*/
	                       var tempHtml    = "<a title='查看详细内容' href='javascript:void(0);' onclick=\"preview("+i+")\">"+title+"</a>";
						   if( currentDate == publishDate.substring(0,10))
						   {
							   tempHtml+="&nbsp;<span class='newsNotice'></span>";
						   }
	                       noticeTitleTd.innerHTML    = tempHtml;
	                       var newsNoticeContent= document.createElement("div");
	                       with(newsNoticeContent){
	                    	   id=newsNoticeContentPrefix+i;
	                    	   innerHTML = content;
	                    	   style.display="none";
	                       }
	                       noticeTitleTd.appendChild(newsNoticeContent);
	                       noticeTr.appendChild(noticeTitleTd);
	                       var noticePublishDateTd          =  document.createElement("td");
	                       noticePublishDateTd.style.textAlign="right";
	                       noticePublishDateTd.innerHTML    = publishDate;
	                       noticeTr.appendChild(noticePublishDateTd);
					    }
		            }
    	            noticeLoaded    = true;
    	            if(pendingLoaded && quickMenuLoaded){
    	            	hideLoadMask();
    	            }
		        },
		        failure:function(response){ },
		        params:{
		        	xmlFileName:'/acl/queryAllNotice.xml',
		        	deadline:true
			    }
		     });
	    }
        function preview(rowIndex){
           var content = jQuery("#"+newsNoticeContentPrefix+rowIndex).html();
     	   var $previewDetailInfoWindowContainer = jQuery("#id_previewDetailInfoWindowContainer");
     	   $previewDetailInfoWindowContainer.show();
     	   var $previewDetailInfo = jQuery("#id_previewDetailInfo");
     	   $previewDetailInfo.html(content);
     	   addNoticeAttachmentDownloadFunction();
     	   $previewDetailInfoWindowContainer.window({top:20,draggable:false});
     	   $previewDetailInfoWindowContainer.window('open');
        }
        //快捷操作
        function recursionFindFirstLevelIndex(menuJson,newDataArr,compareDataArr){
            var children = menuJson.children;
            var childrenLen = children.length;
            if(0 < childrenLen){
                for(var i=0;i<childrenLen;i++){
                	recursionFindFirstLevelIndex(children[i],newDataArr,compareDataArr);
                }
            }else{
                var checked = menuJson.checked;
                var currentId = menuJson.id;
                if("true" == (checked+"")){
                    for(var ii=0;ii<compareDataArr.length;ii++){
                        var compareData = compareDataArr[ii];
                        var compareId   = compareData.id_;
                        if(currentId == compareId){
                            var newObj = {
                                    id_  :compareData.id_,
                                    name_:compareData.name_,
                                    icon_:compareData.icon_,
                                    firstLevelMenuId:menuJson.firstLevelMenuId
                            };
                            newDataArr.push(newObj);
                            break;
                        }
                    }
                }
            }
        }
       function loadQuickMenuInfo(){
    	   quickMenuLoaded = false;
	    	showLoadMask();
	    	
             ajaxRequest({
            	url:"${pageContext.request.contextPath}/table/getTableData.action",
       	        async:true,
       	        success:function(response){
    	        	var rt = (response.responseText);
    	        	if(!rt)$topRightContentDiv.html("您的用户信息发生变动，请联系管理员同步用户权限!");
    	        	var jsonData = JsonUtil.decode(rt);
    	        	var $topRightContentDiv = jQuery("#id_top_right_content_div");
    	            if((typeof(jsonData.norecord)!='undefined')&&(jsonData.norecord=='true'))
    	    	    {
    	            	$topRightContentDiv.html("暂未定义快捷操作!");
    	    	    }
    	            else
    	            {
    	            	var compareDataArr = jsonData.datas;
    	            	var newDataArr          = [];
    		            ajaxRequest({
    		            	url:'${pageContext.request.contextPath}/acl/getUserQuickMenuTreeData.acl',
                            success:function(res){
                                  var jsonChildren = JsonUtil.decode(res.responseText);
                                  for(var k = 0;k < jsonChildren.length;k++){
                                        recursionFindFirstLevelIndex(jsonChildren[k],newDataArr,compareDataArr);
                                  }
		    		          	  for(var i=0;i<newDataArr.length;i++)
			    		          {
		    	    	               	 var data             = newDataArr[i];
		    	    	               	 var menuId		      = data["id_"];
		    	    	               	 var text             = data["name_"];
		    	    	               	 var icon 		      = data["icon_"];
		    	    	               	 var firstLevelMenuId = data["firstLevelMenuId"];
		    	    	               	 
		    	    	               	 var $divContainer = $("<div></div>");
		    	    	       	         $topRightContentDiv.append($divContainer);
		    	    	       	         $divContainer.css("border-bottom","1px solid #DDD");
		    	    	       	         $divContainer.css("cursor","pointer");
		    	    	       	         $divContainer.css("padding","2px");
		    	    	       	         $divContainer.css("textIndent","10px");
		    	    	       	         $divContainer.css("marginBottom","5px");
		    	    	       	         $divContainer.css("background","#D4E1F2");
		    	    	       	         $divContainer.css("line-height","26px");
		    	    	       		     var clickFunc = (function(firstLevelMenuId,menuId){return function(e){
		    	    	       		        	window.top.doCheckTreeByMenuId(firstLevelMenuId,menuId);
		    	    	       			     };})(firstLevelMenuId,menuId);
		    	    	       		     $divContainer.click(clickFunc);
		    	    	       	         var $img = $("<img src='${pageContext.request.contextPath}/menuIcons/"+icon+"'/>");
		    	    	       	         $img.css("verticalAlign","middle");
		    	    	       	         $divContainer.append($img);
		    	    	       	         $divContainer.append("<font>&nbsp;</font>");
		    	    	       	         var $text = $("<a name='"+menuId+"'>"+text+"</a>");
		    	    	       	         $divContainer.append($text);
		    	    	         }
                            }
    			        });
        	        }
    	            quickMenuLoaded = true;
    	            if(pendingLoaded && noticeLoaded){
    	            	hideLoadMask();
    	            }
           	    },
       	        params:{
           	        userId:"${sessionScope['login_userid']}",
           	        xmlFileName:'acl/queryUserQuickMenu.xml'
           	    }
             });
       }
        /*
        //个人消息通知
        jQuery(function(){
        	 var $bottomLeftContentDiv = jQuery("#id_bottom_left_content_div");
        	 $bottomLeftContentDiv.css({
                 lineHeight:bottomHeight+"px",
                 textAlign:"center"
             });
        	 $bottomLeftContentDiv.html("暂无个人消息通知!");
        });
        //图表信息
        jQuery(function(){
              new tracywindyChart({
                    width: bottomRightWidth+10,
                    height:bottomHeight+10,
                    //title:'图表标题',
                    border:false,
                    renderTo:"id_bottom_right_content_div",
                    id:'id_chartTest',
                    swf:'MSCombiDY2D.swf',
                    xmlFileName:'template.xml'
              });
        });*/
        jQuery(function(){
        	loadPendingInfo();
        	loadNoticeInfo();
        	loadQuickMenuInfo();
	       	 document.getElementById("id_queryPendingsTableInput").onkeypress = function(evt){
	    		 var e  = getEvent(evt);
	    	     var code = e.keyCode||e.charCode;
	    	     if(13 == code){
	    	    	 loadPendingInfo();
	    	     }
	    	 };
        });
    </script>
</head>
<body>
	<div id='id_top_left' style="float:left;overflow:hidden;border:0px solid #DDD;padding:5px;">
	   <div class="panel-title">待办事宜
	     <SPAN>搜索：<INPUT style="BORDER-BOTTOM: #ddd 1px solid; BORDER-LEFT: #ddd 1px solid; WIDTH: 150px; BORDER-TOP: #ddd 1px solid; MARGIN-RIGHT: 4px; BORDER-RIGHT: #ddd 1px solid" id=id_queryPendingsTableInput type="text" jQuery18205254865307538132="34"></SPAN>
	   </div>
       <div id="id_top_left_content_div" style="border:1px solid #DDD;border-top:0px;overflow:auto;padding:5px;" ></div>
	</div>
	<div id='id_top_middle' style="overflow:hidden;float:left;border-bottom:0px solid #DDD;padding:5px;">
	   <div class="panel-title" ><font color="red" class="flagUserSelectContainer"></font>公告通知</div>
	   <div id='id_top_middle_content_div' style="border:1px solid #DDD;border-top:0px;overflow:auto;padding:5px;"></div>
	</div>
	<div id='id_top_right' style="overflow:hidden;float:left;border:0px solid #DDD;border-left:0px;border-top:0px;padding:5px;">
	   <div class="panel-title" ><font color="red" class="flagUserSelectContainer"></font>快捷操作</div>
	   <div id='id_top_right_content_div' style="border:1px solid #DDD;border-top:0px;overflow:auto;padding:5px;"></div>
	</div>
	<!-- 
	<div id='id_bottom_left' style="overflow:hidden;float:left;border:0px solid #DDD;border-left:0px;border-top:0px;padding:5px;">
	   <div class="panel-title" ><font color="red" class="flagUserSelectContainer"></font>个人消息通知</div>
	   <div id='id_bottom_left_content_div' style="border:1px solid #DDD;border-top:0px;overflow:auto;padding:5px;"></div>
	</div>
	<div id='id_bottom_right' style="overflow:hidden;float:left;border:0px solid #DDD;border-left:0px;border-top:0px;padding:5px;">
	   <div class="panel-title" ><font color="red" class="flagUserSelectContainer"></font>图表信息</div>
	   <div id='id_bottom_right_content_div' style="border:1px solid #DDD;border-top:0px;overflow:hidden;padding:0px;"></div>
	</div>
	-->
	<script type='text/javascript'>
		var pageWidth  = document.documentElement.clientWidth;
		var pageHeight = document.documentElement.clientHeight-10;
        var topLeftWidth   = 600;
        var topMiddleWidth = (pageWidth - topLeftWidth - 66 )/1.5; 
        var topRightWidth  = (pageWidth - topLeftWidth - 66 ) - topMiddleWidth; 
        
	    var topHeight     =  pageHeight-40;//pageHeight/2;
	    var bottomHeight  =  pageHeight - topHeight - 100;

        var bottomLeftWidth  = topLeftWidth  ;
        var bottomRightWidth = pageWidth - bottomLeftWidth - 45 ;
	    
		jQuery("#id_top_left_content_div").css("height",topHeight+"px");
		jQuery("#id_top_middle_content_div").css("height",topHeight+"px");
		jQuery("#id_top_right_content_div").css("height",topHeight+"px");
		
		jQuery("#id_top_left_content_div").css("width",topLeftWidth+"px");
		jQuery("#id_top_left>div.panel-title").css("width",(topLeftWidth+10)+"px");
		jQuery("#id_top_middle_content_div").css("width",topMiddleWidth+"px");
		jQuery("#id_top_middle>div.panel-title").css("width",(topMiddleWidth+10)+"px");
		jQuery("#id_top_right_content_div").css("width",topRightWidth+"px");
		jQuery("#id_top_right>div.panel-title").css("width",(topRightWidth+10)+"px");
		jQuery("#id_bottom_left_content_div").css("height",bottomHeight+"px");
		jQuery("#id_bottom_right_content_div").css("height",bottomHeight+"px");
		
		jQuery("#id_bottom_left_content_div").css("width",bottomLeftWidth+"px");
		jQuery("#id_bottom_left>div.panel-title").css("width",(bottomLeftWidth+10)+"px");
		jQuery("#id_bottom_right_content_div").css("width",bottomRightWidth+"px");
		jQuery("#id_bottom_right>div.panel-title").css("width",(bottomRightWidth+10)+"px");
		
	</script>
	
	<div id="id_previewDetailInfoWindowContainer"  closable="true" closed="true" modal="true" title="公告内容" style="display:none;">
	     <div id="id_previewDetailInfo" style="text-align:left;padding:5px"></div>
	</div>
	<form method="post" target="fileDownloadIframe" action="${pageContext.request.contextPath}/acl/downloadNoticeUploadFile.acl" id="id_nameForm">
	  <input name="type" type="hidden" value="file" />
	  <input name="uuid"  type="hidden" value=""/>
	</form>
	<iframe name="fileDownloadIframe" style="display:none;"></iframe>
	<script type="text/javascript">
	   	jQuery("#id_previewDetailInfoWindowContainer").css("height",(pageHeight-40)+"px");
	   	jQuery("#id_previewDetailInfoWindowContainer").css("width",(pageWidth-20)+"px");
	    function addNoticeAttachmentDownloadFunction()
	    {
	 	   jQuery("#id_previewDetailInfo a.tracywindyFileDownLoadSpan").each(function(i){
	 		   this.style.cursor = "pointer";
	 		   this.title = "点击下载文件";
	 		   this.style.color = "blue";
	 		   this.href="javascript:void(0)";
	 		   this.style.fontWeight = "BOLD";
	 		   var oldClassStr = (this.className||"").replace(/\s{1,}/gm," ");
	 		   var oldClassArr = oldClassStr.split(" ");
	 		   for(var i=0;i<oldClassArr.length;i++){
	 			   var className = oldClassArr[i]||"";
	 			   if(0 == className.indexOf("uuid-")){
	 				   var uuid = className.substring("uuid-".length,className.length);
	 				   var clickFunc = (function(uuid){
	 					   return function(e){
	 						   jQuery("#id_nameForm input[name='uuid']").val(uuid);
	 						   jQuery("#id_nameForm")[0].submit();
	 						   return false;
	 					   };
	 				   })(uuid);
	 				   this.onclick = clickFunc;
	 			   }
	 		   }
	 	   });
	   }
	</script>
	
</body>
</html>