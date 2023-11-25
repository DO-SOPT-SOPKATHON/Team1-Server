package sopkathon.team1.domain.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {

    Study("학업"),
    Love("사랑"),
    People("인간관계"),
    Finance("경제");

    private final String description;
}
