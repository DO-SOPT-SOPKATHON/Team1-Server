package sopkathon.team1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopkathon.team1.dto.request.PostCreateRequest;
import sopkathon.team1.dto.response.PostCreateResponse;
import sopkathon.team1.dto.response.PostGetResponse;
import sopkathon.team1.exception.ResultCode;
import sopkathon.team1.exception.ResultResponse;
import sopkathon.team1.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostCreateResponse> create(@RequestBody PostCreateRequest request){
        return ResponseEntity.ok(postService.create(request));
    }

    @GetMapping("/{categoryId}")
    public ResultResponse<List<PostGetResponse>> getPosts(@PathVariable("categoryId") Long categoryId){
        return ResultResponse.of(ResultCode.GET_POSTS_SUCCESS, postService.getPosts(categoryId));
    }

}
