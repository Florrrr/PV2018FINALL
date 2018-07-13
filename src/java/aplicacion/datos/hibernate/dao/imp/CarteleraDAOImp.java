/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.CarteleraDAO;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.Pelicula;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author CX
 */
public class CarteleraDAOImp implements CarteleraDAO{

    @Override
    public List<Cartelera> obtenerTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Cartelera.class);
        criteria.add(Restrictions.like("carEstado", true));
        List listado=criteria.list();
        session.close();
        return listado;
    }

    @Override
    public Cartelera consulta(Pelicula unaPelicula, Date unaFecha) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Cartelera.class);
        criteria.add(Restrictions.like("peliculas", unaPelicula));
        criteria.add(Restrictions.like("carFecha",unaFecha));
        Cartelera car=null;
        if(!criteria.list().isEmpty()){
            car=(Cartelera)criteria.list().get(0);
        }
        return car;
    }

    @Override
    public void modificar(Cartelera unaCartelera) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaCartelera);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(Cartelera unaCartelera) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaCartelera);
        session.getTransaction().commit();
        session.close();
    }
    
}
