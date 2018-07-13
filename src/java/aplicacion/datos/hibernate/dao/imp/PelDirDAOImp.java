/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PelDirDAO;
import aplicacion.modelo.dominio.PelDir;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author CX
 */
public class PelDirDAOImp implements PelDirDAO{

    @Override
    public List<PelDir> obtenerTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(PelDir.class);
        criteria.add(Restrictions.like("pdEstado", true));
        List listado=criteria.list();
        session.close();
        return listado;
    }

    @Override
    public PelDir consulta(int codBuscado) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(PelDir.class);
        criteria.add(Restrictions.like("pdCodigo", codBuscado));
        PelDir pd=null;
        if(!criteria.list().isEmpty()){
            pd=(PelDir)criteria.list().get(0);
        }
        return pd;
    }

    @Override
    public void modificar(PelDir unaPelDir) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaPelDir);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(PelDir unaPelDir) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaPelDir);
        session.getTransaction().commit();
        session.close();
    }
    
}
