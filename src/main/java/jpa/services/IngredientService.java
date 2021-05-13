package jpa.services;

import jpa.dao.IngredientDAO;
import jpa.entitymodels.Ingredient;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

public class IngredientService implements IngredientDAO {
    @Override
    public Ingredient findById(int id) {
        Ingredient ingredient =  entityManager.find(Ingredient.class, id);
        return ingredient;
    }

    @Override
    public void updateDatabase(Ingredient entity) {
        entity.setUpdated_on(new Timestamp(System.currentTimeMillis()));
        entityManager.merge(entity);
    }

    @Override
    public List<Ingredient> findAll() {
        Query q = entityManager.createQuery("SELECT i FROM Ingredient i");
        return (List<Ingredient>) q.getResultList();
    }
}
