/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.ClasificacionDAO;
import aplicacion.datos.hibernate.dao.imp.ClasificacionDAOImp;
import aplicacion.modelo.dominio.Clasificacion;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author CX
 */
@ManagedBean
@ViewScoped
public class ClasificacionBean implements Serializable{

    /**
     * Creates a new instance of ClasificacionBean
     */
    public ClasificacionBean() {
    }
    
    public void agregar(Clasificacion unaClasificacion){
        ClasificacionDAO cDAO=new ClasificacionDAOImp();
        cDAO.agregar(unaClasificacion);
    }
    
    public List<Clasificacion> listar(){
        ClasificacionDAO cDAO=new ClasificacionDAOImp();
        return cDAO.obtenerTodos();
    }
    
    public void modificar(Clasificacion unaClasificacion){
        ClasificacionDAO cDAO=new ClasificacionDAOImp();
        cDAO.modificar(unaClasificacion);
    }
    
    public Clasificacion validar(int codBuscado){
        Clasificacion c=null;
        ClasificacionDAO cDAO=new ClasificacionDAOImp();
        c=cDAO.consulta(codBuscado);
        return c;
    }
}
