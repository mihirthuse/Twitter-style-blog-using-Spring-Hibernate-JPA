
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.csuf.Blog"%>
<%@ page import="java.util.List"%>
<%
	@SuppressWarnings("unchecked")
	/*  Map<Integer, Blog> blogDatabase =
	(Map<Integer, Blog>)request.getAttribute("blogDatabase"); */
	List<Blog> blogDatabase = (List<Blog>) request.getAttribute("blogDatabase");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Home Page</title>
</head>
<body>
	<div id="bodydiv">
		<div class="maindiv" id="maindiv">
			<div id="header" class="header">
				<h4>Bloggers</h4>
			</div>
			<div id="maincontent" class="maincontent">
				<div class="blogcontent">
					<script type="text/javascript">
						function callServlet() {
							document.location.href = "\login";
						}
					</script>
					<a href="#" onclick="callServlet()" name="login"> Login </a>
					<p style="font-size: 24px; font-weight: bold;">Recent Blogs
					<p>
						<br>
						<%
							int total = (int) request.getAttribute("total");
						%>
						<%
							if (total == 0) {
						%><i>there are no posts available</i>
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