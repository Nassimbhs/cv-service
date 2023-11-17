package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.Cv;
import workflow.example.workflow.entity.Formation;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
class FormationEntityTest {


    @Test
    void testFormationEqualsAndHashCode() {
        Date dateDeb1 = new Date();
        Date dateFin1 = new Date(dateDeb1.getTime() + 100000);

        Date dateDeb2 = new Date();
        Date dateFin2 = new Date(dateDeb2.getTime() + 200000);

        Formation formation1 = new Formation(1L, "Computer Science", "University A", dateDeb1, dateFin1, new Cv());
        Formation formation2 = new Formation(1L, "Data Science", "University B", dateDeb2, dateFin2, new Cv());

        Assertions.assertEquals(formation1, formation2);
        Assertions.assertEquals(formation1.hashCode(), formation2.hashCode());
    }

    @Test
    void testFormationNotEquals() {
        Formation formation1 = new Formation(1L, "Computer Science", "University A", new Date(), new Date(), new Cv());
        Formation formation2 = new Formation(2L, "Data Science", "University B", new Date(), new Date(), new Cv());

        Assertions.assertNotEquals(formation1, formation2);
    }

    @Test
    void testFormationCvRelationship() {
        Formation formation = new Formation();
        Cv cv = new Cv();

        formation.setCv(cv);

        Assertions.assertEquals(cv, formation.getCv());
    }

    @Test
    void testToString() {
        Formation formation = new Formation();
        formation.setId(1L);
        formation.setNomFormation("Computer Science");
        formation.setEtablissement("University XYZ");
        formation.setDateDeb(new Date());
        formation.setDateFin(new Date());

        Assertions.assertNotNull(formation.toString());
    }

    @Test
    void testEquals() {
        Formation form1 = new Formation();
        form1.setId(1L);

        Formation form2 = new Formation();
        form2.setId(1L);

        Formation form3 = new Formation();
        form3.setId(2L);

        Assertions.assertEquals(form1, form2);
        Assertions.assertNotEquals(form1, form3);
    }

    @Test
    void testHashCode() {
        Formation formation = new Formation();
        formation.setId(1L);
        Assertions.assertEquals(formation.hashCode(), formation.getClass().hashCode());
    }

}