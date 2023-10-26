package workflow.example.workflow.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class WorkflowDto {

    private Long id;
    private String name;
    private String description;
    private Date creationDate;
    private Date lastModifiedDate;
    private String etat;
    private String declencheur;
    private String webhookUrl;
    private String jdbcUrl;
    private String username;
    private String password;
    private String sgbd;
    private String tacheAecouter;
    private String evenement;

    private List<TacheDto> tacheDtoList = new ArrayList<TacheDto>();
}
