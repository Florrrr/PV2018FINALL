/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.CarteleraBean;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.Pelicula;
import aplicacion.modelo.dominio.Sala;
import java.io.Serializable;
import java.util.Date;
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
public class CarteleraFormBean implements Serializable{
    @ManagedProperty(value="#{carteleraBean}")
    private CarteleraBean carteleraBean;
    private int codBuscado;
    private String horario;
    private double precio;
    private Pelicula unaPelicula;
    private Sala unaSala;
    private Cartelera unaCartelera;
    private Date fecha;
    private List<Cartelera> listaCartelera;
    private Pelicula buscPelicula;
    private Date fechaBusc;
    
    /**
     * Creates a new instance of CarteleraFormBean
     */
    public CarteleraFormBean() {
        carteleraBean=new CarteleraBean();
        listarCartelera();
    }

    private void listarCartelera() {
        setListaCartelera(getCarteleraBean().listar());
    }
    
    public void establecer(Cartelera car){
        setUnaCartelera(car);
    }
   
    public void buscar(){
        setUnaCartelera(getCarteleraBean().validar(buscPelicula,fechaBusc));
    }
    
    public void agregar(){
        setUnaCartelera(new Cartelera(getUnaPelicula(),getUnaSala(),getFecha(),getHorario(),getPrecio(),true));
        try{
            getCarteleraBean().agregar(getUnaCartelera());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","La cartelera no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Realizado","Cartelera agregada con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarCartelera();
    }
    
    public void eliminar(){
        getUnaCartelera().setCarEstado(false);
        getCarteleraBean().modificar(getUnaCartelera());
        listarCartelera();
    }
    
    public void modificar(){
        getCarteleraBean().modificar(getUnaCartelera());
        listarCartelera();
    }

    /**
     * @return the carteleraBean
     */
    public CarteleraBean getCarteleraBean() {
        return carteleraBean;
    }

    /**
     * @param carteleraBean the carteleraBean to set
     */
    public void setCarteleraBean(CarteleraBean carteleraBean) {
        this.carteleraBean = carteleraBean;
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
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
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
     * @return the unaSala
     */
    public Sala getUnaSala() {
        return unaSala;
    }

    /**
     * @param unaSala the unaSala to set
     */
    public void setUnaSala(Sala unaSala) {
        this.unaSala = unaSala;
    }

    /**
     * @return the unaCartelera
     */
    public Cartelera getUnaCartelera() {
        return unaCartelera;
    }

    /**
     * @param unaCartelera the unaCartelera to set
     */
    public void setUnaCartelera(Cartelera unaCartelera) {
        this.unaCartelera = unaCartelera;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the listaCartelera
     */
    public List<Cartelera> getListaCartelera() {
        return listaCartelera;
    }

    /**
     * @param listaCartelera the listaCartelera to set
     */
    public void setListaCartelera(List<Cartelera> listaCartelera) {
        this.listaCartelera = listaCartelera;
    }

    /**
     * @return the buscPelicula
     */
    public Pelicula getBuscPelicula() {
        return buscPelicula;
    }

    /**
     * @param buscPelicula the buscPelicula to set
     */
    public void setBuscPelicula(Pelicula buscPelicula) {
        this.buscPelicula = buscPelicula;
    }

    /**
     * @return the fechaBusc
     */
    public Date getFechaBusc() {
        return fechaBusc;
    }

    /**
     * @param fechaBusc the fechaBusc to set
     */
    public void setFechaBusc(Date fechaBusc) {
        this.fechaBusc = fechaBusc;
    }
    
}
