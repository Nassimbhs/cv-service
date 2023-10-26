package workflow.example.workflow.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import org.springframework.stereotype.Component;
import workflow.example.workflow.entity.Workflow;

@Component
public class WorkflowListener {

    @PostPersist
    public void afterPersist(Workflow workflow) {
            System.out.println("Écoutez l'événement d'ajout de la table " + workflow.getTacheAecouter());
    }

    @PostUpdate
    public void afterUpdate(Workflow workflow) {
            System.out.println("Écoutez l'événement de modification de la table "+workflow.getTacheAecouter());
    }

    @PostRemove
    public void afterRemove(Workflow workflow) {
            System.out.println("Écoutez l'événement de suppression de la table " + workflow.getTacheAecouter());
    }

}
