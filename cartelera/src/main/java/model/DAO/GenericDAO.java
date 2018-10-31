package model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

public interface GenericDAO<T> {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.cartelera.jpa");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    T update(T entity);
    T save(T entity);
    void delete(T entity);
    T getById(Serializable id);
}
