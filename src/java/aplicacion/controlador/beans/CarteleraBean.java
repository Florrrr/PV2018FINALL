/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.CarteleraDAO;
import aplicacion.datos.hibernate.dao.imp.CarteleraDAOImp;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.Pelicula;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author CX
 */
@ManagedBean
@ViewScoped
public class CarteleraBean implements Serializable{

    /**
     * Creates a new instance of CarteleraBean
     */
    public CarteleraBean() {
    }
    
    public void agregar(Cartelera unaCartelera){
        CarteleraDAO carDAO=new CarteleraDAOImp();
        carDAO.agregar(unaCartelera);
    }
    
    public List<Cartelera> listar(){
        CarteleraDAO carDAO=new CarteleraDAOImp();
        return carDAO.obtenerTodos();
    }
    
    public void modificar(Cartelera unaCartelera){
        CarteleraDAO carDAO=new CarteleraDAOImp();
        carDAO.modificar(unaCartelera);
    }
    
    public Cartelera validar(Pelicula unaPelicula, Date unaFecha){
        Cartelera car=null;
        CarteleraDAO carDAO=new CarteleraDAOImp();
        car=carDAO.consulta(unaPelicula,unaFecha);
        return car;
    }
    
}
