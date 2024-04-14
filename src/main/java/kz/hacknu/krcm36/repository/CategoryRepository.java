package kz.hacknu.krcm36.repository;

import kz.hacknu.krcm36.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByName(String name);
    Category findByName(String name);
}
