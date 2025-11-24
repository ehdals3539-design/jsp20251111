<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
<div class="wrap">
		<nav>
        	<ul>
                <li><a href="FruitServilet?command=fruit_home">홈으로</a></li>
                <li><a href="FruitServilet?command=fruit_home">공지사항</a></li>
                <li><a href="FruitServilet?command=fruit_Control">회원관리</a></li>
                <li><a href="FruitServilet?command=fruit_Item">상품목록</a></li>           
            </ul>
        </nav>
<h1>상품 상세 페이지</h1>
	<table>
		<tr>
			<th width="50">상품명</th>
			<td>수박</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>10000</td>
		</tr>
		<tr>
			<th>사진</th>
		</tr>
		<tr>
			<th>설명</th>
			<td>달콤하고 맛있는 수박입니다</td>
		</tr>
	</table>
		<br><input type="submit" value="주문하기">
			<input type="reset" value="취소">
</div>
</body>
</html>