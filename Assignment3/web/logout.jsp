<%-- 
    Document   : logout
    Created on : 2018-11-5, 16:21:36
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>User Logout</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    
    <body>
        <div class="container">
            <p> </p>
            <h3> success for logout!</h3>
            <p> </p>
            <%session.invalidate();%>
            <a href="index.jsp" class="btn btn-secondary">Return</a>
        </div>

    </body>
</html>
