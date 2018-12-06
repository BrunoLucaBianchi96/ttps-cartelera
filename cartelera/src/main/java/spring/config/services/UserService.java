package spring.config.services;

import model.DAO.UserDAO;
import model.Token;
import model.User;
import model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Component("userService")
public class UserService {

    @Autowired
    private UserDAO userRepository;

    @Transactional
    public Token checkCredentials(String email, String password){
        return this.userRepository.checkCredentials(email, password);
    }

    @Transactional
    public User getUserById(Integer id){
        return this.userRepository.getById(id);
    }

    @Transactional
    public User getUserByEmail(String email){
        return this.userRepository.getUserByEmail(email);
    }

    @Transactional
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Transactional
    public List<User> getAll() {
        return this.userRepository.getAll();
    }
}
