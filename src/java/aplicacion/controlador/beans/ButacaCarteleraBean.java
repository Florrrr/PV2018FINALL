/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.ButacaCarteleraDAO;
import aplicacion.datos.hibernate.dao.imp.ButacaCarteleraDAOImp;
import aplicacion.modelo.dominio.ButacaCartelera;
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
public class ButacaCarteleraBean implements Serializable{

    /**
     * Creates a new instance of ButacaCartelera
     */
    public ButacaCarteleraBean() {
    }
    
    public void agregar(ButacaCartelera unaButacaCartelera){
        ButacaCarteleraDAO bcDAO=new ButacaCarteleraDAOImp();
        bcDAO.agregar(unaButacaCartelera);
    }
    
    public List<ButacaCartelera> listar(){
        ButacaCarteleraDAO bcDAO=new ButacaCarteleraDAOImp();
        return bcDAO.obtenerTodos();
    }
    
    public void modificar(ButacaCartelera unaButacaCartelera){
        ButacaCarteleraDAO bDAO=new ButacaCarteleraDAOImp();
        bDAO.modificar(unaButacaCartelera);
    }
    
    public ButacaCartelera validar(int codBuscado){
        ButacaCartelera bc=null;
        ButacaCarteleraDAO bcDAO=new ButacaCarteleraDAOImp();
        bc=bcDAO.consulta(codBuscado);
        return bc;
    }
    
}
