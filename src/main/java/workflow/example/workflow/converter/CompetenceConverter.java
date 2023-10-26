package workflow.example.workflow.converter;

import org.springframework.stereotype.Component;
import workflow.example.workflow.dto.CompetenceDto;
import workflow.example.workflow.entity.Competence;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompetenceConverter {

    public CompetenceDto entityToDto(Competence competence){
        CompetenceDto dto = new CompetenceDto();
        dto.setId(competence.getId());
        dto.setNomCompetence(competence.getNomCompetence());
        return dto;
    }
    public List<CompetenceDto> entityToDto(List<Competence> competences)
    {
        return competences.stream().map(this::entityToDto).collect(Collectors.toList());
    }

}
