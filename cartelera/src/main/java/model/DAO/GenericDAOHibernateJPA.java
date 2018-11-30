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

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public Class<T> persistentClass;

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager em){
        this.entityManager = em;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    @Transactional
    public T update(T entity) {
        EntityManager em= this.getEntityManager();
        entity = em.merge(entity);
        return entity;
    }

    @Override
    @Transactional
    public T save(T entity) {
        EntityManager em= this.getEntityManager();
        this.getEntityManager().persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public void delete(T entity) {
        EntityManager em = this.getEntityManager();
        this.getEntityManager().remove(entity);
    }

    @Override
    @Transactional
    public T getById(Serializable id) {
        EntityManager em=  this.getEntityManager();
        T result = em.find(this.getPersistentClass(), id);
        return result;
    }
}
