<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/commonjsps/head.jsp" %>
	<title>Better MSL</title>
</head>
<body>

	<!-- The div for the login form dialog -->
	<%@ include file="/WEB-INF/commonjsps/loginform.jsp" %>

    <div id="logoDiv">
        <img src="/resources/images/logo.png"/>
    </div>

    <%@ include file="/WEB-INF/commonjsps/menubar.jsp" %>

	<br/>

<script type="text/javascript">
	$(document).ready
	(
		function() 
		{
			setupMenuItemsMouseEventsHandlers();
		}
	);

</script>
</body>
</html>
