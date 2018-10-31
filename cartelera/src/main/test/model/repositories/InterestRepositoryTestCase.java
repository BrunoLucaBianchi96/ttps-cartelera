package model.repositories;

import model.Billboard;
import model.Interest;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

@Transactional
public class InterestRepositoryTestCase {

    private InterestRepository interestRepository = new InterestRepository();
    private UserRepository userRepository = new UserRepository();
    private BillboardRepository billboardRepository = new BillboardRepository();
    private Interest interest;

    @Test
    public void testCreateAndDeleteInterest() {
        User user = new User();
        user.setName("Pepe");
        this.userRepository.save(user);

        Billboard billboard = new Billboard();
        billboardRepository.save(billboard);

        interest = new Interest();
        interest.setUser(user);
        interest.setBillboard(billboard);
        interestRepository.save(interest);
        Assert.assertEquals(interest.getId(), this.interestRepository.getAllInterestsForUserId(user.getId()).get(0).getId());

        // Post-test row deletion
        interestRepository.delete(interest);
        billboardRepository.delete(billboard);
    }
}
