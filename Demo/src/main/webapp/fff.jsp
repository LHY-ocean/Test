<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
<script src="../js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
function openfile(){
	$("[name=filename]")[0].click();
}
function upload(){
	var formData = new FormData();
    formData.append("filename",$("[name=filename]")[0].files[0]);
    $.ajax({
        url:'aaa.action',
        type:'post',
        data: formData,
        contentType: false,
        processData: false,
        success:function(res){
           $(".upimg").attr("src",res);
        }
    });
}
</script>
</head>
<body>

<button onclick="openfile();">
测试
</button>
<button onclick="upload();">
上传
</button>
<div>
<img class="upimg" src="">
</div>

<form action="aaa.action" method="post" enctype="multipart/form-data" style="display:none;">
	<input type="file" name="filename">
</form>

</body>
</html>