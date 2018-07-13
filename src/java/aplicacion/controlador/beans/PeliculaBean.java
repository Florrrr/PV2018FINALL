/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.PelClaDAO;
import aplicacion.datos.hibernate.dao.PelDirDAO;
import aplicacion.datos.hibernate.dao.PeliculaDAO;
import aplicacion.datos.hibernate.dao.imp.PelClaDAOImp;
import aplicacion.datos.hibernate.dao.imp.PelDirDAOImp;
import aplicacion.datos.hibernate.dao.imp.PeliculaDAOImp;
import aplicacion.modelo.dominio.PelCla;
import aplicacion.modelo.dominio.PelDir;
import aplicacion.modelo.dominio.Pelicula;
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
public class PeliculaBean implements Serializable{

    /**
     * Creates a new instance of PeliculaBean
     */
    public PeliculaBean() {
    }
    
    public void agregarPelicula(Pelicula unaPelicula){
        PeliculaDAO peliculaDAO=new PeliculaDAOImp();
        peliculaDAO.agregar(unaPelicula);
    }
    
    public void conectar(PelDir unaPelDir,PelCla unaPelCla){
        PelDirDAO peldirDAO=new PelDirDAOImp();
        PelClaDAO pelclaDAO=new PelClaDAOImp();
        pelclaDAO.agregar(unaPelCla);
        peldirDAO.agregar(unaPelDir);
    }
    
    public List<Pelicula> listarPeliculas(){
        PeliculaDAO peliculaDAO=new PeliculaDAOImp();
        return peliculaDAO.obtenerTodos();
    }
    
    public void modificarPelicula(Pelicula unaPelicula){
        PeliculaDAO peliculaDAO=new PeliculaDAOImp();
        peliculaDAO.modificar(unaPelicula);
    }
    
    public Pelicula validarPelicula(int codBuscado){
        Pelicula pelicula=null;
        PeliculaDAO peliculaDAO=new PeliculaDAOImp();
        pelicula=peliculaDAO.consulta(codBuscado);
        return pelicula;
    }
    
}
