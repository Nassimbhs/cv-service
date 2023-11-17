package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.JsonDataDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class JsonDataDtoTest {

    @InjectMocks
    private JsonDataDto jsonDataDto;

    @Test
    void testJsonDataDto() {
        jsonDataDto.setId(1L);
        jsonDataDto.setResponsable(100L);
        jsonDataDto.setEtat("Processed");

        assertEquals(1L, jsonDataDto.getId());
        assertEquals(100L, jsonDataDto.getResponsable());
        assertEquals("Processed", jsonDataDto.getEtat());

    }

    @Test
    void testDataAnnotation() {
        JsonDataDto jsonDataDto = new JsonDataDto();
        jsonDataDto.setId(1L);
        jsonDataDto.setData("Some JSON data");
        jsonDataDto.setResponsable(2L);
        jsonDataDto.setEtat("In Progress");

        Assertions.assertNotNull(jsonDataDto.toString());
        assertEquals(jsonDataDto.hashCode(), jsonDataDto.hashCode());
        Assertions.assertNotNull(jsonDataDto.getId());
        Assertions.assertNotNull(jsonDataDto.getData());
        Assertions.assertNotNull(jsonDataDto.getResponsable());
        Assertions.assertNotNull(jsonDataDto.getEtat());
    }

}

