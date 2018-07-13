/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.ButacaDAO;
import aplicacion.datos.hibernate.dao.imp.ButacaDAOImp;
import aplicacion.modelo.dominio.Butaca;
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
public class ButacaBean implements Serializable{

    /**
     * Creates a new instance of ButacaBean
     */
    public ButacaBean() {
    }
    
    public void agregar(Butaca unaButaca){
        ButacaDAO bDAO=new ButacaDAOImp();
        bDAO.agregar(unaButaca);
    }
    
    public List<Butaca> listar(Sala unaSala){
        ButacaDAO bDAO=new ButacaDAOImp();
        return bDAO.obtenerTodos(unaSala);
    }
    
    public List<Butaca> listarTodos(){
        ButacaDAO bDAO=new ButacaDAOImp();
        return bDAO.obtenerTudos();
    }

    
    public void modificar(Butaca unaButaca){
        ButacaDAO bDAO=new ButacaDAOImp();
        bDAO.modificar(unaButaca);
    }
    
    public Butaca validar(int codBuscado){
        Butaca b=null;
        ButacaDAO bDAO=new ButacaDAOImp();
        b=bDAO.consulta(codBuscado);
        return b;
    }
    
}
