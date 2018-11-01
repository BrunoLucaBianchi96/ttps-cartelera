package model.DAO;

import model.Permission;
import model.Role;

import java.util.List;

public interface RoleDAO extends GenericDAO<Role> {
    List<Permission> getAllPermissionsFromRoleId(Integer id);

}
