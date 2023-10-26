package workflow.example.workflow.entity;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
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
}