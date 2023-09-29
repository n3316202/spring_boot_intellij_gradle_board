package edu.human.ex.service;

import edu.human.ex.mapper.BoardMapper;
import edu.human.ex.page.Criteria;
import edu.human.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {

		log.info("getList..........");
		return mapper.getList();
	}

	@Override
	public void writeBoard(BoardVO boardVO) {

		mapper.insertBoard(boardVO);
	}

	@Override
	public int remove(int bid) {
		log.info("remove..........");
		return mapper.delete(bid);
	}

	@Override
	public BoardVO get(int bid) {

		log.info("get..........");
		return mapper.read(bid);
	}
	@Override
	public int modify(BoardVO board) {
		log.info("service modify");
		return mapper.updateBoard(board);
	}

	@Override
	public void writeReply(BoardVO boardVO) {
		mapper.updateShape(boardVO);
		mapper.insertReply(boardVO);
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		log.info("getListWithPaging()......");
		return mapper.getListWithPaging(cri);
	}

	// 페이징 처리 함수
	@Override
	public int getTotal() {
		log.info("service:getTotal()..");
		return mapper.getTotalCount();
	}
}
