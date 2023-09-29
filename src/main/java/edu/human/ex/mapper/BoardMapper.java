package edu.human.ex.mapper;

import edu.human.ex.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
	public List<BoardVO> getList();
	public int insertBoard(BoardVO boardVO);
	public int delete(int bid);
	public BoardVO read(int bno);
	public int updateBoard(BoardVO boardVO);
	public int updateShape(BoardVO boardVO);
	public int insertReply(BoardVO boardVO);
}
