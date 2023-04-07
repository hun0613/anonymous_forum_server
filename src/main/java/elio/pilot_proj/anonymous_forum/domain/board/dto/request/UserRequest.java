package elio.pilot_proj.anonymous_forum.domain.board.dto.request;

public class UserRequest {
    private String title;
    private String content;
    private String email;


    public UserRequest(String title, String content) {
        if (title.isEmpty() || content.isEmpty()){
            throw new IllegalArgumentException("비어있는 값이 들어왔습니다.");
        }
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    public String getEmail() {
        return email;
    }
}
