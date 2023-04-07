package elio.pilot_proj.anonymous_forum.domain.comment.dto.response;

import java.sql.Timestamp;
import java.util.Date;

public class CommentResponse {
    private Integer bundleId;
    private Integer commentId;
    private Integer depth;
    private Integer refId;
    private String admin;
    private Boolean isDelete;
    private String content;
    private Timestamp createAt;


    public CommentResponse(Integer bundleId, Integer commentId, Integer depth, Integer refId, String admin, Boolean isDelete, String content, Timestamp createAt) {
        this.bundleId = bundleId;
        this.commentId = commentId;
        this.depth = depth;
        this.refId = refId;
        this.admin = admin;
        this.isDelete = isDelete;
        this.content = content;
        this.createAt = createAt;
    }

    public Integer getBundleId() {
        return bundleId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public Integer getDepth() {
        return depth;
    }

    public Integer getRefId() {
        return refId;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public String getAdmin() {
        return admin;
    }

    public Boolean getDelete() {
        return isDelete;
    }
}
