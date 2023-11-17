package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.LangueDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LangueDtoTest {

    @InjectMocks
    private LangueDto langueDto;

    @Test
    void testLangueDto() {
        langueDto.setId(1L);
        langueDto.setNom("English");
        langueDto.setNiveau("Advanced");

        assertEquals(1L, langueDto.getId());
        assertEquals("English", langueDto.getNom());
        assertEquals("Advanced", langueDto.getNiveau());

    }

    @Test
    void testDataAnnotation() {
        LangueDto langueDto = new LangueDto();
        langueDto.setId(1L);
        langueDto.setNom("English");
        langueDto.setNiveau("Advanced");

        Assertions.assertNotNull(langueDto.toString());
        assertEquals(langueDto.hashCode(), langueDto.hashCode());
        Assertions.assertNotNull(langueDto.getId());
        Assertions.assertNotNull(langueDto.getNom());
        Assertions.assertNotNull(langueDto.getNiveau());
    }

}

