package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.TacheDto;
import java.util.ArrayList;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
class TacheDtoTest {
    @InjectMocks
    private TacheDto tacheDto;

    @Test
    void testTacheDto() {
        tacheDto.setId(1L);
        tacheDto.setName("TestTask");
        tacheDto.setDescription("Test description");
        tacheDto.setCreationDate(new Date());
        tacheDto.setAction("");
        tacheDto.setStatut("");
        tacheDto.setTriggerType("");

        Assertions.assertEquals("TestTask", tacheDto.getName());
        Assertions.assertEquals("Test description", tacheDto.getDescription());
        Assertions.assertNotNull(tacheDto.getCreationDate());
        Assertions.assertNotNull(tacheDto.getId());
        Assertions.assertNotNull(tacheDto.getName());
        Assertions.assertNotNull(tacheDto.getDescription());
        Assertions.assertNotNull(tacheDto.getAction());
        Assertions.assertNotNull(tacheDto.getStatut());
        Assertions.assertNotNull(tacheDto.getTriggerType());
    }

    @Test
    void testDataAnnotations() {
        TacheDto tacheDto = new TacheDto();
        tacheDto.setId(1L);
        tacheDto.setName("Task1");
        tacheDto.setDescription("Description");
        tacheDto.setCreationDate(new Date());
        tacheDto.setStartDate(new Date());
        tacheDto.setEndDate(new Date());
        tacheDto.setStatut("In Progress");
        tacheDto.setTriggerType("Manual");
        tacheDto.setAction("Complete");
        tacheDto.setApprobation("Approved");
        tacheDto.setLienTacheDtos(new ArrayList<>());
        tacheDto.setTacheAtraiterDtos(new ArrayList<>());

        Assertions.assertNotNull(tacheDto.toString());
        Assertions.assertEquals("Task1", tacheDto.getName());
        Assertions.assertEquals("Description", tacheDto.getDescription());
        Assertions.assertNotNull(tacheDto.getCreationDate());
        Assertions.assertNotNull(tacheDto.getStartDate());
        Assertions.assertNotNull(tacheDto.getEndDate());
        Assertions.assertEquals("In Progress", tacheDto.getStatut());
        Assertions.assertEquals("Manual", tacheDto.getTriggerType());
        Assertions.assertEquals("Complete", tacheDto.getAction());
        Assertions.assertEquals("Approved", tacheDto.getApprobation());
        Assertions.assertNotNull(tacheDto.getLienTacheDtos());
        Assertions.assertNotNull(tacheDto.getTacheAtraiterDtos());
    }
}
