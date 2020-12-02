<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="/updateBook" method="post">
    书名：西游记：<br/>
    作者：<input type="text" name="author"/><br/>
    价格：<input type="text" name="price"/><br/>
    库存：<input type="text" name="stock"/><br/>
    销量：<input type="text" name="sales"/><br/>
    <input type="submit" value="修改">
</form>
</body>
</html>
