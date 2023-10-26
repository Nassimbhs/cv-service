package workflow.example.workflow.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FormationDto {
    private Long id;
    private String nomFormation;
    private String etablissement;
    private Date dateDeb;
    private Date dateFin;
}
