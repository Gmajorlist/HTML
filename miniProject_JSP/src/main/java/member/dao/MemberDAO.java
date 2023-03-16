package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
	private static MemberDAO memberDAO = new MemberDAO();
	private SqlSessionFactory sqlSessionFactory;
	
	
	public static MemberDAO getInstance() {
		return memberDAO;
	}

	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("conf/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	public MemberDTO memberLogin(Map map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO= sqlSession.selectOne("memberSQL.memberLogin", map);
		sqlSession.close();
		return memberDTO;
	}
	
	
	public int memberWrite(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		 int su= sqlSession.insert("memberSQL.memberWrite",memberDTO);
		 sqlSession.commit();
		 sqlSession.close();
		 return su;
		 
	}	 
		 
		 
		
	
	
//	public MemberDTO memberLogin(String id, String pwd){
//		MemberDTO memberDTO = null;
//		
//		String sql = "SELECT * FROM MEMBER where id=? and pwd=?";
//		
//		try {
//			conn = ds.getConnection();
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setString(2, pwd);
//			rs = pstmt.executeQuery();//ResultSet 리턴
//			
//			if(rs.next()) {
//				memberDTO = new MemberDTO();
//				memberDTO.setName(rs.getString("name"));
//				memberDTO.setEmail1(rs.getString("email1"));
//				memberDTO.setEmail2(rs.getString("email2"));
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MemberDAO.close(conn, pstmt, rs);
//		}
//		
//		return memberDTO;		
//	}
//	
//	public MemberDTO getMember(String id) {
//		MemberDTO memberDTO = null;
//		String sql = "select * from member where id=?";
//		
//		try {
//			conn = ds.getConnection();
//			
//			pstmt = conn.prepareStatement(sql);//생성
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery(); //ResultSet 리턴
//			
//			if(rs.next()) {
//				memberDTO = new MemberDTO(); //생성
//				memberDTO.setName(rs.getString("name"));
//				memberDTO.setId(rs.getString("id"));
//		        memberDTO.setPwd(rs.getString("pwd"));
//		        memberDTO.setGender(rs.getString("gender"));
//		        memberDTO.setEmail1(rs.getString("email1"));
//		        memberDTO.setEmail2(rs.getString("email2"));
//		        memberDTO.setTel1(rs.getString("tel1"));
//		        memberDTO.setTel2(rs.getString("tel2"));
//		        memberDTO.setTel3(rs.getString("tel3"));
//		        memberDTO.setZipcode(rs.getString("zipcode"));
//		        memberDTO.setAddr1(rs.getString("addr1"));
//		        memberDTO.setAddr2(rs.getString("addr2"));
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MemberDAO.close(conn, pstmt, rs);
//		}
//		
//		return memberDTO;
//	}
//
//	public void memberUpdate(MemberDTO memberDTO) {
//		String sql = "update member set name=?"
//								   + ", pwd=?"
//								   + ", gender=?"
//								   + ", email1=?"
//								   + ", email2=?"
//								   + ", tel1=?"
//								   + ", tel2=?"
//								   + ", tel3=?"
//								   + ", zipcode=?"
//								   + ", addr1=?"
//								   + ", addr2=?"
//								   + ", logtime=sysdate"
//								   + " where id=?";
//		
//		
//		try {
//			conn = ds.getConnection();
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memberDTO.getName());
//			pstmt.setString(2, memberDTO.getPwd());
//		    pstmt.setString(3, memberDTO.getGender());
//		    pstmt.setString(4, memberDTO.getEmail1());
//		    pstmt.setString(5, memberDTO.getEmail2());
//		    pstmt.setString(6, memberDTO.getTel1());
//		    pstmt.setString(7, memberDTO.getTel2());
//		    pstmt.setString(8, memberDTO.getTel3());
//		    pstmt.setString(9, memberDTO.getZipcode());
//		    pstmt.setString(10, memberDTO.getAddr1());
//		    pstmt.setString(11, memberDTO.getAddr2());
//		    pstmt.setString(12, memberDTO.getId());
//		    
//		    pstmt.executeUpdate();//개수 리턴
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			MemberDAO.close(conn, pstmt);
//		}
//	}
//	
//	public boolean isExistPwd(String id, String pwd){
//		boolean exist = false;
//		String sql = "select * from member where id=? and pwd=?";
//		
//		try {
//			conn = ds.getConnection();
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setString(2, pwd);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) exist = true;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MemberDAO.close(conn, pstmt, rs);
//		}
//		
//		return exist;
//	}
//	
//	public void memberDelete(String id) {
//		String sql = "delete member where id=?";
//		
//		try {
//			conn = ds.getConnection();
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			
//			pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MemberDAO.close(conn, pstmt);
//		}
//	}
//	
//	public boolean isExistId(String id) {
//		boolean existId = false;
//		String sql = "select * from member where id=?";
//		
//		try {
//			conn = ds.getConnection();
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) existId = true;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MemberDAO.close(conn, pstmt, rs);
//		}
//		
//		return existId;
//	}
}
//


















