package workflow.example.workflow.entity;

import javax.persistence.*;
import lombok.*;
import workflow.example.workflow.listener.TacheListener;

import java.io.Serializable;
import java.util.*;

@Entity
@Data
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
    private List<LienTache> lienTaches = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_tache",
            joinColumns = @JoinColumn(name = "tache_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy = "tacheAtraite", cascade = CascadeType.ALL)
    private List<TacheAtraiter> tacheAtraiters = new ArrayList<>();

}
