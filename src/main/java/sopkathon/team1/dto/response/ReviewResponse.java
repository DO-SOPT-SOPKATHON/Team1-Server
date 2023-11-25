package sopkathon.team1.dto.response;

import java.time.LocalDate;
import sopkathon.team1.domain.review.Review;

public record ReviewResponse(String review, LocalDate reviewDate) {

    public static ReviewResponse of(Review review) {
        return new ReviewResponse(review.getContent(), review.getCreatedAt());
    }
}
