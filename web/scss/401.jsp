<%-- 
    Document   : 401
    Created on : 26/10/2018, 12:15:16 PM
    Author     : CDS
--%>
<%
    String context = request.getContextPath();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body style="background-color: #220C18">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 text-center">
                    <img src="<%=context%>/img/401.gif" style="width:300px;height:300px;" class="img-fluid"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                        <h1 style="color: white;">ERROR 401</h1>
                        <h4 style="color: white;">Al parecer no has iniciado sesión. <a href="<%=context%>/index">Inicia ahora.</a></h4>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>