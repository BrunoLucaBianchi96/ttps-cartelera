package model.repositories;

import model.Billboard;
import model.Comment;
import model.DAO.GenericDAOHibernateJPA;
import model.Post;
import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostRepository extends GenericDAOHibernateJPA<Post> {

    @Override
    public Class<Post> getPersistentClass() { { return Post.class; }
    }
}
