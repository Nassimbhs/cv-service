package workflow.example.workflow.entity;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFormation;
    private String etablissement;
    private Date dateDeb;
    private Date dateFin;
    @ManyToOne
    private Cv cv;
}
