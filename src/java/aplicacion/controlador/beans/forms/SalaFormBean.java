/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.SalaBean;
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
public class SalaFormBean implements Serializable{
    @ManagedProperty(value="#{salaBean}")
    private SalaBean salaBean;
    private int codBuscado;
    private String desc,nombre;
    private List<Sala> listaSala;
    private Sala unaSala;

    /**
     * Creates a new instance of SalaFormBean
     */
    public SalaFormBean() {
        salaBean=new SalaBean();
        listarSala();
    }

    private void listarSala() {
        setListaSala(getSalaBean().listar());
    }
    
    public void establecer(Sala s){
        setUnaSala(s);
    }
   
    public void buscar(){
        setUnaSala(getSalaBean().validar(getCodBuscado()));
    }
    
    public void agregar(){
        setUnaSala(new Sala(getNombre(),getDesc(),true));
        try{
            getSalaBean().agregar(getUnaSala());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","La sala no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Realizado","Sala agregada con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarSala();
    }
    
    public void eliminar(){
        getUnaSala().setSalEstado(false);
        getSalaBean().modificar(getUnaSala());
        listarSala();
    }
    
    public void modificar(){
        getSalaBean().modificar(getUnaSala());
        listarSala();
    }

    /**
     * @return the salaBean
     */
    public SalaBean getSalaBean() {
        return salaBean;
    }

    /**
     * @param salaBean the salaBean to set
     */
    public void setSalaBean(SalaBean salaBean) {
        this.salaBean = salaBean;
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
     * @return the listaSala
     */
    public List<Sala> getListaSala() {
        return listaSala;
    }

    /**
     * @param listaSala the listaSala to set
     */
    public void setListaSala(List<Sala> listaSala) {
        this.listaSala = listaSala;
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
