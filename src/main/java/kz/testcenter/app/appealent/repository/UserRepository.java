package kz.testcenter.app.appealent.repository;

import kz.testcenter.app.appealent.model.publics.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByLogin(String login);

}
