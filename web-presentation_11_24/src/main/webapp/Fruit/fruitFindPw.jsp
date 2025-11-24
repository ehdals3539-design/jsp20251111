<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>비밀번호 찾기</title>
        <link rel="stylesheet" type="text/css" href="css/shopping.css">
    </head>

    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/FruitServilet?command=fruit_home">홈으로</a></li>
                    <li><a href="<%=request.getContextPath()%>/FruitServilet?command=fruit_login">로그인</a></li>
                </ul>
            </nav>
        </header>

        <h2>비밀번호 찾기</h2>

        <form action="<%=request.getContextPath()%>/FruitServilet?command=fruit_find_pw_action" method="post">
            <table class="list">
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="userId" required></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="text" name="email" required></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="비밀번호 찾기">
            <input type="button" value="취소" onclick="history.back()">
        </form>

        <footer>
            <p>COPYRIGHT(C) 2025 과일농장, Inc. All Rights Reserved</p>
        </footer>

    </body>

    </html>