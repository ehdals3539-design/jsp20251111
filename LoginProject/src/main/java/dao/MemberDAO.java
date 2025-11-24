package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MemberDAO {
	
	/**
	 * MemberDAO = DB 연결하고 회원정보 insert/select/update 하는 클래스
	 */
	
	//싱글톤 패턴(프로그램 전체에서 객체 1개만 사용)
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private MemberDAO() {}
	
	//DB 연결 메서도 (초보는 이거 그냥 외우면 됨)
	private Connection getConnection() throws Exception {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String pass = "1234";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		return DriverManager.getConnection(url, user, pass);
				
		
	}
	
	//아이디 중복 체크 메서드
	public int confirmID(String userid) {
		int resilt = -1;
		String sql = "SELECT userid FROM member WHERE userid=?";
		
				
	}
	
	

}
