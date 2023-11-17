package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.FormationConverter;
import workflow.example.workflow.dto.FormationDto;
import workflow.example.workflow.entity.Formation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FormationConverterTest {

    @InjectMocks
    private FormationConverter formationConverter;

    @Test
    void testEntityToDto() throws ParseException {
        Formation formation = createSampleFormation();

        FormationDto dto = formationConverter.entityToDto(formation);

        assertEquals(formation.getId(), dto.getId());
        assertEquals(formation.getNomFormation(), dto.getNomFormation());
        assertEquals(formation.getEtablissement(), dto.getEtablissement());
        assertEquals(formation.getDateDeb(), dto.getDateDeb());
        assertEquals(formation.getDateFin(), dto.getDateFin());
    }

    @Test
    void testEntityToDtoList() throws ParseException {
        List<Formation> formationList = Collections.singletonList(createSampleFormation());

        List<FormationDto> dtoList = formationConverter.entityToDto(formationList);

        assertEquals(formationList.size(), dtoList.size());
    }

    private Formation createSampleFormation() throws ParseException {
        Formation formation = new Formation();
        formation.setId(1L);
        formation.setNomFormation("SampleFormation");
        formation.setEtablissement("SampleEtablissement");
        formation.setDateDeb(parseDate("2023-01-01"));
        formation.setDateFin(parseDate("2023-12-31"));
        return formation;
    }

    private Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateString);
    }
}