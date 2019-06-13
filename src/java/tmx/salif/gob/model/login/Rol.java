
package tmx.salif.gob.model.login;

import tmx.salif.gob.model.login.*;
import java.util.ArrayList;
import java.util.List;

public class Rol {
    private int idRol;
    private String rol;
    private String descripcion;
    private List<Permiso> permisos = new ArrayList<>();

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
