package elio.pilot_proj.anonymous_forum.domain.chart.controller;

import elio.pilot_proj.anonymous_forum.domain.chart.dto.reponse.ChartResponse;
import elio.pilot_proj.anonymous_forum.domain.chart.service.ChartService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChartController {
    private final ChartService chartService;

    public ChartController(JdbcTemplate jdbcTemplate) {
        this.chartService = new ChartService(jdbcTemplate);
    }

    @GetMapping("/chart/week")
    public List<ChartResponse> getWeekChart(@RequestParam String startDate, String endDate){
        return chartService.getWeekChart(startDate, endDate);
    }
}
