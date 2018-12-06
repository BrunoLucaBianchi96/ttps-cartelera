package model.DAO;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {
   // EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.cartelera.jpa");

    T update(T entity);
    T save(T entity);
    void delete(T entity);
    T getById(Serializable id);
    List<T> getAll();
}
