package workflow.example.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CvDto {

    private Long id;
    private String prenom;
    private String nomFamille;
    private String email;
    private String titreProfil;
    private Long tel;
    private String addresse;
    private String ville;
    private Long workflow;

    private List<FormationDto> formationDtos = new ArrayList<>();
    private List<CompetenceDto> competenceDtos = new ArrayList<>();
    private List<LangueDto> langueDtos = new ArrayList<>();
    private List<InteretDto> interetDtos = new ArrayList<>();
    private List<ExperienceDto> experienceDtos = new ArrayList<>();

}
