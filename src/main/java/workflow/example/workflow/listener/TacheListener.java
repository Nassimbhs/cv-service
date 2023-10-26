package workflow.example.workflow.listener;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import workflow.example.workflow.entity.Tache;
import java.util.List;

@Component
public class TacheListener {

    @Autowired
    private JavaMailSender mailSender;

//    @PostPersist
//    public void afterPersist(Tache tache) {
//        System.out.println("Tache " + tache.getName() + " ajouté ");
//    }

//    @PostUpdate
//    public void afterUpdate(Tache tache) {
//        System.out.println("Tache " + tache.getName());
//    }

//    @PreUpdate
//    public void preUpdateTache(Tache tache) {
//        if ("traité".equals(tache.getStatut())) {
//            Workflow workflow = tache.getWorkflowTache();
//            if (workflow != null && !"en cours".equals(workflow.getEtat())) {
//                workflow.setEtat("en cours");
//                workflow.setLastModifiedDate(new Date());
//                workflowRepository.save(workflow);
//
//            }
//        }
//    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    @PostPersist
    public void afterPersist(Tache tache) {
        System.out.println("Tache " + tache.getName() + " ajouté");
    }

    @PostRemove
    public void afterRemove(Tache tache) {
        System.out.println("Tache " + tache.getName() + " supprimé");
    }

    public void beforeAssignation(Long tacheId, List<Long> userIds) {
        System.out.println("Assignation de tâche en cours : tacheId = " + tacheId + ", userIds = " + userIds);
    }
}