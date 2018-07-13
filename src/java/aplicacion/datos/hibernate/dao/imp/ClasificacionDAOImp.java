/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.ClasificacionDAO;
import aplicacion.modelo.dominio.Clasificacion;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author CX
 */
public class ClasificacionDAOImp implements ClasificacionDAO{

    @Override
    public List<Clasificacion> obtenerTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Clasificacion.class);
        criteria.add(Restrictions.like("claEstado", true));
        List listado=criteria.list();
        session.close();
        return listado;
    }

    @Override
    public Clasificacion consulta(int codBuscado) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Clasificacion.class);
        criteria.add(Restrictions.like("claCodigo", codBuscado));
        Clasificacion c=null;
        if(!criteria.list().isEmpty()){
            c=(Clasificacion)criteria.list().get(0);
        }
        return c;
    }

    @Override
    public void modificar(Clasificacion unaClasificacion) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaClasificacion);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(Clasificacion unaClasificacion) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaClasificacion);
        session.getTransaction().commit();
        session.close();
    }
}
