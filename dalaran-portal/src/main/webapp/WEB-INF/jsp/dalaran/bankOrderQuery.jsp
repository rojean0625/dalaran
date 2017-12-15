<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>BankOrderQueryPage</title>
</head>
<body>
<form id="form" action="bankOrdExport.htm" method="post">
<table style="width:1000px">
	<tr>
		<td></td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td><input type="submit" value="导出银行订单明细" /></td>
	</tr>
</table>
</form>

<iframe name="queryResult" src="" width="100%"  height="520px" scrolling="no" frameborder="0" noresize></iframe>
<iframe name="exportResult" src="" width="100%" height="0px" scrolling="no" frameborder="0"  /></iframe>
</body>
</html>