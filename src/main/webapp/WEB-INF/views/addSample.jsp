<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
   <!--  <script>
    	$(document).ready(function(){
    		$('#addBtn').click(function(){
    			if($('#name').val().length < 4){
    				alert('이름은 4자 이상이여야 합니다');
    				return;
    			}
    			var age = $('#age').val();

    			if (!$.isNumeric(age) || age < 0 || age > 100) {
    			    alert('나이는 0~100이하의 숫자만 가능합니다');
    			    return;
    			}
    			$('#addForm').submit();
    		});
    	});
    </script> -->
</head>
<body>
	<h1>addSample</h1>
	<span>${Msg} </span>
	<form id="addForm" method="post" action="/addSample">
		<div>
			<input type="text" id="name" name="name" placeholder="이름">
			<br>
			<input type="number" id="age" name="age" min="0" max="100" placeholder="나이">
			<!-- <button type="button"  id="addBtn">입력</button> -->
				<button type="submit">입력</button>

		</div>
	</form>
</body>
</html>
