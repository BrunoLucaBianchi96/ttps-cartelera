package model.repositories;

import model.DAO.UserDAO;
import model.User;
import model.repositories.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import spring.config.AppConfig;
import spring.config.SpringWebApp;

import javax.swing.*;
import javax.transaction.Transactional;

@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class UserRepositoryTestCase {

    @Autowired
    private UserDAO userRepository;
    private User user;

    @After
    public void deleteUser(){
        if(user != null) {
            //this.userRepository.delete(user);
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
