package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.LienTacheDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LienTacheDtoTest {

    @InjectMocks
    private LienTacheDto lienTacheDto;

    @Test
    void testLienTacheDto() {
        lienTacheDto.setId(1L);
        lienTacheDto.setSource("SourceTask");
        lienTacheDto.setTarget("TargetTask");
        lienTacheDto.setWorkflowId("Workflow123");

        assertEquals(1L, lienTacheDto.getId());
        assertEquals("SourceTask", lienTacheDto.getSource());
        assertEquals("TargetTask", lienTacheDto.getTarget());
        assertEquals("Workflow123", lienTacheDto.getWorkflowId());
    }

    @Test
    void testDataAnnotation() {
        LienTacheDto lienTacheDto = new LienTacheDto();
        lienTacheDto.setId(1L);
        lienTacheDto.setSource("Task1");
        lienTacheDto.setTarget("Task2");
        lienTacheDto.setWorkflowId("Workflow1");
        lienTacheDto.setTacheSourceName("SourceTask");
        lienTacheDto.setTacheTargetName("TargetTask");
        lienTacheDto.setType("Dependency");

        Assertions.assertNotNull(lienTacheDto.toString());
        assertEquals(lienTacheDto.hashCode(), lienTacheDto.hashCode());
        Assertions.assertNotNull(lienTacheDto.getId());
        Assertions.assertNotNull(lienTacheDto.getSource());
        Assertions.assertNotNull(lienTacheDto.getTarget());
        Assertions.assertNotNull(lienTacheDto.getWorkflowId());
        Assertions.assertNotNull(lienTacheDto.getTacheSourceName());
        Assertions.assertNotNull(lienTacheDto.getTacheTargetName());
        Assertions.assertNotNull(lienTacheDto.getType());
    }

}
