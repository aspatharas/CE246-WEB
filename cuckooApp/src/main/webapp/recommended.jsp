<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cuckoo</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


<%@page import="java.util.List" %>
<%@page import="com.w3.cuckoo.Recommended" %>
<%@page import="com.w3.cuckoo.User" %>
<%User user = (User)session.getAttribute("user"); %>

<div class="header">
  <h1>Cuckoo</h1>
  <p>Music can change the world</p>
</div>

<div class="navbar">
  <a href="home.jsp">Home</a>
  <a href="library.jsp">Library</a>
  <a href="recommended.jsp" class = "active">Recommended</a>  
  <a href="login.html" class="right">Logout</a>
  <a href="#" class="right"><%=user.getName()%></a>
</div>
    

    <%
    List<?> playlists = (List<?>)session.getAttribute("recommended");

    for(int i = 0; i < playlists.size(); i+=1) { 
    	Recommended playlist = (Recommended)playlists.get(i);%>  
        <div class="playlist">
			<h6><%=playlist.getName()%></h6>
			<div id="buttons">
				<form action="ViewRecommended" method="post">
					<button type="submit" name="viewBtn" value=<%=playlist.getRecommended_id()%> class="btn">
						<i class="fa fa-eye"></i>
					</button>
				</form>
			</div>
		</div>
    <% } %>

</body>
</html>