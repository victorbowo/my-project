<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>BrownGeek File Sharing</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout.css" type="text/css" />
</head>
<body id="top">
<div id="header">
  <div class="wrapper">
    <div class="fl_left">
      <h1><a href="index.jsp"><img src= "h.png"></a></h1>
      <p>&nbspThe place where people share</p>
    </div>
    <br class="clear" />
  </div>
</div>

<div id="topbar">
  <div class="wrapper">
    <div id="topnav">
      <ul>
        <li><a href="index.jsp">Home</a></li>
        <s:if test="#session.login !=  null">
        <li><a href="upload.jsp">Upload</a></li>
        <li><a href="listDownloads">Download</a></li>
		</s:if>
		<s:if test="#session.login ==  null">
        <li><a href="#">Member</a>
          <ul>
            <li><a href="register.jsp">Register</a></li>
            <li><a href="login.jsp">Login</a></li>
          </ul>
        </li>
        </s:if>
        <s:if test="#session.login !=  null">
        	<li><a href="profile">Profile</a></li>
        	<li><a href="logout">Logout</a></li>
        </s:if>
      </ul>
    </div>
    <div id="search">
  		<!-- Not available in this page -->
    </div>
    <br class="clear" />
  </div>
</div>
<div id="homecontent">
  <div class="wrapper">
    <ul>
      <li>
        <h2 class="title">About our website</h2>
        <p align="justify">&nbsp;&nbsp;&nbsp;What if big business could move at start-up speed? What if files could be openly shared, yet fully secure? What if scaling too fast was an opportunity, not an issue? File sharing has been a feature of mainframe and multi-user computer systems for many years. It is easier than ever to share and secure personal data with Browngeek. Browngeek makes data handling as easy as switching on the light. People have trusted us to share files since 2014, and we see to it that the service we provide is easy to use and reliable. Whether you have small or very large files, no matter in which format or on which platform your files are available to you anytime, anywhere. That is what our Browngeek file sharing website is all about.</p>
      </li>
      <li>
        <h2 class="title">BrownGeek Company</h2>
        <p align="justify">&nbsp;&nbsp;&nbsp;We founded Browngeek back in 2014. Defying "possible." Turning "what if" into "what can be." Using the power of Browngeek to make your business perform like never before. No matter what business you're in. You're in good company; Browngeek is already helping companies like yours to become more productive every day.  Why? Because we're passionate about file delivery and determined to provide the best service we can through our hard work. We value our users, and their feedback is always welcome. We read every message because it's part of our commitment to be the best we can.</p>
      </li>
      <li class="last">
      	<h2 class="title">Our Mascot</h2>
      	<p><img src="Lighthouse.jpg" style="width:290px;height:300px"></p>
      </li>
    </ul>
    <br class="clear" />
  </div>
</div>
<div id="footer">
  <div class="wrapper">
    <div id="newsletter">
      <h2>Stay with us!</h2>
      <p>Please enter your email to join our mailing list</p>
      <form action="#" method="post">
        <fieldset>
          <legend>News Letter</legend>
          <input type="text" value="Enter Email Here&hellip;"  onfocus="this.value=(this.value=='Enter Email Here&hellip;')? '' : this.value ;" />
          <input type="submit" name="news_go" id="news_go" value="GO" />
        </fieldset>
      </form>
    </div>
    <div class="footbox">
    </div>
    <div class="footbox">
    </div>
    <div class="footbox">
    </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div id="copyright">
  <div class="wrapper">
    <p class="fl_left">Copyright &copy; 2014 - All Rights Reserved - <a href="#">BrownGeek Company</a></p>
    <br class="clear" />
  </div>
</div>
</body>
</html>
</html>