package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.LienTacheConverter;
import workflow.example.workflow.converter.TacheAtraiterConverter;
import workflow.example.workflow.converter.TacheConverter;
import workflow.example.workflow.dto.TacheDto;
import workflow.example.workflow.entity.Tache;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TacheConverterTest {

    @Mock
    private LienTacheConverter lienTacheConverter;
    @Mock
    private TacheAtraiterConverter tacheAtraiterConverter;

    @InjectMocks
    private TacheConverter tacheConverter;

    @Test
    void testEntityToDto() {
        Tache tache = createSampleTache();
        when(lienTacheConverter.entityToDto(anyList())).thenReturn(Collections.emptyList());
        when(tacheAtraiterConverter.entityToDto(anyList())).thenReturn(Collections.emptyList());

        TacheDto dto = tacheConverter.entityToDto(tache);

        assertEquals(tache.getId(), dto.getId());
        assertEquals(tache.getName(), dto.getName());

        verify(lienTacheConverter, times(1)).entityToDto(anyList());
        verify(tacheAtraiterConverter, times(1)).entityToDto(anyList());
    }

    @Test
    void testEntityToDtoList() {
        List<Tache> taches = Collections.singletonList(createSampleTache());
        when(lienTacheConverter.entityToDto(anyList())).thenReturn(Collections.emptyList());
        when(tacheAtraiterConverter.entityToDto(anyList())).thenReturn(Collections.emptyList());

        List<TacheDto> dtoList = tacheConverter.entityToDto(taches);

        assertEquals(taches.size(), dtoList.size());

        verify(lienTacheConverter, times(1)).entityToDto(anyList());
        verify(tacheAtraiterConverter, times(1)).entityToDto(anyList());
    }
    private Tache createSampleTache() {
        return new Tache();
    }

}