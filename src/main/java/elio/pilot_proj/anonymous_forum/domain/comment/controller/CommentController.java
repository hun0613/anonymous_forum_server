package elio.pilot_proj.anonymous_forum.domain.comment.controller;

import elio.pilot_proj.anonymous_forum.domain.comment.dto.request.CommentRequest;
import elio.pilot_proj.anonymous_forum.domain.comment.dto.request.PatchRequest;
import elio.pilot_proj.anonymous_forum.domain.comment.service.CommentService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(JdbcTemplate jdbcTemplate) {
        this.commentService = new CommentService(jdbcTemplate);
    }

    @PostMapping("/comment")
    public void saveComment(@RequestBody CommentRequest request){
        commentService.saveComment(request);
    }

    @PatchMapping("/comment")
    public void updateComment(@RequestBody PatchRequest request){
        commentService.updateComment(request);
    }

    @DeleteMapping("/comment")
    public void deleteComment(@RequestParam Integer commentId){
        commentService.deleteComment(commentId);
    }
}
