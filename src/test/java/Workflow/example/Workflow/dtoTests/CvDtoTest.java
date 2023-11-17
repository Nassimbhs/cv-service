package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.CvDto;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CvDtoTest {

    @InjectMocks
    private CvDto cvDto;

    @Test
    void testCvDto() {
        cvDto.setId(1L);
        cvDto.setPrenom("John");
        cvDto.setNomFamille("Doe");
        cvDto.setEmail("john.doe@example.com");
        cvDto.setTitreProfil("Software Engineer");
        cvDto.setTel(1234567890L);
        cvDto.setAddresse("123 Main Street");
        cvDto.setVille("Cityville");
        cvDto.setFormationDtos(new ArrayList<>());
        cvDto.setCompetenceDtos(new ArrayList<>());
        cvDto.setLangueDtos(new ArrayList<>());
        cvDto.setInteretDtos(new ArrayList<>());
        cvDto.setExperienceDtos(new ArrayList<>());

        assertEquals(1L, cvDto.getId());
        assertEquals("John", cvDto.getPrenom());
        assertEquals("Doe", cvDto.getNomFamille());
        assertEquals("john.doe@example.com", cvDto.getEmail());
        assertEquals("Software Engineer", cvDto.getTitreProfil());
        assertEquals(1234567890L, cvDto.getTel());
        assertEquals("123 Main Street", cvDto.getAddresse());
        assertEquals("Cityville", cvDto.getVille());
        assertNotNull(cvDto.getFormationDtos());
        assertNotNull(cvDto.getCompetenceDtos());
        assertNotNull(cvDto.getLangueDtos());
        assertNotNull(cvDto.getInteretDtos());
        assertNotNull(cvDto.getExperienceDtos());

    }

    @Test
    void testDataAnnotation() {
        CvDto cvDto = new CvDto();
        cvDto.setId(1L);
        cvDto.setPrenom("John");
        cvDto.setNomFamille("Doe");
        cvDto.setEmail("john.doe@example.com");
        cvDto.setTitreProfil("Software Developer");
        cvDto.setTel(1234567890L);
        cvDto.setAddresse("123 Main St");
        cvDto.setVille("City");

        assertNotNull(cvDto.toString());
        assertEquals(cvDto.hashCode(), cvDto.hashCode());
        assertNotNull(cvDto.getId());
        assertNotNull(cvDto.getPrenom());
        assertNotNull(cvDto.getNomFamille());
        assertNotNull(cvDto.getEmail());
        assertNotNull(cvDto.getTitreProfil());
        assertNotNull(cvDto.getTel());
        assertNotNull(cvDto.getAddresse());
        assertNotNull(cvDto.getVille());
        assertNotNull(cvDto.getFormationDtos());
        assertNotNull(cvDto.getCompetenceDtos());
        assertNotNull(cvDto.getLangueDtos());
        assertNotNull(cvDto.getInteretDtos());
        assertNotNull(cvDto.getExperienceDtos());
    }

}
