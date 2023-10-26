package workflow.example.workflow.converter;

import org.springframework.stereotype.Component;
import workflow.example.workflow.dto.JsonDataDto;
import workflow.example.workflow.entity.JsonData;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JsonDataConverter {

    public JsonDataDto entityToDto(JsonData jsonData){
        JsonDataDto dto = new JsonDataDto();
        dto.setId(jsonData.getId());
        dto.setData(jsonData.getData());
        dto.setResponsable(jsonData.getResponsable());
        dto.setEtat(jsonData.getEtat());
        return dto;
    }
    public List<JsonDataDto> entityToDto(List<JsonData> jsonData)
    {
        return jsonData.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
