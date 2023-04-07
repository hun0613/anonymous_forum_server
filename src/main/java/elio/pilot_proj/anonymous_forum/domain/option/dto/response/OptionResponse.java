package elio.pilot_proj.anonymous_forum.domain.option.dto.response;

import java.sql.Timestamp;

public class OptionResponse {
    private Integer optionId;
    private Integer pageAmount;
    private Integer pageSetAmount;
    private String adminName;
    private Timestamp createAt;

    public OptionResponse(Integer optionId, Integer pageAmount, Integer pageSetAmount, String adminName, Timestamp createAt) {
        this.optionId = optionId;
        this.pageAmount = pageAmount;
        this.pageSetAmount = pageSetAmount;
        this.adminName = adminName;
        this.createAt = createAt;
    }

    public Integer getOptionId() {
        return optionId;
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

    public Timestamp getCreateAt() {
        return createAt;
    }
}
