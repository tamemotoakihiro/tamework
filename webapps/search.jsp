<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,tamework.*"%>

<%

request.setCharacterEncoding("utf-8");

String StrKeyword = request.getParameter("keyword");//
String StrDatatype = request.getParameter("datatype");//


TameWebDao dao = new TameWebDao();
TameWebDto dto = new TameWebDto();

List <TameWebDto> list = dao.getTameDataList(StrKeyword,StrDatatype);

dao.close();
%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device,initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap" rel="stylesheet">
	<title>Tame-Web | 検索結果</title>
</head>

<body>

	<%@include file ="include/header.jsp" %>


	<div class ="main-contents">

		<div class="search">
			<form action="search.jsp" method="post">
				<p class="input_text">どんな作品をお探しですか？</p>
				<input type="search" name="keyword" placeholder="キーワードを入力"  style="height: 35px">
				<select name="datatype"  style="height: 35px">
					<option value="work_name">作品名</option>
					<option value="address">場所</option>
					<option value="station">最寄り</option>
				</select>
				<input type="submit" name="submit" value="search" style="height: 35px">
				</form>
		</div><!--search-->

		<h3>作品情報の検索結果一覧:</h3>
		<div class="search_result">
      <% for(TameWebDto work : list){ %>
				<div class="search_contents">
					<div class="work_name">
            <a href="work.jsp?id=<%=work.getId()%>">
              <p><%=work.getWork_name()%></p>
            </a>
          </div><!--work_name-->
				  <div class="search_relation"><%=StrKeyword%>,<%=StrDatatype%></div>
				</div><!--search_contents-->
			<% } %>
		</div><!--search_result-->

	</div><!--contents-->


<%@include file ="include/footer.html" %>

</body>
</html>
