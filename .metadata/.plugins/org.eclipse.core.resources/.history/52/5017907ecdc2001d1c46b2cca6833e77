package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		
		Scanner scan = new Scanner(System.in);
		
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
		
		System.out.print("찾고자 하는 아이디를 입력");
		
		
		
	}
}
