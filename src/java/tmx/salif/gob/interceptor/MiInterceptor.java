/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import tmx.salif.gob.model.login.Permiso;

import tmx.salif.gob.model.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author CDS
 */
public class MiInterceptor implements Interceptor {

    @Override
    public void destroy() {
        System.out.println(" Destruyendo interceptor.. ");
    }

    @Override
    public void init() {
        System.out.println(" Construyendo interceptor.. ");
    }

    @Override
    public String intercept(ActionInvocation action) throws Exception {
        String respuesta = "";
        try {
            Map sesion = ActionContext.getContext().getSession();
            Usuario usuario = (Usuario) sesion.get("usuarioLogeado");
            // Obtener el action que se ejecuta
            String actionEjecutandose = ActionContext.getContext().get(ActionContext.ACTION_NAME).toString();
           
            System.out.println(usuario);
            if (usuario == null) {
                respuesta = "NoLogeado";
            } else {
                List<Permiso> permisos = new ArrayList<Permiso>();
                permisos = usuario.getRoles().get(0).getPermisos();

                // Accediendo a permisos y comparando
                for (int i = 0; i < permisos.size(); i++) {
                    if (permisos.get(i).getClave().equals(actionEjecutandose)) {
                        respuesta = action.invoke();
                        break;
                    } else {
                        respuesta = "SinPermiso";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("-> "+e);
            respuesta = "error";
        }
        return respuesta;
    }

}
