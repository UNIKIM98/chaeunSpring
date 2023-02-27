<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Simple Bootstrap Login Form Example</title>
    <link rel='stylesheet' href='https://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
      <link rel="stylesheet" href="css/member/style.css">
       <link rel="stylesheet" href="css/member/memberLoginForm.css">
	<!-- Demo CSS -->
	<link rel="stylesheet" href="css/member/demo.css">
  
  </head>
  <br><br><br><br><br><br><br><br><br><br><br><br>
 <body class="align">

  <div class="grid">

    <form action="memberLogin.do" method="post" class="form login">

      <header class="login__header">
        <h3 class="login__title">Login</h3>
      </header>

      <div class="login__body">

        <div class="form__field">
          <input type="email" placeholder="Email Address" id="memberId" name="memberId" required="required">
        </div>

        <div class="form__field">
          <input type="password" placeholder="Password" id="memberPassword" name="memberPassword" required="required">
        </div>

      </div>

      <footer class="login__footer">
        <input type="submit" value="Login">

        <p><span class="icon icon--info">!</span><a href="memberJoinForm.do">Sign Up</a></p>
      </footer>

    </form>
<br><br><br><br><br><br><br>
  </div>

</body>
</html>