package model.DAO;

import model.Token;
import model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User> {

    User getUserByEmail(String email);

    Token checkCredentials(String email, String password);

    List<User> getAll();
}
