package sopkathon.team1.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopkathon.team1.dto.request.ReviewRequest;
import sopkathon.team1.service.ReviewService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("{postId}")
    public ResponseEntity<Void> postReviewById(@PathVariable Long postId,
                                               @RequestBody ReviewRequest request) {
        URI location = URI.create("/api/review" + "/" + reviewService.postReview(request, postId));
        return ResponseEntity.created(location).build();
    }

}
