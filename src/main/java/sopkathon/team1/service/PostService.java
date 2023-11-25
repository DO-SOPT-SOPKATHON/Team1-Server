package sopkathon.team1.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopkathon.team1.domain.category.Category;
import sopkathon.team1.domain.post.Post;
import sopkathon.team1.dto.request.PostCreateRequest;
import sopkathon.team1.dto.response.PostCreateResponse;
import sopkathon.team1.dto.response.PostGetResponse;
import sopkathon.team1.repository.CategoryRepository;
import sopkathon.team1.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

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
        if(category == null) throw new EntityNotFoundException("카테고리가 존재하지 않습니다.");
        List<Post> posts = postRepository.findAllByCategory(category);
        return posts.stream().map(post -> PostGetResponse.of(post)).toList();
    }

}
