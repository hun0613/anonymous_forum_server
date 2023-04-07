package elio.pilot_proj.anonymous_forum.domain.board.controller;

import elio.pilot_proj.anonymous_forum.domain.board.dto.request.PatchRequest;
import elio.pilot_proj.anonymous_forum.domain.board.dto.request.UserRequest;
import elio.pilot_proj.anonymous_forum.domain.board.dto.response.UserResponse;
import elio.pilot_proj.anonymous_forum.domain.board.service.BoardService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(JdbcTemplate jdbcTemplate) {
        this.boardService = new BoardService(jdbcTemplate);
    }

    @PostMapping("/board")
    public void saveBoard(@RequestBody UserRequest request){
        boardService.saveBoard(request);
    }

    @GetMapping("/board")
    public List<UserResponse> getBoard(@RequestParam(required = false) String email){
        return boardService.getBoard(email);
    }

    @DeleteMapping("/board")
    public void deleteBoard(@RequestParam Integer boardId){
        boardService.deleteBoard(boardId);
    }

    @PatchMapping("/board")
    public void updateBoard(@RequestBody PatchRequest request){
        boardService.updateBoard(request);
    }
}
