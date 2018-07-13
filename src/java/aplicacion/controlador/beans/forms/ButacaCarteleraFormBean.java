/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ButacaCarteleraBean;
import aplicacion.modelo.dominio.Butaca;
import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Cartelera;
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
public class ButacaCarteleraFormBean {
    @ManagedProperty(value="#{butacaCarteleraBean}")
    private ButacaCarteleraBean butacaCarteleraBean;
    private int codBuscado;
    private String id;
    private List<ButacaCartelera> listaButacaCartelera;
    private ButacaCartelera unaButacaCartelera;
    private Cartelera unaCartelera;
    private boolean disp;
    private Butaca unaButaca;
    
    
    /**
     * Creates a new instance of ButacaCarteleraFormBean
     */
    public ButacaCarteleraFormBean() {
        unaButacaCartelera=new ButacaCartelera();
        butacaCarteleraBean=new ButacaCarteleraBean();
        listarButacaCartelera();
    }

    private void listarButacaCartelera() {
        setListaButacaCartelera(getButacaCarteleraBean().listar());
    }
    
    public void establecer(ButacaCartelera bc){
        setUnaButacaCartelera(bc);
    }
   
    public void buscar(){
        setUnaButacaCartelera(getButacaCarteleraBean().validar(getCodBuscado()));
    }
    
    public void agregar(){
        setUnaButacaCartelera(new ButacaCartelera(getId(),isDisp(),true,getUnaCartelera()));
        try{
            getButacaCarteleraBean().agregar(getUnaButacaCartelera());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","La butaca de la Cartelera no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Realizado","Butaca de Cartelera agregada con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarButacaCartelera();
    }
    
    public void eliminar(){
        getUnaButacaCartelera().setBcEstado(false);
        getButacaCarteleraBean().modificar(getUnaButacaCartelera());
        listarButacaCartelera();
    }
    
    public void modificar(){
        getButacaCarteleraBean().modificar(getUnaButacaCartelera());
        listarButacaCartelera();
    }

    /**
     * @return the butacaCarteleraBean
     */
    public ButacaCarteleraBean getButacaCarteleraBean() {
        return butacaCarteleraBean;
    }

    /**
     * @param butacaCarteleraBean the butacaCarteleraBean to set
     */
    public void setButacaCarteleraBean(ButacaCarteleraBean butacaCarteleraBean) {
        this.butacaCarteleraBean = butacaCarteleraBean;
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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the listaButacaCartelera
     */
    public List<ButacaCartelera> getListaButacaCartelera() {
        return listaButacaCartelera;
    }

    /**
     * @param listaButacaCartelera the listaButacaCartelera to set
     */
    public void setListaButacaCartelera(List<ButacaCartelera> listaButacaCartelera) {
        this.listaButacaCartelera = listaButacaCartelera;
    }

    /**
     * @return the unaButacaCartelera
     */
    public ButacaCartelera getUnaButacaCartelera() {
        return unaButacaCartelera;
    }

    /**
     * @param unaButacaCartelera the unaButacaCartelera to set
     */
    public void setUnaButacaCartelera(ButacaCartelera unaButacaCartelera) {
        this.unaButacaCartelera = unaButacaCartelera;
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
     * @return the disp
     */
    public boolean isDisp() {
        return disp;
    }

    /**
     * @param disp the disp to set
     */
    public void setDisp(boolean disp) {
        this.disp = disp;
    }

    /**
     * @return the unaButaca
     */
    public Butaca getUnaButaca() {
        return unaButaca;
    }

    /**
     * @param unaButaca the unaButaca to set
     */
    public void setUnaButaca(Butaca unaButaca) {
        this.unaButaca = unaButaca;
    }
    
}
