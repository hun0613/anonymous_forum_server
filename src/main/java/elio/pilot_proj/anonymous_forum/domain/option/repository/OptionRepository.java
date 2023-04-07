package elio.pilot_proj.anonymous_forum.domain.option.repository;

import elio.pilot_proj.anonymous_forum.domain.option.dto.request.OptionRequest;
import elio.pilot_proj.anonymous_forum.domain.option.dto.response.OptionResponse;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class OptionRepository {
    private final JdbcTemplate jdbcTemplate;

    public OptionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OptionResponse> getOption(){
        String sql = "SELECT optionId, pageAmount, pageSetAmount, adminName, createAt FROM options ORDER BY createAt DESC";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            int optionId = rs.getInt("optionId");
            int pageAmount = rs.getInt("pageAmount");
            int pageSetAmount = rs.getInt("pageSetAmount");
            String adminName = rs.getString("adminName");
            Timestamp createAt = rs.getTimestamp("createAt");
            return new OptionResponse(optionId, pageAmount, pageSetAmount, adminName, createAt);
        });
    }

    public void saveOption(OptionRequest optionRequest){
        String sql = "INSERT INTO options (pageAmount, pageSetAmount, adminName, createAt) VALUES (?,?,?,?)";

        jdbcTemplate.update(sql, optionRequest.getPageAmount(), optionRequest.getPageSetAmount(), optionRequest.getAdminName(), new Date());
    }
}
