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
import java.util.ArrayList;
import java.util.List;

@Repository

public class UserRepository extends GenericDAOHibernateJPA<User> implements UserDAO {

    public UserRepository(){}

    @Override
    public User getUserByEmail(String email) {
        ArrayList<User> users = (ArrayList<User>) this.getEntityManager().createNativeQuery("SELECT * FROM user WHERE email = :email ",User.class)
                    .setParameter("email", email)
                    .getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public Class<User> getPersistentClass() {
        return User.class;
    }
}
