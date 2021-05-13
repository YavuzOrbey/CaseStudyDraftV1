package jpa.entitymodels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "recipe")
    Set<Meal> meal;
/*    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="recipe_id"),
            inverseJoinColumns = @JoinColumn(name="step_id")
    )
    private Set<StepEntity> stepEntity;*/
    private Timestamp created_on;
    private Timestamp updated_on;

    public Recipe() {
    }

    public Recipe(String name) {
        this.name = name;
        this.created_on = new Timestamp(System.currentTimeMillis());
        this.updated_on = new Timestamp(System.currentTimeMillis());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Meal> getMealEntity() {
        return meal;
    }

    public void setMealEntity(Set<Meal> meal) {
        this.meal = meal;
    }

    public Timestamp getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Timestamp updated_on) {
        this.updated_on = updated_on;
    }

    public Timestamp getCreated_on() {
        return created_on;
    }
}
