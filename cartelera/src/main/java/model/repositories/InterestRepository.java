package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.Interest;

public class InterestRepository extends GenericDAOHibernateJPA<Interest> {


    @Override
    public Class<Interest> getPersistentClass() { return Interest.class; }

}
