<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie"%>

<!DOCTYPE html>
<html>
<head>
    <title>Validasi</title>
</head>
<body>

<%

String user = request.getParameter("username");
String pass = request.getParameter("password");

if(user.equals("ADMIN") && pass.equals("ADMIN"))
{

    session.setAttribute("userLogin", user);

    session.setMaxInactiveInterval(60*60*24);

    Cookie ck = new Cookie("user", user);

    ck.setMaxAge(60*60*24);

    response.addCookie(ck);

%>

<h2>LOGIN BERHASIL</h2>

Username :
<%=user%>

<%

}
else
{

%>

<h2>LOGIN GAGAL</h2>

<%

}

%>

</body>
</html>