package model.repositories;

import model.Billboard;
import model.DAO.GenericDAOHibernateJPA;
import model.Interest;
import model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository

@Transactional
public class BillboardRepository extends GenericDAOHibernateJPA<Billboard> {

    @Override
    public Class<Billboard> getPersistentClass() {
        return Billboard.class;
    }

}
