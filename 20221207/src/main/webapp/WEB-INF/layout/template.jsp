<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Simple Sidebar - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<style>
@font-face {
    font-family: 'KoddiUDOnGothic-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/KoddiUDOnGothic-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
	* {
		font-family: KoddiUDOnGothic-Regular;
	}
</style>
</head>
<body>
	<div class="d-flex" id="wrapper">
		<!--▶ Sidebar-->
		<tiles:insertAttribute name="sidebar"></tiles:insertAttribute>

		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!--▶ top navigation-->
			<tiles:insertAttribute name="top"></tiles:insertAttribute>

			<!-- Page content-->
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
