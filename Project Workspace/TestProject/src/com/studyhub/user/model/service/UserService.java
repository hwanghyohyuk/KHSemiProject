package com.studyhub.user.model.service;

import com.studyhub.user.model.dao.UserDao;
import com.studyhub.common.vo.User;
import static com.studyhub.common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class UserService {

	private UserDao uDao;
	private User user;

	public User loginCheck(String useremail, String userpwd) {
		Connection conn = getConnection();
		uDao = new UserDao();
		user = uDao.selectUser(conn, useremail, userpwd);
		close(conn);
		return user;
	}

	public boolean createUser(User user) {
		Connection conn = getConnection();
		uDao = new UserDao();
		boolean result = uDao.createUser(conn, user);
		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int checkEmail(String userEmail) {
		Connection conn = getConnection();
		uDao = new UserDao();
		int result = uDao.checkEmail(conn, userEmail);
		close(conn);
		return result;
	}

	public int checkName(String userEmail, String userName) {
		Connection conn = getConnection();
		uDao = new UserDao();
		int result = uDao.checkName(conn, userEmail, userName);
		close(conn);
		return result;
	}

	public int checkPwd(String userEmail, String userName, String userPwd) {
		Connection conn = getConnection();
		uDao = new UserDao();
		int result = uDao.checkPwd(conn, userEmail, userName, userPwd);
		close(conn);
		return result;
	}

	public String sendNewPwd(String decryptEmail, String decryptName) {
		String smtpMail = "studyhub555@gmail.com";
		String smtpPwd = "studyhub555!";
		String newPwd = randomCreatePwd();

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(smtpMail, smtpPwd);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(smtpMail));//
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(decryptEmail));
			message.setSubject("StudyHub에서 임시비밀번호를 발송합니다.");
			message.setText(
					decryptName + "님께 보내드리는 임시 비밀번호 입니다\n 임시 비밀번호 : " + newPwd + "\n 위 임시 비밀번호로 로그인하신 후 비밀번호 변경을 바랍니다");// 내용
			// message.setContent("내용","text/html; charset=utf-8");//글내용을 html타입
			// charset설정
			System.out.println("send!!!");
			Transport.send(message);
			System.out.println("SEND");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newPwd;
	}

	public String randomCreatePwd() {
		String password = null;
		String charBase = "abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		int index = 0;

		for (int i = 0; i < 6; i++) {
			index = (int) (Math.random() * charBase.length());
			// 0<= index <36 : 0~35
			sb.append(charBase.charAt(index));
		}
		password = sb.toString();
		return password;
	}

	public int modifyPwd(String decryptEmail, String newPwd) {
		Connection conn = getConnection();
		uDao = new UserDao();
		int result = uDao.modifyPwd(conn, decryptEmail, newPwd);
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int changeState(String decryptEmail, int pwdState) {
		Connection conn = getConnection();
		uDao = new UserDao();
		int result = uDao.changeState(conn, decryptEmail, pwdState);
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int changeUserState(String email, int state) {
		Connection conn = getConnection();
		uDao = new UserDao();
		int result = uDao.changeUserState(conn, email,state);
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateUserInfo(String email, String pwd, String phone, int pwdState) {
		Connection conn = getConnection();
		uDao = new UserDao();
		int result = uDao.updateUserInfo(conn, email, pwd, phone, pwdState);
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
