package model.repositories;

import model.Billboard;
import model.Comment;
import model.Interest;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.Date;

@Transactional
public class InterestRepositoryTestCase {

    private InterestRepository interestRepository = new InterestRepository();
    private UserRepository userRepository = new UserRepository();
    private BillboardRepository billboardRepository = new BillboardRepository();
    private Interest interest;

    @After
    public void deleteInterest(){
        if(interest != null) {
            this.interestRepository.delete(interest);
            this.userRepository.delete(interest.getUser());
            this.billboardRepository.delete(interest.getBillboard());
        }
    }

    @Test
    public void testGetById(){
        interest = createInterest();
        this.interestRepository.save(interest);
        interest = this.interestRepository.getById(interest.getId());
        Assert.assertNotNull(interest);
    }

    @Test
    public void testUpdateInterest(){


        interest = createInterest();
        this.interestRepository.save(interest);



        this.interestRepository.update(interest);
        interest = this.interestRepository.getById(interest.getId());
        Assert.assertEquals( "e", interest.getUser());
    }

    private Interest createInterest(){
        User user = new User();
        user.setName("Pepe");
        this.userRepository.save(user);

        Billboard billboard = new Billboard();
        billboardRepository.save(billboard);

        interest = new Interest();
        interest.setUser(user);
        interest.setBillboard(billboard);
        return interest;
    }

    @Test
    public void testSaveAndDeleteInterest(){
        interest = createInterest();
        this.interestRepository.save(interest);
        Assert.assertNotNull(this.interestRepository.getById(interest.getId()));
        this.interestRepository.delete(interest);
        Assert.assertNull(this.interestRepository.getById(interest.getId()));
    }
}
