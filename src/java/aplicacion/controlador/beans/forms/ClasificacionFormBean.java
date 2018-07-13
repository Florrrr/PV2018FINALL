/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ClasificacionBean;
import aplicacion.modelo.dominio.Clasificacion;
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
public class ClasificacionFormBean implements Serializable{
    @ManagedProperty(value="#{clasificacionBean}")
    private ClasificacionBean clasificacionBean;
    private int codBuscado;
    private String desc;
    private List<Clasificacion> listaClasificacion;
    private Clasificacion unaClasificacion;

    /**
     * Creates a new instance of ClasificacionFormBean
     */
    public ClasificacionFormBean() {
        clasificacionBean=new ClasificacionBean();
        listarClasificaciones();
    }
    
    private void listarClasificaciones(){
        setListaClasificacion(clasificacionBean.listar());
    }
    
    public void establecer(Clasificacion c){
        setUnaClasificacion(c);
    }
   
    public void buscar(){
        setUnaClasificacion(getClasificacionBean().validar(getCodBuscado()));
    }
    
    public void agregar(){
        setUnaClasificacion(new Clasificacion(getDesc(),true));
        try{
            getClasificacionBean().agregar(getUnaClasificacion());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","La clasificacion no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Realizado","Clasificacion agregada con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarClasificaciones();
    }
    
    public void eliminar(){
        getUnaClasificacion().setClaEstado(false);
        getClasificacionBean().modificar(getUnaClasificacion());
        listarClasificaciones();
    }
    
    public void modificar(){
        getClasificacionBean().modificar(getUnaClasificacion());
        listarClasificaciones();
    }


    /**
     * @return the clasificacionBean
     */
    public ClasificacionBean getClasificacionBean() {
        return clasificacionBean;
    }

    /**
     * @param clasificacionBean the clasificacionBean to set
     */
    public void setClasificacionBean(ClasificacionBean clasificacionBean) {
        this.clasificacionBean = clasificacionBean;
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
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the listaClasificacion
     */
    public List<Clasificacion> getListaClasificacion() {
        return listaClasificacion;
    }

    /**
     * @param listaClasificacion the listaClasificacion to set
     */
    public void setListaClasificacion(List<Clasificacion> listaClasificacion) {
        this.listaClasificacion = listaClasificacion;
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
