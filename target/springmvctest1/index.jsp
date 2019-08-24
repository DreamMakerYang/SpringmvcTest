<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门案例</h3>

    <a href="/springmvc/hello?money=1000">跳转成功页面</a>

    <br>

    <form action="/springmvc/user" method="post">
        用户名：<input name="username" type="text"><br>
        密码：<input name="password" type="text"><br>
        <input type="submit" value="提交">
    </form>

    <br>

    <form action="/springmvc/user" method="post">
        用户名：<input name="username" type="text"><br>
        密码：<input name="password" type="text"><br>
        List账户：<input name="list[0].accountName" type="text"><br>
        List金额：<input name="list[0].money" type="text"><br>
        Map帐号：<input name="map['one'].accountName" type="text"><br>
        Map金额：<input name="map['one'].money" type="text"><br>1
        <input type="submit" value="提交">
    </form>

    <br>

    <a href="/springmvc/testRequestParam?username=lois">测试RequestParam</a>

    <br>

    <form action="/springmvc/testRequestBody" method="post">
        用户名：<input name="username" type="text"><br>
        密码：<input name="password" type="text"><br>
        <input type="submit" value="提交">
    </form>

    <br>

    <a href="/springmvc/testPathVariable/1000">测试PathVariable</a>

    <br>

    <a href="/springmvc/testRequestHeader">测试RequestHeader</a>

    <br>

    <a href="/springmvc/testCookieValue">测试CookieValue</a>

    <br>

    <form action="/springmvc/testModelAttribute" method="post">
        用户名：<input name="username" type="text"><br>
        密码：<input name="password" type="text"><br>
        <input type="submit" value="提交">
    </form>

    <a href="/springmvc/testSessionAttributesPut">测试SessionAttributes存储数据</a>

    <br>
    <a href="/springmvc/testSessionAttributesGet">测试SessionAttributes获得数据</a>

    <br>
    <a href="/springmvc/testSessionAttributesDel">测试SessionAttributes清除数据</a>

    <br>
</body>
</html>
