package org.example.jpa.jpademo.repository;

import org.example.jpa.jpademo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    public List<User> findByUserName(String userName);
}
