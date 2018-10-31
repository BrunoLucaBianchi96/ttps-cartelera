package model.DAO;

import model.Interest;
import model.Role;

import java.util.List;

public interface RoleDAO extends GenericDAO<Role> {
    List<Interest> getAllPermissionsFromRoleId(Integer id);

}
