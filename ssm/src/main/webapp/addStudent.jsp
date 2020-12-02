<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
        <form action="add.do" method="post">
            <table>
                <tr>
                    <td>
                        姓名
                    </td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>
                        年龄
                    </td>
                    <td>
                        <input type="text" name="age">
                    </td>
                </tr>
                <td>
                    邮箱
                </td>
                <td>
                    <input type="text" name="email">
                </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="点击注册">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
