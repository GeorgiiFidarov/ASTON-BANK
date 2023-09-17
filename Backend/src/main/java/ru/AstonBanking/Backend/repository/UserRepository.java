package ru.AstonBanking.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.AstonBanking.Backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);
    User findUserByAccount_AccountId(Long accountNumber);
}
