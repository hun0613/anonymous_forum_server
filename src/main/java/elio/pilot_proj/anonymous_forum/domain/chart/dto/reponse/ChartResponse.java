package elio.pilot_proj.anonymous_forum.domain.chart.dto.reponse;

public class ChartResponse {
    private String createDate;
    private Integer cnt;

    public ChartResponse(String createDate, Integer cnt) {
        this.createDate = createDate;
        this.cnt = cnt;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Integer getCnt() {
        return cnt;
    }
}
