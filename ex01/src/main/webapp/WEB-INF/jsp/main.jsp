<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
메인
<!--  이미지가 ㅇ나 나오는 이유. 페이지 파일을 못 찾음.. -->
<!-- web.xml을 보면 알 수 있음 -->
<!-- 이미지 경로 넣을때 "/img/gosim.jpg" 이렇게 하면 왜 안 나올까..? 절대경로이기 때문! -->
<!-- context path -->
<!-- 하나의 톰캣 서버에 여러개의 프로젝트를 올릴 수 있음. 그걸 구분해주는게 context path이거! -->
<!-- 서버에 하나만 올린다면 변경 안 해도 되지만,  -->
<!-- /localhost다음에 오는 경로를 적어주면 됨/img/gosim.jpg -->
<!-- <img src="img/gosim.jpg"> -->
<!-- request로부터 contextPath를 받아와서, 경로가 변경돼도 바로 나오도록 해줌 -->
${pageContext.request.contextPath }
<%=application.getRealPath("/img") %>
<img src="${pageContext.request.contextPath }/img/gosim.jpg">

<!-- contextPath는 모듈 탭에서 바꿔도 되고, Servers -> server.xml 안에 제일 밑에서 바꿔도 됨.. -->
</body>
</html>