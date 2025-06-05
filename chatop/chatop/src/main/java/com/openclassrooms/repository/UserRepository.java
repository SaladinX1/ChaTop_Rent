package com.openclassrooms.repository;


 import java.util.Optional;
import com.openclassrooms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


// public interface UserRepository extends JpaRepository<User, Long> {
//     User findByEmail(String email);
// }