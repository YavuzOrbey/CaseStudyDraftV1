package jpa.entitymodels;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="meal")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(mappedBy = "meal")
    Set<MealType> mealType;

    @ManyToMany
    @JoinTable(name = "meal_recipe",
            joinColumns = @JoinColumn(name="meal_id"),
            inverseJoinColumns = @JoinColumn(name="recipe_id")
    )
    Set<Recipe> recipe;
    private Date theDate;

    private Timestamp created_on;
    private Timestamp updated_on;

}
