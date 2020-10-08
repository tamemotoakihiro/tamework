<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,ricoweb.*"%>
<%

RicoWebDao dao = new RicoWebDao();
RicoWebDto dto = new RicoWebDto();

dto = dao.getRicoData();

dao.close();
%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device,initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap" rel="stylesheet">
	<title>Rico-Web | トップページ</title>
</head>

<body>

	<div class ="header">
		<div class ="header-contents">
			<div class ="header-logo">
				<a href="index.jsp"><img src="img/logo.svg" width="180"></a>
			</div>
			<ul class="header-list">
				<li><a href="about.html">このサイトについて</a></li>
				<li><a href="#">会員登録(工事中)</a></li>
				<li><a href="#">ログイン(工事中)</a></li>
			</ul>
		</div><!--header-contents-->
	</div><!--header-->


	<div class ="main-contents">

		<div class="search">
			<form action="search.jsp" method="post">
				<p class="input_text">どんな求人をお探しですか？</p>
				<input type="search" name="keyword" placeholder="キーワードを入力"  style="height: 35px">
        <select name="datatype"  style="height: 35px">
          <option value="company_name">会社名</option>
          <option value="address">住所</option>
          <option value="station">最寄駅</option>
        </select>
				<input type="submit" name="submit" value="search" style="height: 35px">
				</form>
		</div><!--search-->


		<div class="mainlist">
			<h3>新着会社リスト</h3>
		      <ul>
		        <li>
		          <p>会社名：<%=dto.getCompany_name()%></p>
							<p>一言：<%=dto.getAccessinf()%></p>
		        </li>
		      </ul>
		</div><!--main-->

    <div class="sublist">
			<h3>サイトからのお知らせ</h3>
	        <ul>
	          <li>
							<div>2020年10月7日</div>
	            <p>「このサイトについて」を更新しました。</p>
	          </li>
	        </ul>

    </div><!--sub-->


	</div><!--main-contents-->

	<div class ="footer">
		<div class="footer-content">
			<h3>関連リンク</h3>
		</div>
			<ul class="footer-list">
				<li><a href="https://event.rico-web.net/">Rico-Web</a></li>
				<li><a href="http://www.rico-web.net/">キョウリツネット</a></li>
				<li><a href="http://terahouse-ica.ac.jp/">テラハウスICA</a></li>
			</ul>
			<div class="footer-content">
			<p>このサイトは<a href="tame-intro.com">Java+Webプログラミング実践科の学生</a>が作成したものです。</p>
		</div>
	</div><!--footer-->

</body>
</html>
