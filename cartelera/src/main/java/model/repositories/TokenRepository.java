package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.DAO.TokenDAO;
import model.DAO.UserDAO;
import model.Token;
import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class TokenRepository extends GenericDAOHibernateJPA<Token> implements TokenDAO {

    public TokenRepository(){}

    @Override
    public ArrayList<Token> getAll() {
        return (ArrayList<Token>) this.getEntityManager().createNativeQuery("SELECT * FROM token",Token.class).getResultList();
    }

    @Override
    public Class<Token> getPersistentClass() {
        return Token.class;
    }
}
