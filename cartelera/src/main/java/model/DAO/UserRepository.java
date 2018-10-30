package model.DAO;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserRepository implements UserDAO {
    @Override
    public User getUserByEmail(String email) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.cartelera.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return (User) entityManager.createNativeQuery("SELECT * FROM user WHERE email = :email ",User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public GenericDAO update(User entity) {
        return null;
    }
}
