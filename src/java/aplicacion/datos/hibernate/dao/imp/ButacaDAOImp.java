/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.ButacaDAO;
import aplicacion.modelo.dominio.Butaca;
import aplicacion.modelo.dominio.Sala;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author CX
 */
public class ButacaDAOImp implements ButacaDAO{

    @Override
    public List<Butaca> obtenerTodos(Sala unaSala) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Butaca.class);
        criteria.add(Restrictions.like("butEstado", true));
        criteria.add(Restrictions.like("salas.salCodigo", unaSala.getSalCodigo()));
        List listado=criteria.list();
        session.close();
        return listado;
    }
    
    @Override
    public List<Butaca> obtenerTudos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Butaca.class);
        criteria.add(Restrictions.like("butEstado", true));
        List listado=criteria.list();
        session.close();
        return listado;
    }

    @Override
    public Butaca consulta(int codBuscado) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Butaca.class);
        criteria.add(Restrictions.like("butCodigo", codBuscado));
        Butaca b=null;
        if(!criteria.list().isEmpty()){
            b=(Butaca)criteria.list().get(0);
        }
        return b;
    }

    @Override
    public void modificar(Butaca unaButaca) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaButaca);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(Butaca unaButaca) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaButaca);
        session.getTransaction().commit();
        session.close();
    }
    
}
