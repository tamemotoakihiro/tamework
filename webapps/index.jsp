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


TameWebDao dao = new TameWebDao();
TameWebDto dto = new TameWebDto();

dto = dao.getTameData();

dao.close();
%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

	<script>

	var assoc ={};

	function showHint(str) {

		assoc.keyword = str.value;
		data = JSON.stringify(assoc);

	  if (str.length == 0) {
	    document.getElementById("txtHint").innerHTML = "";
	    return;
	  } else {
	    var xmlhttp = new XMLHttpRequest();
	    xmlhttp.onreadystatechange = function() {
	      if (this.readyState == 4 && this.status == 200) {
	        document.getElementById("txtHint").innerHTML = this.responseText;
	      }
	    };
	    xmlhttp.open("GET", "../suggestion" , true);
			xmlhttp.setRequestHeader("Content-Type","application/json");
	    xmlhttp.send(JSON.stringify(data));
	  }
	}

	</script>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device,initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap" rel="stylesheet">
	<title>Tame-Web | トップページ</title>
</head>

<body>

	<%@include file ="include/header.jsp" %>


	<div class ="main-contents">

		<div class="main-image">
			<img src="img/main_image.jpg">
		</div>

		<div class="">
			<p>このサイトは、ためがこれまで描いてきた作品をまとめたサイトです。</p>
		</div>

		<div class="search">
			<form action="search.jsp" method="post">
				<p>おいでませ。<%=strUser%>さん。作品検索はこちらから</p>
				<input type="search" name="keyword" id="input_text" placeholder="キーワードを入力" oninput="showHint(this.value)" style="height: 35px">
        <select name="datatype"  style="height: 35px">
          <option value="work_name">作品名</option>
          <option value="address">場所</option>
          <option value="station">最寄り</option>
        </select>
				<input type="submit" name="submit" value="search" style="height: 35px">
				</form>
			<p>もしかしてこれかな？<span id="txtHint"></span></p>
		</div><!--search-->


		<div class="mainlist">
			<h3>新しくこんなものを描いたよ。</h3>
		      <ul>
		        <li>
		          <p>作品名：<%=dto.getWork_name()%></p>
							<p>解説：<%=dto.getMessage()%></p>
		        </li>
		      </ul>
		</div><!--main-->

    <div class="sublist">
			<h3>お知らせ</h3>
	        <ul>
	          <li>
							<div>2020年10月29日</div>
	            <p>「このサイトについて」をまとめてみたよ。</p>
	          </li>
	        </ul>

    </div><!--sub-->


	</div><!--main-contents-->

	<%@include file ="include/footer.html" %>

</body>
</html>
