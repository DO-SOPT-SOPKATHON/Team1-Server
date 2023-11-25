package sopkathon.team1.dto.request;

import lombok.Data;
import sopkathon.team1.domain.category.Category;

@Data
public class PostCreateRequest {
    private Long categoryId;

    private String title;

    private String content;
}
