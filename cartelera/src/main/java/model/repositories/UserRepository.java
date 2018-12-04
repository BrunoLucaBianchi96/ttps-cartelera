package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.DAO.UserDAO;
import model.Token;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.config.services.TokenService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public class UserRepository extends GenericDAOHibernateJPA<User> implements UserDAO {

    public UserRepository(){}

    @Autowired
    private TokenService tokenService;

    @Override
    public User getUserByEmail(String email) {
        ArrayList<User> users = (ArrayList<User>) this.getEntityManager().createNativeQuery("SELECT * FROM user WHERE email = :email ",User.class)
                    .setParameter("email", email)
                    .getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public Token checkCredentials(String email, String password){
        ArrayList<User> list = (ArrayList<User>) this.getEntityManager().createNativeQuery("SELECT * FROM user WHERE email = :email AND password = :password", User.class)
                .setParameter("email", email)
                .setParameter("password",password)
        .getResultList();
        if (!list.isEmpty()){ //Si la lista no esta vacía quiere decir que se encontro un usuario con las credenciales ingresadas
            User loggedUser = list.get(0);
            Token token = tokenService.getByUserId(loggedUser.getId());
            return tokenService.updateToken(token);
        }
        return null;
    }

    @Override
    public Class<User> getPersistentClass() {
        return User.class;
    }
}
