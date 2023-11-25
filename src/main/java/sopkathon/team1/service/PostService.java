package sopkathon.team1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopkathon.team1.domain.category.Category;
import sopkathon.team1.domain.post.Post;
import sopkathon.team1.dto.request.PostCreateRequest;
import sopkathon.team1.dto.response.PostCreateResponse;
import sopkathon.team1.repository.CategoryRepository;
import sopkathon.team1.repository.PostRepository;

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

}
