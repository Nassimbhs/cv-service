package workflow.example.workflow.converter;

import org.springframework.stereotype.Component;
import workflow.example.workflow.dto.TacheAtraiterDto;
import workflow.example.workflow.entity.TacheAtraiter;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TacheAtraiterConverter {
    public TacheAtraiterDto entityToDto(TacheAtraiter tacheAtraiter) {
        TacheAtraiterDto dto = new TacheAtraiterDto();
        dto.setId(tacheAtraiter.getId());
        dto.setResponsable(tacheAtraiter.getResponsable());
        dto.setName(tacheAtraiter.getName());
        dto.setDescription(tacheAtraiter.getDescription());
        dto.setEndDate(tacheAtraiter.getEndDate());
        dto.setStatut(tacheAtraiter.getStatut());
        dto.setAction(tacheAtraiter.getAction());
        dto.setWorkflowId(tacheAtraiter.getWorkflowId());
        dto.setEmailResponsable(tacheAtraiter.getEmailResponsable());
        dto.setApprobation(tacheAtraiter.getApprobation());
        dto.setResponsable(tacheAtraiter.getResponsable());
        return dto;
    }

    public List<TacheAtraiterDto> entityToDto(List<TacheAtraiter> tacheAtraiters) {
        return tacheAtraiters.stream().map(this::entityToDto).collect(Collectors.toList());
    }

}
