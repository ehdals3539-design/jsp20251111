<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>회원 정보 수정</h2>

<form action="<%=request.getContextPath()%>/FruitServilet?command=fruit_update" method="post">

<table>
    <tr>
        <th>아이디</th>
        <td><input type="text" name="userId" value="${mvo.userId}" readonly></td>
    </tr>
    <tr>
        <th>이름</th>
        <td><input type="text" name="name" value="${mvo.name}"></td>
    </tr>
    <tr>
        <th>암호</th>
        <td><input type="text" name="userpw" value="${mvo.userpw}"></td>
    </tr>
    <tr>
        <th>전화번호</th>
        <td><input type="text" name="phone" value="${mvo.phone}"></td>
    </tr>
    <tr>
        <th>이메일</th>
        <td><input type="text" name="email" value="${mvo.email}"></td>
    </tr>
    <tr>
        <th>주소</th>
        <td><input type="text" name="address" value="${mvo.address}"></td>
    </tr>
</table>

<input type="submit" value="수정하기">

</form>
