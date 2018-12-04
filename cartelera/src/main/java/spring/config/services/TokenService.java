package spring.config.services;

import model.DAO.TokenDAO;
import model.DAO.UserDAO;
import model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component("tokenService")
public class TokenService {

    @Autowired
    private TokenDAO tokenRepository;

    @Transactional
    public Token getByUserId(int id) {
        return this.tokenRepository.getByUserId(id);
    }

    @Transactional
    public Token updateToken(Token token) {
        String newToken = "pretendHash"; // TO-DO do this
        token.setToken(newToken);
        this.tokenRepository.update(token);
        return token;
    }
}