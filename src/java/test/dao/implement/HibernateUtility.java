/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao.implement;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author rzkypprtm
 */
@Transactional
public class HibernateUtility {

    @Autowired
    public SessionFactory sessionFactory;
    
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    protected Query createQuery(String query){
        return getSession().createQuery(query);
    }

    protected SQLQuery createNativeQuery(String query){
        return getSession().createSQLQuery(query);
    }
}
