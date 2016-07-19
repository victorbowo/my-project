<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<s:if test="#session.login ==  null">
<jsp:forward page="index.jsp"/>
</s:if>
<title>BrownGeek File Sharing</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout.css" type="text/css" />
</head>
<body id="top">
<div id="header">
  <div class="wrapper">
    <div class="fl_left">
      <h1><a href="index.jsp"><img src= "h.png"></a></h1>
      <p>&nbsp;The place where people share</p>
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
        <fieldset>
          <legend>Site Search</legend>
          <s:form action="searchFiles">
	          <input type="text" value="Search for files" name="fileName"/>
	          <input type="submit" name="go" id="go" value="Search"/>
          </s:form>
        </fieldset>
    </div>
    <br class="clear" />
  </div>
</div>
<div id="homecontent">
  <div class="wrapper">
   <table>
   <thead>
      <tr>
         <th width=300>File Name</th>
         <th colspan="2">Operations</th>
      </tr>
      </thead>
      <s:url id="fileDownload" namespace="/" action="downloadFile" ></s:url>
      <s:iterator value="files">
      <tbody>
      	<tr>	
      		<td><s:property value="%{filename}"/></td>
			<td align="center">
				<s:form name="myForm" action="downloadFile">
					<s:hidden name="fileName" value="%{filename}"/>
					<input type="submit" value="download"/>
				</s:form>
			</td> 	
			<td>
				<s:form action="deleteFiles">
					<s:hidden name="fileName" value="%{filename}"/>
					<s:if test="#session.level == 0">
					<input type="submit" value="delete" disabled/>
					</s:if>
					<s:if test="#session.level == 1">
					<input type="submit" value="delete"/>
					</s:if>
				</s:form>
			</td>
      	</tr>
      	</tbody>
      	</s:iterator>
   </table>
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
</html>
