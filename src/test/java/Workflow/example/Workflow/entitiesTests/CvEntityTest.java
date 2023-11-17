package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.Competence;
import workflow.example.workflow.entity.Cv;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class CvEntityTest {

    @Test
    void testCvCompetencesRelationship() {
        Cv cv = new Cv();
        Competence competence1 = new Competence();
        Competence competence2 = new Competence();

        cv.getCompetences().add(competence1);
        cv.getCompetences().add(competence2);

        Assertions.assertEquals(2, cv.getCompetences().size());
        Assertions.assertTrue(cv.getCompetences().contains(competence1));
        Assertions.assertTrue(cv.getCompetences().contains(competence2));
    }

    @Test
    void testToString() {
        Cv cv = new Cv();
        cv.setId(1L);
        cv.setPrenom("John");
        cv.setNomFamille("Doe");
        cv.setEmail("john.doe@example.com");
        cv.setTitreProfil("Software Developer");
        cv.setTel(1234567890L);
        cv.setAddresse("123 Main Street");
        cv.setVille("City");

        Assertions.assertNotNull(cv.toString());
    }

    @Test
    void testEquals() {
        Cv cv1 = new Cv();
        cv1.setId(1L);

        Cv cv2 = new Cv();
        cv2.setId(1L);

        Cv cv3 = new Cv();
        cv3.setId(2L);

        Assertions.assertEquals(cv1, cv2);
        Assertions.assertNotEquals(cv1, cv3);
    }

    @Test
    void testHashCode() {
        Cv cv = new Cv();
        cv.setId(1L);
        Assertions.assertEquals(cv.hashCode(), cv.getClass().hashCode());
    }

    @Test
    void testEquals_ObjectIsOfDifferentClass_ReturnsFalse() {
        Cv cv = new Cv();
        Object differentObject = mock(Object.class);

        boolean result = cv.equals(differentObject);

        Assertions.assertFalse(result);
    }

}
