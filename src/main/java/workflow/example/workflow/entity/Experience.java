package workflow.example.workflow.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String poste;
    private String employeur;
    private Date dateDeb;
    private Date dateFin;
    private String description;

    @ManyToOne
    private Cv cv;
}
