package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.LienTache;
import workflow.example.workflow.entity.Tache;
import workflow.example.workflow.entity.Workflow;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TacheEntityTest {

    @Test
    void testTacheWorkflowRelationship() {
        Tache tache = new Tache();
        Workflow workflow = new Workflow();

        tache.setWorkflowTache(workflow);

        Assertions.assertEquals(workflow, tache.getWorkflowTache());
    }

    @Test
    void testTacheLienTachesRelationship() {
        Tache tache = new Tache();
        tache.setId(1L);

        LienTache lienTache1 = new LienTache();

        LienTache lienTache2 = new LienTache();

        List<LienTache> lienTaches = List.of(lienTache1, lienTache2);
        tache.setLienTaches(lienTaches);

        Assertions.assertEquals(2, tache.getLienTaches().size());
        Assertions.assertTrue(tache.getLienTaches().contains(lienTache1));
        Assertions.assertTrue(tache.getLienTaches().contains(lienTache2));
    }
    @Test
    void testToString() {
        Tache tache = new Tache();
        tache.setId(1L);
        tache.setName("Task1");
        tache.setDescription("Description for Task1");
        tache.setCreationDate(new Date());
        tache.setStartDate(new Date());
        tache.setEndDate(new Date());
        tache.setStatut("InProgress");
        tache.setAction("Approve");
        tache.setApprobation("Approved");

        Assertions.assertNotNull(tache.toString());
    }

    @Test
    void testEquals() {
        Tache tache1 = new Tache();
        tache1.setId(1L);

        Tache tache2 = new Tache();
        tache2.setId(1L);

        Tache tache3 = new Tache();
        tache3.setId(2L);

        // Test equals method
        Assertions.assertEquals(tache1, tache2);
        Assertions.assertNotEquals(tache1, tache3);
    }

    @Test
    void testHashCode() {
        Tache tache = new Tache();
        tache.setId(1L);

        Assertions.assertEquals(tache.hashCode(), tache.getClass().hashCode());
    }

}
