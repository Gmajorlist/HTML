package user.main;

import java.util.Scanner;

public class UserMain {
	
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int num;
		while(true) {
			System.out.println();
			System.out.println("*************************");
			System.out.println("	1.입력");
			System.out.println("	2.출력");
			System.out.println("	3.수정");
			System.out.println("	4.삭제");
			System.out.println("	5.검색");
			System.out.println("	6.종료");
			System.out.println("*************************");
			System.out.println("번호 입려력 :");
			num = sc.nextInt();
			if(num ==6) break;
					}//while
	}

	public static void main(String[] args) {
		

	}

}
