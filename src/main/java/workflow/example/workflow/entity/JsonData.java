package workflow.example.workflow.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class JsonData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "LONGTEXT")
    private String data;
    private Long responsable;
    private String etat;

    @ManyToMany(mappedBy = "jsonDatas")
    @ToString.Exclude
    private List<TacheAtraiter> tachesAtraiter = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JsonData jsonData = (JsonData) o;
        return getId() != null && Objects.equals(getId(), jsonData.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
