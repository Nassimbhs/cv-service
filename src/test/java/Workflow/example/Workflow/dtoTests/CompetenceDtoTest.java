package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.CompetenceDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CompetenceDtoTest {

    @InjectMocks
    private CompetenceDto competenceDto;

    @Test
    void testCompetenceDto() {
        competenceDto.setId(1L);
        competenceDto.setNomCompetence("Java Programming");

        assertEquals(1L, competenceDto.getId());
        assertEquals("Java Programming", competenceDto.getNomCompetence());

    }

    @Test
    void testDataAnnotation() {
        CompetenceDto competenceDto = new CompetenceDto(1L, "Java");
        Assertions.assertNotNull(competenceDto.toString());
        assertEquals(competenceDto.hashCode(), competenceDto.hashCode());
        Assertions.assertNotNull(competenceDto.getId());
        Assertions.assertNotNull(competenceDto.getNomCompetence());
    }

}
