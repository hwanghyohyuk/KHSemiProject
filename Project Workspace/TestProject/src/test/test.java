package test;

import java.util.Scanner;

import com.studyhub.common.CryptTemplate;
import com.studyhub.common.vo.AesUtil;

public class test implements CryptTemplate{

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("비밀번호를 입력하세요 : ");
			String userpwd = sc.nextLine();
			if(userpwd.equals("exit")){
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
			String encryptPwd = util.encrypt(SALT, IV, PASSPHRASE, userpwd);
			System.out.println("암호화된 비밀번호는 "+encryptPwd+" 입니다");
		}		
	}

}
