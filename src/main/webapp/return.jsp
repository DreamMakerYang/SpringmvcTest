<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>return</title>

    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"return/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"id":1,"username":"小明","password":123456}', dataType:"json", type:"post",
                    success:function(data){
                        alert(data);
                        alert(data.username);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="/return/testReturnString">测试testReturnString</a><br>

    <a href="/return/testReturnVoid">测试testReturnVoid</a><br>

    <a href="/return/testReturnModelAndView">测试testReturnModelAndView</a><br>

    <a href="/return/testForward">测试testForward</a><br>

    <a href="/return/testRedirect">测试testRedirect</a><br>

    <button id="btn" >发送ajax请求</button><br>

    <form action="/return/fileUpload" method="post" enctype="multipart/form-data">
        上传一张图片： <input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>

    <a href="/return/testException">页面出错</a><br>

    <a href="/return/testInterceptor">测试拦截器</a><br>

</body>
</html>
