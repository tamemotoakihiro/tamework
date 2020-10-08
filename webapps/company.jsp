<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,ricoweb.*"%>

<%

String StrId = request.getParameter("id");//selecttype.jspで取得したパラメータを代入
int intId = Integer.parseInt(StrId);

RicoWebDao dao = new RicoWebDao();
RicoWebDto dto = new RicoWebDto();

dto = dao.getRicoDataById(intId);

String accessinf = dto.getAccessinf();
accessinf = accessinf.replace(",","<br/>");

String message = dto.getMessage();
message = message.replace(",","<br/>");

dao.close();
%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device,initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap" rel="stylesheet">
	<title>Rico-Web | <%=dto.getCompany_name()%></title>
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

				<div class="company_data">
            <h3><%=dto.getCompany_name()%></h3>
            <table>
              <tr>
                  <th>住所</th>
                  <td><%=dto.getAddress()%></td>
              </tr>
              <tr>
                <th>最寄駅</th>
                <td><%=dto.getStation()%></td>
              </tr>
              <tr>
                <th>会社WebサイトURL</th>
                <td><a href="<%=dto.getMainlink()%>" target="_blank"><%=dto.getMainlink()%></a></td>
              </tr>
              <tr>
                <th>求人情報URL</th>
                <td><a href="<%=dto.getSublink()%>" target="_blank"><%=dto.getSublink()%></a></td>
              </tr>
              <tr>
                <th>企業訪問・面談</th>
                <td><p><%=accessinf%></p></td>
              </tr>
              <tr>
                <th>訓練生へのメッセージ</th>
                <td><p><%=message%></p></td>
              </tr>
            </table>

				</div><!--company_data-->

				<div class="back-button"><button onclick="history.back()">戻る</button></div>

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
