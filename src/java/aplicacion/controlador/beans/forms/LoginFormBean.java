/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FranNBK
 */
@ManagedBean
@RequestScoped
public class LoginFormBean implements Serializable{
    @ManagedProperty(value="#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private String user;
    private String pass;
    private Usuario userAux;

    /**
     * Creates a new instance of UsuarioFormBean
     */
    public LoginFormBean() {
    }
    
    public String validarUsuario(){
        String res=null;
        Usuario usuario=null;
        usuario=getUsuarioBean().validarUsuario(getUser(), getPass());
        if(usuario==null){
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Credenciales Invalidas","El nombre de usuario o contraseña son incorrectos"); 
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        else{
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Ingreso Correcto","Bienvenido de nuevo "+usuario.getUsuNombreUsuario());
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado",usuario);
            res="/inicio";
        }
        return res;
    }
    
    public Usuario getNombreUsuarioValidado(){
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario;
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Sesion Cerrada","Ha finalizado su sesion");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        String resultado="/index";
        return resultado;
    }
    
    public int verificarSesion(){
        boolean sesionValida=false;
        int tipo=0;
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if(usuario!=null)
            sesionValida=true;
        if(sesionValida==true){
            switch(usuario.getUsuTipoUsuario()){
            case "final":{
                tipo=1;
                break;
            }
            case "administrador":{
                tipo=2;
                break;
            }
            case "supervisor":{
                tipo=3;
                break;
            }
        }
        }
        return tipo;
    }

    public boolean validarSesion(){
        boolean sesionValida=false;        
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if(usuario!=null){
            sesionValida=true;
        
        }
        return sesionValida;
    }
    
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
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
     * @return the userAux
     */
    public Usuario getUserAux() {
        return userAux;
    }

    /**
     * @param userAux the userAux to set
     */
    public void setUserAux(Usuario userAux) {
        this.userAux = userAux;
    }
    
}
