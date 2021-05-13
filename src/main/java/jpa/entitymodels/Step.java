package jpa.entitymodels;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="step")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private int stepOrder   ;
    private Timestamp created_on;
    private Timestamp updated_on;
    @ManyToOne
    private Recipe recipe;
  /*  @ManyToMany(mappedBy = "stepEntity")
    Set<RecipeEntity> recipeEntity;
*/

    public Step() {
    }

    public Step(String text, int stepOrder) {
        this.text = text;
        this.stepOrder = stepOrder;
        this.created_on = new Timestamp(System.currentTimeMillis());
        this.updated_on = new Timestamp(System.currentTimeMillis());
    }


    public Timestamp getCreated_on() {
        return created_on;
    }

    public Timestamp getUpdated_on() {
        return updated_on;
    }

    @Override
    public String toString() {
        return "StepEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", stepOrder=" + stepOrder +
                ", created_on=" + created_on +
                ", updated_on=" + updated_on +
                ", recipeEntity=" + recipe +
                '}';
    }

    public void setUpdated_on(Timestamp updated_on) {
        this.updated_on =  new Timestamp(System.currentTimeMillis());
    }
}
