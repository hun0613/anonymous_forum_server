package elio.pilot_proj.anonymous_forum.domain.admin.dto.request;

public class UserRequest {
    private String name;
    private String code;

    public UserRequest(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
