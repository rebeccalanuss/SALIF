/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.controller;

import tmx.salif.gob.controller.*;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;

import tmx.salif.gob.model.usuario.Usuario;
import tmx.salif.gob.model.login.DaoLogin;
import tmx.salif.gob.model.login.DaoRol;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rogelio
 */
public class ActionLogin {

    private Usuario usuario = new Usuario();
    private String respuesta;
    private List<Usuario> usuarios = new ArrayList<>();
    private DaoLogin dao = new DaoLogin();
    private DaoRol daoR = new DaoRol();

    
    private String mensaje;

   
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public String home() {
        Map sesion = ActionContext.getContext().getSession();
        respuesta = sesion.get("home").toString();
        return SUCCESS;
    }

    public String logout() {
        Map sesion = ActionContext.getContext().getSession();
        sesion.clear();
        respuesta = "Regresa pronto..";
        return SUCCESS;
    }

    public String iniciarSesion() {
     
        usuario = dao.iniciarSesion(usuario.getNombreUsuario(), usuario.getContrasena());
        System.out.println(usuario.getNombreUsuario()+usuario.getContrasena());
        if (usuario.getRoles().size() > 0) {
            Map sesion = ActionContext.getContext().getSession();
            // Dar de alta el usuario a la sesión
            sesion.put("usuarioLogeado", usuario);
            sesion.put("rol", usuario.getRoles().get(0).getRol());
      
//          sesion.put("home", usuario.getRoles().get(0).getRol().equals("Usuario") ? "colsultarHabitacionUsuario" : "consultarUsuario");
            if (usuario.getRoles().get(0).getRol().equals("Licencias")) {
                return "loginLicencias";
            }else if(usuario.getRoles().get(0).getRol().equals("Proteccion Civil")) {
                return "loginProteccionCivil";    
            } else {
//                usuarios = daoU.consultarUsuarios();
//                sesion.put("roles", daoR.consultarRoles());
                return "loginAdministrador";
            }
        } else {
            respuesta = "El usuario y/o contraseña son incorrectas.";
            return "loginError";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
     public String administrador() {
        return SUCCESS;
    }
     public String proteccionCivil() {
        return SUCCESS;
    }
     public String licencias() {
        return SUCCESS;
    }

}
