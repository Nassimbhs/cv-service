package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.Tache;
import workflow.example.workflow.entity.Workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class WorkflowEntityTest {
    @Test
    void testWorkflowConstructor() {
        Workflow workflow = new Workflow(1L, "WorkflowName", "Description", new Date(), new Date(),
                "InProgress", "Trigger", "Webhook", "JDBC", "Username", "Password",
                "SGBD", "Task", "Event", new ArrayList<>());

        Assertions.assertEquals("WorkflowName", workflow.getName());
        Assertions.assertEquals("Description", workflow.getDescription());
    }

    @Test
    void testEqualsAndHashCode() {
        Workflow workflow1 = new Workflow(1L, "WorkflowName", "Description", new Date(), new Date(),
                "InProgress", "Trigger", "Webhook", "JDBC", "Username", "Password",
                "SGBD", "Task", "Event", new ArrayList<>());

        Workflow workflow2 = new Workflow(1L, "WorkflowName2", "Description2", new Date(), new Date(),
                "InProgress", "Trigger", "Webhook", "JDBC", "Username", "Password",
                "SGBD", "Task", "Event", new ArrayList<>());

        Assertions.assertEquals(workflow1, workflow2);

        Assertions.assertEquals(workflow1.hashCode(), workflow2.hashCode());
    }

    @Test
    void testWorkflowTachesRelationship() {
        Workflow workflow = new Workflow();

        Tache tache1 = new Tache();
        tache1.setId(1L);
        tache1.setName("Tache 1");
        tache1.setDescription("Description 1");
        tache1.setCreationDate(new Date());

        Tache tache2 = new Tache();
        tache2.setId(2L);
        tache2.setName("Tache 2");
        tache2.setDescription("Description 2");
        tache2.setCreationDate(new Date());

        List<Tache> taches = List.of(tache1, tache2);
        workflow.setTaches(taches);

        Assertions.assertEquals(2, workflow.getTaches().size());
        Assertions.assertTrue(workflow.getTaches().contains(tache1));
        Assertions.assertTrue(workflow.getTaches().contains(tache2));
    }

    @Test
    void testWorkflowEqualsWithNullId() {
        Workflow workflow1 = new Workflow(null, "WorkflowName", "Description", new Date(), new Date(),
                "InProgress", "Trigger", "Webhook", "JDBC", "Username", "Password",
                "SGBD", "Task", "Event", new ArrayList<>());

        Workflow workflow2 = new Workflow(null, "WorkflowName2", "Description2", new Date(), new Date(),
                "InProgress", "Trigger", "Webhook", "JDBC", "Username", "Password",
                "SGBD", "Task", "Event", new ArrayList<>());

        Assertions.assertEquals(workflow1.hashCode(), workflow2.hashCode());
    }

    @Test
    void testToString() {
        Workflow workflow = new Workflow();
        workflow.setId(1L);
        workflow.setName("Workflow1");
        workflow.setDescription("Description for Workflow1");
        workflow.setCreationDate(new Date());
        workflow.setLastModifiedDate(new Date());
        workflow.setEtat("Active");
        workflow.setDeclencheur("Manual");
        workflow.setWebhookUrl("https://example.com/webhook");
        workflow.setJdbcUrl("jdbc:mysql://localhost:3306/database");
        workflow.setUsername("username");
        workflow.setPassword("password");
        workflow.setSgbd("MySQL");
        workflow.setTacheAecouter("TaskToListen");
        workflow.setEvenement("Event");

        Assertions.assertNotNull(workflow.toString());
    }

    @Test
    void testEquals() {
        Workflow workflow1 = new Workflow();
        workflow1.setId(1L);

        Workflow workflow2 = new Workflow();
        workflow2.setId(1L);

        Workflow workflow3 = new Workflow();
        workflow3.setId(2L);

        Assertions.assertEquals(workflow1, workflow2);
        Assertions.assertNotEquals(workflow1, workflow3);
    }

    @Test
    void testHashCode() {
        Workflow workflow = new Workflow();
        workflow.setId(1L);

        Assertions.assertEquals(workflow.hashCode(), workflow.getClass().hashCode());
    }

}
