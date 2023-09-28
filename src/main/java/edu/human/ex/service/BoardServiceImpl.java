package edu.human.ex.service;

import edu.human.ex.mapper.BoardMapper;
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
}
