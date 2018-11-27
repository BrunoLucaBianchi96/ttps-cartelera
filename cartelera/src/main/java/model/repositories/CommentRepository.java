package model.repositories;

import model.Comment;
import model.DAO.GenericDAOHibernateJPA;
import model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@PersistenceContext
@Transactional
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
