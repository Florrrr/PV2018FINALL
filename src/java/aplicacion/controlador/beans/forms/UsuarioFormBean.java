/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author CX
 */
@ManagedBean
@RequestScoped
public class UsuarioFormBean implements Serializable{
    @ManagedProperty(value="#{usuarioBean}")
    private UsuarioBean usuarioBean;
     private Integer usuCodigo;
     private String usuNombreUsuario;
     private String usuPassword;
     private String usuTipoUsuario;
     private boolean usuEstado;
     private Usuario usuario;
     private String usuPassword2;
     private List<Usuario> usuarioLista;
    
    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
    }
    
    public void agregarUsuario(){
        setUsuarioLista(getUsuarioBean().obtenerUsuario());
        setUsuEstado(true);
        //Random r1=new Random();
        //setUsuCodigo((Integer) r1.nextInt(1000));
        setUsuario(new Usuario(getUsuNombreUsuario(), getUsuPassword(), getUsuTipoUsuario(), isUsuEstado()));
        getUsuarioBean().agregarUsuario(getUsuario());
        setUsuarioLista(getUsuarioBean().obtenerUsuario());
    }
    
    public void mostrarUsuarios(){
        setUsuarioLista(getUsuarioBean().obtenerUsuario());
    }

    /**
     * @return the usuCodigo
     */
    public Integer getUsuCodigo() {
        return usuCodigo;
    }

    /**
     * @param usuCodigo the usuCodigo to set
     */
    public void setUsuCodigo(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    /**
     * @return the usuNombreUsuario
     */
    public String getUsuNombreUsuario() {
        return usuNombreUsuario;
    }

    /**
     * @param usuNombreUsuario the usuNombreUsuario to set
     */
    public void setUsuNombreUsuario(String usuNombreUsuario) {
        this.usuNombreUsuario = usuNombreUsuario;
    }

    /**
     * @return the usuPassword
     */
    public String getUsuPassword() {
        return usuPassword;
    }

    /**
     * @param usuPassword the usuPassword to set
     */
    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    /**
     * @return the usuTipoUsuario
     */
    public String getUsuTipoUsuario() {
        return usuTipoUsuario;
    }

    /**
     * @param usuTipoUsuario the usuTipoUsuario to set
     */
    public void setUsuTipoUsuario(String usuTipoUsuario) {
        this.usuTipoUsuario = usuTipoUsuario;
    }

    /**
     * @return the usuEstado
     */
    public boolean isUsuEstado() {
        return usuEstado;
    }

    /**
     * @param usuEstado the usuEstado to set
     */
    public void setUsuEstado(boolean usuEstado) {
        this.usuEstado = usuEstado;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    /**
     * @return the usuPassword2
     */
    public String getUsuPassword2() {
        return usuPassword2;
    }

    /**
     * @param usuPassword2 the usuPassword2 to set
     */
    public void setUsuPassword2(String usuPassword2) {
        this.usuPassword2 = usuPassword2;
    }

    /**
     * @return the usuarioLista
     */
    public List<Usuario> getUsuarioLista() {
        return usuarioLista;
    }

    /**
     * @param usuarioLista the usuarioLista to set
     */
    public void setUsuarioLista(List<Usuario> usuarioLista) {
        this.usuarioLista = usuarioLista;
    }
    
}
