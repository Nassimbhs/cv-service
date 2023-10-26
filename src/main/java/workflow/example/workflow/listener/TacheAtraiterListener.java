package workflow.example.workflow.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import workflow.example.workflow.entity.TacheAtraiter;

@Component
public class TacheAtraiterListener {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    @PostPersist
    public void afterPersist(TacheAtraiter tacheAtraiter) {
            System.out.println(tacheAtraiter.getEmailResponsable());
//            sendEmail(tacheAtraiter.getEmailResponsable(),
//                    "Nouvelle tâche à traiter",
//                    "Tache appelée : " + "'" + tacheAtraiter.getName() + "'" + " a été ajouté.");
    }

    @PostUpdate
    public void afterUpdate(TacheAtraiter tacheAtraiter) {
        if (tacheAtraiter.getAction() != null && tacheAtraiter.getAction().equals("Accepter")) {
            System.out.println("Nom de la tache modifié : " + tacheAtraiter.getName());
            System.out.println("Email responsable : " + tacheAtraiter.getEmailResponsable());
        }
    }

    @PostRemove
    public void afterRemove(TacheAtraiter tacheAtraiter) {
        System.out.println("nom de la tache supprimer : " + tacheAtraiter.getName());
    }

}
