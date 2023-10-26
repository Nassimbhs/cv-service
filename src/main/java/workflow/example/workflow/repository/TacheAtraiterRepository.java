package workflow.example.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workflow.example.workflow.entity.TacheAtraiter;

@Repository
public interface TacheAtraiterRepository extends JpaRepository<TacheAtraiter,Long> {

}
