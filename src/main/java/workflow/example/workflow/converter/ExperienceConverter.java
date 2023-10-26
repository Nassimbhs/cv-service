package workflow.example.workflow.converter;

import org.springframework.stereotype.Component;
import workflow.example.workflow.dto.ExperienceDto;
import workflow.example.workflow.entity.Experience;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExperienceConverter {

    public ExperienceDto entityToDto(Experience experience){
        ExperienceDto dto = new ExperienceDto();
        dto.setId(experience.getId());
        dto.setPoste(experience.getPoste());
        dto.setEmployeur(experience.getEmployeur());
        dto.setDescription(experience.getDescription());
        dto.setDateDeb(experience.getDateDeb());
        dto.setDateFin(experience.getDateFin());
        return dto;
    }

    public List<ExperienceDto> entityToDto(List<Experience> experiences)
    {
        return experiences.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
