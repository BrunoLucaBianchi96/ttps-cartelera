package model.repositories;

import model.Billboard;
import model.DAO.BillboardDAO;
import model.DAO.GenericDAOHibernateJPA;
import model.Interest;
import model.Post;

import java.util.List;

public class BillboardRepository extends GenericDAOHibernateJPA<Billboard> implements BillboardDAO {

    @Override
    public Class<Billboard> getPersistentClass() {
        return Billboard.class;
    }

    @Override
    public List<Interest> getAllInterestedFromBillboardId(Integer id) {
        return this.getEntityManager().createNativeQuery("SELECT * FROM permission WHERE billboard_id = :billboard_id", this.getPersistentClass())
                .setParameter("billboard_id", id)
                .getResultList();
    }

    @Override
    public List<Post> getAllPostsFromBillboardId(Integer id) {
        return this.getEntityManager().createNativeQuery("SELECT * FROM post WHERE billboard_id = :billboard_id", this.getPersistentClass())
                .setParameter("billboard_id", id)
                .getResultList();
    }
}
