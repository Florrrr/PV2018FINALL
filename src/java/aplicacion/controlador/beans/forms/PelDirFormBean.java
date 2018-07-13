/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PelDirBean;
import aplicacion.modelo.dominio.Director;
import aplicacion.modelo.dominio.PelDir;
import aplicacion.modelo.dominio.Pelicula;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author CX
 */
@ManagedBean
@ViewScoped
public class PelDirFormBean implements Serializable{
    @ManagedProperty(value="#{pelDirBean}")
    private PelDirBean pelDirBean;
    private List<PelDir> listaPelDir;
    private PelDir unaPelDir;
    private Pelicula unaPelicula;
    private Director unDirector;
    
    /**
     * Creates a new instance of PelDirFormBean
     */
    public PelDirFormBean() {
        pelDirBean=new PelDirBean();
        listarPelDir();
    }
    
    private void listarPelDir() {
        setListaPelDir(getPelDirBean().listar());
    }
    
    /**
     * @return the pelDirBean
     */
    public PelDirBean getPelDirBean() {
        return pelDirBean;
    }

    /**
     * @param pelDirBean the pelDirBean to set
     */
    public void setPelDirBean(PelDirBean pelDirBean) {
        this.pelDirBean = pelDirBean;
    }
    /**
     * @return the listaPelDir
     */
    public List<PelDir> getListaPelDir() {
        return listaPelDir;
    }

    /**
     * @param listaPelDir the listaPelDir to set
     */
    public void setListaPelDir(List<PelDir> listaPelDir) {
        this.listaPelDir = listaPelDir;
    }

    /**
     * @return the unaPelDir
     */
    public PelDir getUnaPelDir() {
        return unaPelDir;
    }

    /**
     * @param unaPelDir the unaPelDir to set
     */
    public void setUnaPelDir(PelDir unaPelDir) {
        this.unaPelDir = unaPelDir;
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
    
}
