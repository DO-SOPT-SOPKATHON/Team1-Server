package sopkathon.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.team1.domain.category.Category;
import sopkathon.team1.domain.post.Post;
import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCategory(Category category);
}
