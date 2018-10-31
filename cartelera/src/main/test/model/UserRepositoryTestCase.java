package model;

import model.DAO.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;

@Transactional
public class UserRepositoryTestCase {

    private UserRepository userRepository = new UserRepository();
    private User user;

    @After
    public void deleteUser(){
        if(user != null) {
            this.userRepository.delete(user);
        }
    }

    @Test
    public void testGetByEmail(){
        user = createUser();
        this.userRepository.save(user);
        Assert.assertNotNull(userRepository.getUserByEmail("email"));

    }

    @Test
    public void testGetById(){
        user = createUser();
        this.userRepository.save(user);
        user = userRepository.getById(user.getId());
        Assert.assertNotNull(user);

    }
    @Test
    public void testUpdateUser(){
        user = createUser();
        this.userRepository.save(user);
        user.setName("New Name");
        this.userRepository.update(user);
        user = this.userRepository.getById(user.getId());
        Assert.assertEquals("New Name", user.getName());

    }

    private User createUser(){
        User user = new User();
        user.setName("Juan");
        user.setLastName("Pedro");
        user.setPassword("Pass");
        user.setEmail("email");
        return user;
    }

    @Test
    public void testSaveAndDeleteUser(){
        user = createUser();
        this.userRepository.save(user);
        Assert.assertNotNull(this.userRepository.getById(user.getId()));
        this.userRepository.delete(user);
        Assert.assertNull(this.userRepository.getById(user.getId()));
    }

}
