package elio.pilot_proj.anonymous_forum.domain.admin.service;

import elio.pilot_proj.anonymous_forum.domain.admin.dto.request.UserRequest;
import elio.pilot_proj.anonymous_forum.domain.admin.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService {
    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.userRepository = new UserRepository(jdbcTemplate);
    }

    public void checkAdmin(UserRequest request){
        if(userRepository.isUserNotExist(request.getName(), request.getCode())){
            throw new IllegalArgumentException(String.format("등록되지 않은 관리자정보입니다"));
        }
    }
}
