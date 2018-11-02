package model.repositories;

import model.Permission;
import model.Role;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoleRepositoryTestCase {

    private RoleRepository roleRepository = new RoleRepository();
    private Role role;

    @After
    public void deleteRole(){
        if(role != null) {
            this.roleRepository.delete(role);
        }
    }

    @Before
    public void createRole(){
        role = new Role();
        role.setName("Admin test");
    }

    @Test
    public void testGetById(){
        this.roleRepository.save(role);
        role = this.roleRepository.getById(role.getId());
        Assert.assertNotNull(role);

    }
    @Test
    public void testUpdateComment(){
        String name = "Inservible";
        this.roleRepository.save(role);
        role.setName(name);
        this.roleRepository.update(role);
        role = this.roleRepository.getById(role.getId());
        Assert.assertEquals(name, role.getName());

    }

    @Test
    public void testSaveAndDeletePermission(){
        roleRepository.save(role);
        Assert.assertNotNull(this.roleRepository.getById(role.getId()));
        this.roleRepository.delete(role);
        Assert.assertNull(this.roleRepository.getById(role.getId()));
        //We create the permission again so we can delete it later in the @After :)
        this.createRole();
        roleRepository.save(role);
    }

}
