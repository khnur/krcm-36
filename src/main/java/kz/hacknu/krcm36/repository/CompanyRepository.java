package kz.hacknu.krcm36.repository;

import kz.hacknu.krcm36.model.Company;
import kz.hacknu.krcm36.util.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findCompanyByCategory(ServiceCategory category);
    List<Company> findCompaniesByName(String name);
}
