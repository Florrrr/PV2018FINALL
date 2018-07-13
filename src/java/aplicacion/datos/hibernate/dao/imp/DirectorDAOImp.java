/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.DirectorDAO;
import aplicacion.modelo.dominio.Director;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author CX
 */
public class DirectorDAOImp implements DirectorDAO{

    @Override
    public List<Director> obtenerTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Director.class);
        criteria.add(Restrictions.like("dirEstado", true));
        List listado=criteria.list();
        session.close();
        return listado;
    }

    @Override
    public Director consulta(int codBuscado) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Director.class);
        criteria.add(Restrictions.like("dirCodigo", codBuscado));
        Director d=null;
        if(!criteria.list().isEmpty()){
            d=(Director)criteria.list().get(0);
        }
        return d;
    }

    @Override
    public void modificar(Director unDirector) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unDirector);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(Director unDirector) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unDirector);
        session.getTransaction().commit();
        session.close();
    }
    
}
