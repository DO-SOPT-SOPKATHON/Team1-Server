package sopkathon.team1.dto.request;

import lombok.Data;

@Data
public class PostCreateRequest {
    private Long categoryId;

    private String title;

    private String content;
}
