package workflow.example.workflow.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LienTache implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq")
    @SequenceGenerator(name = "my_entity_seq", initialValue = 100, allocationSize = 1)
    private Long id;
    private String source ;
    private String target ;
    private String workflowId;
    private String tacheSourceName;
    private String tacheTargetName;
    private String type;

    @ManyToOne
    private Tache tacheLien;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LienTache lienTache = (LienTache) o;
        return getId() != null && Objects.equals(getId(), lienTache.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}