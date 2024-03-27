<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin1.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
		<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
		<script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/app.js"></script>
		<script src="${pageContext.request.contextPath}/js/plugs.js"></script>
		<script>
                <%--把empId传到后台处理器处理--%>

                function delEmp(empId) {
                    if (confirm("是否删除？"))
                    {window.location.href = "${pageContext.request.contextPath}/emp/delEmp.action?empId=" + empId;};
                }
                //批量删除
                function delEmps(){
					//获取所有的aaaa  class
					var $delEmp = $(".aaa");
					var ids ="";
					$.each($delEmp,function (i, delEmp) {
						if (delEmp.checked == true) {
							ids = ids + delEmp.value + ",";
						}
					})
					var data={"ids": ids}
					if (confirm("确认删除吗？")) {
						if (ids == "") {
							alert("请选择删除项！");
							return;
						}
						$.post("${pageContext.request.contextPath}/emp/delEmps.action?",data,function (resultObject) {
							if (resultObject.resultCode == 0) {
								alert(resultObject.resultMsg);
								window.location.href="${pageContext.request.contextPath}/emp/toEmpManager.action?empName=${empName}"
							}else{
								alert(resultObject.resultMsg);
							}
						},"json");
					}
				}
				//全选、全不选
				function checkAll() {

					var $checkList = $(".aaa");
					if ($("#checkboxxx").prop("checked") == true) {
						for (var i = 0; i < $checkList.length; i++) {
							$checkList[i].checked = true;
						}
					}else{
						for (var i = 0; i < $checkList.length; i++) {
                            $checkList[i].checked = false;
                        }
					}
				}

		</script>
	</head>
	<body>
		
			<div class="panel admin-panel" style="border: 1px solid #ddd;">
				<div class="panel-head"><span class="icon-magic"> 员工管理</span></div>
				<div class="padding border-bottom">
					<style>
						ul li{
				display: inline;
			}
		</style>
					<ul class="search">
						<li>
							<a href="${pageContext.request.contextPath}/emp/toAddEmp.action" style="margin-top:10px ;" class="btn btn-success" target="right">添加员工</a>
							<button style="margin-top:10px ;" class="btn btn-danger" onclick="delEmps()">批量删除</button>
						</li>

						<li>
							<form action="${pageContext.request.contextPath}/emp/toEmpManager.action?empName=${empName}" method="get">
								<%--<div class="am-u-sm-12 am-u-md-3" style="position: absolute;right:220px;top:65px">--%>
										<%--<select id="dept" name="deptno" data-am-selected="{btnSize: 'sm'}" style="display: none;">--%>
											<%--<option value="0">--%>
												<%--请选择部门--%>
											<%--</option>--%>
											<%--<option value="0">--%>
												<%--研发部--%>
											<%--</option>--%>
										<%--</select>--%>
								<%--</div>--%>

								<div class="am-u-sm-12 am-u-md-3" style="position: absolute;right:10px;top:68px">
									<div class="am-input-group am-input-group-sm">
										<input class="am-form-field" placeholder="请输入员工姓名" name="empName" value="" type="text">
										<span class="am-input-group-btn">
											<button type="submit" class="btn btn-primary">查询</button></span>
									</div>
								</div>
							</form>
		</li>
		</ul>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th><input type="checkbox" id="checkboxxx"  value="" onclick="checkAll()" /></th>
				<th>编号</th>
				<th>姓名</th>
				<th>月薪</th>
				<th>入职日期</th>
				<th>头像</th>
				<th>所在部门</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${empList}" var="emp">
			<tr>
				<td>
					<input type="checkbox" class="aaa"  value="${emp.empId}" />
				</td>
				<td>${emp.empId}</td>
				<td>${emp.empName}</td>
				<td>${emp.empSal}</td>
				<td>${emp.empHireDate}</td>
				<td><img src="${pageContext.request.contextPath}/images/${emp.empImg}" width="50px" height="50px"></td>
				<td>${emp.dept.deptName}</td>
				<td>
					<a href="${pageContext.request.contextPath}/emp/showEmpInfo.action?empId=${emp.empId}" class="btn btn-info" target="right">修改</a>
					<button class="btn btn-warning" onclick="delEmp(${emp.empId})">删除</button>
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="8">
					<nav aria-label="Page navigation">
						<ul class="pagination">
                            <c:if test="${pageNum>1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/emp/toEmpManager.action?pageNum=${pageNum-1}&empName=${empName}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;上一页</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${pages}" var="i" step="1">
                                <c:if test="${pageNum==i}">
                                    <li class="active"><a href="${pageContext.request.contextPath}/emp/toEmpManager.action?pageNum=${i}&empName=${empName}">${i}</a></li>
                                </c:if>
                                <c:if test="${pageNum!=i}">
                                    <li><a href="${pageContext.request.contextPath}/emp/toEmpManager.action?pageNum=${i}&empName=${empName}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${pageNum<pages}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/emp/toEmpManager.action?pageNum=${pageNum+1}&empName=${empName}" aria-label="Next">
                                        <span aria-hidden="true">&laquo;下一页</span>
                                    </a>
                                </li>
                            </c:if>
						</ul>
					</nav>
				</td>
			</tr>
		</table>
		</div>
		</form>
	</body>
</html>
