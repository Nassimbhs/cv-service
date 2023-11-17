package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.JsonDataConverter;
import workflow.example.workflow.dto.JsonDataDto;
import workflow.example.workflow.entity.JsonData;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class JsonDataConverterTest {

    @InjectMocks
    private JsonDataConverter jsonDataConverter;

    @Test
    void testEntityToDto() {
        JsonData jsonData = createSampleJsonData();

        JsonDataDto dto = jsonDataConverter.entityToDto(jsonData);

        assertEquals(jsonData.getId(), dto.getId());
        assertEquals(jsonData.getData(), dto.getData());
        assertEquals(jsonData.getResponsable(), dto.getResponsable());
        assertEquals(jsonData.getEtat(), dto.getEtat());
    }

    @Test
    void testEntityToDtoList() {
        List<JsonData> jsonDataList = Collections.singletonList(createSampleJsonData());

        List<JsonDataDto> dtoList = jsonDataConverter.entityToDto(jsonDataList);

        assertEquals(jsonDataList.size(), dtoList.size());
    }

    private JsonData createSampleJsonData() {
        return new JsonData();
    }

}
