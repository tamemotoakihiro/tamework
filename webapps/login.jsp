<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,tamework.*"%>

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
			<h3>すでに登録済みの方</h3>
        <form action="confirm.jsp" method="post">
        <div class="form-section">
          <table>
            <tr><td>ユーザー名</td><td><input type="text" NAME="user_name"></td></tr>
            <tr><td>パスワード</td><td><input type="password" NAME="password"></td></tr>
          </table>

        </div>
        <input type="submit" name="btn" value ="ログイン">
        </form>
		</div><!--main-->




	</div><!--main-contents-->

	<%@include file ="include/footer.html" %>


</body>
</html>
