package jpa.entitymodels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="nutrient")
public class Nutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="nutrient_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id")
    )
    private Set<Ingredient> ingredients;
    @ManyToMany(mappedBy = "nutrients")
    private Set<Measurement> measurements;

    private Timestamp created_on = new Timestamp(System.currentTimeMillis());
    private Timestamp updated_on = new Timestamp(System.currentTimeMillis());
}
