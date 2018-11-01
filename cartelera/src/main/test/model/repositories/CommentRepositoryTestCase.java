package model.repositories;

import model.Comment;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;

@Transactional
public class CommentRepositoryTestCase {

    private CommentRepository commentRepository = new CommentRepository();

    @Test
    public void test(){
        Comment comment = new Comment();
        comment.setText("Usted tiene que arrepentirse de lo que me dijo");
        commentRepository.save(comment);
        Assert.assertNotNull(comment.getId());
        commentRepository.delete(comment);
    }
}
