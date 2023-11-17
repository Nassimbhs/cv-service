package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.Cv;
import workflow.example.workflow.entity.Experience;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
class ExperienceEntityTest {

    @Test
    void testExperienceEqualsAndHashCode() {
        Date dateDeb1 = new Date();
        Date dateFin1 = new Date(dateDeb1.getTime() + 100000);

        Date dateDeb2 = new Date();
        Date dateFin2 = new Date(dateDeb2.getTime() + 200000);

        Experience experience1 = new Experience(1L, "Software Engineer", "Company A", dateDeb1, dateFin1, "Worked on projects A and B", new Cv());
        Experience experience2 = new Experience(1L, "Data Scientist", "Company B", dateDeb2, dateFin2, "Worked on projects C and D", new Cv());

        Assertions.assertEquals(experience1, experience2);
        Assertions.assertEquals(experience1.hashCode(), experience2.hashCode());
    }

    @Test
    void testExperienceNotEquals() {
        Experience experience1 = new Experience(1L, "Software Engineer", "Company A", new Date(), new Date(), "Worked on projects A and B", new Cv());
        Experience experience2 = new Experience(2L, "Data Scientist", "Company B", new Date(), new Date(), "Worked on projects C and D", new Cv());

        Assertions.assertNotEquals(experience1, experience2);
    }

    @Test
    void testExperienceCvRelationship() {
        Experience experience = new Experience();
        Cv cv = new Cv();

        experience.setCv(cv);

        Assertions.assertEquals(cv, experience.getCv());
    }

    @Test
    void testToString() {
        Experience experience = new Experience();
        experience.setId(1L);
        experience.setPoste("Software Developer");
        experience.setEmployeur("ABC Inc");
        experience.setDateDeb(new Date());
        experience.setDateFin(new Date());
        experience.setDescription("Worked on exciting projects");

        Assertions.assertNotNull(experience.toString());
    }

    @Test
    void testEquals() {
        Experience exp1 = new Experience();
        exp1.setId(1L);

        Experience exp2 = new Experience();
        exp2.setId(1L);

        Experience exp3 = new Experience();
        exp3.setId(2L);

        Assertions.assertEquals(exp1, exp2);
        Assertions.assertNotEquals(exp1, exp3);
    }

    @Test
    void testHashCode() {
        Experience experience = new Experience();
        experience.setId(1L);

        Assertions.assertEquals(experience.hashCode(), experience.getClass().hashCode());
    }

}