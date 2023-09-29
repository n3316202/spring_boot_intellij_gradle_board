package edu.human.ex.controller;

import edu.human.ex.service.BoardService;
import edu.human.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequestMapping("/boards")
public class RestBoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/")
    public ResponseEntity<String> write(@RequestBody BoardVO boardVO) {

        log.info("Board:" + boardVO);
        ResponseEntity<String> entity = null;

        try {
            boardService.writeBoard(boardVO);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;

    }

    @DeleteMapping("/{bid}")
    public ResponseEntity<String> restDelete(BoardVO boardVO, Model model) {
        ResponseEntity<String> entity = null;
        log.info("rest_delete..");

        try {
            int rn = boardService.remove(boardVO.getBid());
            // 삭제가 성공하면 성공 상태메시지 저장
            log.info("delete 넘어온 숫자:::::" + rn);

            entity = new ResponseEntity<String>(String.valueOf(rn), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // 댓글 삭제가 실패하면 실패 상태메시지 저장
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        // 삭제 처리 HTTP 상태 메시지 리턴
        return entity;

    }

    @PutMapping("/")
    public ResponseEntity<String> restUpdate(@RequestBody BoardVO boardVO) {

        ResponseEntity<String> entity = null;

        log.info("rest_update..");
        try {

            int rn = boardService.modify(boardVO);
            log.info("update 넘어온 숫자:::::" + rn);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

}
