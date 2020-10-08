<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,ricoweb.*"%>

<%

request.setCharacterEncoding("utf-8");

String StrKeyword = request.getParameter("keyword");//
String StrDatatype = request.getParameter("datatype");//


RicoWebDao dao = new RicoWebDao();
RicoWebDto dto = new RicoWebDto();

List <RicoWebDto> list = dao.getRicoDataList(StrKeyword,StrDatatype);

dao.close();
%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device,initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap" rel="stylesheet">
	<title>Rico-Web | 検索結果</title>
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

		<h3>会社情報の検索結果一覧:</h3>
		<div class="search_result">
      <% for(RicoWebDto company : list){ %>
				<div class="search_contents">
					<div class="company_name">
            <a href="company.jsp?id=<%=company.getId()%>">
              <p><%=company.getCompany_name()%></p>
            </a>
          </div><!--company_name-->
				  <div class="search_relation"><%=StrKeyword%>,<%=StrDatatype%></div>
				</div><!--search_contents-->
			<% } %>
		</div><!--search_result-->

	</div><!--contents-->


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
