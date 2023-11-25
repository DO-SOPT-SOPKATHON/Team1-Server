package sopkathon.team1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PostCreateResponse {
    private String title;

    private String content;

    private LocalDate createdAt;

    private Long categoryId;
}
