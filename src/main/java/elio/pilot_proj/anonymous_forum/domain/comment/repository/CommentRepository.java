package elio.pilot_proj.anonymous_forum.domain.comment.repository;

import elio.pilot_proj.anonymous_forum.domain.comment.dto.request.CommentRequest;
import elio.pilot_proj.anonymous_forum.domain.comment.dto.request.PatchRequest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class CommentRepository {
    private final JdbcTemplate jdbcTemplate;

    public CommentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveComment(CommentRequest request){
        String sql = "INSERT INTO comment (bundleId, depth, refId, admin, isDelete, content, createAt) VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, request.getBundleId(), request.getDepth(), request.getRefId(), request.getAdmin(), false, request.getContent(), new Date());
    }

    public void updateComment(PatchRequest request){
        String sql = "UPDATE comment SET content = ?, createAt = ? where commentId = ?";
        jdbcTemplate.update(sql, request.getComment(), new Date(), request.getCommentId());
    }

    public void deleteComment(Integer commentId){
        String sql = "UPDATE comment SET content = ?, createAt = ?, isDelete = ? where commentId = ?";
        jdbcTemplate.update(sql, "삭제된 댓글입니다", new Date(), true, commentId);
    }
}
