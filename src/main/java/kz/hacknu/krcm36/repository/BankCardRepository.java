package kz.hacknu.krcm36.repository;

import kz.hacknu.krcm36.model.BankCard;
import kz.hacknu.krcm36.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Integer> {
    List<BankCard> findBankCardsByUser(User user);
}
