package workflow.example.workflow.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class TacheAtraiterDto implements Serializable {

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

}
