package elio.pilot_proj.anonymous_forum.domain.comment.service;

import elio.pilot_proj.anonymous_forum.domain.comment.dto.request.CommentRequest;
import elio.pilot_proj.anonymous_forum.domain.comment.dto.request.PatchRequest;
import elio.pilot_proj.anonymous_forum.domain.comment.repository.CommentRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(JdbcTemplate jdbcTemplate) {
        this.commentRepository = new CommentRepository(jdbcTemplate);
    }

    public void saveComment(CommentRequest commentRequest){
        commentRepository.saveComment(commentRequest);
    }

    public void updateComment(PatchRequest request){
        commentRepository.updateComment(request);
    }

    public void deleteComment(Integer commentId){
        commentRepository.deleteComment(commentId);
    }
}
