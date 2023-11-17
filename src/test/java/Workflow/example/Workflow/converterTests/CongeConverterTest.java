package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.CongeConverter;
import workflow.example.workflow.dto.CongeDto;
import workflow.example.workflow.entity.Conge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CongeConverterTest {

    @InjectMocks
    private CongeConverter congeConverter;

    @Test
    void testEntityToDto() throws ParseException {
        Conge conge = createSampleConge();

        CongeDto dto = congeConverter.entityToDto(conge);

        assertEquals(conge.getId(), dto.getId());
        assertEquals(conge.getType(), dto.getType());
        assertEquals(conge.getStatut(), dto.getStatut());
        assertEquals(conge.getDateDeb(), dto.getDateDeb());
        assertEquals(conge.getDateFin(), dto.getDateFin());
        assertEquals(conge.getCommentaire(), dto.getCommentaire());
        assertEquals(conge.getResponsable(), dto.getResponsable());
    }

    @Test
    void testEntityToDtoList() throws ParseException {
        List<Conge> congeList = Collections.singletonList(createSampleConge());

        List<CongeDto> dtoList = congeConverter.entityToDto(congeList);

        assertEquals(congeList.size(), dtoList.size());
    }

    private Conge createSampleConge() throws ParseException {
        Conge conge = new Conge();
        conge.setId(1L);
        conge.setType("SampleType");
        conge.setStatut("SampleStatut");
        conge.setDateDeb(parseDate("2023-01-01"));
        conge.setDateFin(parseDate("2023-01-05"));
        conge.setCommentaire("SampleComment");
        conge.setResponsable("SampleResponsable");
        return conge;
    }

    private Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateString);
    }

}

