package model.repositories;

import model.Comment;
import model.User;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;

@Transactional
public class CommentRepositoryTestCase {

    private CommentRepository commentRepository = new CommentRepository();
    private UserRepository userRepository = new UserRepository();

    @Test
    public void test(){
        User user = new User();
        user.setName("pedro");
        userRepository.save(user);
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setText("Usted tiene que arrepentirse de lo que me dijo");
        commentRepository.save(comment);
        Assert.assertNotNull(comment.getId());

        commentRepository.delete(comment);
        userRepository.delete(user);
    }
}
