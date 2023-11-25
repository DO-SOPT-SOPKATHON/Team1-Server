package sopkathon.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.team1.domain.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryId(Long categoryId);
}
