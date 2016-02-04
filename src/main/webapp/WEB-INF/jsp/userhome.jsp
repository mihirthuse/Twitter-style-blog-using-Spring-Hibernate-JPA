
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.csuf.Blog"%>
<%@ page import="java.util.List"%>
<%
	@SuppressWarnings("unchecked")
	/*  Map<Integer, Blog> blogDatabase =
	(Map<Integer, Blog>)request.getAttribute("blogDatabase"); */
	List<Blog> blogDatabase = (List<Blog>) request.getAttribute("blogDatabase");
%>
<!-- @SuppressWarnings("unchecked")
    Map<String, ArrayList<Blog>> blogDatabase =
            (Map<String, ArrayList<Blog>>)request.getAttribute("blogDatabase");
String usern=request.getAttribute("username").toString();
ArrayList<Blog> blogList=new ArrayList<Blog>();
if(blogDatabase.get(usern)!=null)
	
{
blogList=new ArrayList<Blog>(blogDatabase.get(usern));
}
 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="homestyle.css">
<title>User home page</title>
</head>
<body>
	<div id="bodydiv">
		<div class="maindiv" id="maindiv">
			<div id="header" class="header">
				<h4>Bloggers</h4>
				<div id="logoutbutton" class="logoutbutton">
					<a href="<c:url value="/login?logout" />">Logout</a>
				</div>
			</div>
			<div id="maincontent" class="maincontent">
				<br />
				<div class="blogcontent">
					<p style="font-weight: bold; font-size: 18px;">
						Welcome,
						<%=request.getAttribute("username")%>
					</p>
					<form method="POST" action="<c:url value="/blog" />">
						Title<br /> <input type="text" name="title" /><br /> <br />
						Description<br /> <input type="text" id="description"
							style="width: 300px;" name="description" maxlength="140" /><br />
						<span id="#characterlimit"
							style="font-style: italic; font-size: 11px;">Not more than
							140 characters</span> <br /> <br /> <input type="submit"
							onclick="validate()" name="submit" id="uploadbutton"
							value="Upload" />
					</form>
					<%
						int total = (int) request.getAttribute("total");
					%>
					<%
						if (total == 0) {
					%><br /> <i>There are no posts available</i>
					<%
						} else {
					%>
					<hr style="margin-right: 20px;">
					<%
						for (Blog display : blogDatabase) {
					%>
					<p>
						<%=display.getUserName()%>
						says,
					</p>

					<i><u><%=display.getTitle()%> </u></i> <br>
					<p>
						<%=display.getDescription()%></p>
					<%=display.getDate()%>
					<hr style="margin-right: 20px;">
					<%
						}
						}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>