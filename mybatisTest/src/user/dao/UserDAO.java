package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static UserDAO userDAO = new UserDAO();	
	
	public static UserDAO getInstance() {
		
		return userDAO;
		
	}
	
	public UserDAO() {
		/* InputStream inputStream; */
		try {
			//Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		sqlSession.insert("userSQL.write", userDTO);
		sqlSession.commit();
		sqlSession.close();		
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		sqlSession.close();	 // 오라클 lock -> insert/delete/ update -> 반드시 Commit
		return list;
	}

	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", id);
		sqlSession.close();
		return userDTO;
	}

	public void update(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		sqlSession.update("userSQL.update",map);
		sqlSession.commit();
		sqlSession.close();
	}
		
}



















