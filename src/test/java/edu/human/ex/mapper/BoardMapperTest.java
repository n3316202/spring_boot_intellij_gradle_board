package edu.human.ex.mapper;

import edu.human.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testGetList() {
        assertNotNull(boardMapper);

        System.out.println(boardMapper.getList().size());

        for(BoardVO vo : boardMapper.getList()) {
            log.info("보드" + vo);
        }
    }
}