<%--
  Created by IntelliJ IDEA.
  User: 娃哈哈
  Date: 2017/10/27
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/static/jquery-3.1.1.min.js"></script>
<html>
<head>
    <title>Demo-two</title>
</head>
<body>

<center style="text-align: center;color: red">
    <p>OSS图片上传</p>
</center>

<div style="margin: auto;text-align: center">
    <form action="${pageContext.request.contextPath}/user/upload/img" method="post" enctype="multipart/form-data">
        图片1:<input type="file" name="file1">
        图片2:<input type="file" name="file2">
        <input type="submit" value="上传">
    </form>
    <p class="subTitle" style="margin:auto;width: 58px;height: 24px;background-color: aqua">提交</p>
</div>

</body>

<script type="text/javascript">
    $(".subTitle").click(function(){

        var obj = document.getElementById("fileInput");

        console.log(obj);
        return

        var files = [];

        for(var i = 0;i < obj.length;i++){
            files.push(obj[i]);
        }

        var data = new FormData($("#subid")[0]);
        for(var i = 0;i<obj.length;i++){
            data.append("file"+(i+1),files[i]);
        }

        $.ajax({
            url:"${pageContext.request.contextPath}/user/upload/img",
            type:"post",
            data:data,
            processDate:false,
            contentType:false,
            success:function (datasucc) {
                console.log("提示信息为："+datasucc);
            },error:function (dataerror) {
                alert("失败");
            }

        })

    })
</script>
</html>
