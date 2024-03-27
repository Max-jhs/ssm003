<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
		<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<script>
			<%--异步注册--%>
			function showReg(){
				alert("手动控制注册弹出框")
				$("#adminName").val("");
				$("#adminUpwd").val("");
				$("#adminUpwd2").val("");
				$("#myModal").modal("show");
			}
			$(function () {
				$("#regBut").click(function () {
					//收据数据
					var adminName = $("#adminName").val();
					var adminPwd = $("#adminUpwd").val();
					var adminPwd2 = $("#adminUpwd2").val();

					if ( !(adminName === null || $.trim(adminName) === "" || adminPwd != adminPwd2)) {
						//验证两次密码是否相等且名字和密码不能为空
						var data= {"adminName":adminName,"adminPwd":adminPwd}
						//	发起异步请求
						$.ajax({
							type: "post",
							url:"${pageContext.request.contextPath}/login/regAdmin.action",
							data:data,
							datatype: "text",
							success: function (resultObject) {
								// console.log(resultObject.resultMap.adminCode);
								if (resultObject.resultCode == 0) {
									//注册成功
									alert("注册成功！您的账号为：" + resultObject.resultMap.adminCode);
									$("#myModal").modal("hide");
								}else{
									alert(resultObject.resultMeg)
								}
							}
						});
					//	两次密码输入不相同
					}else {
						$("#regError").text("两次密码不一致请重新输入！")
						$("#myModal").modal("show");
					}
				});

			//	异步登录
				$("#loginBut").click(function () {
					var code = $("#Code").val();
					var pwd = $("#Password").val();
					var loginFlag = $("#loginFlag").prop("checked");
					var data = {"adminCode":code,"adminPwd":pwd,"loginFlag":loginFlag}
					$.post("${pageContext.request.contextPath}/login/ajaxLogin.action", data, function (resutObject) {
						if (resutObject.resultCode == 0) {
							//登陆成功 去到主页
							window.location.href = "${pageContext.request.contextPath}/admin/toIndex.action";
							<%--window.location.href = "${pageContext.request.contextPath}/login/backIndex.action";--%>
						}else {
							alert(resutObject.resultMsg);
						}
					}, "json");
				})
			});
		</script>
	</head>
	<body>
		<div class="bg"></div>
		<div class="container">
			<div class="line bouncein">
				<div class="xs6 xm4 xs3-move xm4-move">
					<div style="height:150px;"></div>
					<div class="media media-y margin-big-bottom">
					</div>
					<form>
						<div class="panel loginbox" style="margin-top: -100px;">
							<div class="text-center margin-big padding-big-top">
								<h1>后台管理中心</h1>
							</div>
							<div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="text" autofocus="autofocus" class="input input-big" id="Code" name="Code" value="${cookie.loginCode.value}" placeholder="登录账号" data-validate="required:请填写账号" />
										<span class="icon icon-user margin-small"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="password" class="input input-big" id="Password" name="Password" placeholder="登录密码" value="${cookie.loginUpwd.value}" data-validate="required:请填写密码" />
										<span class="icon icon-key margin-small"></span>
									</div>
								</div>
								<%--<div class="form-group">--%>
									<%--<div class="field">--%>
										<%--<input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />--%>
										<%--<img src="images/passcode.jpg" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;"--%>
										 <%--onclick="this.src=this.src+'?'">--%>

									<%--</div>--%>
								<%--</div>--%>
								<div class="checkbox">
									<label style="font-family: 宋体;font-weight: bold;color: gray;">
										<input style="vertical-align: middle;" type="checkbox" id="loginFlag" name="loginFlag" value="yes" checked="checked">
										两周内自动登录
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="javascript:showReg();" id="" data-toggle="modal" scr style="font-style: italic;">没账号？点我注册</a>
								</div>
							</div>
							<div style="padding:30px;"><input type="button" id="loginBut" class="button button-block bg-main text-big input-big" value="登录"></div>
							<font color="#663399">${loginError}</font>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 注册弹出框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
						<h4 class="modal-title" id="myModalLabel">新用户注册</h4>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label>用户名</label>
								<input type="text" id="adminName" value="" class="form-control" placeholder="请输入用户名">
							</div>
							<div class="form-group">
								<label>密码</label>
								<input type="password" id="adminUpwd" value="" class="form-control" placeholder="请输入密码">
							</div>
							<div class="form-group">
								<label>确认密码</label>
								<input type="password" id="adminUpwd2" value="" class="form-control" placeholder="请输入确认密码">
							</div>

							<div class="form-group">
								<input type="button" id="regBut" style="width: 100%;" class="btn btn-lg btn-success"  value="注 册">
							</div>
							<%--提示两次密码不唯一--%>
							<span id="regError" style="color: red"></span>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
