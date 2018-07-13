/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
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
public class PerfilFormBean implements Serializable{
    @ManagedProperty(value="#{perfilBean}")
    private PerfilBean perfilBean;
    private Usuario unUsuario;
    private Perfil unPerfil;
    private String nombreUs;
    private String passUs;
    private String tipo;
    private String nombres;
    private String apellidos;
    private String dni;
    private boolean busqueda;
    private List<Perfil> listaPerfiles;
    private String mail;
    private Date fechaNac;
    private String direccion;
    private int codBuscado;
    /**
     * Creates a new instance of PerfilFormBean
     */
    public PerfilFormBean() {
        perfilBean=new PerfilBean();
        listarPerfiles();
    }

    private void listarPerfiles() {
        setListaPerfiles(getPerfilBean().listarPerfiles());
    }
    
    public void establecerPerfil(Perfil per){
        setUnPerfil(per);
    }
   
    public void buscarPerfil(){
        setUnPerfil(getPerfilBean().validarPerfil(codBuscado));
    }
    
    public Perfil getDatosUsuarioValidado(){
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("usuarioValidado");
        Perfil perfil=getPerfilBean().validarPerfil(usuario.getUsuCodigo());
        return perfil;
    }
    
    public void agregarPerfil(){
        setUnUsuario(new Usuario(getNombreUs(),getPassUs(),getTipo(),true));
        setUnPerfil(new Perfil(getUnUsuario(),getNombres(),getApellidos(),getDni(),
                getFechaNac(),getMail(),getDireccion(),true));
        try{
            getPerfilBean().agregarPerfil(getUnPerfil());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","El usuario no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Felicidades!","Usuario creado con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarPerfiles();
    }
    
    public void eliminarPerfil(){
        getUnPerfil().getUsuarios().setUsuEstado(false);
        getUnPerfil().setPerEstado(false);
        getPerfilBean().modificarPerfil(getUnPerfil());
        listarPerfiles();
    }
    
    public void modificarPerfil(){
        getPerfilBean().modificarPerfil(getUnPerfil());
        listarPerfiles();
    }

    /**
     * @return the perfilBean
     */
    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    /**
     * @param perfilBean the perfilBean to set
     */
    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    /**
     * @return the unUsuario
     */
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    /**
     * @return the unPerfil
     */
    public Perfil getUnPerfil() {
        return unPerfil;
    }

    /**
     * @param unPerfil the unPerfil to set
     */
    public void setUnPerfil(Perfil unPerfil) {
        this.unPerfil = unPerfil;
    }

    /**
     * @return the nombreUs
     */
    public String getNombreUs() {
        return nombreUs;
    }

    /**
     * @param nombreUs the nombreUs to set
     */
    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    /**
     * @return the passUs
     */
    public String getPassUs() {
        return passUs;
    }

    /**
     * @param passUs the passUs to set
     */
    public void setPassUs(String passUs) {
        this.passUs = passUs;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the busqueda
     */
    public boolean isBusqueda() {
        return busqueda;
    }

    /**
     * @param busqueda the busqueda to set
     */
    public void setBusqueda(boolean busqueda) {
        this.busqueda = busqueda;
    }

    /**
     * @return the listaPerfiles
     */
    public List<Perfil> getListaPerfiles() {
        return listaPerfiles;
    }

    /**
     * @param listaPerfiles the listaPerfiles to set
     */
    public void setListaPerfiles(List<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the fechaNac
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    
}
