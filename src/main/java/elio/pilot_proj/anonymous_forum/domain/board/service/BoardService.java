package elio.pilot_proj.anonymous_forum.domain.board.service;

import elio.pilot_proj.anonymous_forum.domain.board.dto.request.PatchRequest;
import elio.pilot_proj.anonymous_forum.domain.board.dto.request.UserRequest;
import elio.pilot_proj.anonymous_forum.domain.board.dto.response.UserResponse;
import elio.pilot_proj.anonymous_forum.domain.board.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BoardService {
    private final UserRepository userRepository;

    public BoardService(JdbcTemplate jdbcTemplate) {
        this.userRepository = new UserRepository(jdbcTemplate);
    }

    public void saveBoard(UserRequest request){
        userRepository.saveBoard(request.getTitle(), request.getContent(), request.getEmail());
    }

    public List<UserResponse> getBoard(String email){
        if(email == null){
            return userRepository.getBoard();
        }else{
            if(userRepository.isDataNotExist(email)){
                throw new IllegalArgumentException(String.format("등록되지 않은 이메일입니다"));
            }
            return userRepository.getMyBoard(email);
        }
    }

    public void deleteBoard(Integer boardId){
        userRepository.deleteBoard(boardId);
    }

    public void updateBoard(PatchRequest request){
        userRepository.updateBoard(request);
    }
}
