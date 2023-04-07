package elio.pilot_proj.anonymous_forum.domain.board.dto.response;

import elio.pilot_proj.anonymous_forum.domain.comment.dto.response.CommentResponse;

import java.sql.Timestamp;
import java.util.List;

public class UserResponse {
    private Integer boardId;
    private String title;
    private String content;
    private Timestamp createAt;

    private List<CommentResponse> comment;

    public UserResponse(Integer boardId, String title, String content, Timestamp createAt, List<CommentResponse> comment) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.comment = comment;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public List<CommentResponse> getComment() {
        return comment;
    }
}
