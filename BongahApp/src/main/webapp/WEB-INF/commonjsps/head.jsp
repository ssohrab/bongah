<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="<c:url value="/resources/styles/general.css" />">
<link rel="stylesheet" href="<c:url value="/resources/styles/smoothness/jquery-ui-1.10.4.custom.min.css" />">

<script src="<c:url value="/resources/js/generalJS.js" />"></script>
<script src="<c:url value="/resources/js/jquery-2.1.0.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui-1.10.2.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui-1.10.4.custom.min.js" />"></script>

<c:set var="serverPath" value="http://localhost:8080"></c:set>
<c:set var="secureServerPath" value="https://localhost:8443/secure"></c:set>

<script type="text/javascript">
	var sessionId = "failed";
</script>
