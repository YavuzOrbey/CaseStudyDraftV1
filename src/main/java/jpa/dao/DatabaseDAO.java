package jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface DatabaseDAO {

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("food");;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        static void startDatabase(){

        }

        static void closeDatabase(){
            entityManager.close();
            entityManagerFactory.close();
        }

        static EntityManager getEntityManager() {
            return entityManager;
        }
    }

