package jpa.entitymodels;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="recipe_ingredient")
public class RecipeIngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    Recipe recipe;
    @ManyToOne
    Ingredient ingredient;
    private int quantity;
    @ManyToOne
    Measurement measurement;

    private Timestamp created_on;
    private Timestamp updated_on;
}
