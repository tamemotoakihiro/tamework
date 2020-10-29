<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,tamework.*"%>
<%

request.setCharacterEncoding("utf-8");
String strUser=request.getParameter("user_name");
String strPassword=request.getParameter("password");


UserDao dao = new UserDao();
UserDto dto = new UserDto();
boolean blResult = dao.login(strUser,strPassword);
if(blResult){
	session.setAttribute("user_name",strUser);
}

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


      <DIV CLASS="form">
      	<H1>ログイン</H1>
      	<DIV CLASS="form-section">
      	<%if(blResult){%>
      		こんにちは<%=strUser%>さん<BR>

      		<a href="index.jsp">トップページへ移動する</A>
      	<%}else{%>
      		ユーザ名またはパスワードが違います。<BR>
      		<A href="javascript:history.back()">戻る</A>
      	<%}%>
      	</DIV>
      </DIV>

	</div><!--form-->

	<%@include file ="include/footer.html" %>

</body>
</html>
