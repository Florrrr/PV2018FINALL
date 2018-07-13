/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.ButacaCarteleraDAO;
import aplicacion.modelo.dominio.ButacaCartelera;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author CX
 */
public class ButacaCarteleraDAOImp implements ButacaCarteleraDAO{

    @Override
    public List<ButacaCartelera> obtenerTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(ButacaCartelera.class);
        criteria.add(Restrictions.like("bcEstado", true));
        List listado=criteria.list();
        session.close();
        return listado;
    }

    @Override
    public ButacaCartelera consulta(int codBuscado) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(ButacaCartelera.class);
        criteria.add(Restrictions.like("bcCodigo", codBuscado));
        ButacaCartelera bc=null;
        if(!criteria.list().isEmpty()){
            bc=(ButacaCartelera)criteria.list().get(0);
        }
        return bc;
    }

    @Override
    public void modificar(ButacaCartelera unaButacaCartelera) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaButacaCartelera);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(ButacaCartelera unaButacaCartelera) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaButacaCartelera);
        session.getTransaction().commit();
        session.close();
    }
    
}
