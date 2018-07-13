/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.PelDirDAO;
import aplicacion.datos.hibernate.dao.imp.PelDirDAOImp;
import aplicacion.modelo.dominio.PelDir;
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
public class PelDirBean implements Serializable{

    /**
     * Creates a new instance of PelDirBean
     */
    public PelDirBean() {
    }
    
    public void agregar(PelDir unaPelDir){
        PelDirDAO pdDAO=new PelDirDAOImp();
        pdDAO.agregar(unaPelDir);
    }
    
    public List<PelDir> listar(){
        PelDirDAO pdDAO=new PelDirDAOImp();
        return pdDAO.obtenerTodos();
    }
    
    public void modificar(PelDir unaPelDir){
        PelDirDAO pdDAO=new PelDirDAOImp();
        pdDAO.modificar(unaPelDir);
    }
    
    public PelDir validar(int codBuscado){
        PelDir pd=null;
        PelDirDAO pdDAO=new PelDirDAOImp();
        pd=pdDAO.consulta(codBuscado);
        return pd;
    }
    
}
