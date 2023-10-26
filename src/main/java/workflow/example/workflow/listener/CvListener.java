package workflow.example.workflow.listener;

import javax.persistence.PostPersist;
import org.springframework.stereotype.Component;
import workflow.example.workflow.entity.Cv;

@Component
public class CvListener {

    @PostPersist
    public void afterPersist(Cv cv) {
        System.out.println("CV " + cv.getId() + " ajouté ");
    }

}