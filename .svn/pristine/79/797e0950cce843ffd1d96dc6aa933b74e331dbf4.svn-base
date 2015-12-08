<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 

<div id="id_nextRouteChoseWindow" buttons="#id_nextWindowDialogButtons" closed="true" modal="true" title="提交下一步详情" style="display:none;width:600px;padding-top:10px;padding:0px;">
	<center>
		<c:if test="${0 == fn:length(next_activityTaskUsersList)}">
		   <script type="text/javascript">
		    isShowSubmitChosePersonWindow = false;
		   </script>
		</c:if>
		<script type="text/javascript">
			nextChosePersonArr = [];
			var requestNextRoute = document.getElementById("id_requestInitiatorRoute");
			requestNextRoute.value = "${dynamicRequestInitiatorRoute}";
		</script>
		<div style="width:96%;text-align:left;">
			<table  width="100%">
			    <c:set var="pageSize" value="4"></c:set>
			    <tr style='height:20px;'><td></td></tr>
			    <c:forEach items="${next_activityTaskUsersList}" var="activityTaskUsers" varStatus="status">
			        <c:set var="routePath" value="${activityTaskUsers.routeInfo.currentTransition.name}"></c:set>
			        <c:set var="activityName" value="${activityTaskUsers.currentTaskUsers.activityDetail.activityName}"></c:set>
			        <c:set var="parentActivityName" value="${activityTaskUsers.routeInfo.parentActivityName}"></c:set>
			        <c:set var="len" value="${fn:length(activityTaskUsers.currentTaskUsers.dealUsers)}" ></c:set>
			        <c:set var="dealMethod" value="${activityTaskUsers.currentTaskUsers.activityDetail.dealMethod}" ></c:set>
			        <c:set var="dealMethodChineseName" value="${activityTaskUsers.currentTaskUsers.activityDetail.dealMethodChineseName}" ></c:set>
			        <c:set var="passedCount" value="${activityTaskUsers.currentTaskUsers.activityDetail.passedCount}" ></c:set>
			        <c:set var="checkType" value="checkbox"></c:set>
				     <c:if test="${'Single' eq dealMethod}">
				        <c:set var="checkType" value="radio"></c:set>
				     </c:if>
				     <script type="text/javascript">
				       nextChosePersonArr.push('next_chose_${routePath}_${activityName}');
				     </script>
				     <tr identity="next_chose_tr_${routePath}">
				         <td colspan=2>
				          <div> 
				            ${activityName}
				          </div>
				         </td>
				     </tr>
				     <c:if test="${0 == len}">
				       <tr identity="next_chose_tr_${routePath}">
				           <td colspan=2>
				              <input type="radio" style="position:relative;top:3px;" 
				              name="next_chose_${routePath}_${activityName}"  
				              login_name="NULL" routePath="${routePath}" 
				              node_name="${activityName}"
				              onclick="nextRejectChecked('next_chose_${routePath}_${parentActivityName}','actor');"
					          parent_node_name="${parentActivityName}"
					          parent_name     = "next_chose_${routePath}_${parentActivityName}" 
					          flag="actor"
					          dealMethod  =  "${dealMethod}"
					          passedCount = "${passedCount}"
					          routePath="${routePath}"
				              />
				              ${activityName}
				           </td>
				       </tr>  
				     </c:if>
				     <!--执行人开始 -->
				     <c:forEach items="${activityTaskUsers.currentTaskUsers.dealUsers}" var="dealUser" varStatus="userStatus">
				          <c:if test="${0 == userStatus.index}">
				            <tr identity="next_chose_tr_${routePath}"><td>
				             <fieldset style="margin-top:5px;padding-left:20px;border:1px solid #DDD;" >
				                <legend>
				                                           任务处理人【${dealMethodChineseName}<c:if test="${'NPassed' eq dealMethod}">,处理人数&nbsp;${passedCount}&nbsp;</c:if>】
				          	    <c:if test="${'Single' ne dealMethod}">
					              &nbsp;&nbsp;<input 
					              id="next_chose_${routePath}_${parentActivityName}_checkedAll_actor" 
					              style="position:relative;top:3px;" 
					              type="checkbox" 
					              checked
					              onclick="doCheckedAll(this.checked,'next_chose_${routePath}_${activityName}','next_chose_${routePath}_${parentActivityName}','actor');"/>
					              &nbsp;全选
					            </c:if></legend>
				                <table>
				                <tr identity="next_chose_tr_${routePath}" type="actor">
				          </c:if>
				              <td style="padding-left:10px;">
					              <input 
					                style="position:relative;top:3px;" 
					                type="${checkType}" name="next_chose_${routePath}_${activityName}"  
					                node_name="${activityName}" real_name="${dealUser.realname}" 
					                delegate_real_name="" login_name="${dealUser.username}" routePath="${routePath}"
					                onclick="nextRejectChecked('next_chose_${routePath}_${parentActivityName}','actor');"
					                parent_node_name="${parentActivityName}"
					                parent_name     = "next_chose_${routePath}_${parentActivityName}" 
					                flag="actor"
					                dealMethod  =  "${dealMethod}"
					                passedCount = "${passedCount}"
					                routePath="${routePath}"
					              />
					              ${dealUser.realname}
				             </td>
				          <c:choose>
							<c:when test="${((len-1) != userStatus.index) && (0 == ((userStatus.index+1) mod 2))}">
								</tr>
						    	<tr identity="next_chose_tr_${routePath}">
						    </c:when>
							<c:otherwise>
								<c:if test="${(len-1) == userStatus.index}">
										</tr>
									</table>
				                  </fieldset>
				                  </td></tr>
								</c:if>
							</c:otherwise>
							</c:choose>
				     </c:forEach>
				    <!-- 会签人开始 -->
				    <c:set var="len" value="${fn:length(activityTaskUsers.currentTaskUsers.signatureUsers)}" ></c:set>
				    <c:forEach items="${activityTaskUsers.currentTaskUsers.signatureUsers}" var="dealUser" varStatus="userStatus">
					          <c:if test="${0 == userStatus.index}">
					            <tr identity="next_chose_tr_${routePath}"><td>
					             <fieldset style="margin-top:5px;padding-left:20px;border:1px solid #DDD;">
					                <legend>会签对象	
					                  <input 
						              id="next_chose_${routePath}_${parentActivityName}_checkedAll_signature" 
						              style="position:relative;top:3px;" 
						              type="checkbox" 
						              onclick="doCheckedAll(this.checked,'next_chose_${routePath}_${activityName}','next_chose_${routePath}_${parentActivityName}','signature');"/>
						                                    全选 
					                </legend>
					                <table>
					            <tr identity="next_chose_tr_${routePath}">
					          </c:if>
					              <td style="padding-left:10px;">
						              <input 
						                style="position:relative;top:3px;" 
						                type="checkbox" name="next_chose_${routePath}_${activityName}"  
						                node_name="${activityName}" real_name="${dealUser.realname}" 
						                delegate_real_name="" login_name="${dealUser.username}" routePath="${routePath}"
						                onclick="nextRejectChecked('next_chose_${routePath}_${parentActivityName}','signature');"
						                flag="signature"
						                parent_node_name="${parentActivityName}"
					          			parent_name     = "next_chose_${routePath}_${parentActivityName}" 
					          			routePath="${routePath}"
						              />
						              ${dealUser.realname}
					             </td>
					          <c:choose>
								<c:when test="${((len-1) != userStatus.index) && (0 == ((userStatus.index+1) mod 2))}">
									</tr>
							    	<tr identity="next_chose_tr_${routePath}">
							    </c:when>
								<c:otherwise>
									<c:if test="${(len-1) == userStatus.index}">
											</tr>
										</table>
					                  </fieldset>
					                  </td></tr>
									</c:if>
								</c:otherwise>
								</c:choose>
					</c:forEach>
				    <!-- 会签人结束 -->
				    <!-- 传阅人开始 -->
				     <c:set var="len" value="${fn:length(activityTaskUsers.currentTaskUsers.readDealUsers)}" ></c:set>
				     <c:forEach items="${activityTaskUsers.currentTaskUsers.readDealUsers}" var="dealUser" varStatus="userStatus">
					          <c:if test="${0 == userStatus.index}">
					            <tr identity="next_chose_tr_${routePath}"><td>
					             <fieldset style="margin-top:5px;padding-left:20px;border:1px solid #DDD;">
					                <legend>传阅对象	
					                  <input 
						              id="next_chose_${routePath}_${parentActivityName}_checkedAll_read" 
						              style="position:relative;top:3px;" 
						              type="checkbox" 
						              onclick="doCheckedAll(this.checked,'next_chose_${routePath}_${activityName}','next_chose_${routePath}_${parentActivityName}','read');"/>
						                                    全选 
						            </legend>
					                <table>
					            <tr identity="next_chose_tr_${routePath}">
					          </c:if>
					              <td style="padding-left:10px;">
						              <input 
						                style="position:relative;top:3px;" 
						                type="checkbox" name="next_chose_${routePath}_${activityName}"  
						                node_name="${activityName}" real_name="${dealUser.realname}" 
						                delegate_real_name="" login_name="${dealUser.username}" routePath="${routePath}"
						                onclick="nextRejectChecked('next_chose_${routePath}_${parentActivityName}','read');"
						                parent_node_name="${parentActivityName}"
					          			parent_name     = "next_chose_${routePath}_${parentActivityName}" 
						                flag="read"
						                routePath="${routePath}"
						              />
						              ${dealUser.realname}
					             </td>
					          <c:choose>
								<c:when test="${((len-1) != userStatus.index) && (0 == ((userStatus.index+1) mod 2))}">
									</tr>
							    	<tr identity="next_chose_tr_${routePath}">
							    </c:when>
								<c:otherwise>
									<c:if test="${(len-1) == userStatus.index}">
											</tr>
										</table>
					                  </fieldset>
					                  </td></tr>
									</c:if>
								</c:otherwise>
								</c:choose>
					</c:forEach>
				    <!-- 传阅人结束 -->
			    </c:forEach>
			    <!-- 执行人结束 -->
			    <!--
			    <tr>
			    	<td  bgcolor=#d9d9d9 colspan="2">
			    	<div id="workflow_message" >
			    	<fieldset>
	 					   <legend>【信息】</legend>
			    			<div title="发送短信" >
				    			<table  width="98%">
				    				<tr>
				    					<td  colspan="4">是否发送短信：<input id="isSendMsgFlag" type="checkbox" > 是否发送站内信：<input id="isSendStationMsgFlag" type="checkbox" ></td>
				    				</tr>
				    				<tr>
				    					<td style="width: 100px;">短息内容：</td>
				    					<td colspan="3">
				    						<textarea id="sendMsgContent" rows="2" cols="50"></textarea>
				    					</td>
				    				</tr>
				    			</table>
			    			</div>
		                   <div title="发送站内信" >
				    			<table  width="100%">
				    				<tr>
				    					<td  style="width: 100px;">是否发送站内信：</td>
				    					<td><input id="isSendStationMsgFlag" type="checkbox" ></td>
				    				</tr>
				    				<tr>
				    					<td style="width: 100px;">站内信内容：</td>
				    					<td ><textarea id="sendStationMsgContent" rows="2" cols="50"></textarea></td>
				    				</tr>
				    			</table>
			    			</div> 
			    			</fieldset>
			    		</div>
			    	</td>
			    </tr>
			    -->
			</table>
		</div>
	</center>
</div>
<div id="id_nextWindowDialogButtons" style='text-align:center;height:40px;line-height:40px;display:none'>
	<div style="width:600px;text-align:center;">
			<input class="btn btn-primary" type="button" value="确定" onclick='doChoseRouteOper("next");' style="cursor:pointer;width:60px;"/>
			<input class="btn btn-primary" type="button" value="取消" onclick='jQuery("#id_nextRouteChoseWindow").window("close");' style="cursor:pointer;margin-left:20px;width:60px;"/>
	</div>
</div>
<!-- 弹出提交列表结束 -->