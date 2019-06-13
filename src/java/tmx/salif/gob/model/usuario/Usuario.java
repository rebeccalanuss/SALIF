/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.usuario;
import tmx.salif.gob.bean.usuario.*;
import tmx.salif.gob.model.login.Rol;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rogelio
 */
public class Usuario {
  
    private int idUsuario;
    private String nombreUsuario;
    private String nombres;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String contrasena;
    private String fechaNacimiento;
    private int estado;
    private List<Rol> roles = new ArrayList<>();

    public Usuario(int idUsuario, String nombreUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String contrasena, String fechaNacimiento, int estado) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    

    public Usuario() {
    }

   
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombre) {
        this.nombreUsuario = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

   
    
}


