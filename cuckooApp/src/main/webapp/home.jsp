<!DOCTYPE html>
<html lang="en">
<head>
<title>Cuckoo</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style.css">
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
  <a href="#" class = "active">Home</a>
  <a href="library.jsp">Library</a>
  <a href="recommended.jsp">Recommended</a>
  <a href="login.html" class="right">Logout</a>
  <a href="#" class="right"><%=user.getName()%></a>
</div>

<div class="background">

  <div class="side">
    <h2>The site for the absolute music</h2>
    <img src="images/note.jpg" style="width:300px;height:150px;border-radius: 150px;">
    <p>This site offers the best navigation among thousands of songs that are currently <br>
    released. You can make your own playlists and enjoy your favorite songs completely free.<br>
    Get ready to taste the ultimate experience and get to grips with the limitless <br>
    possibilities offered by the Cuckoo.<br><br/>
	
	</p>
    <h3>Quotes that represent us</h3>
     <img src="images/quote.jpg" style="width:300px;height:250px;border-radius: 40px;"><br/><br/><br/><br/><br/>
     <img src="images/quote2.png" style="width:300px;height:250px;border-radius: 40px;"><br/><br/><br/><br/><br/>
     <img src="images/quote3.jpg" style="width:300px;height:250px;border-radius: 40px;"><br/><br/><br/><br/><br/>
  </div>
  <div class="main">
    <h2>Songs</h2>
    <h5>The site has available all the hits of 2019</h5>
    <img src="images/hits.jpg" style="width:600px;height:400px;border-radius: 60px;"><br/>
    <p>NEW HITS &amp; TOP VIRAL 2019 Pop Songs. Top 100 Hits Playlist : The most hottest songs hitting the charts. 2019 - 2020 Weekly Pop Songs / Hip Hop &amp; Rap, EDM Songs.</p>
    <br>
    <h2>Albums</h2>
    <h5>Title description, Sep 2, 2017</h5>
    <img src="images/album.jpg" style="width:600px;height:400px;border-radius: 60px;"><br/>
    <p>The following is a list of albums released or scheduled for release in 2019. The albums should be notable which is defined as significant coverage from reliable sources that are independent of the subject.</p>
  </div>

  <div class="contact">
    <h2>Contact us:</h2>
    <a href="https://www.facebook.com/" class="fa fa-facebook"></a>
    <a href="https://twitter.com/" class="fa fa-twitter"></a>
    <a href="https://github.com/" class="fa fa-github"></a>
    <a href="https://www.linkedin.com/" class="fa fa-linkedin"></a>
  </div>

</div>
</body>
</html>