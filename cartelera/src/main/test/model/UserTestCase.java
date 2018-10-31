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

    @Before
    public void initTest() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.cartelera.jpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void test() {
        User user = new User();
        user.setName("Juan");
        Assert.assertEquals("Juan", user.getName());
    }

}
