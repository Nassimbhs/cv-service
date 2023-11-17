package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.ExperienceDto;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ExperienceDtoTest {

    @InjectMocks
    private ExperienceDto experienceDto;

    @Test
    void testExperienceDto() {
        experienceDto.setId(1L);
        experienceDto.setPoste("Software Engineer");
        experienceDto.setEmployeur("Tech Company XYZ");
        experienceDto.setDateDeb(new Date());
        experienceDto.setDateFin(new Date());
        experienceDto.setDescription("Worked on developing new features");

        assertEquals(1L, experienceDto.getId());
        assertEquals("Software Engineer", experienceDto.getPoste());
        assertEquals("Tech Company XYZ", experienceDto.getEmployeur());
        assertNotNull(experienceDto.getDateDeb());
        assertNotNull(experienceDto.getDateFin());
        assertEquals("Worked on developing new features", experienceDto.getDescription());

    }

    @Test
    void testDataAnnotation() {
        ExperienceDto experienceDto = new ExperienceDto();
        experienceDto.setId(1L);
        experienceDto.setPoste("Software Engineer");
        experienceDto.setEmployeur("ABC Company");
        experienceDto.setDateDeb(new Date());
        experienceDto.setDateFin(new Date());
        experienceDto.setDescription("Worked on various projects");

        assertNotNull(experienceDto.toString());
        assertEquals(experienceDto.hashCode(), experienceDto.hashCode());
        assertNotNull(experienceDto.getId());
        assertNotNull(experienceDto.getPoste());
        assertNotNull(experienceDto.getEmployeur());
        assertNotNull(experienceDto.getDateDeb());
        assertNotNull(experienceDto.getDateFin());
        assertNotNull(experienceDto.getDescription());
    }

}
