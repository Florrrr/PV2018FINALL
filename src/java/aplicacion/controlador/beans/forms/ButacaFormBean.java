/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ButacaBean;
import aplicacion.modelo.dominio.Butaca;
import aplicacion.modelo.dominio.Sala;
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
public class ButacaFormBean implements Serializable{
    @ManagedProperty(value="#{butacaBean}")
    private ButacaBean butacaBean;
    private int codBuscado;
    private String id;
    private List<Butaca> listaButaca;
    private Butaca unaButaca;
    private Sala unaSala;

    /**
     * Creates a new instance of ButacaFormBean
     */
    public ButacaFormBean() {
        butacaBean=new ButacaBean();
        listarButaca();
    }

    private void listarButaca() {
        setListaButaca(getButacaBean().listarTodos());
    }
    
    public void establecer(Butaca B){
        setUnaButaca(B);
    }
   
    public void buscar(){
        setUnaButaca(getButacaBean().validar(getCodBuscado()));
    }
    
    public void agregar(){
        setUnaButaca(new Butaca(getId(),true,getUnaSala()));
        try{
            getButacaBean().agregar(getUnaButaca());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","La sala no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Realizado","Sala agregada con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarButaca();
    }
    
    public void eliminar(){
        getUnaButaca().setButEstado(false);
        getButacaBean().modificar(getUnaButaca());
        listarButaca();
    }
    
    public void modificar(){
        getButacaBean().modificar(getUnaButaca());
        listarButaca();
    }

    /**
     * @return the butacaBean
     */
    public ButacaBean getButacaBean() {
        return butacaBean;
    }

    /**
     * @param butacaBean the butacaBean to set
     */
    public void setButacaBean(ButacaBean butacaBean) {
        this.butacaBean = butacaBean;
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
     * @return the listaButaca
     */
    public List<Butaca> getListaButaca() {
        return listaButaca;
    }

    /**
     * @param listaButaca the listaButaca to set
     */
    public void setListaButaca(List<Butaca> listaButaca) {
        this.listaButaca = listaButaca;
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
    
}
