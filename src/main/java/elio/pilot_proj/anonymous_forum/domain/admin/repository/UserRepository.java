package elio.pilot_proj.anonymous_forum.domain.admin.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(String name, String code){
        String readSql = "SELECT admin_id FROM admin WHERE name = ? and admin_code = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name, code).isEmpty();
    }
}
