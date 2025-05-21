<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 변경</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <form id="changePwForm">
        <div>
            <input type="password" name="pw" id="pw" placeholder="비밀번호 변경" required>    
            <input type="password" name="pw2" id="pw2" placeholder="비밀번호 확인" required>
        </div>
        <button type="submit">패스워드 변경</button>
    </form>

    <div id="resultMessage" style="color: red; margin-top: 10px;"></div>

    <script>
    $('#changePwForm').submit(function(e) {
        e.preventDefault();

        const pw = $('#pw').val();
        const pw2 = $('#pw2').val();

        if (pw !== pw2) {
            alert('비밀번호가 일치하지 않습니다.');
            return;
        }

        $.ajax({
            url: '/changePw',
            method: 'POST',
            data: { pw: pw },
            success: function(response) {
                if (response === 'success') {
                    $('#resultMessage').css('color', 'green').text('비밀번호가 성공적으로 변경되었습니다.');
                    setTimeout(function() {
                        window.location.href = '/login';
                    }, 1500);
                } else {
                    $('#resultMessage').css('color', 'red').text( response);
                }
            },
            error: function() {
                $('#resultMessage').css('color', 'red').text('서버와 통신 중 오류가 발생했습니다.');
            }
        });
    });
    </script>
</body>
</html>
