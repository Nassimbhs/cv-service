package workflow.example.workflow.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ExperienceDto {
    private Long id;
    private String poste;
    private String employeur;
    private Date dateDeb;
    private Date dateFin;
    private String description;
}
