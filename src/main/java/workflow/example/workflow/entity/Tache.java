package workflow.example.workflow.entity;

import lombok.*;
import org.hibernate.Hibernate;
import workflow.example.workflow.listener.TacheListener;

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
@EntityListeners(TacheListener.class)
public class Tache implements Serializable {

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
    @ManyToOne
    private Workflow workflowTache;

    @OneToMany(mappedBy = "tacheLien", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<LienTache> lienTaches = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_tache",
            joinColumns = @JoinColumn(name = "tache_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @ToString.Exclude
    private List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy = "tacheAtraite", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TacheAtraiter> tacheAtraiters = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tache tache = (Tache) o;
        return getId() != null && Objects.equals(getId(), tache.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
