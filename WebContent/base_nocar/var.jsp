<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld"%>
<c:set var="currentTimestamp" value="20140109000"></c:set>
<c:set var="currentLocale" value="zh_CN"></c:set>
<c:set var="currentSkin" value="bootstrap"></c:set>
<script type="text/javascript">
	var globalTimestamp = "${currentTimestamp}";
	var globalLocale = "${currentLocale}";
	var globalSkin = "${currentSkin}";
	var globalClientWidth = document.documentElement.clientWidth;
	var globalClientHeight = document.documentElement.clientHeight;
	var globalWebRoot = "${pageContext.request.contextPath}";
</script>