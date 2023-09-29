package edu.human.ex.mapper;

import edu.human.ex.page.Criteria;
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

	/*댓글 관련*/
	public int updateShape(BoardVO boardVO);
	public int insertReply(BoardVO boardVO);

	/*페이징 관련*/
	public List<BoardVO> getListWithPaging(Criteria cri);
	public int getTotalCount();
}
