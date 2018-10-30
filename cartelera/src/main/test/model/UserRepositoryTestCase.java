package model;

import model.DAO.UserRepository;
import org.junit.Test;

import javax.transaction.Transactional;

@Transactional
public class UserRepositoryTestCase {

    private UserRepository userRepository = new UserRepository();

    @Transactional
    @Test
    public void testGetByEmail(){

        userRepository.getUserByEmail("juan");
    }

}
