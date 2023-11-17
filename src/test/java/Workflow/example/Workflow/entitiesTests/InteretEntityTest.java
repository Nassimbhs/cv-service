package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.Interet;

@ExtendWith(MockitoExtension.class)
class InteretEntityTest {
    @Test
    void testEquals() {
        Interet interet1 = new Interet();
        interet1.setId(1L);
        interet1.setNom("Programming");

        Interet interet2 = new Interet();
        interet2.setId(1L);
        interet2.setNom("Programming");

        Interet interet3 = new Interet();
        interet3.setId(2L);
        interet3.setNom("Sports");

        Assertions.assertEquals(interet1, interet2);
        Assertions.assertNotEquals(interet1, interet3);
    }

    @Test
    void testHashCode() {
        Interet interet = new Interet();
        interet.setId(1L);
        interet.setNom("Programming");

        Assertions.assertEquals(interet.hashCode(), interet.getClass().hashCode());
    }

    @Test
    void testToString() {
        Interet interet = new Interet();
        interet.setId(1L);
        interet.setNom("Programming");

        Assertions.assertNotNull(interet.toString());
    }
}
