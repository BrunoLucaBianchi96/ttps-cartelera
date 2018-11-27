package model.DAO;

import model.EMF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;

@Transactional
public abstract class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

    public Class<T> persistentClass;

    @PersistenceContext
    private EntityManagerFactory emf;

    private EntityManager entityManager;

    public void setEntityManager(EntityManager em){
        this.entityManager = em;
    }

    @PersistenceContext
    public EntityManager getEntityManager() {

        return entityManager;
    }

    public abstract Class<T> getPersistentClass();

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
        EntityManager em = this.getEntityManager();
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
