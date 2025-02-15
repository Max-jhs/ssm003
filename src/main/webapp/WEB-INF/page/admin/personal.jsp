<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
<style>
	  .item label{
		  display: inline-block;
		  width: 100px;
		  height: 30px;
		  text-align: center;
		  color: #fff;
		  line-height: 30px;
		  background-color: skyblue;
		  border-radius: 5px;
		  cursor: pointer;
	  }
	  .item input{
		  display: none;
	  }
</style>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil"></span> 个人信息完善</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/admin/upDatePerson.action" enctype="multipart/form-data">
	  <div class="form-group">
	    <div class="label">
			<br />
	      <label>头像：</label>
	    </div>
	    <div class="field">
	      <div class="item">
			  <br />
	          <label for="file1">上传图片</label>
	          <input type="file" id="file1" name="file2" onchange="xmTanUploadImg(this)">
			  <img id="img" style="position:absolute;left:110px;bottom: -25px; display: none; width: 90px;height: 90px;border-radius: 100%"
			   src="${user.img}" />
	      </div>
		  <script type="text/javascript">
			  //选择图片，马上预览
			  function xmTanUploadImg(obj) {
				  var file = obj.files[0];
				  var reader = new FileReader();
				  reader.onload = function(e) {
					  var img = document.getElementById("img");
					  img.src = e.target.result;
				  }
				  reader.readAsDataURL(file);
				  img.style.display = "inline";
			  }
		  </script>
	    </div>
	  </div> 
      <div class="form-group">
        <div class="label">
          <label>邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="email"
		   placeholder="请输入邮箱" />
          <span></span>
        </div>
      </div>
	  <div class="form-group">
	    <div class="label">
	      <label>手机号码：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50" value="" name="ephone"
	  		   placeholder="请输入手机号码" />
	      <span></span>
	    </div>
	  </div>
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input" name="enote" style="height:120px;" value=""></textarea>
          <div class="tips"></div>
        </div>
      </div>
		
		<div class="form-group">
		  <div class="label">
		    <label></label>
		  </div>
		  <div class="field">
		    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>  
				  <button type="button" style="width: 110px;" class="button bg-green" onclick="javascript:history.back(-1)"> 返回</button>   
		  </div>
		</div>  
    </form>
  </div>
</div>

</body></html>