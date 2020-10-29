<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,tamework.*"%>

<%
String strInvalidate = request.getParameter("invalidate");
if(strInvalidate!= null){
	session.invalidate();
}

//falseと書かないと、新しいsessionが代入されてしまうのでnullにならない
session = request.getSession(false);
%>

<!DOCtype html>
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

      <%if(session != null){%>
  			<h3>おつかれさまです！ログアウトしますか？</h3>
          <form action="logout.jsp?invalidate" method="post">
          <div class="form-section">
            <input type="submit" value ="ログアウトする">
          </div>
          </form>
      <%}else{%>
        <h3>ログアウトしました。ありがとう！また来てね</h3>
        	<a href="index.jsp">トップページへ移動する</a>
      <%}%>
		</div><!--form-->




	</div><!--main-contents-->

	<%@include file ="include/footer.html" %>


</body>
</html>
