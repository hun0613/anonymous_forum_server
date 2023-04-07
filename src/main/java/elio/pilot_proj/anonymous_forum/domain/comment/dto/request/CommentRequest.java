package elio.pilot_proj.anonymous_forum.domain.comment.dto.request;

public class CommentRequest {
    private Integer bundleId;
    private Integer depth;
    private Integer refId;
    private String content;

    private String admin;

    public CommentRequest(Integer bundleId, Integer depth, Integer refId, String content, String admin) {
        this.bundleId = bundleId;
        this.depth = depth;
        this.refId = refId;
        this.content = content;
        this.admin = admin;
    }

    public Integer getBundleId() {
        return bundleId;
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

    public String getAdmin() {
        return admin;
    }
}
