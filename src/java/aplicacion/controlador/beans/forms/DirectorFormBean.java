/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;


import aplicacion.controlador.beans.DirectorBean;
import aplicacion.modelo.dominio.Director;
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
public class DirectorFormBean implements Serializable{
    @ManagedProperty(value="#{directorBean}")
    private DirectorBean directorBean;
    private int codBuscado;
    private String nombres;
    private String apellidos;
    private List<Director> listaDirectores;
    private Director unDirector;
    
    
    /**
     * Creates a new instance of DirectorFormBean
     */
    public DirectorFormBean() {
        directorBean=new DirectorBean();
        listarDirectores();
    }

    private void listarDirectores() {
        setListaDirectores(getDirectorBean().listar());
    }
    
    public void establecer(Director d){
        setUnDirector(d);
    }
   
    public void buscar(){
        setUnDirector(getDirectorBean().validar(getCodBuscado()));
    }
    
    public void agregar(){
        setUnDirector(new Director(getNombres(),getApellidos(),true));
        try{
            getDirectorBean().agregar(getUnDirector());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","El director no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Realizado","Director agregada con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarDirectores();
    }
    
    public void eliminar(){
        getUnDirector().setDirEstado(false);
        getDirectorBean().modificar(getUnDirector());
        listarDirectores();
    }
    
    public void modificar(){
        getDirectorBean().modificar(getUnDirector());
        listarDirectores();
    }

    /**
     * @return the directorBean
     */
    public DirectorBean getDirectorBean() {
        return directorBean;
    }

    /**
     * @param directorBean the directorBean to set
     */
    public void setDirectorBean(DirectorBean directorBean) {
        this.directorBean = directorBean;
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
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the listaDirectores
     */
    public List<Director> getListaDirectores() {
        return listaDirectores;
    }

    /**
     * @param listaDirectores the listaDirectores to set
     */
    public void setListaDirectores(List<Director> listaDirectores) {
        this.listaDirectores = listaDirectores;
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
    
}
