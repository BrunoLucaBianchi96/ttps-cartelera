package model.repositories;

import model.Comment;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;

@Transactional
public class CommentRepositoryTestCase {

    private CommentRepository commentRepository = new CommentRepository();
    private UserRepository userRepository = new UserRepository();
    private Comment comment;

    @After
    public void deleteComment(){
        if(comment != null) {
            this.commentRepository.delete(comment);
            this.userRepository.delete(comment.getUser());
        }
    }

    @Test
    public void testGetById(){
        comment = createComment();
        this.commentRepository.save(comment);
        comment = this.commentRepository.getById(comment.getId());
        Assert.assertNotNull(comment);

    }
    @Test
    public void testUpdateComment(){
        String text = "Usted no me puede decir eso.";
        comment = createComment();
        this.commentRepository.save(comment);
        comment.setText(text);
        this.commentRepository.update(comment);
        comment = this.commentRepository.getById(comment.getId());
        Assert.assertEquals(text, comment.getText());

    }

    private Comment createComment(){
        User user = new User();
        user.setName("Samid");
        this.userRepository.save(user);
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setText("Usted tiene que arrepentirse de lo que me dijo");
        return comment;
    }

    @Test
    public void testSaveAndDeleteComment(){
        comment = createComment();
        this.commentRepository.save(comment);
        Assert.assertNotNull(this.commentRepository.getById(comment.getId()));
        this.commentRepository.delete(comment);
        this.userRepository.delete(comment.getUser());
        Assert.assertNull(this.commentRepository.getById(comment.getId()));
    }

}
