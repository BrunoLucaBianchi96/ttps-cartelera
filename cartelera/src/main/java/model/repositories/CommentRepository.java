package model.repositories;

import model.Comment;
import model.DAO.GenericDAOHibernateJPA;
import model.Post;

import java.util.List;

public class CommentRepository extends GenericDAOHibernateJPA<Comment> {
    @Override
    public Class<Comment> getPersistentClass() {
        return Comment.class;
    }

    public List<Comment> getAllCommentsForPost(Post post){
        return this.getEntityManager().createNativeQuery("SELECT * FROM post WHERE post_id = :postId ", getPersistentClass())
                .setParameter("postId", post.getId())
                .getResultList();
    }
}
