<%@page import="pm.vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="pm.service.FactoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex3_List</title>
<style>
	th{
		background: #444;
		color: #fff;
	}
	td{
		border-right: 1px solid #444;
	}
	td:first-child{
		text-align:center;
	}
	td:last-child{
		text-align:center;
		border-right: none;
	}
</style>
</head>
<body>
<% 	// 스크립트 릿은 요청할 때마다 무조건 수행한다.

	// 요청시 한글 처리
	request.setCharacterEncoding("utf-8");

	// 싱글톤으로 준비된 FactoryService를 이용하여 factory를 얻어
	// SqlSession을 얻어내자
	SqlSession ss = FactoryService.getFactory().openSession();
	List<DeptVO> d_list = ss.selectList("dept.all");
	
	%>
	<table id="t1">
		<thead>
			<tr>
				<th>부서코드</th>
				<th>부서명</th>
				<th>도시코드</th>
			</tr>
		</thead>
	<%
	System.out.println(d_list.size());
	for(DeptVO dvo: d_list){
		System.out.println(dvo.getDeptno());
		%><tr>
			<td><%=dvo.getDeptno()%></td>
			<td><%=dvo.getDname()%></td>
			<td><%=dvo.getLoc_code()%></td>
		</tr><%
	}
%>
	</table>
</body>
</html>