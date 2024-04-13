package kz.hacknu.krcm36.repository;

import kz.hacknu.krcm36.model.CashBack;
import kz.hacknu.krcm36.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashBackRepository extends JpaRepository<CashBack, Integer> {
    List<CashBack> findCashBackByCompany(Company company);
}
