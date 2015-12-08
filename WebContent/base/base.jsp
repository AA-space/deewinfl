<%@include  file="var.jsp"%>
<script src="${pageContext.request.contextPath}/js/seajs/sea.js?${currentTimestamp}" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js?${currentTimestamp}" type="text/javascript"></script>
<script type="text/javascript">seajs.config({vars: { currentLocale: '${currentLocale}',currentSkin:'${currentSkin}'},base: '${pageContext.request.contextPath}/',map: [[ /^(.*\.(?:css|js))(.*)$/i, '$1?${currentTimestamp}' ]],charset: 'UTF-8'});</script>
<link rel=stylesheet href="${pageContext.request.contextPath}/css/base/${currentSkin}/base.css?${currentTimestamp}"/>