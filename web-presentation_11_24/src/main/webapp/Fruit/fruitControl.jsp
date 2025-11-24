<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 페이지</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/shopping.css">

</head>
<body>

<header>
    <nav>
        <ul>
            <li><a href="<%=request.getContextPath()%>/FruitServilet?command=fruit_home">홈으로</a></li>
            <li><a href="<%=request.getContextPath()%>/FruitServilet?command=fruit_home">공지사항</a></li>
            <li><a href="<%=request.getContextPath()%>/FruitServilet?command=fruit_Control">회원관리</a></li>
            <li><a href="<%=request.getContextPath()%>/FruitServilet?command=fruit_Item">상품목록</a></li>
        </ul>
    </nav>
</header>

<h1>회원관리 페이지</h1>

<table class="list">
	<tr>
      		<td colspan="5" style ="border: white; text-align:left; font-size:25px ">
      		<b>회원정보</b></td>
      	</tr>

    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>아이디</th>
        <th>전화번호</th>
        <th>email</th>
    </tr>

    <c:forEach var="m" items="${memberList}">
        <tr>
            <td>${m.memberId}</td>

            <td>
                <a href="<%=request.getContextPath()%>/FruitServilet?command=fruit_UDP&userId=${m.userId}">
                    ${m.name}
                </a>
            </td>

            <td>${m.userId}</td>
            <td>${m.phone}</td>
            <td>${m.email}</td>
        </tr>
    </c:forEach>

</table>

<footer>
    <p>COPYRICHT(C) 2025 과일농장, Inc. All Rights Reserved</p>
</footer>

</body>
</html>
