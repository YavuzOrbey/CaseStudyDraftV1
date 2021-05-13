package jpa.services;

import jpa.dao.RecipeDAO;
import jpa.entitymodels.Recipe;

import javax.persistence.Query;
import java.util.List;

public class RecipeService implements RecipeDAO {
    @Override
    public Recipe findById(int id) {
        Recipe recipe =  entityManager.find(Recipe.class, id);
        return recipe;
    }

    @Override
    public List<Recipe> findAll() {
        Query q = entityManager.createQuery("SELECT r FROM Recipe r");
        return ( List<Recipe>) q.getResultList();
    }
}
