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
  <a href="library.jsp">Library</a>
  <a href="recommended.jsp">Recommended</a>  
  <a href="login.html" class="right">Logout</a>
  <a href="#" class="right"><%=user.getName()%></a>
</div>

<form action="View" method="post">
	<button type="button" class="newBtn" onclick="show();">+ Add Song</button>
	<input id="input" type="text" autocomplete="off" placeholder="Enter a song name" name="song_name" onkeyup="myFunction()" required>
	<button id="button" type="submit" class="btn" name="operation" value="create" onclick="hide();">Save</button>
</form>


<ul id="ul">

<%@page import="java.util.List" %>
<%@page import="com.w3.cuckoo.Song" %>
<%List<?> allSongs = (List<?>)session.getAttribute("allSongs");

    for(int i = 0; i < allSongs.size(); i+=1) { 
        Song song = (Song)allSongs.get(i);%>  

  			<li><a href="#"><%=song.getName()%></a></li>

	<%}%>
</ul>

<div id="songs">


<%@page import="java.util.List" %>
<%@page import="com.w3.cuckoo.Song" %>
<%@page import="com.w3.cuckoo.Artist" %>
<%@page import="com.w3.cuckoo.Manager" %>
    <%
    List<?> songs = (List<?>)session.getAttribute("playlist_songs");
    List<?> artists = (List<?>)session.getAttribute("artists");

    for(int i = 0; i < songs.size(); i+=1) { 
        Song song = (Song)songs.get(i);
        Artist artist = (Artist)artists.get(i);%>  
        <div id="box">
    	<div class="info">
      		<p><%=song.getName()%></p>
      		<h6>Time length: <%=song.getLength()%></h6>
	  		<h5><%=artist.getName()%></h5>
	  		<form action="View" method="post">
				<button type="submit" name="operation" value=<%=song.getSong_id()%> class="btn">
					<i class="fa fa-trash"></i>
				</button>
			</form>
		</div>
  	</div><hr>
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

function myFunction() {
    var input, filter, ul, li, a, i, txtValue, count;
    input = document.getElementById("input");
    filter = input.value.toUpperCase();
    ul = document.getElementById("ul");
    li = ul.getElementsByTagName("li");

    if(filter.length>0) {
    	$("#ul").show();
    }
    else {
    	$("#ul").hide();
    }
    
    count=0;
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1 && count<10) {
            li[i].style.display = "";
            count += 1;
        } else {
            li[i].style.display = "none";
        }
    }
}
</script>

</body>
</html>
