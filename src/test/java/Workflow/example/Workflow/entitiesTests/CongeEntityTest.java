package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.Conge;
import workflow.example.workflow.entity.TacheAtraiter;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
class CongeEntityTest {

    @Test
    void testCongeEqualsAndHashCode() {
        Date dateDeb1 = new Date();
        Date dateFin1 = new Date(dateDeb1.getTime() + 100000);

        Date dateDeb2 = new Date();
        Date dateFin2 = new Date(dateDeb2.getTime() + 200000);

        Conge conge1 = new Conge(1L, dateDeb1, dateFin1, "Vacation", "Approved", "Enjoy your vacation", "Manager A", new TacheAtraiter());
        Conge conge2 = new Conge(1L, dateDeb2, dateFin2, "Sick Leave", "Pending", "Get well soon", "Manager B", new TacheAtraiter());

        Assertions.assertEquals(conge1, conge2);
        Assertions.assertEquals(conge1.hashCode(), conge2.hashCode());
    }

    @Test
    void testCongeNotEquals() {
        Conge conge1 = new Conge(1L, new Date(), new Date(), "Vacation", "Approved", "Enjoy your vacation", "Manager A", new TacheAtraiter());
        Conge conge2 = new Conge(2L, new Date(), new Date(), "Sick Leave", "Pending", "Get well soon", "Manager B", new TacheAtraiter());

        Assertions.assertNotEquals(conge1, conge2);
    }

    @Test
    void testCongeTacheAtraiterRelationship() {
        Conge conge = new Conge();
        TacheAtraiter tacheAtraiter = new TacheAtraiter();

        conge.setTacheAtraiter(tacheAtraiter);

        Assertions.assertEquals(tacheAtraiter, conge.getTacheAtraiter());
    }
    @Test
    void testToString() {
        Conge conge = new Conge();
        conge.setId(1L);
        conge.setDateDeb(new Date());
        conge.setDateFin(new Date());
        conge.setType("Vacation");
        conge.setStatut("Approved");
        conge.setCommentaire("Enjoy your time off!");
        conge.setResponsable("John Doe");

        Assertions.assertNotNull(conge.toString());
    }

    @Test
    void testEquals() {
        Conge cong1 = new Conge();
        cong1.setId(1L);

        Conge cong2 = new Conge();
        cong2.setId(1L);

        Conge cong3 = new Conge();
        cong3.setId(2L);

        Assertions.assertEquals(cong1, cong2);
        Assertions.assertNotEquals(cong1, cong3);
    }

    @Test
    void testHashCode() {
        Conge conge = new Conge();
        conge.setId(1L);

        Assertions.assertEquals(conge.hashCode(), conge.getClass().hashCode());
    }
}
