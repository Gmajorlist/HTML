package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static BoardDAO boardDAO = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return boardDAO;
	}
		
	public BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void boardWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite", map);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<BoardDTO> boardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);
		sqlSession.close();
		return list;
	}
	
	public int getTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}
	
	public BoardDTO getBoard(int seq) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
	    int hit = boardDTO.getHit(); // boardDTO로부터 조회수 가져오기
	    hit++; 					// 조회수 1씩 증가
	    hitUpdate(seq, hit); 	// DB에 조회수 업데이트
	    boardDTO.setHit(hit); 	// boardDTO에 조회수 업데이트
	    sqlSession.close();
	    return boardDTO;
	}
	
	public int hitUpdate(int seq, int hit) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    map.put("seq", seq);
	    map.put("hit", hit);
	    sqlSession.update("boardSQL.hitUpdate", map);
	    sqlSession.commit();
	    sqlSession.close();
	    
	    return -1; // DB 오류
	}

	public void boardReply(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//원글
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", map.get("pseq"));
		
		//step update
		//update board set step=step+1 where ref=원글ref and step>원글step
		sqlSession.update("boardSQL.boardReply1", boardDTO);
		
		//insert
		//답글 ref = 원글ref
		//답글 lev = 원글lev +1
		//답글 step = 원글step +1
		//map에는 id name email subject content pseq를 담아왔다 추가로 ref lev step 넣엇다.
		map.put("ref", boardDTO.getRef()+"");
		map.put("lev", boardDTO.getLev()+1+"");
		map.put("step", boardDTO.getStep()+1+"");
		sqlSession.insert("boardSQL.boardReply2", map);
		//reply update
		
		//update baord set reply=reply+1 where seq=원글번호
		sqlSession.update("boardSQl.boardReply3", boardDTO.getSeq());
		
		sqlSession.commit();
		sqlSession.close();
		
	}
}
