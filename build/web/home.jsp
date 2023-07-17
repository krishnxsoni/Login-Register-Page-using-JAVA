
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home | JSP-Page</title>
    </head>
    <body bgcolor="cyan">
        <%
            String username = (String)session.getAttribute("username");
            if(username==null)
            {
                response.sendRedirect("login.html");
            }
        %>
        <h1>Welcome <%=username%>!</h1>
        <form action="logout.jsp">
            <b>Click here to Go-Back : </b><input type="submit"value="Sign-out" />
        </form>
    </body>
</html>
