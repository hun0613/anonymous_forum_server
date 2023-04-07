package elio.pilot_proj.anonymous_forum.domain.admin.controller;

import elio.pilot_proj.anonymous_forum.domain.admin.dto.request.UserRequest;
import elio.pilot_proj.anonymous_forum.domain.admin.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.userService = new UserService(jdbcTemplate);
    }

    @PostMapping("/admin")
    public void checkAdmin(@RequestBody UserRequest request){
        userService.checkAdmin(request);
    }
}
