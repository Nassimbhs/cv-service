package workflow.example.workflow.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CongeDto {

    private Long id;
    private Date dateDeb;
    private Date dateFin;
    private String type;
    private String statut;
    private String commentaire;
    private String responsable;

}
