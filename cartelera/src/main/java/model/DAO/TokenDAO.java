package model.DAO;

import model.Token;

import java.util.ArrayList;

public interface TokenDAO extends GenericDAO<Token> {

    ArrayList<Token> getAll();
    Token getByUserId(int id);
}
