<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>회원 상세 페이지</title>

            <link rel="stylesheet" type="text/css" href="css/shopping.css">

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

            <h2>회원 상세 페이지</h2>

            <form action="<%=request.getContextPath()%>/FruitServilet?command=fruit_update" method="post"
                onsubmit="return confirm('정말로 수정하시겠습니까?');">

                <table class="list">

                    <tr>
                        <th>번호</th>
                        <td>${mvo.memberId}</td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td>${mvo.name}<input type="hidden" name="name" value="${mvo.name}"></td>
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td>${mvo.userId}</td>
                    </tr>

                    <tr>
                        <th>암 호</th>
                        <td>
                            <input type="password" name="userpw" value="${mvo.userpw}">
                            <input type="hidden" name="userId" value="${mvo.userId}">
                        </td>
                    </tr>

                    <tr>
                        <th>전화번호</th>
                        <td><input type="text" name="phone" value="${mvo.phone}"></td>
                    </tr>
                    <tr>
                        <th>email</th>
                        <td><input type="text" name="email" value="${mvo.email}"></td>
                    </tr>
                    <tr>
                        <th>회원가입일</th>
                        <td>${mvo.regDate}</td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td><input type="text" name="address" value="${mvo.address}"></td>
                    </tr>
                </table>

                <br>

                <input type="submit" value="수정">
                <input type="button" value="취소" onclick="history.back();">

            </form>

            <footer>
                <p>COPYRICHT(C) 2025 과일농장, Inc. All Rights Reserved</p>
            </footer>

        </body>

        </html>