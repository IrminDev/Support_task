<%-- 
    Document   : error
    Created on : 2/06/2022, 09:34:10 PM
    Author     : Moni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        HttpSession objError = request.getSession();
        String e = objError.getAttribute("error").toString();
    %>
    <body>
        <h1><% out.print(e); %></h1>
    </body>
</html>
