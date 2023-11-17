package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.*;
import workflow.example.workflow.dto.CvDto;
import workflow.example.workflow.entity.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CvConverterTest {

    @InjectMocks
    private CvConverter cvConverter;
    @Mock
    private FormationConverter formationConverter;
    @Mock
    private CompetenceConverter competenceConverter;
    @Mock
    private InteretConverter interetConverter;
    @Mock
    private LangueConverter langueConverter;
    @Mock
    private ExperienceConverter experienceConverter;

    @Test
    void testEntityToDto() {
        Cv cv = createSampleCv();
        when(formationConverter.entityToDto(cv.getFormations())).thenReturn(Collections.emptyList());
        when(competenceConverter.entityToDto(cv.getCompetences())).thenReturn(Collections.emptyList());
        when(interetConverter.entityToDto(cv.getInterets())).thenReturn(Collections.emptyList());
        when(langueConverter.entityToDto(cv.getLangues())).thenReturn(Collections.emptyList());
        when(experienceConverter.entityToDto(cv.getExperiences())).thenReturn(Collections.emptyList());

        CvDto dto = cvConverter.entityToDto(cv);

        assertEquals(cv.getId(), dto.getId());
    }

    @Test
    void testEntityToDtoList() {
        List<Cv> cvList = Collections.singletonList(createSampleCv());
        when(formationConverter.entityToDto(cvList.get(0).getFormations())).thenReturn(Collections.emptyList());
        when(competenceConverter.entityToDto(cvList.get(0).getCompetences())).thenReturn(Collections.emptyList());
        when(interetConverter.entityToDto(cvList.get(0).getInterets())).thenReturn(Collections.emptyList());
        when(langueConverter.entityToDto(cvList.get(0).getLangues())).thenReturn(Collections.emptyList());
        when(experienceConverter.entityToDto(cvList.get(0).getExperiences())).thenReturn(Collections.emptyList());

        List<CvDto> dtoList = cvConverter.entityToDto(cvList);

        assertEquals(cvList.size(), dtoList.size());
    }

    private Cv createSampleCv() {
        Cv cv = new Cv();
        cv.setId(1L);
        cv.setFormations(Arrays.asList(new Formation(), new Formation()));
        cv.setCompetences(Arrays.asList(new Competence(), new Competence()));
        cv.setInterets(Arrays.asList(new Interet(), new Interet()));
        cv.setLangues(Arrays.asList(new Langue(), new Langue()));
        cv.setExperiences(Arrays.asList(new Experience(), new Experience()));
        return cv;
    }

}
