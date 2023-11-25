package sopkathon.team1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopkathon.team1.dto.request.PostCreateRequest;
import sopkathon.team1.dto.response.PostCreateResponse;
import sopkathon.team1.dto.response.PostResponse;
import sopkathon.team1.service.PostService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @GetMapping("{postId}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @GetMapping("/random")
    public ResponseEntity<PostResponse> getRandomPost() {
        return ResponseEntity.ok(postService.getRandomPost());
    }


    @PostMapping
    public ResponseEntity<PostCreateResponse> create(@RequestBody PostCreateRequest request) {
        return ResponseEntity.ok(postService.create(request));
    }
}
