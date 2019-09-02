<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="layui/layui.all.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>


<form class="layui-form" lay-filter="myform" action="Customer">
<c:if test="${param.id==null}">
<input type="hidden" name="_method" value="post">
</c:if>
<c:if test="${param.id!=null}">
<input type="hidden" name="_method" value="put">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">编号</label>
    <div class="layui-input-block">
      <input type="text" name="cus_no"  autocomplete="off" placeholder="请输入编号" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="cus_name"  autocomplete="off" placeholder="请输入姓名" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <select name="cus_sex" >
      </select>
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">商品</label>
    <div class="layui-input-block">
      <select name="pro_id" >
      </select>
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">
layui.use(['form',], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
		 $.post($("form").attr("action"), data.field, function(json) {
			  closeFrame();
			  parent.fresh('demo');
			}, "json");
		    
		    return false;
		  });
});



var id="${param.id}";
function init(){
	$.post("Customer/"+id,{_method:'get'}, function(json) {
		render('myform', json);
		getarray("Customer/getCus_sex",{_method:'get'},"[name=cus_sex]",json.cus_sex);
		getlist("Customer/getProduct",{_method:'get'},"[name=pro_id]",json.pro_id);
	},"json");
}
if(id!=null&&id.length>0){
	init();
}else{
	getarray("Customer/getCus_sex",{_method:'get'},"[name=cus_sex]",-1);
	getlist("Customer/getProduct",{_method:'get'},"[name=pro_id]",0);
}

</script>
</body>
</html>