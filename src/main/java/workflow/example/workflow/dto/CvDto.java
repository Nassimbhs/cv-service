package workflow.example.workflow.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

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

    private List<FormationDto> formationDtos = new ArrayList<FormationDto>();
    private List<CompetenceDto> competenceDtos = new ArrayList<CompetenceDto>();
    private List<LangueDto> langueDtos = new ArrayList<LangueDto>();
    private List<InteretDto> interetDtos = new ArrayList<InteretDto>();
    private List<ExperienceDto> experienceDtos = new ArrayList<ExperienceDto>();

}
