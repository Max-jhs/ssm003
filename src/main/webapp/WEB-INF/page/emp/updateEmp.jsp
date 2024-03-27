<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
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
<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
	<script>
		<%--异步去查询部门--%>
		$(function () {
				$.get("${pageContext.request.contextPath}/dept/showDepts.action",function (resultObject) {
					var $deptSel = $("#deptSel");
					var depts = resultObject.resultMap.deptList;
					console.log(depts);
					$.each(depts, function (i, dept) {
						$deptSel.append("<option value='" + dept.deptId + "'>" +dept.deptName+"</option>");
					});
				},"json")
		})
	</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-magic"> 修改员工</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/emp/upDateEmp.action?empId=${Emp.empId}" enctype="multipart/form-data">
		<div class="form-group">
			<div class="label">
				<label>员工编号：</label>
			</div>
			<div class="field">
				<input type="text" class="input w50" value="${Emp.empId}"  disabled  name="empId"/>
				<span></span>
			</div>
		</div>
      <div class="form-group">
        <div class="label">
          <label>员工姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${Emp.empName}" name="empName"
		   placeholder="请输入姓名" />
          <span></span>
        </div>
      </div>
	  <div class="form-group">
	    <div class="label">
	      <label>月薪：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50" value="${Emp.empSal}" name="empSal"
	  		   placeholder="请输入月薪"/>
	      <span></span>
	    </div>
	  </div>
		<div class="form-group">
			<div class="label">
				<label>入职日期：</label>
			</div>
			<div class="field">
				<input type="date" class="input w50"
					   id="hiredate"
					   value="${Emp.empHireDate}"
					   name="empHireDate"
					   placeholder="请选择职日期"/>
				<span></span>
				<script>
					laydate.render({
						elem: '#hiredate' //指定元素
					});
				</script>
			</div>
		</div>
		  <div class="form-group">
			  <div class="label">
				  <label>员工头像：</label>
			  </div>
			  <img src="${pageContext.request.contextPath}/images/${Emp.empImg}" width="50px" height="50px">
		  </div>
		<div class="form-group">
			<div class="label">
				<label>上传头像：</label>
			</div>
			<div class="field">
				<input type="file" class="input w50" value="" name="photoFile"/>
				<span></span>
			</div>
		<%--部门也是现场异步查询--%>
		  <div class="form-group">
			  <div class="label">
				  <label>所在部门：</label>
			  </div>
			  <div class="field">
				  <select name="empDeptId"  class="input w50" id="deptSel">
				  </select>
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