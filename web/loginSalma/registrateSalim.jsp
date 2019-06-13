<%-- 
    Document   : registrateSalim
    Created on : 5/06/2019, 11:43:10 AM
    Author     : BELTRAN PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">¡Regístrate!</h2>
                        <form method="POST" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input required type="text" name="name" id="name" placeholder="Nombre Completo"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input required type="email" name="email" id="email" placeholder="Correo Electronico"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input required type="password" name="pass" id="pass" placeholder="Contraseña"/>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input required type="password" name="re_pass" id="re_pass" placeholder="Repetir Contraseña"/>
                            </div>
                            <div class="form-group">
                                <input required type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>Acepto politicas y condiciones de privacidad<a href="#" class="term-service"></a></label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Registrarme"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="http://temixco.gob.mx/wp-content/uploads/2019/01/logo-jpg-01-1.jpg" alt="sing up image"></figure>
                        <a href="iniciarSesion.html" class="signup-image-link">¿Ya estás registrado? Inicias sesión...</a>
                    </div>
                </div>
            </div>
        </section>



        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
