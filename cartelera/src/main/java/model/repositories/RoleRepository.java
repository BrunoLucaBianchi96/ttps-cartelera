package model.repositories;

import model.DAO.GenericDAOHibernateJPA;
import model.DAO.RoleDAO;
import model.Permission;
import model.Role;

import java.util.List;

public class RoleRepository extends GenericDAOHibernateJPA<Role> implements RoleDAO {


    @Override
    public Class<Role> getPersistentClass() { return Role.class; }

    @Override
    public List<Permission> getAllPermissionsFromRoleId(Integer id) {
        return this.getEntityManager().createNativeQuery("SELECT * FROM permission WHERE role_id = :role_id", this.getPersistentClass())
                .setParameter("role_id", id)
                .getResultList();
    }
}
