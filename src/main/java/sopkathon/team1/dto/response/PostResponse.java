package sopkathon.team1.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import sopkathon.team1.domain.post.Post;
import sopkathon.team1.domain.review.Review;

public record PostResponse(long postId,
                           String title,
                           String content,
                           LocalDate createdAt,
                           int dayDiff,
                           List<ReviewResponse> reviewList
                           ) {
    public static PostResponse of(Post post, int dayDiff, List<Review> reviewList) {
        List<ReviewResponse> reviewResponses = reviewList.stream()
                .map(review -> ReviewResponse.of(review))
                .collect(Collectors.toList());

        return new PostResponse(
                post.getPostId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                dayDiff,
                reviewResponses
                );
    }
}
