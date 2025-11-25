<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 20px;
        background-color: #f5f5f5;
    }
    .container {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    h2 {
        color: #333;
        margin-top: 0;
    }
    .input-group {
        margin: 15px 0;
    }
    input[type="text"] {
        padding: 8px;
        width: 200px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    button {
        padding: 8px 16px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-left: 5px;
    }
    button:hover {
        background-color: #45a049;
    }
    .use-btn {
        background-color: #2196F3;
    }
    .use-btn:hover {
        background-color: #0b7dda;
    }
    .message {
        margin: 15px 0;
        padding: 10px;
        border-radius: 4px;
    }
    .success {
        background-color: #d4edda;
        color: #155724;
        border: 1px solid #c3e6cb;
    }
    .error {
        background-color: #f8d7da;
        color: #721c24;
        border: 1px solid #f5c6cb;
    }
</style>
<script>
function checkId() {
    var userId = document.getElementById("userId").value;
    
    if (userId.trim() === "") {
        alert("아이디를 입력해주세요.");
        return;
    }
    
    // 아이디 유효성 검사 (영문, 숫자만 허용, 4-12자)
    var idPattern = /^[a-zA-Z0-9]{4,12}$/;
    if (!idPattern.test(userId)) {
        alert("아이디는 영문, 숫자 4-12자로 입력해주세요.");
        return;
    }
    
    // 중복 확인 요청
    window.location.href = "<%=request.getContextPath()%>/FruitServilet?command=fruit_id_check&userId=" + userId;
}

function useThisId() {
    var userId = document.getElementById("userId").value;
    
    if (userId.trim() === "" || <%=request.getAttribute("result") == null ? "true" : "false"%>) {
        alert("먼저 중복 확인을 해주세요.");
        return;
    }
    
    // 부모 창의 아이디 입력란에 값 설정
    opener.document.joinForm.userId.value = userId;
    opener.document.joinForm.idChecked.value = "true";
    
    alert("아이디가 설정되었습니다.");
    window.close();
}
</script>
</head>
<body>
<div class="container">
    <h2>아이디 중복 확인</h2>
    
    <div class="input-group">
        <input type="text" id="userId" name="userId" 
               value="<%=request.getParameter("userId") != null ? request.getParameter("userId") : ""%>"
               placeholder="아이디 입력">
        <button onclick="checkId()">중복 확인</button>
    </div>
    
    <%
        Integer result = (Integer) request.getAttribute("result");
        String userId = request.getParameter("userId");
        
        if (result != null) {
            if (result == -1) {
                // 사용 가능
    %>
                <div class="message success">
                    <strong><%=userId%></strong>는 사용 가능한 아이디입니다.
                </div>
                <button class="use-btn" onclick="useThisId()">이 아이디 사용하기</button>
    <%
            } else {
                // 중복
    %>
                <div class="message error">
                    <strong><%=userId%></strong>는 이미 사용 중인 아이디입니다.
                </div>
    <%
            }
        }
    %>
</div>
</body>
</html>
