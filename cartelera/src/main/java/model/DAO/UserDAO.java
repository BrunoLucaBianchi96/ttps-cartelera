package model.DAO;

import model.Token;
import model.User;

public interface UserDAO extends GenericDAO<User> {

    User getUserByEmail(String email);

    Token checkCredentials(String email, String password);
}
