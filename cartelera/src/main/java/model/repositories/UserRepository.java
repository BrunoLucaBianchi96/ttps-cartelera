package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.DAO.UserDAO;
import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@PersistenceContext
@Transactional
public class UserRepository extends GenericDAOHibernateJPA<User> implements UserDAO {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.cartelera.jpa");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public User getUserByEmail(String email) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.cartelera.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return (User) entityManager.createNativeQuery("SELECT * FROM user WHERE email = :email ",User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public Class<User> getPersistentClass() {
        return User.class;
    }
}
