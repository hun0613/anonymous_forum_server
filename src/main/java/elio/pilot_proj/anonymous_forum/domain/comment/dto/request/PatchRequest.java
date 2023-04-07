package elio.pilot_proj.anonymous_forum.domain.comment.dto.request;

public class PatchRequest {
    private Integer commentId;
    private String comment;

    public PatchRequest(Integer commentId, String comment) {
        this.commentId = commentId;
        this.comment = comment;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }
}
