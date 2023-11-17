package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.LienTache;
import workflow.example.workflow.entity.Tache;

@ExtendWith(MockitoExtension.class)
class LienTacheEntityTest {

    @Test
    void testLienTacheEqualsAndHashCode() {
        LienTache lienTache1 = new LienTache(1L, "source1", "target1", "workflowId1",
                "tacheSourceName1", "tacheTargetName1", "type1", new Tache());

        LienTache lienTache2 = new LienTache(1L, "source2", "target2", "workflowId2",
                "tacheSourceName2", "tacheTargetName2", "type2", new Tache());

        Assertions.assertEquals(lienTache1, lienTache2);
        Assertions.assertEquals(lienTache1.hashCode(), lienTache2.hashCode());
    }

    @Test
    void testLienTacheNotEquals() {
        LienTache lienTache1 = new LienTache(1L, "source1", "target1", "workflowId1",
                "tacheSourceName1", "tacheTargetName1", "type1", new Tache());

        LienTache lienTache2 = new LienTache(2L, "source2", "target2", "workflowId2",
                "tacheSourceName2", "tacheTargetName2", "type2", new Tache());

        Assertions.assertNotEquals(lienTache1, lienTache2);
    }

    @Test
    void testToString() {
        LienTache lienTache = new LienTache();
        lienTache.setId(1L);
        lienTache.setSource("Source");
        lienTache.setTarget("Target");
        lienTache.setWorkflowId("Workflow123");
        lienTache.setTacheSourceName("SourceTask");
        lienTache.setTacheTargetName("TargetTask");
        lienTache.setType("Dependency");

        Assertions.assertNotNull(lienTache.toString());
    }

    @Test
    void testEquals() {
        LienTache lien1 = new LienTache();
        lien1.setId(1L);

        LienTache lien2 = new LienTache();
        lien2.setId(1L);

        LienTache lien3 = new LienTache();
        lien3.setId(2L);

        Assertions.assertEquals(lien1, lien2);
        Assertions.assertNotEquals(lien1, lien3);
    }

    @Test
    void testHashCode() {
        LienTache lienTache = new LienTache();
        lienTache.setId(1L);

        Assertions.assertEquals(lienTache.hashCode(), lienTache.getClass().hashCode());
    }

}
