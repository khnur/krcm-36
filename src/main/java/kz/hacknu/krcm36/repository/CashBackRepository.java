package kz.hacknu.krcm36.repository;

import kz.hacknu.krcm36.model.CashBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashBackRepository extends JpaRepository<CashBack, Long> {
}
