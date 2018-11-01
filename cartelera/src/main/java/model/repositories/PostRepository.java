package model.repositories;

import model.Billboard;
import model.Comment;
import model.DAO.GenericDAOHibernateJPA;
import model.Post;
import model.User;

import java.util.List;

public class PostRepository extends GenericDAOHibernateJPA<Post> {

    @Override
    public Class<Post> getPersistentClass() { { return Post.class; }
    }
}
