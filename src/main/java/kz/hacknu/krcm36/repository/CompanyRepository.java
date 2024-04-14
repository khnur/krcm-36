package kz.hacknu.krcm36.repository;

import kz.hacknu.krcm36.model.Category;
import kz.hacknu.krcm36.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findCompanyByCategory(Category category);

    Company findCompanyByName(String name);

    boolean existsCompanyByName(String name);
}
