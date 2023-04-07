package elio.pilot_proj.anonymous_forum.domain.board.dto.request;

public class PatchRequest {
    private Integer boardId;
    private String title;
    private String content;

    public PatchRequest(Integer boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
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
}
