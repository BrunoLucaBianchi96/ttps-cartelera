package model;

import model.DAO.UserRepository;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;

@Transactional
public class UserRepositoryTestCase {

    private UserRepository userRepository = new UserRepository();
    @Test
    public void testGetByEmail(){
        Assert.assertNotNull(userRepository.getUserByEmail("email"));
    }

    @Test
    public void testUpdateUser(){
        User user = createUser();
        this.userRepository.save(user);
        user.setName("New Name");
        this.userRepository.update(user);
        user = this.userRepository.getUserById(user.getId());
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
        User user = createUser();
        this.userRepository.save(user);
        Assert.assertNotNull(this.userRepository.getUserById(user.getId()));
        this.userRepository.delete(user);
        Assert.assertNull(this.userRepository.getUserById(user.getId()));
        userRepository.getUserByEmail("email");
    }

}
