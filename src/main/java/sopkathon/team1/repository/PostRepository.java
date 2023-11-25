package sopkathon.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.team1.domain.post.Post;


public interface PostRepository extends JpaRepository<Post, Long> {

}
