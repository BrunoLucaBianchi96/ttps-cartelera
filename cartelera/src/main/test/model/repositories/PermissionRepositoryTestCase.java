package model.repositories;

import model.Permission;
import model.Role;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional
public class PermissionRepositoryTestCase {

    private PermissionRepository permissionRepository = new PermissionRepository();
    private RoleRepository roleRepository = new RoleRepository();
    private Permission permission;
    private Role role;

    @After
    public void deleteComment(){
        if(permission != null) {
            this.permissionRepository.delete(permission);
            this.roleRepository.delete(role);
        }
    }

    @Before
    public void createPermission(){
        role = new Role();
        role.setName("Admin test");
        List<Role> list = Arrays.asList(role);
        this.roleRepository.save(role);
        this.permission = new Permission();
        permission.setRoles(list);
        permission.setName("permission name test");
    }

    @Test
    public void testGetById(){
        this.permissionRepository.save(permission);
        permission = this.permissionRepository.getById(permission.getId());
        Assert.assertNotNull(permission);

    }
    @Test
    public void testUpdateComment(){
        String name = "Inservible";
        this.permissionRepository.save(permission);
        permission.setName(name);
        this.permissionRepository.update(permission);
        permission = this.permissionRepository.getById(permission.getId());
        Assert.assertEquals(name, permission.getName());

    }

    @Test
    public void testSaveAndDeletePermission(){
        permissionRepository.save(permission);
        Assert.assertNotNull(this.permissionRepository.getById(permission.getId()));
        this.permissionRepository.delete(permission);
        this.roleRepository.delete(permission.getRoles().get(0));
        Assert.assertNull(this.permissionRepository.getById(permission.getId()));
        //We create the permission again so we can delete it later in the @After :)
        this.createPermission();
        permissionRepository.save(permission);
    }

}
