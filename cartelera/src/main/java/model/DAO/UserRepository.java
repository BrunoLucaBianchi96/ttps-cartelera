package model.DAO;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
    
}
