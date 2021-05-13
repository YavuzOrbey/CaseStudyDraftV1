package jpa.entitymodels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="pantry")
public class Pantry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="pantry_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private Set<User> users;
    private Timestamp created_on;
    private Timestamp updated_on;
}
