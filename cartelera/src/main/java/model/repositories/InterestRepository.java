package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.DAO.InterestDAO;
import model.Interest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class InterestRepository extends GenericDAOHibernateJPA<Interest> implements InterestDAO {


    @Override
    public Class<Interest> getPersistentClass() { return Interest.class; }

    @Override
    public List<Interest> getAllInterestsForUserId(Integer id) {
        return this.getEntityManager().createNativeQuery("SELECT * FROM interest WHERE user_id = :user_id", Interest.class)
                .setParameter("user_id", id)
                .getResultList();

    }
}
