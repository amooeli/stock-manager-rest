package stockmanager.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stockmanager.task.entity.User;

/**
 * @author ali
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}