/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.UsuarioDAO;
import aplicacion.datos.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author CX
 */
@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable{

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
    
    public Usuario validarUsuario(String user,String pass){
        Usuario usuario=null;
        UsuarioDAO usuarioDAO=new UsuarioDAOImp();
        usuario=usuarioDAO.consulta(user,pass);
        return usuario;
    }
    
    public void agregarUsuario(Usuario usuario){
        UsuarioDAO usuarioDAO=new UsuarioDAOImp();
        usuarioDAO.agregar(usuario);
    }
    
    public List<Usuario> obtenerUsuario(){
        UsuarioDAO usuarioDAO=new UsuarioDAOImp();
        return usuarioDAO.obtenerTodos();
    }
    
}
