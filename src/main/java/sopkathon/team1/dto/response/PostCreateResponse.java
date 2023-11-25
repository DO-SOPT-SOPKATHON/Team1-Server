package sopkathon.team1.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostCreateResponse {
    private String title;

    private String content;

    private LocalDate createdAt;

    private Long categoryType;
}
