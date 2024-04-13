package kz.hacknu.krcm36.repository;

import kz.hacknu.krcm36.model.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Integer> {
}
