package sopkathon.team1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import sopkathon.team1.domain.post.Post;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PostGetResponse {
    private String title;

    private String content;

    private LocalDate createdAt;

    private Long categoryId;

    public static PostGetResponse of(Post post) {
        return new PostGetResponse(post.getTitle(), post.getContent(), post.getCreatedAt(), post.getCategory().getCategoryId());
    }
}