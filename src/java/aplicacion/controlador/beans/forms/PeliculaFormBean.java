/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PeliculaBean;
import aplicacion.modelo.dominio.Clasificacion;
import aplicacion.modelo.dominio.Director;
import aplicacion.modelo.dominio.PelCla;
import aplicacion.modelo.dominio.PelDir;
import aplicacion.modelo.dominio.Pelicula;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author CX
 */
@ManagedBean
@ViewScoped
public class PeliculaFormBean implements Serializable{
    @ManagedProperty(value="#{peliculaBean}")
    private PeliculaBean peliculaBean;
    private int codBuscado;
    private String nombre;
    private String descripcion;
    private List<Pelicula> listaPeliculas;
    private Pelicula unaPelicula;
    private Director unDirector;
    private Clasificacion unaClasificacion;
    
    /**
     * Creates a new instance of PeliculaFormBean
     */
    public PeliculaFormBean() {
        peliculaBean=new PeliculaBean();
        listarPeliculas();
    }
    
    private void listarPeliculas() {
        setListaPeliculas(getPeliculaBean().listarPeliculas());
    }
    
    public void establecerPelicula(Pelicula pel){
        setUnaPelicula(pel);
    }
   
    public void buscarPelicula(){
        setUnaPelicula(getPeliculaBean().validarPelicula(getCodBuscado()));
    }
    
    public void agregarPelicula(){
        setUnaPelicula(new Pelicula(getNombre(),getDescripcion(),true));
        try{
            getPeliculaBean().agregarPelicula(getUnaPelicula());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","La pelicula no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Felicidades!","Pelicula agregada con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarPeliculas();
    }
    
    public void conectar(){
        PelDir peldir=new PelDir(unaPelicula,unDirector,true);
        PelCla pelcla=new PelCla(unaPelicula,true,unaClasificacion);
        try{
            getPeliculaBean().conectar(peldir,pelcla);
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","La pelicula no se ha podido conectar");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Felicidades!","Pelicula actualizada con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarPeliculas();
    }
    
    public void eliminarPelicula(){
        getUnaPelicula().setPelEstado(false);
        getPeliculaBean().modificarPelicula(getUnaPelicula());
        listarPeliculas();
    }
    
    public void modificarPelicula(){
        getPeliculaBean().modificarPelicula(getUnaPelicula());
        listarPeliculas();
    }

    /**
     * @return the peliculaBean
     */
    public PeliculaBean getPeliculaBean() {
        return peliculaBean;
    }

    /**
     * @param peliculaBean the peliculaBean to set
     */
    public void setPeliculaBean(PeliculaBean peliculaBean) {
        this.peliculaBean = peliculaBean;
    }

    /**
     * @return the codBuscado
     */
    public int getCodBuscado() {
        return codBuscado;
    }

    /**
     * @param codBuscado the codBuscado to set
     */
    public void setCodBuscado(int codBuscado) {
        this.codBuscado = codBuscado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the listaPeliculas
     */
    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    /**
     * @param listaPeliculas the listaPeliculas to set
     */
    public void setListaPeliculas(List<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    /**
     * @return the unaPelicula
     */
    public Pelicula getUnaPelicula() {
        return unaPelicula;
    }

    /**
     * @param unaPelicula the unaPelicula to set
     */
    public void setUnaPelicula(Pelicula unaPelicula) {
        this.unaPelicula = unaPelicula;
    }

    /**
     * @return the unDirector
     */
    public Director getUnDirector() {
        return unDirector;
    }

    /**
     * @param unDirector the unDirector to set
     */
    public void setUnDirector(Director unDirector) {
        this.unDirector = unDirector;
    }

    /**
     * @return the unaClasificacion
     */
    public Clasificacion getUnaClasificacion() {
        return unaClasificacion;
    }

    /**
     * @param unaClasificacion the unaClasificacion to set
     */
    public void setUnaClasificacion(Clasificacion unaClasificacion) {
        this.unaClasificacion = unaClasificacion;
    }
    
}
