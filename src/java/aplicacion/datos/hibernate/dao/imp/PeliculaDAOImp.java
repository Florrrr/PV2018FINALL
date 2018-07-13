/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PeliculaDAO;
import aplicacion.modelo.dominio.Pelicula;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author CX
 */
public class PeliculaDAOImp implements PeliculaDAO{

    @Override
    public List<Pelicula> obtenerTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Pelicula.class);
        criteria.add(Restrictions.like("pelEstado", true));
        List listado=criteria.list();
        session.close();
        return listado;
    }

    @Override
    public Pelicula consulta(int codBuscado) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Pelicula.class);
        criteria.add(Restrictions.like("pelCodigo", codBuscado));
        Pelicula p=null;
        if(!criteria.list().isEmpty()){
            p=(Pelicula)criteria.list().get(0);
        }
        return p;
    }

    @Override
    public void modificar(Pelicula unaPelicula) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaPelicula);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(Pelicula unaPelicula) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaPelicula);
        session.getTransaction().commit();
        session.close();
    }

}
