package workflow.example.workflow.converter;

import org.springframework.stereotype.Component;
import workflow.example.workflow.dto.CongeDto;
import workflow.example.workflow.entity.Conge;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CongeConverter {
    public CongeDto entityToDto(Conge conge){
        CongeDto dto = new CongeDto();
        dto.setId(conge.getId());
        dto.setType(conge.getType());
        dto.setStatut(conge.getStatut());
        dto.setDateDeb(conge.getDateDeb());
        dto.setDateFin(conge.getDateFin());
        dto.setCommentaire(conge.getCommentaire());
        dto.setResponsable(conge.getResponsable());
        return dto;
    }
    public List<CongeDto> entityToDto(List<Conge> conges)
    {
        return conges.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
