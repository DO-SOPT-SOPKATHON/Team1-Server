package sopkathon.team1.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopkathon.team1.domain.post.Post;
import sopkathon.team1.domain.review.Review;
import sopkathon.team1.dto.request.ReviewRequest;
import sopkathon.team1.repository.PostRepository;
import sopkathon.team1.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final PostRepository postRepository;

    @Transactional
    public String postReview(ReviewRequest request, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 포스트가 없습니다."));
        Review review = reviewRepository.save(
                Review.builder()
                        .content(request.content())
                        .post(post)
                        .build());
        return review.getId().toString();
    }


}

