/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.modelo.dominio.Perfil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author CX
 */
public class PerfilDAOImp implements PerfilDAO{

    @Override
    public List<Perfil> obtenerTodos() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Perfil.class);
        criteria.add(Restrictions.like("perEstado", true));
        List listado=criteria.list();
        session.close();
        return listado;
    }

    @Override
    public Perfil consulta(int codBuscado) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Perfil.class);
        criteria.add(Restrictions.like("usuarios.usuCodigo", codBuscado));
        Perfil u=null;
        if(!criteria.list().isEmpty()){
            u=(Perfil)criteria.list().get(0);
        }
        return u;
    }

    @Override
    public void modificar(Perfil unPerfil) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unPerfil);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void agregar(Perfil unPerfil) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unPerfil);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Perfil unPerfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
