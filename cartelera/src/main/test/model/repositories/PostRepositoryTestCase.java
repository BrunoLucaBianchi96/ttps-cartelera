package model.repositories;

import model.Billboard;
import model.Comment;
import model.Post;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PostRepositoryTestCase {


    private BillboardRepository billboardRepository = new BillboardRepository();
    private PostRepository postRepository = new PostRepository();
    private UserRepository userRepository = new UserRepository();
    private CommentRepository commentRepository = new CommentRepository();
    private Billboard billboard;
    private Comment comment;
    private User user;
    private Post post;


    @After
    public void deletePost(){
        if(post != null) {
            this.postRepository.delete(post);
            this.billboardRepository.delete(billboard);
            this.commentRepository.delete(comment);
            this.userRepository.delete(user);
        }
    }

    @Before
    public void createPost(){
        user = new User();
        user.setName("Admin");
        this.userRepository.save(user);
        comment = new Comment();
        comment.setText("TESTING");
        comment.setUser(user);
        this.commentRepository.save(comment);
        List<Comment> listComment = Arrays.asList(comment);
        post = new Post();
        post.setTitle("Test");
        post.setUser(user);
        this.billboard = new Billboard();
        billboard.setName("Billboard");
        this.billboardRepository.save(billboard);
        post.setBillboard(billboard);
    }

    @Test
    public void testGetById(){
        this.postRepository.save(post);
        post = this.postRepository.getById(post.getId());
        Assert.assertNotNull(postRepository);

    }
    @Test
    public void testUpdateComment(){
        String name = "Inservible";
        this.postRepository.save(post);
        post.setTitle(name);
        this.postRepository.update(post);
        post = this.postRepository.getById(post.getId());
        Assert.assertEquals(name, post.getTitle());

    }

    @Test
    public void testSaveAndDeletePermission(){
        postRepository.save(post);
        Assert.assertNotNull(this.postRepository.getById(post.getId()));
        this.postRepository.delete(post);
        Assert.assertNull(this.postRepository.getById(post.getId()));
        //We create the permission again so we can delete it later in the @After :)
        this.createPost();
        postRepository.save(post);
    }
}
