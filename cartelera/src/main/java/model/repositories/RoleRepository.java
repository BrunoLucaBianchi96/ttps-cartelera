package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.Permission;
import model.Role;

import java.util.List;

public class RoleRepository extends GenericDAOHibernateJPA<Role> {


    @Override
    public Class<Role> getPersistentClass() { return Role.class; }

}
