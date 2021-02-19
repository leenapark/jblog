<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

</head>
<body>
	<div id="center-content">
		
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>		
		<!-- 메인 해더 -->
		
	

		<div>		
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
				<table>
			      	<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td><label for="txtId">아이디</label></td>
		      			<td><input id="txtId" type="text" name="id"></td>
		      			<td><button id="btnIdCheck" type="button">아이디체크</button></td>
		      		</tr>
		      		<tr>
		      			<td></td>
		      			<td id="tdMsg" colspan="2"></td>
		      		</tr> 
		      		<tr>
		      			<td><label for="txtPassword">패스워드</label> </td>
		      			<td><input id="txtPassword" type="password" name="password"  value=""></td>   
		      			<td></td>  			
		      		</tr> 
		      		<tr>
		      			<td><label for="txtUserName">이름</label> </td>
		      			<td><input id="txtUserName" type="text" name="userName"  value=""></td>   
		      			<td></td>  			
		      		</tr>  
		      		<tr>
		      			<td><span>약관동의</span> </td>
		      			<td colspan="3">
		      				<input id="chkAgree" type="checkbox" name="agree" value="y">
		      				<label for="chkAgree">서비스 약관에 동의합니다.</label>
		      			</td>   
		      		</tr>   		
		      	</table>
	      		<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit" >회원가입</button>
				</div>
	      		
			</form>
			
		</div>
		
		
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
		<!-- 메인 푸터  자리-->
		
	</div>

</body>


<script type="text/javascript">
	// 아이디 체크 - ajax 사용
	$("#btnIdCheck").on("click", function(){
		
		var uid = $("#txtId").val();
		console.log(uid);
		
		if(uid != null && uid != ''){
			console.log("id");
			
			$.ajax({	// 서버하고 통신하는 기술
				
				// controller로 데이터 보낼 정보
				url : "${pageContext.request.contextPath }/user/idcheck",		
				type : "post",
				//contentType : "application/json",
				data : {id: uid},
		
				// controller에서 온 데이터를 받을 때
				dataType : "text",
				success : function(result){
					/*성공시 처리해야될 코드 작성*/
					if(result == 'can'){
						console.log("can");
						$("#tdMsg").html("사용할 수 있는 아이디 입니다.");
					} else {
						console.log("cant");
						$("#tdMsg").html("사용할 수 없는 아이디 입니다.")
						
					}				
					console.log(result);
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
			});
		} else {
			alert("id를 입력해주세요.");
		}
		
	});
	
	// 가입 정보 submit 할 때 --> submit 되기 전
	$("#joinForm").on("submit", function(){
		
		// id 입력 체크
		var id = $("#txtId").val();
		//console.log(id);
		
		// 패스워드 체크
		var pw = $("#txtPassword").val();
		//console.log(pw);

		// 이름 입력 여부 체크
		var name = $("#txtUserName").val();
		//console.log(name);
		
		// 동의 여부 체크
		var agree = $("#chkAgree").is(":checked");
		//console.log(agree);
		
		if(id == "") {
			alert("id를 입력해주세요.");
			
			return false;
		}
		
		if(pw == "") {
			alert("비밀 번호를 입력해주세요.");
			
			return false;
		}
		
		if(name == ""){
			alert("이름을 입력해주세요.")
			
			return false;
		}
		
		if(!agree){
			alert("약관에 동의 해주세요.");
			return false;
		}
		
		return true;
		
	});


</script>

</html>