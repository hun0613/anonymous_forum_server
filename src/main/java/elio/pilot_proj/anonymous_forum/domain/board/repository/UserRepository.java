package elio.pilot_proj.anonymous_forum.domain.board.repository;

import elio.pilot_proj.anonymous_forum.domain.board.dto.request.PatchRequest;
import elio.pilot_proj.anonymous_forum.domain.comment.dto.response.CommentResponse;
import elio.pilot_proj.anonymous_forum.domain.board.dto.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveBoard(String title, String content, String email){
        String sql = "INSERT INTO board (title, content, createAt, email) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, title, content, new Date(), email);
    }

    public List<UserResponse> getBoard(){
        // 댓글 조회 쿼리
        String commentSql = "SELECT bundleId, commentId, depth, refId, admin, isDelete, content, createAt FROM comment WHERE bundleId = ?";
        // 게시글 조회 쿼리
        String sql = "SELECT id, title, content, createAt FROM board ORDER BY createAt DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String content = rs.getString("content");
            Timestamp createAt = rs.getTimestamp("createAt");
            List<CommentResponse> comment = jdbcTemplate.query(commentSql, (rs2, rowNum2) -> {
                int bundleId = rs2.getInt("bundleId");
                int commentId = rs2.getInt("commentId");
                int depth = rs2.getInt("depth");
                int refId = rs2.getInt("refId");
                String admin = rs2.getString("admin");
                Boolean isDelete = rs2.getBoolean("isDelete");
                String step = rs2.getString("content");
                Timestamp commentCreateAt = rs2.getTimestamp("createAt");
                return new CommentResponse(bundleId, commentId, depth, refId, admin, isDelete, step, commentCreateAt);
            }, id);
            return new UserResponse(id, title, content, createAt, comment);
        });
    }

    public void deleteBoard(Integer boardId){
        // 게시글 테이블 삭제 쿼리
        String sql = "DELETE FROM board WHERE id = ?";
        jdbcTemplate.update(sql, boardId);
        // 댓글 테이블 삭제 쿼리
        String commentSql = "DELETE FROM comment WHERE bundleId = ?";
        jdbcTemplate.update(commentSql, boardId);
    }

    public List<UserResponse> getMyBoard(String email){
        String commentSql = "SELECT bundleId, commentId, depth, refId, admin, isDelete, content, createAt FROM comment WHERE bundleId = ?";


        String sql = "SELECT id, title, content, createAt FROM board WHERE email = ? ORDER BY createAt DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String content = rs.getString("content");
            Timestamp createAt = rs.getTimestamp("createAt");
            List<CommentResponse> comment = jdbcTemplate.query(commentSql, (rs2, rowNum2) -> {
                int bundleId = rs2.getInt("bundleId");
                int commentId = rs2.getInt("commentId");
                int depth = rs2.getInt("depth");
                int refId = rs2.getInt("refId");
                String admin = rs2.getString("admin");
                Boolean isDelete = rs2.getBoolean("isDelete");
                String step = rs2.getString("content");
                Timestamp commentCreateAt = rs2.getTimestamp("createAt");
                return new CommentResponse(bundleId, commentId, depth, refId, admin, isDelete, step, commentCreateAt);
            }, id);
            return new UserResponse(id, title, content, createAt, comment);
        }, email);
    }

    public boolean isDataNotExist(String email){
        String sql = "SELECT id FROM board WHERE email = ? ORDER BY createAt DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 0, email).isEmpty();
    }

    public void updateBoard(PatchRequest request){
        String sql = "UPDATE board SET title = ?, content = ?, createAt = ? WHERE id = ?";
        jdbcTemplate.update(sql, request.getTitle(), request.getContent(), new Date(), request.getBoardId());
    }
}
