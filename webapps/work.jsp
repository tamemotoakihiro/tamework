<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,tamework.*"%>

<%

String StrId = request.getParameter("id");//selecttype.jspで取得したパラメータを代入
int intId = Integer.parseInt(StrId);

TameWebDao dao = new TameWebDao();
TameWebDto dto = new TameWebDto();

dto = dao.getTameDataById(intId);

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
	<title>Tame-Web | <%=dto.getWork_name()%></title>
</head>

<body>

	<%@include file ="include/header.jsp" %>


	<div class ="main-contents">

				<div class="work_data">
            <h3>作品名：<%=dto.getWork_name()%></h3>
            <table>
              <tr>
                  <th>場所</th>
                  <td><%=dto.getAddress()%></td>
              </tr>
              <tr>
                <th>最寄り</th>
                <td><%=dto.getStation()%></td>
              </tr>
              <tr>
                <th>作品URL</th>
                <td><a href="<%=dto.getMainlink()%>" target="_blank"><%=dto.getMainlink()%></a></td>
              </tr>
              <tr>
                <th>関連URL</th>
                <td><a href="<%=dto.getSublink()%>" target="_blank"><%=dto.getSublink()%></a></td>
              </tr>
              <tr>
                <th>作品メッセージ</th>
                <td><p><%=message%></p></td>
              </tr>
            </table>
						<%
						//ここにいいねボタン置きたい。Servlet Ajaxで。
						%>
				</div><!--work_data-->

				<div class="back-button"><button onclick="history.back()">戻る</button></div>

	</div><!--main-contents-->

	<%@include file ="include/footer.html" %>

</body>
</html>
