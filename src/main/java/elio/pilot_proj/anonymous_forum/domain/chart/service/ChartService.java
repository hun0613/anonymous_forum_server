package elio.pilot_proj.anonymous_forum.domain.chart.service;

import elio.pilot_proj.anonymous_forum.domain.chart.dto.reponse.ChartResponse;
import elio.pilot_proj.anonymous_forum.domain.chart.repository.ChartRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ChartService {
    private final ChartRepository chartRepository;

    public ChartService(JdbcTemplate jdbcTemplate) {
        this.chartRepository = new ChartRepository(jdbcTemplate);
    }

    public List<ChartResponse> getWeekChart(String startDate, String endDate){
        return chartRepository.getWeekChart(startDate, endDate);
    }
}
