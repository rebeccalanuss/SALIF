/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.estado;

/**
 *
 * @author Oscar Rodríguez
 */
public class BeanEstado {
    
    private int idEstado_licencia;
    private String estado;
    private String descriocion;

    public int getIdEstado_licencia() {
        return idEstado_licencia;
    }

    public void setIdEstado_licencia(int idEstado_licencia) {
        this.idEstado_licencia = idEstado_licencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescriocion() {
        return descriocion;
    }

    public void setDescriocion(String descriocion) {
        this.descriocion = descriocion;
    }
    
}
