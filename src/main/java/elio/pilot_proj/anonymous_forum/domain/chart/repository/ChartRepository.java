package elio.pilot_proj.anonymous_forum.domain.chart.repository;

import elio.pilot_proj.anonymous_forum.domain.chart.dto.reponse.ChartResponse;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ChartRepository {
    private final JdbcTemplate jdbcTemplate;

    public ChartRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ChartResponse> getWeekChart(String startDate, String endDate){
        String sql = "select d as createDate, result as cnt from (select a.d, count(b.id) as result from year_date a left outer join board b on a.d = date_format(b.createAt, '%Y-%m-%d') group by a.d) A where A.d between ? and ?";

        return jdbcTemplate.query(sql,(rs, rowNum) -> {
            String createDate = rs.getString("createDate");
            int cnt = rs.getInt("cnt");

            return new ChartResponse(createDate, cnt);
        }, startDate, endDate);
    }
}
