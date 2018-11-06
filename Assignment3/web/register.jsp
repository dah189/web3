<%-- 
    Document   : register
    Created on : 2018-11-5, 16:59:06
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Register</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    </head>

    <body>
  	<p> </p>
        <div class="container">
            <form action="RegisterServlet" method="post">
                <label for="basic-url">Username</label>
                <div class="input-group mb-3 col-md-3">
                    <input type="text" name="username" class="form-control" placeholder="Please creat your Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <label for="basic-url">Password</label>
                <div class="input-group mb-3 col-md-3">
                    <input type="password" name="password" class="form-control" placeholder="Please creat your Password" aria-label="Password" aria-describedby="basic-addon1">
                </div>
                
                <label for="basic-url">Email</label>
                <div class="input-group mb-3 col-md-3">
                    <input type="text" name="email" class="form-control" placeholder="Please input your Email" aria-label="Email" aria-describedby="basic-addon1">
                </div>
                <p> </p>
            <div class="row">
                <input type="submit" class="btn btn-secondary  col-md-1 col-sm-10" value="Register"> 
                <p class="col-md-1"> </p>
            </form>            
            
            <a href="index.jsp" class="btn btn-secondary col-md-1 col-sm-10">Return</a>
            </div>
        </div>
    </body>
</html>
