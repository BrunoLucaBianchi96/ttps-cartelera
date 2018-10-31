package model.DAO;

import model.EMF;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

public abstract class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

    public Class<T> persistentClass;

    public abstract Class<T> getPersistentClass();

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
            em.remove(em.contains(entity) ? entity : em.merge(entity));
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

    @Override
    public T getById(Serializable id) {
        EntityManager em= EMF.getEMF().createEntityManager();
        T result = em.find(this.getPersistentClass(), id);
        em.close();
        return result;

    }
}
