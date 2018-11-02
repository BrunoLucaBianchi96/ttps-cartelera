package model.repositories;

import model.Billboard;
import model.Interest;
import model.Post;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BillboardRepositoryTestCase {


    private BillboardRepository billboardRepository = new BillboardRepository();
    private PostRepository postRepository = new PostRepository();
    private UserRepository userRepository = new UserRepository();
    private Billboard billboard;
    private Post post;
    private User user;

    @After
    public void deleteBillboard(){
        if(billboard != null) {
            this.billboardRepository.delete(billboard);
            this.postRepository.delete(post);
            this.userRepository.delete(user);
        }
    }

    @Before
    public void createBillboard(){
        user = new User();
        user.setName("Admin");
        List<User> listUser = Arrays.asList(user);
        this.userRepository.save(user);
        post = new Post();
        post.setTitle("Test");
        post.setUser(user);
        List<Post> listPost = Arrays.asList(post);
        this.postRepository.save(post);
        this.billboard = new Billboard();
        billboard.setUsers(listUser);
        billboard.setPosts(listPost);
        billboard.setName("Billboard");
    }

    @Test
    public void testGetById(){
        this.billboardRepository.save(billboard);
        billboard = this.billboardRepository.getById(billboard.getId());
        Assert.assertNotNull(billboard);

    }
    @Test
    public void testUpdateComment(){
        String name = "Inservible";
        this.billboardRepository.save(billboard);
        billboard.setName(name);
        this.billboardRepository.update(billboard);
        billboard = this.billboardRepository.getById(billboard.getId());
        Assert.assertEquals(name, billboard.getName());

    }

    @Test
    public void testSaveAndDeletePermission(){
        billboardRepository.save(billboard);
        Assert.assertNotNull(this.billboardRepository.getById(billboard.getId()));
        this.billboardRepository.delete(billboard);
        Assert.assertNull(this.billboardRepository.getById(billboard.getId()));
        //We create the permission again so we can delete it later in the @After :)
        this.createBillboard();
        billboardRepository.save(billboard);
    }

}
