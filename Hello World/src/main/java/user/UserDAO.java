package user; //data base와 연동되는, 기록 및 가져오는 역할을 수행함.

/*
 * 회원가입 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DatabaseUtil;

public class UserDAO {
	
	public int join(String userID, String userPassword) {
		String SQL = "INSERT INTO USER VALUES (?, ?)"; //?는 실제 사용자 입력 id, password 들어간다.
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL); //?에 실제 data 넣어줄 수 있게 해주는 기능
			pstmt.setString(1, userID); //유저 id, ps 넣어줌
			pstmt.setString(2, userPassword);
			return pstmt.executeUpdate();//inset 구문에서 실행되서 나오는 결과를 반환해줌(insert된 갯수)
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
