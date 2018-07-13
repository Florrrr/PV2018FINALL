/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.SalaDAO;
import aplicacion.modelo.dominio.Sala;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author CX
 */
public class SalaDAOImp implements SalaDAO{

    @Override
    public List<Sala> obtenerTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Sala.class);
        criteria.add(Restrictions.like("salEstado", true));
        List listado=criteria.list();
        session.close();
        return listado;
    }

    @Override
    public Sala consulta(int codBuscado) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Sala.class);
        criteria.add(Restrictions.like("salCodigo", codBuscado));
        Sala s=null;
        if(!criteria.list().isEmpty()){
            s=(Sala)criteria.list().get(0);
        }
        return s;
    }

    @Override
    public void modificar(Sala unaSala) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaSala);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(Sala unaSala) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaSala);
        session.getTransaction().commit();
        session.close();
    }
    
}
