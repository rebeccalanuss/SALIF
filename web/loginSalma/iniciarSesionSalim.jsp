<%-- 
    Document   : iniciarSesionSalim
    Created on : 5/06/2019, 11:41:03 AM
    Author     : BELTRAN PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%String context = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>SALMA TMX</title>
        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="http://temixco.gob.mx/wp-content/uploads/2019/01/logo-jpg-01-1.jpg" alt="sing up image"></figure>

                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Iniciar Sesión</h2>
                        <s:form action="iniciarSesion" theme="simple">                    
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input required type="text" name="usuario.nombreUsuario" id="your_name" placeholder="usuario"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input required type="password" name="usuario.contrasena" id="your_pass" placeholder="contraseña"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />

                            </div>
                            <div class="form-group form-button">
                                <center></center>
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Entrar"/>
                                <br><br>
                                <a href="olvideContraSalim.jsp" class="signup-image-link">¿Olvidaste tu contraseña?</a>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
        </section>


        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
