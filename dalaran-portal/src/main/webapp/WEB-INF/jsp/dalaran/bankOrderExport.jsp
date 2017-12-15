<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<!-- @ include file="../include/commons-include.jsp"%> -->
	<%
	response.setHeader("Pragma ", "public");
	response.setHeader("Cache-Control ", "must-revalidate, post-check=0, pre-check=0 ");
	response.addHeader("Cache-Control ", "public ");
	response.addHeader("Content-Disposition", "attachment; filename="+java.net.URLEncoder.encode("汇总", "utf8")+".xls");
	response.setContentType("application/vnd.ms-excel.numberformat:@;charset=UTF-8");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="charset=utf-8" />
<style>
table {
	border: thin solid #333;
	border-collapse: collapse;
	border-spacing: 0px;
}

th {
	background-color: #ccc;
	border: thin solid #333;
}

td {
	border: thin solid #000;
}
</style>
</head>
<body>
	<table cellpadding="1" cellspacing="1" align="center" class="global_tableresult" style="width: 100%">
		<tr align="center">
			<th nowrap="true">请款-发送方</th>
			<th nowrap="true">发送方小计</th>
		</tr>

		<c:forEach var="v" items="${list}">
		<tr>
			<td>${v.fileName }</td>
			<td></td>
		</tr>
		</c:forEach>
			<!--
		<tr>
			<td>${v.accessInst}"</td>
			<td>${v.fileName}"</td>
		</tr>
		<c:forEach var="v" items="${list}">
		</c:forEach>
			<td style= "vnd.ms-excel.numberformat:#,##0.00"><fmt:formatNumber  value="${v.auditingAmt}" pattern="#.##"/></td>
			<td style="mso-number-format:'\@';">${v.isReview}</td>
			 -->
	</table>
</body>
</html>
