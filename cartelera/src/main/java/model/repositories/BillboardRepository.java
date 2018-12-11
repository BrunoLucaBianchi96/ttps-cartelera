package model.repositories;

import model.Billboard;
import model.DAO.BillboardDAO;
import model.DAO.GenericDAOHibernateJPA;
import model.Interest;
import model.Post;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Component("billboardRepository")
@Transactional
public class BillboardRepository extends GenericDAOHibernateJPA<Billboard> implements BillboardDAO {

    @Override
    public Class<Billboard> getPersistentClass() {
        return Billboard.class;
    }

    @Override
    public List<Interest> getAllInterestedFromBillboardId(Integer id) {
        //TODO: implement this
        return null;
    }

    @Override
    public List<Post> getAllPostsFromBillboardId(Integer id) {
        //TODO: implement this
        return null;
    }
}
