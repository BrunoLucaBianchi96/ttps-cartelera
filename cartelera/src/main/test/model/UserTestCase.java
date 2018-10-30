package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

@Transactional
public class UserTestCase {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Test
    public void test(){
        User user = new User();
        user.setName("Juan");
        Assert.assertEquals("Juan", user.getName());
    }


    @Before
    public void initTest(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.cartelera.jpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    @Transactional
    public void testPersistence(){
        User user = new User();
        user.setName("Nice");
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        this.entityManager.getTransaction().commit();
        this.entityManagerFactory.close();
    }
}
