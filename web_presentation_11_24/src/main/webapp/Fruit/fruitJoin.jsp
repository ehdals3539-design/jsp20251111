<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="login-container">
    <h2>회원가입</h2>
    '* '표시는 필수 입력 항목입니다.

<form action="<%=request.getContextPath()%>/FruitServilet?command=fruit_join_action" method="post">
        <div class="input-group">
        <table>

            <tr>
                <td>이름</td>
                <td><input type="text" name="name" size="20" required>*</td>
            </tr>

            <tr>
                <td>아이디</td>
                <td><input type="text" name="userId" size="20" required>*</td>
            </tr>

            <tr>
                <td>암호</td>
                <td><input type="password" name="userpw" size="20" required>*</td>
            </tr>

            <tr>
                <td>전화번호</td>
                <td><input type="text" name="phone" size="20" required>*</td>
            </tr>

            <tr>
                <td>email</td>
                <td><input type="text" name="email" size="20" required>*</td>
            </tr>

            <tr>
                <td>주소</td>
                <td><input type="text" name="address" size="30" required>*</td>
            </tr>

        </table>

        <div class="links">
            <input type="submit" value="확인">
            <input type="reset" value="취소">
        </div>
        </div>
    </form>
</div>
</body>
</html>
