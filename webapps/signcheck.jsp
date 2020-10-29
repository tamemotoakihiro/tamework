<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,tamework.*"%>
<%

request.setCharacterEncoding("utf-8");
String strUser=request.getParameter("user_name");
String strPassword=request.getParameter("password");


UserDao dao = new UserDao();
UserDto dto = new UserDto();

boolean SameAccount = dao.DepreCheck(strUser);

int result = dao.RegisterNewUser(strUser,strPassword,SameAccount);
String StrResult = new Integer(result).toString();

dao.close();
%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device,initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap" rel="stylesheet">
	<title>Tame-Web | トップページ</title>
</head>

<body>

	<%@include file ="include/header.jsp" %>

	<div class ="main-contents">
		<div class="form">
			<%if(StrResult.equals("0")){%>

				<p>済みません。再度お試しください。</p>
				<p>パスワードは8文字以上、名前は5文字以上でお願いいたします。</p>

			<%} else if(StrResult.equals("-1")){%>

				<p>同じ名前を使っているユーザーがすでに存在します</p>

			<%}else{%>

				<p>会員登録完了しました</p>
				<a href="login.jsp">ログインページへ移動する</A>
			<%}%>
		</div>

	</div><!--main-contents-->

	<%@include file ="include/footer.html" %>

</body>
</html>
