<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cuckoo</title>
<link rel="stylesheet" href="style.css">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<%@page import="java.util.List" %>
<%@page import="com.w3.cuckoo.Song" %>
<%@page import="com.w3.cuckoo.Artist" %>
<%@page import="com.w3.cuckoo.User" %>
<%User user = (User)session.getAttribute("user"); %>

<div class="header">
  <h1>Cuckoo</h1>
  <p>Music can change the world</p>
</div>

<div class="navbar">
  <a href="home.jsp">Home</a>
  <a href="library.jsp">Library</a>
  <a href="recommended.jsp">Recommended</a>  
  <a href="login.html" class="right">Logout</a>
  <a href="#" class="right"><%=user.getName()%></a>
</div>

<div id="songs">

    <%
    List<?> songs = (List<?>)session.getAttribute("recommended_songs");
    List<?> artists = (List<?>)session.getAttribute("artists");

    for(int i = 0; i < songs.size(); i+=1) { 
        Song song = (Song)songs.get(i);
        Artist artist = (Artist)artists.get(i);%> 
         
        <div id="box">
    	<div class="info">
	  		<p><%=song.getName()%></p>
	  		<h6>Time length: <%=song.getLength()%></h6>
	  		<h5><%=artist.getName()%></h5>
		</div>
  	</div><hr>
    <% } %>
    
</div>

</body>
</html>
