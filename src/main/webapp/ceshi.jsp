<%@page contentType="text/html; charset=utf-8"%>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/manager?type=newDish" method="post" enctype="multipart/form-data">
    菜品名：<input type="text" name="dishName"><br/>
    菜系：<input type="text" name="dishClass"><br/>
    菜价：<input type="text" name="dishPrice"><br/>
    菜品详细信息：<input type="text" name="dishInfo"><br/>
    文件：<input type="file" name="file"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>