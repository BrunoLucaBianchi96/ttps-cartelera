package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.Permission;
import model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleRepository extends GenericDAOHibernateJPA<Role> {


    @Override
    public Class<Role> getPersistentClass() { return Role.class; }

}
