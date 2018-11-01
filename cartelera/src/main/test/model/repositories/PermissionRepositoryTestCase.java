package model.repositories;

import model.Permission;
import model.Role;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class PermissionRepositoryTestCase {

    private PermissionRepository permissionRepository = new PermissionRepository();
    private RoleRepository roleRepository = new RoleRepository();
    private Permission permission;

    @After
    public void deleteComment(){
        if(permission != null) {
            this.permissionRepository.delete(permission);
            this.roleRepository.delete(permission.getRoles().get(0));
        }
    }

    @Test
    public void testGetById(){
        permission = createPermission();
        this.permissionRepository.save(permission);
        permission = this.permissionRepository.getById(permission.getId());
        Assert.assertNotNull(permission);

    }
    @Test
    public void testUpdateComment(){
        String name = "Inservible";
        permission = createPermission();
        this.permissionRepository.save(permission);
        permission.setName(name);
        this.permissionRepository.update(permission);
        permission = this.permissionRepository.getById(permission.getId());
        Assert.assertEquals(name, permission.getName());

    }

    private Permission createPermission(){
        Role role = new Role();
        role.setName("Admin test");
        List<Role> list = new ArrayList<Role>();
        this.roleRepository.save(role);
        list.add(role);
        Permission permission = new Permission();
        permission.setRoles(list);
        permission.setName("permission name test");
        return permission;
    }

    @Test
    public void testSaveAndDeletePermission(){
        permission = createPermission();
        this.permissionRepository.save(permission);
        Assert.assertNotNull(this.permissionRepository.getById(permission.getId()));
        this.permissionRepository.delete(permission);
        this.roleRepository.delete(permission.getRoles().get(0));
        Assert.assertNull(this.permissionRepository.getById(permission.getId()));
    }

}
