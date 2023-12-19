<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "测试界面" %>
</h1>
<br/>

<p><a href="${pageContext.request.contextPath}/login.do">login</a></p>

</body>
</html>