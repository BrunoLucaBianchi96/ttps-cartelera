package model.DAO;

import model.EMF;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

    protected Class<T> persistentClass;

    @Override
    public T update(T entity) {
        EntityManager em= EMF.getEMF().createEntityManager();
        EntityTransaction etx= em.getTransaction();
        etx.begin();
        entity = em.merge(entity);
        etx.commit();
        em.close();
        return entity;
    }

    @Override
    public T save(T entity) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();
        }
        catch (RuntimeException e) {
            if ( tx != null && tx.isActive() ) tx.rollback();
            throw e; // escribir en un log o mostrar un mensaje
        }
        finally {
            em.close();
        }
        return entity;
    }

    @Override
    public void delete(T entity) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(entity);
            tx.commit();
        }
        catch (RuntimeException e) {
            if ( tx != null && tx.isActive() ) tx.rollback();
            throw e; // escribir en un log o mostrar un mensaje
        }
        finally {
            em.close();
        }
    }
}
