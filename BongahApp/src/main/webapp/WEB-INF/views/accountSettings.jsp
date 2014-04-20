<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/commonjsps/head.jsp" %>
	<title>Better MSL</title>
</head>
<body>

<p>Result is: <span id="result"></span></p>

<script type="text/javascript">

$(document).ready
(
	function() 
	{
		var dataToSend = "sessionId=" + sessionId;
		var theURL = "${secureServerPath}/getAccountSettingsData";
	
		$.ajax({
			url: theURL,
			type: "GET",
			data: dataToSend,
			cache: false,
			contentType: "text/plain",
			dataType: "text",
			success: function(data, textStatus, jqXHR)
			{
				$("#result").html(data);
			},
			error: function(jqXHR, textStatus, errorThrown)
			{
				alert(jqXHR.status);
			}
		});
	}
);

</script>

</body>

</html>