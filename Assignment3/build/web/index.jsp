<%-- 
    Document   : index
    Created on : 2018-11-5, 14:03:57
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>User Login</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>

    <body>
  	<p> </p>
        <div class="container">
            <form action="LoginServlet" method="post">
                <label for="basic-url">Username</label>
                <div class="input-group mb-3 col-md-3 col-sm-10">
                    <input type="text" name="username" class="form-control" placeholder="Please input your Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <label for="basic-url">Password</label>
                <div class="input-group mb-3 col-md-3 col-sm-10">
                    <input type="password" name="password" class="form-control" placeholder="Please input your Password" aria-label="Username" aria-describedby="basic-addon1">
                </div>
                <p> </p>
                <div class="row">
                <input type="submit" class="btn btn-secondary col-md-1 col-sm-10" value="Login"> 
                <p class="col-md-1"> </p>
            </form>
            
            <a href="register.jsp" class="btn btn-secondary col-md-1 col-sm-10">Register</a>
            </div>
            
        </div>
    </body>
</html>
