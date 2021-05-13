package jpa.entitymodels;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name="role_user",
            joinColumns = @JoinColumn(name="role_id",  referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="user_id",  referencedColumnName="id")
    )

    private List<User> rUsers;


    private Timestamp created_on;
    private Timestamp updated_on;

    public Role() {
        this.created_on = new Timestamp(System.currentTimeMillis());
        this.updated_on = new Timestamp(System.currentTimeMillis());
    }

    public Role(String name) {
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

    public void setUsers(List<User> users) {
        this.rUsers = users;
    }
    public List<User> getUsers() {
        return rUsers;
    }

    public void setUserEntity(List<User> users) {
        this.rUsers = users;
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
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
