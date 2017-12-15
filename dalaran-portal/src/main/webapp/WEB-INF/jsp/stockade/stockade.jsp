<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${path}/js/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=">
<title>Spring 事务</title>
<style type="text/css">
table
{
border-collapse: collapse;
border: none;
width: 200px;
}
td{border: solid #000 1px;height:70px;}

</style>
<script type="text/javascript">

function testUpdate(){
	alert("TestUpdate");
	$("#form").attr("action", "testUpdate.htm");
	$("#form").submit();
}

function testRestore(){
	$("#form").attr("action", "testRestore.htm");
	$("#form").submit();
}


function proRequired(w,b,t,x,r){
	alert("Required");
	$("#form").attr("action", "proRequired.htm?b="+b+"&w="+w+"&t="+t+"&x="+x+"&r="+r);
	$("#form").submit();
}

function requiredNew(w,b){
	alert("RequiredNew");
	$("#form").attr("action", "proRequiredNew.htm?b="+b+"&w="+w);
	$("#form").submit();
}

function proSupports(w,b){
	alert("Supports");
	$("#form").attr("action", "proSupports.htm?b="+b+"&w="+w);
	$("#form").submit();
}

function proNested(w,b){
	alert("Nested");
	$("#form").attr("action", "proNested.htm?b="+b+"&w="+w);
	$("#form").submit();
}
</script>
</head>
<body>
<div class="divMain">
<form method="post" id="form">
<table border="1" style="width:1200px;" align="center" class="tb">

<tr align="center">
	<td>事务传播行为类型</td>
	<td>说明</td>
	<td>操作</td>
</tr>
<tr align="center">
	<td height="80">PROPAGATION_REQUIRED</td>
	<td>如果当前没有事务，新建一个事务，如果已经存在一个事务，加入到这个事务中。
	</br>spring使用AOP来支持声明式事务，会根据事务属性，自动在方法调用之前决定是否
	</br>开启一个事务并在方法执行之后决定事务提交或回滚事务.</td>
	<td>
		<input type="button" value="White失败" onclick="proRequired('0','1','0','0','0')" />
		<input type="button" value="Black失败" onclick="proRequired('1','0','0','0','0')" />
		<input type="button" value="异常" onclick="proRequired('1','1','0','1','0')" />
		</br>
		<input type="button" value="只读" onclick="proRequired('1','1','0','0','1')" />
		<input type="button" value="都成功" onclick="proRequired('1','1','0','0','0')" />
		<!--
		<input type="button" value="TO" onclick="proRequired('1','1','1','0','0')" />
		 -->
	</td>
	<!--
	 -->
</tr>


<tr align="center">
	<td>PROPAGATION_REQUIRES_NEW</td>
	<td>如果当前没有事务，就新建一个事务，如果当前存在事务，把当前事务挂起。
	</br>
	内层事务的提交回滚不受外层事务的影响
	</td>
	<td>
		<input type="button" value="White外层事务失败" onclick="requiredNew('1','1')" />
		<input type="button" value="Black内层事务失败" onclick="requiredNew('1','0')" />
	</td>
</tr>


<tr align="center">
	<td>PROPAGATION_NESTED</td>
	<td>如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。
	</br>
	外层事务的回滚可以引起内层事务的回滚
	</td>
	<td>

		<input type="button" value="White外层事务失败" onclick="proNested('1','1')" />
		<input type="button" value="Black内层事务失败" onclick="proNested('1','0')" />
	</td>
</tr>


<tr align="center">
	<td>PROPAGATION_SUPPORTS</td>
	<td>如果存在一个事务，加入当前事务。如果没有事务，以非事务方式执行。</td>
	<td>
		<input type="button" value="存在事务" onclick="proSupports('1','1')" />
		<input type="button" value="不存在事务" onclick="proSupports('0','0')" />
	</td>
</tr>


<tr align="center">
	<td>PROPAGATION_MANDATORY</td>
	<td>
	如果存在一个事务，支持当前事务。如果没有事务,则抛出异常。
	</br>

	</td>
	<td rowspan="4">
		[事务隔离级别]:</br>
		READ-UNCOMMIITED 未提交可见</br>
		READ-COMMITTED   提交可见</br>
		REPEATABLE-READ  可重复读</br>
		SERIALIZABLE     可串行化</br>
	</td>
</tr>


<tr align="center">
	<td>PROPAGATION_NOT_SUPPORTED</td>
	<td>如果存在事务将这个事务挂起，建立新的数据库连接。新的数据库连接不使用事务。</td>

</tr>

<tr align="center">
	<td>PROPAGATION_NEVER</td>
	<td>以非事务方式执行，如果当前存在事务，则抛出异常。</td>
</tr>


<tr align="center">
	<td>测试功能：</td>
	<td>
	<input type="button" value="测试更新" onclick="testUpdate()"/>
	<input type="button" value="测试还原" onclick="testRestore()"/>
	</td>

</tr>
</table>
</form>
</div>
</body>
</html>