package jpa.entitymodels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String email;
    private String password;
    @ManyToMany(mappedBy = "users")
    private Set<Pantry> pantry;

    @ManyToMany(mappedBy = "rUsers")
    private List<Role> userRoles;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="recipe_id")
    )
    private Set<Recipe> recipe;
    private Timestamp created_on;
    private Timestamp updated_on;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.created_on = new Timestamp(System.currentTimeMillis());
        this.updated_on = new Timestamp(System.currentTimeMillis());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return userRoles;
    }

    public void setRoles(List<Role> roles) {
        this.userRoles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated_on() {
        return created_on;
    }

    public Timestamp getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Timestamp updated_on) {
        this.updated_on = updated_on;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
