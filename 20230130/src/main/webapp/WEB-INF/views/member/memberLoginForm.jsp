<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@font-face {
	font-family: 'NanumSquareNeo-Variable';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/NanumSquareNeo-Variable.woff2')
		format('woff2');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: 'NanumSquareNeo-Variable';
}
</style>
</head>
<body>
	<div align="center">
		<div>
			<h3>로그인</h3>
		</div>
		<div>
			<form id="form" action="memberLogin.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">* 아이디</th>
							<td width="200"><input type="text" id="memberId"
								name="memberId"></td>
						</tr>

						<tr>
							<th width="150">* 비밀번호</th>
							<td width="200"><input type="password" id="memberPassword"
								name="memberPassword"></td>
						</tr>
					</table>
				</div>
				<br> <input type="submit" value="Login">&nbsp;&nbsp; <input
					type="reset" value="cancel">
			</form>
		</div>
	</div>
</body>
</html>