package sopkathon.team1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopkathon.team1.dto.response.PostResponse;
import sopkathon.team1.service.PostService;

@RestController
@RequiredArgsConstructor
@RequestMapping("BASE_PATH")
public class PostController {
    static final String BASE_PATH = "/api/post";
    private final PostService postService;

    @GetMapping("{postId}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

}
