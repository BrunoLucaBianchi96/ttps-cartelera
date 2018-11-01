package model.DAO;



import model.Billboard;
import model.Interest;
import model.Post;

import java.util.List;

public interface BillboardDAO extends GenericDAO<Billboard> {
    List<Interest> getAllInterestedFromBillboardId(Integer id);
    List<Post> getAllPostsFromBillboardId(Integer id);

}

