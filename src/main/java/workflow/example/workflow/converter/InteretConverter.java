package workflow.example.workflow.converter;

import org.springframework.stereotype.Component;
import workflow.example.workflow.dto.InteretDto;
import workflow.example.workflow.entity.Interet;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InteretConverter {

    public InteretDto entityToDto(Interet interet){
        InteretDto dto = new InteretDto();
        dto.setId(interet.getId());
        dto.setInteret(interet.getInteret());
        return dto;
    }

    public List<InteretDto> entityToDto(List<Interet> interets)
    {
        return interets.stream().map(this::entityToDto).collect(Collectors.toList());
    }

}
