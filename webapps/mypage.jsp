<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,tamework.*"%>
<%

String strUser="ゲスト";

if(session != null){
	strUser = (String)session.getAttribute("user_name");
}

if(strUser == null){
	strUser = "ゲスト";
}

%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=divice,initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap" rel="stylesheet">
	<title>Tame-Web | マイページ</title>
</head>

<body>

	<%@include file ="include/header.jsp" %>

	<div class ="main-contents">

		<h3>マイページ</h3>
		<div class="">
      <%=strUser%>さんの情報
		</div><!--search_result-->
		<div class="">
      オススメ作品
		</div>
		<div class="">
			お気に入り本棚
		</div><!--search_result-->

	</div><!--contents-->


	<%@include file ="include/footer.html" %>

</body>
</html>
