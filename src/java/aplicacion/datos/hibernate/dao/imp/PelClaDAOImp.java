/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PelClaDAO;
import aplicacion.modelo.dominio.PelCla;
import org.hibernate.Session;


/**
 *
 * @author CX
 */
public class PelClaDAOImp implements PelClaDAO{

    @Override
    public void modificar(PelCla unaPelCla) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaPelCla);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(PelCla unaPelCla) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaPelCla);
        session.getTransaction().commit();
        session.close();
    }
    
}
