import model.Interest;
import model.Permission;
import model.User;
import model.repositories.*;
import org.junit.Test;

import javax.transaction.Transactional;
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



    }
}
