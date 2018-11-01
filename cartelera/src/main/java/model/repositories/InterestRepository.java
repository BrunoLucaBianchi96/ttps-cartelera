package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.Interest;

import java.util.List;

public class InterestRepository extends GenericDAOHibernateJPA<Interest> {


    @Override
    public Class<Interest> getPersistentClass() { return Interest.class; }

    public List<Interest> getAllInterestsForUserId(Integer id) {
        return this.getEntityManager().createNativeQuery("SELECT * FROM interest WHERE user_id = :user_id", Interest.class)
                .setParameter("user_id", id)
                .getResultList();
    }

}
