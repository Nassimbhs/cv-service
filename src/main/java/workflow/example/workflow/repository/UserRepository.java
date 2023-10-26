package workflow.example.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workflow.example.workflow.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
