package web.app.springboot.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.app.springboot.boot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
