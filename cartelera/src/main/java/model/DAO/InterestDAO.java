package model.DAO;

import model.Interest;
import java.util.List;

public interface InterestDAO extends GenericDAO<Interest> {
    List<Interest> getAllInterestsForUserId(Integer id);
}
