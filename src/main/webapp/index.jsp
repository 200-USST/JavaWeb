<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World 我修改了" %>
</h1>
<br/>

<p><a href="${pageContext.request.contextPath}/jsp/login.jsp">login.jsp</a></p>
<p><a href="${pageContext.request.contextPath}/jsp/user.jsp">user.jsp</a></p>
<p><a href="${pageContext.request.contextPath}/jsp/canteen-manager.jsp">canteen-manager.jsp</a></p>
<p><a href="${pageContext.request.contextPath}/jsp/system-manager.jsp">system-manager.jsp</a></p>
<p><a href="${pageContext.request.contextPath}/jsp/register.jsp">register.jsp</a></p>

</body>
</html>