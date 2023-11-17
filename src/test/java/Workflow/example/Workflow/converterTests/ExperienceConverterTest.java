package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.ExperienceConverter;
import workflow.example.workflow.dto.ExperienceDto;
import workflow.example.workflow.entity.Experience;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ExperienceConverterTest {

    @InjectMocks
    private ExperienceConverter experienceConverter;

    @Test
    void testEntityToDto() throws ParseException {
        Experience experience = createSampleExperience();

        ExperienceDto dto = experienceConverter.entityToDto(experience);

        assertEquals(experience.getId(), dto.getId());
        assertEquals(experience.getPoste(), dto.getPoste());
        assertEquals(experience.getEmployeur(), dto.getEmployeur());
        assertEquals(experience.getDescription(), dto.getDescription());
        assertEquals(experience.getDateDeb(), dto.getDateDeb());
        assertEquals(experience.getDateFin(), dto.getDateFin());
    }

    @Test
    void testEntityToDtoList() throws ParseException {
        List<Experience> experienceList = Collections.singletonList(createSampleExperience());

        List<ExperienceDto> dtoList = experienceConverter.entityToDto(experienceList);

        assertEquals(experienceList.size(), dtoList.size());
    }

    private Experience createSampleExperience() throws ParseException {
        Experience experience = new Experience();
        experience.setId(1L);
        experience.setPoste("SamplePoste");
        experience.setEmployeur("SampleEmployeur");
        experience.setDescription("SampleDescription");
        experience.setDateDeb(parseDate("2023-01-01"));
        experience.setDateFin(parseDate("2023-12-31"));
        return experience;
    }
    private Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateString);
    }

}

