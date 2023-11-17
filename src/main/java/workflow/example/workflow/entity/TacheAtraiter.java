package workflow.example.workflow.entity;

import lombok.*;
import org.hibernate.Hibernate;
import workflow.example.workflow.listener.TacheAtraiterListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EntityListeners(TacheAtraiterListener.class)
public class TacheAtraiter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private String statut;
    private String action;
    private String approbation;
    private Long responsable;
    private String emailResponsable;
    private Long workflowId;
    @ManyToOne
    private Tache tacheAtraite;

    @OneToMany(mappedBy = "tacheAtraiter", cascade = CascadeType.ALL)
    @ToString.Exclude
    List<Conge> conges = new ArrayList<>();

    @ManyToMany(mappedBy = "tachesAtraiter")
    @ToString.Exclude
    private List<Cv> cvs = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tache_atraiter_jsondata",
            joinColumns = @JoinColumn(name = "tache_atraiter_id"),
            inverseJoinColumns = @JoinColumn(name = "jsondata_id")
    )
    @ToString.Exclude
    private List<JsonData> jsonDatas = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TacheAtraiter that = (TacheAtraiter) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}