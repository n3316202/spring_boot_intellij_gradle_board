package edu.human.ex.service;

import edu.human.ex.vo.BoardVO;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;


public interface BoardService {
	public List<BoardVO> getList();
	public void writeBoard(BoardVO board);
	public int remove(int bid);
	public BoardVO get(int bid);
	public int modify(BoardVO board);
	public void writeReply(BoardVO board);
}
