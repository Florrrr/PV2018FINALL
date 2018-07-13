/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.datos.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Perfil;
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
public class PerfilBean implements Serializable{

    /**
     * Creates a new instance of PerfilBean
     */
    public PerfilBean() {
    }
    
    public void agregarPerfil(Perfil unPerfil){
        PerfilDAO perfilDAO=new PerfilDAOImp();
        perfilDAO.agregar(unPerfil);
    }
    
    public List<Perfil> listarPerfiles(){
        PerfilDAO perfilDAO=new PerfilDAOImp();
        return perfilDAO.obtenerTodos();
    }
    
    public void modificarPerfil(Perfil unPerfil){
        PerfilDAO perfilDAO=new PerfilDAOImp();
        perfilDAO.modificar(unPerfil);
    }
    
    public Perfil validarPerfil(int codBuscado){
        Perfil perfil=null;
        PerfilDAO perfilDAO=new PerfilDAOImp();
        perfil=perfilDAO.consulta(codBuscado);
        return perfil;
    }
    
}
