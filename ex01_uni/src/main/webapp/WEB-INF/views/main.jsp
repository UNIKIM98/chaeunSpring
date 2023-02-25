<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<img alt="메인" src="/app/img/dt6.gif">
	<%=application.getRealPath("/img")%>
<%-- 	<img alt="메인" src="/${pageContext.request.contextPath }/img/dt6.gif"> --%>
<%-- 	<p>${pageContext.request.contextPath }</p> --%>
	<!-- ↑ src 
	하나의 톰켓 서버 안에 여러 개의 어플리케ㅣ션이 있으 룻 있음 
	그래서 서버 돌릴 때 구분이 되어야하는데 이걸 구분하는게 컨텍스트 페스!
	하나의 어플만 있으면 ㄱㅊ
	하지만 여러개라면 필요함
	localhost/"여기!!"/main
	에서 "여기"에 해당하는 부분을 저겅줘야함
	 -->
</body>
</html>