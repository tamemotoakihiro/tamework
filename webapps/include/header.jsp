<%@ page pageEncoding="utf-8" %>
<%
//セッション用の確認機能
String str=null;

if(session != null){
	str = (String)session.getAttribute("user_name");
}
%>

<div class ="header">
  <div class ="header-contents">
    <div class ="header-logo">
      <a href="index.jsp"><img src="img/logo.jpg" width="60"></a>
    </div>
    <ul class="header-list">
      <li><a href="about.jsp">このサイトについて</a></li>
      <li><a href="signin.jsp">会員登録(β版)</a></li>
    <%if(str == null){%>
      <li><a href="login.jsp">ログイン(β版)</a></li>
    <%}else{%>
			<li><a href="mypage.jsp">マイページ(β版)</a></li>
      <li><a href="logout.jsp">ログアウト(β版)</a></li>
    <%}%>
    </ul>
  </div><!--header-contents-->
</div><!--header-->
