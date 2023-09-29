package edu.human.ex.controller;

import edu.human.ex.service.BoardService;
import edu.human.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {

        log.info("list() ..");
        model.addAttribute("boards",boardService.getList());

        return "/views/board/list";
    }

    @GetMapping("/content_view")
    public String content_view(HttpServletRequest request, Model model) {

        System.out.println("content_view()");

        String bid = request.getParameter("bid");
        model.addAttribute("content_view", boardService.get(Integer.valueOf(bid)));

        return "/views/board/content_view";
    }

    @GetMapping("/reply_view/{bid}")
    public String reply_view(@PathVariable int bid, Model model) {

        System.out.println("reply_view()");


        model.addAttribute("reply_view", boardService.get(bid));

        return "/views/board/reply_view";
    }

    @PostMapping("/reply")
    public String reply(BoardVO boardVO) {

        System.out.println("reply() ..");

        boardService.writeReply(boardVO);

        return "redirect:/board/list";
    }

}
