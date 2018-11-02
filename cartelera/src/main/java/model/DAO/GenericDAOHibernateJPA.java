package model.DAO;

import model.EMF;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.io.Serializable;

public abstract class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

    public Class<T> persistentClass;

    public abstract Class<T> getPersistentClass();

    public EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.cartelera.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    @Override
    @Transactional
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
    @Transactional
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
    @Transactional
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
    @Transactional
    public T getById(Serializable id) {
        EntityManager em= EMF.getEMF().createEntityManager();
        T result = em.find(this.getPersistentClass(), id);
        em.close();
        return result;

    }
}
