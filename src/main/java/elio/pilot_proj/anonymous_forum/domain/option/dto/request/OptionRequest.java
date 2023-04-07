package elio.pilot_proj.anonymous_forum.domain.option.dto.request;

public class OptionRequest {
    private Integer pageAmount;
    private Integer pageSetAmount;
    private String adminName;

    public OptionRequest(Integer pageAmount, Integer pageSetAmount, String adminName) {
        this.pageAmount = pageAmount;
        this.pageSetAmount = pageSetAmount;
        this.adminName = adminName;
    }

    public Integer getPageAmount() {
        return pageAmount;
    }

    public Integer getPageSetAmount() {
        return pageSetAmount;
    }

    public String getAdminName() {
        return adminName;
    }
}
