package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {

    public static EntityManagerFactory getEMF(){
        return Persistence.createEntityManagerFactory("org.hibernate.cartelera.jpa");
    }
}
