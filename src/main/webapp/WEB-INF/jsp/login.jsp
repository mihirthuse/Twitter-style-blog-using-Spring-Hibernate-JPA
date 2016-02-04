<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Bloggers</title>
</head>
<body>
	<div id="bodydiv">
		<div class="maindiv" id="maindiv">
			<div id="header" class="header">
				<h4>Bloggers</h4>
			</div>
			<div id="maincontent" class="maincontent">
				<table>
					<tr>
						<td>
							<div class="logindiv">
								<div class="logincontent">
									<h2 style="font-family: Calibri;">Login</h2>

									<%
										if (((Boolean) request.getAttribute("loginFailed"))) {
									%>
									<b>The username or password you entered are not correct.
										Please try again.</b><br /> <br />
									<%
										}
									%>
									<form method="POST" action="<c:url value="/login" />">
										<span>Username</span><br /> <input type="text"
											name="username"
											style="height: 23px; width: 250px; border-radius: 1px;" /><br />
										<br /> <span>Password</span><br /> <input type="password"
											name="password"
											style="height: 23px; width: 250px; border-radius: 1px;" /><br />
										<br /> <input type="submit" name="submit" value="Log In"
											id="submitbutton" />
									</form>
								</div>
							</div>
						</td>
						<td>
							<div class="signupdiv">
								<div class="signupcontent">
									<h2 style="font-family: Calibri;">Sign Up</h2>
									<%
										try {
											if (((Boolean) request.getAttribute("userExists"))) {
									%>
									<b>Username Exists</b><br /> <br />
									<%
										}
										} catch (Exception e) {
											//System.out.println("Flag not set");
										}
									%>
									<form method="POST" action="<c:url value="/login" />">

										<span>First name</span><br /> <input type="text"
											name="firstname"
											style="height: 23px; width: 250px; border-radius: 1px;" /><br />
										<br> <span>Last name</span><br /> <input type="text"
											name="lastname"
											style="height: 23px; width: 250px; border-radius: 1px;" /><br />
										<br /> <span>Username</span><br /> <input type="text"
											name="username"
											style="height: 23px; width: 250px; border-radius: 1px;" /><br />
										<br /> <span>Password</span><br /> <input type="password"
											name="password"
											style="height: 23px; width: 250px; border-radius: 1px;" /><br />
										<br /> <input type="submit" name="submit" value="Sign up"
											id="submitbutton" />
									</form>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
