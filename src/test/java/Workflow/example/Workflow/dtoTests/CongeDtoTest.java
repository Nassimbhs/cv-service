package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.CongeDto;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CongeDtoTest {

    @InjectMocks
    private CongeDto congeDto;

    @Test
    void testCongeDto() {
        congeDto.setId(1L);
        congeDto.setDateDeb(new Date());
        congeDto.setDateFin(new Date());
        congeDto.setType("Vacation");
        congeDto.setStatut("Approved");
        congeDto.setCommentaire("Enjoy your time off!");
        congeDto.setResponsable("Manager ABC");

        assertEquals(1L, congeDto.getId());
        assertNotNull(congeDto.getDateDeb());
        assertNotNull(congeDto.getDateFin());
        assertEquals("Vacation", congeDto.getType());
        assertEquals("Approved", congeDto.getStatut());
        assertEquals("Enjoy your time off!", congeDto.getCommentaire());
        assertEquals("Manager ABC", congeDto.getResponsable());

    }
    @Test
    void testDataAnnotation() {
        CongeDto congeDto = new CongeDto(1L, new Date(), new Date(), "Vacation", "Approved", "Enjoying time off", "John Doe");
        assertNotNull(congeDto.toString());
        assertEquals(congeDto.hashCode(), congeDto.hashCode());
        assertNotNull(congeDto.getId());
        assertNotNull(congeDto.getDateDeb());
        assertNotNull(congeDto.getDateFin());
        assertNotNull(congeDto.getType());
        assertNotNull(congeDto.getStatut());
        assertNotNull(congeDto.getCommentaire());
        assertNotNull(congeDto.getResponsable());
    }
}
