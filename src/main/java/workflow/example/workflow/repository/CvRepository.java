package workflow.example.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import workflow.example.workflow.entity.Cv;

import java.util.List;

@Repository
public interface CvRepository extends JpaRepository<Cv,Long> {
    List<Cv> findByTachesAtraiterId(Long tacheAtraiterId);
    @Query("SELECT DISTINCT cv FROM Cv cv JOIN cv.tachesAtraiter t WHERE t.id = ?1")
    Cv findByIdWithCompetencesAndFormations(Long tacheAtraiterId);

    Cv findCvByWorkflow(Long workflowId);
}
