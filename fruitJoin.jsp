<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" charset="UTF-8">
        <title>회원가입</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <script>
            // 아이디 중복확인 팝업 열기
            function openIdCheck() {
                var userId = document.joinForm.userId.value;

                if (userId.trim() === "") {
                    alert("아이디를 먼저 입력해주세요.");
                    document.joinForm.userId.focus();
                    return;
                }

                // 아이디 유효성 검사 (영문, 숫자만 허용, 4-12자)
                var idPattern = /^[a-zA-Z0-9]{4,12}$/;
                if (!idPattern.test(userId)) {
                    alert("아이디는 영문, 숫자 4-12자로 입력해주세요.");
                    document.joinForm.userId.focus();
                    return;
                }

                // 팝업 창 열기
                var url = "<%=request.getContextPath()%>/FruitServilet?command=fruit_id_check&userId=" + userId;
                window.open(url, "idCheck", "width=500,height=400,resizable=no,scrollbars=no");
            }

            // 회원가입 유효성 검사
            function joinCheck() {
                var form = document.joinForm;

                // 1. 이름 검사
                if (form.name.value.trim() === "") {
                    alert("이름을 입력해주세요.");
                    form.name.focus();
                    return false;
                }

                // 2. 아이디 검사
                if (form.userId.value.trim() === "") {
                    alert("아이디를 입력해주세요.");
                    form.userId.focus();
                    return false;
                }

                var idPattern = /^[a-zA-Z0-9]{4,12}$/;
                if (!idPattern.test(form.userId.value)) {
                    alert("아이디는 영문, 숫자 4-12자로 입력해주세요.");
                    form.userId.focus();
                    return false;
                }

                // 3. 아이디 중복확인 체크
                if (form.idChecked.value !== "true") {
                    alert("아이디 중복확인을 해주세요.");
                    return false;
                }

                // 4. 비밀번호 검사
                if (form.userpw.value.trim() === "") {
                    alert("비밀번호를 입력해주세요.");
                    form.userpw.focus();
                    return false;
                }

                if (form.userpw.value.length < 4) {
                    alert("비밀번호는 최소 4자 이상이어야 합니다.");
                    form.userpw.focus();
                    return false;
                }

                // 5. 비밀번호 확인 검사
                if (form.userpw_check.value.trim() === "") {
                    alert("비밀번호 확인을 입력해주세요.");
                    form.userpw_check.focus();
                    return false;
                }

                if (form.userpw.value !== form.userpw_check.value) {
                    alert("비밀번호가 일치하지 않습니다.");
                    form.userpw_check.focus();
                    return false;
                }

                // 6. 닉네임 검사
                if (form.nickname.value.trim() === "") {
                    alert("닉네임을 입력해주세요.");
                    form.nickname.focus();
                    return false;
                }

                if (form.nickname.value.length < 2 || form.nickname.value.length > 10) {
                    alert("닉네임은 2-10자로 입력해주세요.");
                    form.nickname.focus();
                    return false;
                }

                // 7. 전화번호 검사
                if (form.phone.value.trim() === "") {
                    alert("전화번호를 입력해주세요.");
                    form.phone.focus();
                    return false;
                }

                var phonePattern = /^[0-9]{10,11}$/;
                if (!phonePattern.test(form.phone.value.replace(/-/g, ""))) {
                    alert("전화번호 형식이 올바르지 않습니다. (숫자만 10-11자)");
                    form.phone.focus();
                    return false;
                }

                // 8. 이메일 검사
                if (form.email.value.trim() === "") {
                    alert("이메일을 입력해주세요.");
                    form.email.focus();
                    return false;
                }

                var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
                if (!emailPattern.test(form.email.value)) {
                    alert("이메일 형식이 올바르지 않습니다.");
                    form.email.focus();
                    return false;
                }

                // 9. 주소 검사
                if (form.address.value.trim() === "") {
                    alert("주소를 입력해주세요.");
                    form.address.focus();
                    return false;
                }

                return true;
            }
        </script>
    </head>

    <body>
        <div class="login-container">
            <h2>회원가입</h2>
            '* '표시는 필수 입력 항목입니다.

            <form name="joinForm" action="<%=request.getContextPath()%>/FruitServilet?command=fruit_join_action"
                method="post" onsubmit="return joinCheck()">
                <!-- 아이디 중복확인 여부를 저장하는 hidden 필드 -->
                <input type="hidden" name="idChecked" value="false">

                <div class="input-group">
                    <table>

                        <tr>
                            <td>이름</td>
                            <td><input type="text" name="name" size="20">*</td>
                        </tr>

                        <tr>
                            <td>아이디</td>
                            <td>
                                <input type="text" name="userId" size="20">*
                                <input type="button" value="중복확인" onclick="openIdCheck()"
                                    style="padding: 5px 10px; cursor: pointer; background-color: #4CAF50; color: white; border: none; border-radius: 3px;">
                            </td>
                        </tr>

                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" name="userpw" size="20">*</td>
                        </tr>

                        <tr>
                            <td style="white-space: nowrap;">비밀번호확인</td>
                            <td><input type="password" name="userpw_check" size="20">*</td>
                        </tr>

                        <tr>
                            <td>닉네임</td>
                            <td><input type="text" name="nickname" size="20" placeholder="2-10자">*</td>
                        </tr>

                        <tr>
                            <td>전화번호</td>
                            <td><input type="text" name="phone" size="20" placeholder="01012345678">*</td>
                        </tr>

                        <tr>
                            <td>email</td>
                            <td><input type="text" name="email" size="20" placeholder="example@email.com">*</td>
                        </tr>

                        <tr>
                            <td>주소</td>
                            <td><input type="text" name="address" size="30">*</td>
                        </tr>

                    </table>

                    <div class="links">
                        <input type="submit" value="확인" style="padding: 10px 30px; 
                                  background-color: #4CAF50; 
                                  color: white; 
                                  border: none; 
                                  border-radius: 5px; 
                                  cursor: pointer; 
                                  font-size: 16px;
                                  font-weight: bold;
                                  margin-right: 20px;">
                        <input type="reset" value="취소" style="padding: 10px 30px; 
                                  background-color: #9e9e9e; 
                                  color: white; 
                                  border: none; 
                                  border-radius: 5px; 
                                  cursor: pointer; 
                                  font-size: 16px;
                                  font-weight: bold;">
                    </div>
                </div>
            </form>
        </div>
    </body>

    </html>