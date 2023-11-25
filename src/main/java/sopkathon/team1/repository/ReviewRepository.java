package sopkathon.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.team1.domain.review.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
