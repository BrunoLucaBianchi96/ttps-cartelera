package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.Permission;

import java.util.List;

public class PermissionRepository extends GenericDAOHibernateJPA<Permission> {


    @Override
    public Class<Permission> getPersistentClass() { return Permission.class; }

}

