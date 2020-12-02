<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            loader();
        })
        function loader() {$.ajax({
            url:"find.do",
            type:"get",
            dataType:"json",
            success:function (date) {
                $.each(date,function (i,n) {
                    $("#tbody").append("<tr>")
                        .append("<td>"+n.id+"</td>")
                        .append("<td>"+n.name+"</td>")
                        .append("<td>"+n.age+"</td>")
                        .append("<td>"+n.email+"</td>")
                        .append("<tr>").append("</form>")
                })
            }
        })

        }
    </script>
</head>
<body>
<div align="center">
        <table>
            <thead>
            <tr>
                <td>
                    ID
                </td>
                <td>
                    姓名
                </td>
                <td>
                    年龄
                </td>
                <td>
                    邮箱
                </td>
            </tr>
            <form action='alter.do' method='get'>
            <tbody id="tbody">
            </tbody>
        </table>

</div>
</body>
</html>
