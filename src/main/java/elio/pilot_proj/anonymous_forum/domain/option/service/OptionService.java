package elio.pilot_proj.anonymous_forum.domain.option.service;

import elio.pilot_proj.anonymous_forum.domain.option.dto.request.OptionRequest;
import elio.pilot_proj.anonymous_forum.domain.option.dto.response.OptionResponse;
import elio.pilot_proj.anonymous_forum.domain.option.repository.OptionRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OptionService {
    private final OptionRepository optionRepository;

    public OptionService(JdbcTemplate jdbcTemplate) {
        this.optionRepository = new OptionRepository(jdbcTemplate);
    }

    public List<OptionResponse> getOption(){
        return optionRepository.getOption();
    }

    public void saveOption(OptionRequest optionRequest){
        optionRepository.saveOption(optionRequest);
    }
}
