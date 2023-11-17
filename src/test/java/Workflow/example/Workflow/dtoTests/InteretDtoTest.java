package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.InteretDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class InteretDtoTest {

    @InjectMocks
    private InteretDto interetDto;

    @Test
    void testInteretDto() {
        interetDto.setId(1L);
        interetDto.setNom("Programming");

        assertEquals(1L, interetDto.getId());
        assertEquals("Programming", interetDto.getNom());
    }

    @Test
    void testDataAnnotation() {
        InteretDto interetDto = new InteretDto();
        interetDto.setId(1L);
        interetDto.setNom("Reading");

        Assertions.assertNotNull(interetDto.toString());
        assertEquals(interetDto.hashCode(), interetDto.hashCode());
        Assertions.assertNotNull(interetDto.getId());
        Assertions.assertNotNull(interetDto.getNom());
    }

}
