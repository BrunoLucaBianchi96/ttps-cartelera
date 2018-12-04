package spring.config.services;

import model.DAO.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Component("userService")
public class UserService {

    @Autowired
    private UserDAO userRepository;


    @Transactional
    public User getUserById(Integer id){
        return this.userRepository.getById(id);
    }

    @Transactional
    public User getUserByEmail(String email){
        return this.userRepository.getUserByEmail(email);
    }

    public void save(User user) {
        this.userRepository.save(user);
    }
}
