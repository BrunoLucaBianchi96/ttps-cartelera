package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.Permission;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PermissionRepository extends GenericDAOHibernateJPA<Permission> {


    @Override
    public Class<Permission> getPersistentClass() { return Permission.class; }

}

