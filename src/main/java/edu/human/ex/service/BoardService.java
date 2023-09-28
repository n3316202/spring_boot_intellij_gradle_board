package edu.human.ex.service;

import edu.human.ex.vo.BoardVO;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;


public interface BoardService {
	public List<BoardVO> getList();
}
