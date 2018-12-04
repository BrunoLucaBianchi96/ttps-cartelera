package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.DAO.TokenDAO;
import model.DAO.UserDAO;
import model.Token;
import model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Component("tokenRepository")
public class TokenRepository extends GenericDAOHibernateJPA<Token> implements TokenDAO {

    public TokenRepository(){}

    @Override
    public ArrayList<Token> getAll() {
        return (ArrayList<Token>) this.getEntityManager().createNativeQuery("SELECT * FROM token",Token.class).getResultList();
    }

    @Override
    public Token getByUserId(int id){
        return (Token) this.getEntityManager().createNativeQuery("SELECT * FROM token WHERE user_id = :id ",Token.class)
                .setParameter("user_id", id)
                .getSingleResult();
    }

    @Override
    public Class<Token> getPersistentClass() {
        return Token.class;
    }
}
