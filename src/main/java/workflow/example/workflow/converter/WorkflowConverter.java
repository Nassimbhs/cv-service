package workflow.example.workflow.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workflow.example.workflow.dto.WorkflowDto;
import workflow.example.workflow.entity.Workflow;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkflowConverter {
    @Autowired
    private TacheConverter tacheConverter;

    public WorkflowDto entityToDto(Workflow workflow){

        WorkflowDto dto = new WorkflowDto();
        dto.setId(workflow.getId());
        dto.setName(workflow.getName());
        dto.setDescription(workflow.getDescription());
        dto.setEtat(workflow.getEtat());
        dto.setCreationDate(workflow.getCreationDate());
        dto.setLastModifiedDate(workflow.getLastModifiedDate());
        dto.setWebhookUrl(workflow.getWebhookUrl());
        dto.setDeclencheur(workflow.getDeclencheur());
        dto.setSgbd(workflow.getSgbd());
        dto.setJdbcUrl(workflow.getJdbcUrl());
        dto.setUsername(workflow.getUsername());
        dto.setPassword(workflow.getPassword());
        dto.setTacheAecouter(workflow.getTacheAecouter());
        dto.setEvenement(workflow.getEvenement());
        dto.setTacheDtoList(tacheConverter.entityToDto(workflow.getTaches()));
        return dto;
    }

    public List<WorkflowDto> entityToDto(List<Workflow> workflows)
    {
        return workflows.stream().map(this::entityToDto).collect(Collectors.toList());
    }

}
