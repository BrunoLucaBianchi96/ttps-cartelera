package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.Interest;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@PersistenceContext
@Transactional
public class InterestRepository extends GenericDAOHibernateJPA<Interest> {


    @Override
    public Class<Interest> getPersistentClass() { return Interest.class; }

    public List<Interest> getAllInterestsForUserId(Integer id) {
        return this.getEntityManager().createNativeQuery("SELECT * FROM interest WHERE user_id = :user_id", Interest.class)
                .setParameter("user_id", id)
                .getResultList();
    }

}
