package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.Competence;
import workflow.example.workflow.entity.Cv;

@ExtendWith(MockitoExtension.class)
class CompetenceEntityTest {

    @Test
    void testCompetenceEqualsAndHashCode() {
        Competence competence1 = new Competence(1L, "Java Programming", new Cv());
        Competence competence2 = new Competence(1L, "Python Programming", new Cv());

        Assertions.assertEquals(competence1, competence2);
        Assertions.assertEquals(competence1.hashCode(), competence2.hashCode());
    }

    @Test
    void testCompetenceNotEquals() {
        Competence competence1 = new Competence(1L, "Java Programming", new Cv());
        Competence competence2 = new Competence(2L, "Python Programming", new Cv());

        Assertions.assertNotEquals(competence1, competence2);
    }

    @Test
    void testCompetenceCvRelationship() {
        Competence competence = new Competence();
        Cv cv = new Cv();

        competence.setCv(cv);

        Assertions.assertEquals(cv, competence.getCv());
    }
    @Test
    void testToString() {
        Competence competence = new Competence();
        competence.setId(1L);
        competence.setNomCompetence("Java Programming");

        Assertions.assertNotNull(competence.toString());
    }

    @Test
    void testEquals() {
        Competence comp1 = new Competence();
        comp1.setId(1L);

        Competence comp2 = new Competence();
        comp2.setId(1L);

        Competence comp3 = new Competence();
        comp3.setId(2L);

        Assertions.assertEquals(comp1, comp2);
        Assertions.assertNotEquals(comp1, comp3);
    }

    @Test
    void testHashCode() {
        Competence competence = new Competence();
        competence.setId(1L);

        Assertions.assertEquals(competence.hashCode(), competence.getClass().hashCode());
    }
}
