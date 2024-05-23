<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="pm.service.FactoryService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex3_Add_Ok</title>
</head>
<body>
    <% 	// 스크립트 릿은 요청할 때마다 무조건 수행한다.

	// 요청시 한글 처리
	request.setCharacterEncoding("utf-8");

	//파라미터들 받기
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	// String ip = request.getParameter("ip");
	
	Map<String, String> d_map = new HashMap<>();
	d_map.put("deptno",deptno);
	d_map.put("dname",dname);
	d_map.put("loc",loc);
	
	// 싱글톤으로 준비된 FactoryService를 이용하여 factory를 얻어
	// SqlSession을 얻어내자
	SqlSession ss = FactoryService.getFactory().openSession();
	int cnt = ss.insert("dept.add",d_map);

	if(cnt>0){ // 저장성공
	%>
	<h2>저장성공</h2>
	<%
	 ss.commit();
	} else { // 저장실패
	 %>
	 <h2>저장실패</h2>
	 <%
	 ss.rollback();
	}	
%>

<a href="Ex3_List.jsp">부서목록</a>
<button type="button" onclick="goList()">부서목록</button>

<script>
	function goList(){
		//자바스크립트에서 페이지 강제이동
		location.href = "Ex3_List.jsp";
	}
</script>


</body>
</html>