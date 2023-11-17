package workflow.example.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExperienceDto {
    private Long id;
    private String poste;
    private String employeur;
    private Date dateDeb;
    private Date dateFin;
    private String description;
}
