<%@ page contentType="text/html; charset=utf-8" %>
<html>
	<body>
		<script>	
			window.parent.alert("<%=request.getAttribute("msg").toString()%>");
		</script>
	</body>
</html>
