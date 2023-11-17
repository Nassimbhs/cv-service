package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.CompetenceConverter;
import workflow.example.workflow.dto.CompetenceDto;
import workflow.example.workflow.entity.Competence;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CompetenceConverterTest {

    @InjectMocks
    private CompetenceConverter competenceConverter;

    @Test
    void testEntityToDto() {
        Competence competence = createSampleCompetence();

        CompetenceDto dto = competenceConverter.entityToDto(competence);

        assertEquals(competence.getId(), dto.getId());
        assertEquals(competence.getNomCompetence(), dto.getNomCompetence());
    }

    @Test
    void testEntityToDtoList() {
        List<Competence> competenceList = Collections.singletonList(createSampleCompetence());

        List<CompetenceDto> dtoList = competenceConverter.entityToDto(competenceList);

        assertEquals(competenceList.size(), dtoList.size());
    }

    private Competence createSampleCompetence() {
        Competence competence = new Competence();
        competence.setId(1L);
        competence.setNomCompetence("SampleCompetence");
        return competence;
    }

}

