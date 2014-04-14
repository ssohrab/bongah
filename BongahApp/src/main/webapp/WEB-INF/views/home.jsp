<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/commonjsps/head.jsp" %>
	<title>Better MSL</title>
</head>
<body>
	<!-- The div for the login form dialog -->
	<%@ include file="/WEB-INF/commonjsps/loginform.jsp" %>
	
	<div style="background-color: #009933;">
		<%@ include file="/WEB-INF/commonjsps/menubar.jsp" %>
	</div>

	<%@ include file="/WEB-INF/commonjsps/leftad.jsp" %>
	<%@ include file="/WEB-INF/commonjsps/rightad.jsp" %>

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
