package workflow.example.workflow.converter;

import org.springframework.stereotype.Component;
import workflow.example.workflow.dto.LienTacheDto;
import workflow.example.workflow.entity.LienTache;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LienTacheConverter {

    public LienTacheDto entityToDto(LienTache lienTache) {
        LienTacheDto dto = new LienTacheDto();
        dto.setId(lienTache.getId());
        dto.setSource(lienTache.getSource());
        dto.setTarget(lienTache.getTarget());
        dto.setWorkflowId(lienTache.getWorkflowId());
        dto.setTacheSourceName(lienTache.getTacheSourceName());
        dto.setTacheTargetName(lienTache.getTacheTargetName());
        dto.setType(lienTache.getType());
        return dto;
    }
    public List<LienTacheDto> entityToDto(List<LienTache> lienTaches)
    {
        return lienTaches.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
