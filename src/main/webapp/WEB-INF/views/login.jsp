<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
<h1>로그인 페이지</h1>

<!-- 로그인 안되어 있다면 -->
<c:if test="${empty loginMember}">
    <form method="post" action="/login">
        <div>
            <label for="id">아이디:</label>
            <input type="text" name="id" id="id" required />
        </div>
        <div>
            <label for="pw">비밀번호:</label>
            <input type="password" name="pw" id="pw" required />
        </div>
        <div>
            <button type="submit">로그인</button>
        </div>
    </form>

    <!-- 로그인 실패 시 오류 메시지 출력 -->
    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>
</c:if>

<!-- 로그인 되어 있다면 -->
<c:if test="${not empty loginMember}">
    <div>
        ${loginMember.id}님 환영합니다!
    </div>
    <div>
        <a href="/logout">로그아웃</a>
    </div>
     <div>
        <h3>로그인 이력</h3>
        <ul>
            <c:forEach var="date" items="${loginHistory}">
                <li>${date}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>

</body>
</html>
