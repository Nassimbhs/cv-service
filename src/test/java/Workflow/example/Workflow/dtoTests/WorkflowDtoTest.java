package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.WorkflowDto;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class WorkflowDtoTest {

    @Test
    void testWorkflowDto() {
        Long id = 1L;
        String name = "SampleWorkflow";
        String description = "SampleDescription";
        String etat = "Active";
        String declencheur = "Manual";
        String webhookUrl = "http://example.com/webhook";

        WorkflowDto workflowDto = new WorkflowDto(id, name, description, null, null, etat, declencheur, webhookUrl, null, null, null, null, null, null, null);

        assertEquals(id, workflowDto.getId());
        assertEquals(name, workflowDto.getName());
        assertEquals(description, workflowDto.getDescription());
        assertEquals(etat, workflowDto.getEtat());
        assertEquals(declencheur, workflowDto.getDeclencheur());
        assertEquals(webhookUrl, workflowDto.getWebhookUrl());
    }

    @Test
    void testDataAnnotation() {
        WorkflowDto workflowDto = new WorkflowDto();
        workflowDto.setId(1L);
        workflowDto.setName("Workflow1");
        workflowDto.setDescription("Description");
        workflowDto.setCreationDate(new Date());
        workflowDto.setLastModifiedDate(new Date());
        workflowDto.setEtat("Active");
        workflowDto.setDeclencheur("Manual");
        workflowDto.setWebhookUrl("http://example.com/webhook");
        workflowDto.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
        workflowDto.setUsername("user");
        workflowDto.setPassword("password");
        workflowDto.setSgbd("MySQL");
        workflowDto.setTacheAecouter("Task1");
        workflowDto.setEvenement("Event1");
        workflowDto.setTacheDtoList(new ArrayList<>());

        Assertions.assertNotNull(workflowDto.toString());
        assertEquals(1L, workflowDto.getId());
        assertEquals("Workflow1", workflowDto.getName());
        assertEquals("Description", workflowDto.getDescription());
        Assertions.assertNotNull(workflowDto.getCreationDate());
        Assertions.assertNotNull(workflowDto.getLastModifiedDate());
        assertEquals("Active", workflowDto.getEtat());
        assertEquals("Manual", workflowDto.getDeclencheur());
        assertEquals("http://example.com/webhook", workflowDto.getWebhookUrl());
        assertEquals("jdbc:mysql://localhost:3306/mydb", workflowDto.getJdbcUrl());
        assertEquals("user", workflowDto.getUsername());
        assertEquals("password", workflowDto.getPassword());
        assertEquals("MySQL", workflowDto.getSgbd());
        assertEquals("Task1", workflowDto.getTacheAecouter());
        assertEquals("Event1", workflowDto.getEvenement());
        Assertions.assertNotNull(workflowDto.getTacheDtoList());
    }

}