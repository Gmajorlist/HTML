package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		String columnName = null;
		String value = null;
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 이름 검색");
		System.out.println("2. 아이디 검색");
		System.out.println("번호 입력 : ");
		int num = sc.nextInt();
		
		if(num == 1) {
			
			System.out.println("검색할 이름 입력 :");
			value = sc.next();
			columnName = "name";
		}else if(num == 2) {
			System.out.println("검색할 아이디 입력 : ");
			String id = sc.next();
			columnName = "id";
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("columnName", columnName);
		map.put("value", value);
		
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.search(map);
		
		System.out.println("이름\t아이디\t비밀번호");
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		}//for
		
		
	}

}
