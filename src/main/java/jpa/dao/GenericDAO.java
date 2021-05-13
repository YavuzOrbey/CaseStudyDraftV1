package jpa.dao;

import javax.persistence.Entity;
import java.util.List;

public interface GenericDAO<E> extends DatabaseDAO{
    E findById(int id);
    default void saveToDatabase(E entity){
        entityManager.persist(entity);
        System.out.println("Saved to database!");
    }
    default void updateDatabase(E entity){
        entityManager.merge(entity);
    }

    List<E> findAll();
}
