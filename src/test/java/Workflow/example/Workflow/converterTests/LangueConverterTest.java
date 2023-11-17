package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.LangueConverter;
import workflow.example.workflow.dto.LangueDto;
import workflow.example.workflow.entity.Langue;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LangueConverterTest {

    @InjectMocks
    private LangueConverter langueConverter;

    @Test
    void testEntityToDto() {
        Langue langue = createSampleLangue();

        LangueDto dto = langueConverter.entityToDto(langue);

        assertEquals(langue.getId(), dto.getId());
        assertEquals(langue.getNom(), dto.getNom());
        assertEquals(langue.getNiveau(), dto.getNiveau());
    }

    @Test
    void testEntityToDtoList() {
        List<Langue> langues = Collections.singletonList(createSampleLangue());

        List<LangueDto> dtoList = langueConverter.entityToDto(langues);

        assertEquals(langues.size(), dtoList.size());
    }

    private Langue createSampleLangue() {
        return new Langue();
    }
}