/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.SalaDAO;
import aplicacion.datos.hibernate.dao.imp.SalaDAOImp;
import aplicacion.modelo.dominio.Sala;
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
public class SalaBean implements Serializable{

    /**
     * Creates a new instance of SalaBean
     */
    public SalaBean() {
    }
    
    public void agregar(Sala unaSala){
        SalaDAO sDAO=new SalaDAOImp();
        sDAO.agregar(unaSala);
    }
    
    public List<Sala> listar(){
        SalaDAO sDAO=new SalaDAOImp();
        return sDAO.obtenerTodos();
    }
    
    public void modificar(Sala unaSala){
        SalaDAO sDAO=new SalaDAOImp();
        sDAO.modificar(unaSala);
    }
    
    public Sala validar(int codBuscado){
        Sala s=null;
        SalaDAO sDAO=new SalaDAOImp();
        s=sDAO.consulta(codBuscado);
        return s;
    }
    
}
