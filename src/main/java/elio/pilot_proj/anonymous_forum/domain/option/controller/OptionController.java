package elio.pilot_proj.anonymous_forum.domain.option.controller;

import elio.pilot_proj.anonymous_forum.domain.option.dto.request.OptionRequest;
import elio.pilot_proj.anonymous_forum.domain.option.dto.response.OptionResponse;
import elio.pilot_proj.anonymous_forum.domain.option.service.OptionService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OptionController {
    private final OptionService optionService;

    public OptionController(JdbcTemplate jdbcTemplate) {
        this.optionService = new OptionService(jdbcTemplate);
    }

    @GetMapping("/option")
    public List<OptionResponse> getOption(){
        return optionService.getOption();
    }

    @PostMapping("/option")
    public void saveOption(@RequestBody OptionRequest optionRequest){
        optionService.saveOption(optionRequest);
    }
}
