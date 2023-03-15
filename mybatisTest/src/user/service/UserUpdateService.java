package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService{
	
	@Override
	public void execute() {
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("찾고자 하는 아이디를 입력");
		String id = sc.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("아이디가 없습니다.");
			return; //함수를 나가라
		} 
		System.out.println();
		System.out.println("이름\t아이디\t비밀번호");
		System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		
		System.out.println();
		System.out.print("변경할 이름 입력 : ");
		String name = sc.next();
		System.out.print("변경할 비밀번호 입력 : ");
		String pwd = sc.next();
	
		Map<String,String> map = new HashMap<>();
		map.put("name", name); 
		map.put("id", id);
		map.put("pwd", pwd);
		
		userDAO.update(map);
		
		System.out.println("데이터를 수정하였습니다");
		
	}	
	}

