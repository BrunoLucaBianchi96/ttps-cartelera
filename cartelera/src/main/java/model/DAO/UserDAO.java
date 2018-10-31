package model.DAO;

import model.User;

public interface UserDAO extends GenericDAO<User> {

    User getUserByEmail(String email);

    User getUserById(int id);
}
