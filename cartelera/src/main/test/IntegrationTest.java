import model.*;
import model.repositories.*;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;


@Transactional
public class IntegrationTest {

    private BillboardRepository billboardRepository = new BillboardRepository();
    private CommentRepository commentRepository = new CommentRepository();
    private InterestRepository interestRepository = new InterestRepository();
    private PermissionRepository permissionRepository = new PermissionRepository();
    private PostRepository postRepository = new PostRepository();
    private RoleRepository roleRepository = new RoleRepository();
    private UserRepository userRepository = new UserRepository();

    @Test
    public void test(){

        User user = new User();
        user.setName("Marco");
        user.setLastName("Polo");
        user.setEmail("polo@gmail.com");
        user.setPassword("vgwe45t3GVB#");
        user.setNotificationType("notification type");
        userRepository.save(user);

        Permission permission = new Permission();
        permission.setCreated_at( new Date());
        permission.setName("permission name");
        permissionRepository.save(permission);

        Role role = new Role();
        role.setName("Test role");
        role.setPermissions(Collections.singletonList(permission));
        roleRepository.save(role);

        Billboard billboard = new Billboard();
        billboard.setUsers(Collections.singletonList(user));
        billboardRepository.save(billboard);

        user.setRoles(Collections.singletonList(role));
        user.setBillboards(Collections.singletonList(billboard));
        userRepository.update(user);

        Post post = new Post();
        post.setCommentsEnabled(true);
        post.setTitle("Cool Post");
        post.setUser(user);
        post.setBillboard(billboard);
        post.setContent("Usted se tiene que arrepentir de lo que me dijo");
        postRepository.save(post);

        Comment comment = new Comment();
        comment.setText("Usted no me puede decir eso");
        comment.setUser(user);
        comment.setPost(post);
        commentRepository.save(comment);

        Interest interest = new Interest();
        interest.setUser(user);
        interest.setBillboard(billboard);
        interestRepository.save(interest);







        permissionRepository.delete(permission);
        postRepository.delete(post);
        commentRepository.delete(comment);
        interestRepository.delete(interest);
        billboardRepository.delete(billboard);
        //roleRepository.delete(role);
        //userRepository.delete(user);
    }
}
