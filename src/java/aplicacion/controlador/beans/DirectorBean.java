/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;


import aplicacion.datos.hibernate.dao.DirectorDAO;
import aplicacion.datos.hibernate.dao.imp.DirectorDAOImp;
import aplicacion.modelo.dominio.Director;
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
public class DirectorBean implements Serializable{

    /**
     * Creates a new instance of DirectorBean
     */
    public DirectorBean() {
    }
    
    public void agregar(Director unDirector){
        DirectorDAO directorDAO=new DirectorDAOImp();
        directorDAO.agregar(unDirector);
    }
    
    public List<Director> listar(){
        DirectorDAO directorDAO=new DirectorDAOImp();
        return directorDAO.obtenerTodos();
    }
    
    public void modificar(Director unDirector){
        DirectorDAO dDAO=new DirectorDAOImp();
        dDAO.modificar(unDirector);
    }
    
    public Director validar(int codBuscado){
        Director d=null;
        DirectorDAO dDAO=new DirectorDAOImp();
        d=dDAO.consulta(codBuscado);
        return d;
    }
    
}
