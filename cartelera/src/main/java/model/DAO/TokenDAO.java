package model.DAO;

import model.Token;

import java.util.ArrayList;

public interface TokenDAO extends GenericDAO<Token> {

    ArrayList<Token> getAll();
    ArrayList<Token> getByUserId(int id);

    Boolean checkIfExists(String token, int id);
}
