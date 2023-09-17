package ru.AstonBanking.Backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.AstonBanking.Backend.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

        Account findAccountByAccountId(Long id);
}
