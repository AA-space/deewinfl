<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAttachmentFileUpload.js"></script>
<script type="text/javascript">
var pageWidth  = document.documentElement.clientWidth-2;
var pageHeight = document.documentElement.clientHeight-2;
var proj_id="${requestScope['proj_info.projid']}";
var param={};
/*var readonly;
if("true"=='${isFirstTask}')
{
	readonly=false;
}else{
	readonly=true;
}*/
	jQuery(function(){
		tracywindyAttachmentFileUpload({
			isReadOnly:isAttachment,
            renderTo:'id_tableContainer',
            module:'projCreditCustCompanyAttchmentFiles',
            attachmentType:'proj_credit_cust_company',
            identifierOne:proj_id,
            width:(parseInt("${param.tableWidth}")||pageWidth)-1,
            height:parseInt("${param.tableHeight}")||pageHeight,
            //isReadOnly:window.isCompletedTask||window.assignAttachmentIsReadOnly||false,
            border:true
		});
   });

</script>
</html>