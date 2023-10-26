package workflow.example.workflow.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import org.springframework.stereotype.Component;
import workflow.example.workflow.entity.Conge;

@Component
public class CongeListener {

    @PostPersist
    public void afterPersist(Conge conge) {
        System.out.println("Congé ajouté : " + conge.getDateDeb() + " jusqu'à le : " + conge.getDateFin());
    }

    @PostUpdate
    public void afterUpdate(Conge conge) {
        System.out.println("Congé mis à jour : " + conge.getDateDeb() + " jusqu'à le : " + conge.getDateFin());
    }

    @PostRemove
    public void afterRemove(Conge conge) {
        System.out.println("Congé supprimé : " + conge.getDateDeb() + " jusqu'à le : " + conge.getDateFin());
    }

}
