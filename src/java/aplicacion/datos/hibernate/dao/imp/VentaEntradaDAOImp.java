/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.VentaEntradaDAO;
import aplicacion.modelo.dominio.VentaEntrada;
import org.hibernate.Session;

/**
 *
 * @author CX
 */
public class VentaEntradaDAOImp implements VentaEntradaDAO{

    @Override
    public void agregar(VentaEntrada unaVenta) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaVenta);
        session.getTransaction().commit();
        session.close();
    }
    
}
