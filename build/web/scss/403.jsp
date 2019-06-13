<%-- 
    Document   : 403
    Created on : 28/10/2018, 11:40:23 AM
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
    <body style="background-color: #F35460">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 text-center">
                    <img src="<%=context%>/img/403.gif" style="width:300px;height:300px;" class="img-fluid"/>
                    <h4>Al parecer no tienes permiso de acceso a está página. <a href="<%=context%>/home">Regresa al inicio.</a></h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                        <h1>ERROR 403</h1>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
