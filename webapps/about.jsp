<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=divice,initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap" rel="stylesheet">
	<title>Tame-Web | トップページ</title>
</head>

<body>

	<%@include file ="include/header.jsp" %>

	<div class ="main-contents">

		<h3>このサイトについて</h3>

		<div class="">
	    <p>このサイトは、ためのこれまでの作品リンクをアーカイブしています。</p>
			<p>開発言語はJava(JSP)+Tomcat+MySQL(JDBC)を用いています。</p>
		</div><!--search_result-->

		<h3>ためについて</h3>

		<div class="">
			<p>31歳。何かの永久機関。目からチェレンコフ光を出す。</p>
			<p>これまで営業、放射線技師、ITの採用、ライターを経験。</p>
			<p>詳細のプロフィールは<a href="http://tame-intro.com">こちら</a>をご覧ください。</p>
		</div>

	</div><!--contents-->


	<%@include file ="include/footer.html" %>

</body>
</html>
