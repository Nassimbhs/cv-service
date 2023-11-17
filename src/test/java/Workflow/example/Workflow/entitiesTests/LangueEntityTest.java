package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.Cv;
import workflow.example.workflow.entity.Langue;

@ExtendWith(MockitoExtension.class)
class LangueEntityTest {

    @Test
    void testLangueEqualsAndHashCode() {
        Langue langue1 = new Langue(1L, "French", "Intermediate", new Cv());
        Langue langue2 = new Langue(1L, "Spanish", "Advanced", new Cv());

        Assertions.assertEquals(langue1, langue2);
        Assertions.assertEquals(langue1.hashCode(), langue2.hashCode());
    }

    @Test
    void testLangueNotEquals() {
        Langue langue1 = new Langue(1L, "French", "Intermediate", new Cv());
        Langue langue2 = new Langue(2L, "Spanish", "Advanced", new Cv());

        Assertions.assertNotEquals(langue1, langue2);
    }

    @Test
    void testLangueCvRelationship() {
        Langue langue = new Langue();
        Cv cv = new Cv();

        langue.setCv(cv);

        Assertions.assertEquals(cv, langue.getCv());
    }

    @Test
    void testToString() {
        Langue langue = new Langue();
        langue.setId(1L);
        langue.setNom("English");
        langue.setNiveau("Advanced");

        Assertions.assertNotNull(langue.toString());
    }

    @Test
    void testEquals() {
        Langue lang1 = new Langue();
        lang1.setId(1L);

        Langue lang2 = new Langue();
        lang2.setId(1L);

        Langue lang3 = new Langue();
        lang3.setId(2L);

        Assertions.assertEquals(lang1, lang2);
        Assertions.assertNotEquals(lang1, lang3);
    }

    @Test
    void testHashCode() {
        Langue langue = new Langue();
        langue.setId(1L);

        Assertions.assertEquals(langue.hashCode(), langue.getClass().hashCode());
    }

}
