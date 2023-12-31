package sopkathon.team1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.team1.domain.post.Post;
import sopkathon.team1.domain.review.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllReviewByPost(Post post);
}
