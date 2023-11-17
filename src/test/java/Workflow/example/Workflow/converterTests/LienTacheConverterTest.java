package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.LienTacheConverter;
import workflow.example.workflow.dto.LienTacheDto;
import workflow.example.workflow.entity.LienTache;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LienTacheConverterTest {

    @InjectMocks
    private LienTacheConverter lienTacheConverter;

    @Test
    void testEntityToDto() {
        LienTache lienTache = createSampleLienTache();

        LienTacheDto dto = lienTacheConverter.entityToDto(lienTache);

        assertEquals(lienTache.getId(), dto.getId());
        assertEquals(lienTache.getSource(), dto.getSource());
    }

    @Test
    void testEntityToDtoList() {
        List<LienTache> lienTaches = Collections.singletonList(createSampleLienTache());

        List<LienTacheDto> dtoList = lienTacheConverter.entityToDto(lienTaches);

        assertEquals(lienTaches.size(), dtoList.size());
    }

    private LienTache createSampleLienTache() {
        return new LienTache();
    }

    private LienTacheDto createSampleLienTacheDto() {
        return new LienTacheDto();
    }

}
