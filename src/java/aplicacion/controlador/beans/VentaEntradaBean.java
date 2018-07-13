/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.VentaEntradaDAO;
import aplicacion.datos.hibernate.dao.imp.VentaEntradaDAOImp;
import aplicacion.modelo.dominio.VentaEntrada;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author CX
 */
@ManagedBean
@ViewScoped
public class VentaEntradaBean implements Serializable{

    /**
     * Creates a new instance of VentaEntradaBean
     */
    public VentaEntradaBean() {
    }
    
    public void agregar(VentaEntrada unaVentaEntrada){
        VentaEntradaDAO vDAO=new VentaEntradaDAOImp();
        vDAO.agregar(unaVentaEntrada);
    }
    
}
