package workflow.example.workflow.entity;

import lombok.*;
import org.hibernate.Hibernate;
import workflow.example.workflow.listener.CvListener;

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
@EntityListeners(CvListener.class)
public class Cv implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nomFamille;
    private String email;
    private String titreProfil;
    private Long tel;
    private String addresse;
    private String ville;
    private Long workflow;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Competence> competences = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Formation> formations = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Langue> langues = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Interet> interets = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cv_tache",
            joinColumns = @JoinColumn(name = "cv_id"),
            inverseJoinColumns = @JoinColumn(name = "tache_id")
    )
    @ToString.Exclude
    private List<TacheAtraiter> tachesAtraiter = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        var cv = (Cv) o;
        return getId() != null && Objects.equals(getId(), cv.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}