<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>

    <body>
        <div class="login-container">
            <h2>로그인</h2>
            <form action="FruitServilet?command=fruit_home" method="POST">

                <div class="input-group">
                    <label for="user_id">아이디</label>
                    <input type="text" id="user_id" name="username" placeholder="아이디를 입력하세요" required>
                </div>
                <div class="input-group">
                    <label for="user_pw">비밀번호</label>
                    <input type="password" id="user_pw" name="username" placeholder="비밀번호를 입력하세요" required>
                </div>

                <button type="submit" class="login-btn">로그인</button>
            </form>
            <div class="links">
                <a href="FruitServilet?command=fruit_find_id_form">아이디찾기</a> | <a
                    href="FruitServilet?command=fruit_find_pw_form">비밀번호찾기</a> | <a
                    href="FruitServilet?command=fruit_Join">회원가입</a>
            </div>
        </div>

        <footer>
            <p>COPYRICHT(C) 2025 과일농장, lnc. All Rights Reserved</p>
        </footer>

        <h1><a href="FruitServilet?command=fruit_home">홈으로</a></h1>
    </body>

    </html>