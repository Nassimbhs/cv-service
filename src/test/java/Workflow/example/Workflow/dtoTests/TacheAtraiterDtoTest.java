package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.TacheAtraiterDto;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class TacheAtraiterDtoTest {

    @InjectMocks
    private TacheAtraiterDto tacheAtraiterDto;

    @Test
    void testTacheAtraiterDto() {
        tacheAtraiterDto.setId(1L);
        tacheAtraiterDto.setName("TestTask");
        tacheAtraiterDto.setDescription("Test description");
        tacheAtraiterDto.setCreationDate(new Date());

        assertEquals(1L, tacheAtraiterDto.getId());
        assertEquals("TestTask", tacheAtraiterDto.getName());
        assertEquals("Test description", tacheAtraiterDto.getDescription());
        assertNotNull(tacheAtraiterDto.getCreationDate());

    }

    @Test
    void testDataAnnotation() {
        TacheAtraiterDto tacheAtraiterDto = new TacheAtraiterDto();
        tacheAtraiterDto.setId(1L);
        tacheAtraiterDto.setName("Task1");
        tacheAtraiterDto.setDescription("Description");
        tacheAtraiterDto.setCreationDate(new Date());
        tacheAtraiterDto.setStartDate(new Date());
        tacheAtraiterDto.setEndDate(new Date());
        tacheAtraiterDto.setStatut("In Progress");
        tacheAtraiterDto.setAction("Complete");
        tacheAtraiterDto.setApprobation("Approved");
        tacheAtraiterDto.setResponsable(2L);
        tacheAtraiterDto.setEmailResponsable("responsable@example.com");
        tacheAtraiterDto.setWorkflowId(3L);

        assertNotNull(tacheAtraiterDto.toString());
        assertEquals(tacheAtraiterDto.hashCode(), tacheAtraiterDto.hashCode());
        assertNotNull(tacheAtraiterDto.getId());
        assertNotNull(tacheAtraiterDto.getName());
        assertNotNull(tacheAtraiterDto.getDescription());
        assertNotNull(tacheAtraiterDto.getCreationDate());
        assertNotNull(tacheAtraiterDto.getStartDate());
        assertNotNull(tacheAtraiterDto.getEndDate());
        assertNotNull(tacheAtraiterDto.getStatut());
        assertNotNull(tacheAtraiterDto.getAction());
        assertNotNull(tacheAtraiterDto.getApprobation());
        assertNotNull(tacheAtraiterDto.getResponsable());
        assertNotNull(tacheAtraiterDto.getEmailResponsable());
        assertNotNull(tacheAtraiterDto.getWorkflowId());
    }

}
