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

<%@page import="com.w3.cuckoo.User" %>
<%User user = (User)session.getAttribute("user"); %>

<div class="header">
  <h1>Cuckoo</h1>
  <p>Music can change the world</p>
</div>

<div class="navbar">
  <a href="home.jsp">Home</a>
  <a href="#" class = "active">Library</a>
  <a href="recommended.jsp">Recommended</a>  
  <a href="login.html" class="right">Logout</a>
  <a href="#" class="right"><%=user.getName()%></a>
</div>

<form action="Library" method="post">
	<button type="button" class="newBtn" onclick="show();">+ New Playlist</button>
	<input id="input" type="text" placeholder="Enter a playlist name" name="playlist_name" required>
	<button id="button" type="submit" class="btn" name="operation" value="create" onclick="hide();">Save</button>
</form>

<div id="playlists">
<%@page import="java.util.List" %>
<%@page import="com.w3.cuckoo.Playlist" %>
    <%
    List<?> playlists = (List<?>)session.getAttribute("playlists");

    for(int i = 0; i < playlists.size(); i+=1) {
        Playlist playlist = (Playlist)playlists.get(i);%>    
        <div class="playlist">
			<h6><%=playlist.getName()%></h6>
			<div id="buttons">
				<form action="ViewLibrary" method="post">
					<button type="submit" name="viewBtn" value=<%=playlist.getPlaylist_id()%> class="btn">
						<i class="fa fa-eye"></i>
					</button>
				</form>
				<form action="Library" method="post">
					<button type="submit" name="operation" value=<%=playlist.getPlaylist_id()%> class="btn">
						<i class="fa fa-trash"></i>
					</button>
				</form>
			</div>
		</div>
    <% } %>
</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
function show() {
	$("#input").show();
	$("#button").show();
}

function hide() {
	$("#input").hide();
	$("#button").hide();
}
</script>

</body>
</html>