package model.repositories;

import model.Billboard;
import model.DAO.GenericDAOHibernateJPA;

public class BillboardRepository extends GenericDAOHibernateJPA<Billboard> {
    @Override
    public Class<Billboard> getPersistentClass() {
        return Billboard.class;
    }
}
