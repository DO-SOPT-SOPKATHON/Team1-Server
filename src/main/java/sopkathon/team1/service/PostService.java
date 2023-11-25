package sopkathon.team1.service;


import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopkathon.team1.domain.post.Post;
import sopkathon.team1.domain.review.Review;
import sopkathon.team1.dto.response.PostResponse;
import sopkathon.team1.repository.PostRepository;
import java.time.temporal.ChronoUnit;
import sopkathon.team1.repository.ReviewRepository;
import sopkathon.team1.domain.category.Category;
import sopkathon.team1.dto.request.PostCreateRequest;
import sopkathon.team1.dto.response.PostCreateResponse;
import sopkathon.team1.repository.CategoryRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final ReviewRepository reviewRepository;
    private final CategoryRepository categoryRepository;

    public PostResponse getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 포스트가 없습니다."));

        LocalDate todayLocalDate = LocalDate.now(); // 현재 날짜
        int daysDifference = (int)ChronoUnit.DAYS.between(post.getCreatedAt(), todayLocalDate);

        List<Review> reviewList = reviewRepository.findAllReviewByPost(post);

        return PostResponse.of(post, daysDifference, reviewList);
    }

    @Transactional
    public PostCreateResponse create(PostCreateRequest request){
        Category category = categoryRepository.findByCategoryId(request.getCategoryId());
        Post post = Post.builder().title(request.getTitle())
                .content(request.getContent())
                .category(category)
                .build();
        postRepository.save(post);
        return new PostCreateResponse(post.getTitle(), post.getContent(), post.getCreatedAt(), post.getCategory().getCategoryId());
    }



}
