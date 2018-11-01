package model.repositories;

import model.Billboard;
import model.DAO.GenericDAOHibernateJPA;
import model.Interest;
import model.Post;

import java.util.List;

public class BillboardRepository extends GenericDAOHibernateJPA<Billboard> {

    @Override
    public Class<Billboard> getPersistentClass() {
        return Billboard.class;
    }

}
