package jpa.entitymodels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
@Entity
@Table(name="mealType")
public class MealType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "mealType_meal",
            joinColumns = @JoinColumn(name="mealType_id"),
            inverseJoinColumns = @JoinColumn(name="meal_id")
    )
    Set<Meal> meal;

    private Timestamp created_on;
    private Timestamp updated_on;
}
