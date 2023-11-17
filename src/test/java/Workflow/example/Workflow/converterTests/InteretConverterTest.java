package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.InteretConverter;
import workflow.example.workflow.dto.InteretDto;
import workflow.example.workflow.entity.Interet;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class InteretConverterTest {

    @InjectMocks
    private InteretConverter interetConverter;

    @Test
    void testEntityToDto() {
        Interet interet = createSampleInteret();

        InteretDto dto = interetConverter.entityToDto(interet);

        assertEquals(interet.getId(), dto.getId());
        assertEquals(interet.getNom(), dto.getNom());
    }

    @Test
    void testEntityToDtoList() {
        List<Interet> interetList = Collections.singletonList(createSampleInteret());

        List<InteretDto> dtoList = interetConverter.entityToDto(interetList);

        assertEquals(interetList.size(), dtoList.size());
    }

    private Interet createSampleInteret() {
        return new Interet();
    }

}
