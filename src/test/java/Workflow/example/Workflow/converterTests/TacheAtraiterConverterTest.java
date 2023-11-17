package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.TacheAtraiterConverter;
import workflow.example.workflow.dto.TacheAtraiterDto;
import workflow.example.workflow.entity.TacheAtraiter;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TacheAtraiterConverterTest {

    @InjectMocks
    private TacheAtraiterConverter tacheAtraiterConverter;

    @Test
    void testEntityToDto() {
        TacheAtraiter tacheAtraiter = createSampleTacheAtraiter();

        TacheAtraiterDto dto = tacheAtraiterConverter.entityToDto(tacheAtraiter);

        assertEquals(tacheAtraiter.getId(), dto.getId());
        assertEquals(tacheAtraiter.getResponsable(), dto.getResponsable());
    }

    @Test
    void testEntityToDtoList() {
        List<TacheAtraiter> tacheAtraiters = Collections.singletonList(createSampleTacheAtraiter());

        List<TacheAtraiterDto> dtoList = tacheAtraiterConverter.entityToDto(tacheAtraiters);

        assertEquals(tacheAtraiters.size(), dtoList.size());
    }

    private TacheAtraiter createSampleTacheAtraiter() {
        return new TacheAtraiter();
    }

    private TacheAtraiterDto createSampleTacheAtraiterDto() {
        return new TacheAtraiterDto();
    }

}