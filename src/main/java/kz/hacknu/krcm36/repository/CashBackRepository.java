package kz.hacknu.krcm36.repository;

import kz.hacknu.krcm36.model.CashBack;
import kz.hacknu.krcm36.model.Company;
import kz.hacknu.krcm36.util.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashBackRepository extends JpaRepository<CashBack, Integer> {
    CashBack findCashBackByCategory(Category category);
    List<CashBack> findCashBackByCompany(Company company);
}
