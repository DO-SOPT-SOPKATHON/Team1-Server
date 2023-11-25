package sopkathon.team1.service;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopkathon.team1.domain.post.Post;
import sopkathon.team1.domain.review.Review;
import sopkathon.team1.dto.response.PostResponse;
import sopkathon.team1.exception.CategoryException;
import sopkathon.team1.exception.CustomErrorCode;
import sopkathon.team1.repository.PostRepository;
import java.time.temporal.ChronoUnit;
import sopkathon.team1.repository.ReviewRepository;
import sopkathon.team1.domain.category.Category;
import sopkathon.team1.dto.request.PostCreateRequest;
import sopkathon.team1.dto.response.PostCreateResponse;
import sopkathon.team1.dto.response.PostGetResponse;
import sopkathon.team1.repository.CategoryRepository;

import java.util.List;

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

    public PostResponse getRandomPost() {
        Random random = new Random();
        int totalPostNumber = (int)postRepository.count();
        long randomNumber = random.nextInt(totalPostNumber) + 1;

        Post post = postRepository.findById(randomNumber).orElseThrow(() -> new EntityNotFoundException("해당하는 포스트가 없습니다."));
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

    @Transactional
    public List<PostGetResponse> getPosts(Long categoryId){
        Category category = categoryRepository.findByCategoryId(categoryId);
        if(category == null) throw new CategoryException(CustomErrorCode.CATEGORY_NOT_FOUND);
        List<Post> posts = postRepository.findAllByCategory(category);
        return posts.stream().map(post -> PostGetResponse.of(post)).toList();
    }


}
