package tamework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UserDao {

	private Connection conn;

	public UserDao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String strConn = "jdbc:mysql://localhost:3306/tamework"
		+ "?user=Mulder&password=TrustNo1"
		+ "&useUnicode=true&characterEncoding=ms932";
		conn = DriverManager.getConnection(strConn);
	}

	public void close() {
		try {
		conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
  //DBの起動・終了



	//ログイン：復号化が必要
	public boolean login(String strUser, String strPassword)
	throws Exception{

		boolean blResult=false;
		Statement stmt = null;
		ResultSet rs = null;
		UserDto dto = new UserDto();
		PasswordUtil pass = new PasswordUtil();

		try{
			stmt = conn.createStatement();
			String strSql = "select * from user_list "
											+ "where user_name = '"+strUser+"' "
											+ " limit 1";
			rs = stmt.executeQuery(strSql);
			rs.next();
			dto.setPassword(rs.getString("password"));
			String EncodedPass = dto.getPassword();
			String RealPass = pass.getAuthPassword(EncodedPass,strPassword);
			if(RealPass.equals(strPassword)){
				blResult = true;
			}
			return blResult;
		}finally{
			try { rs.close(); } catch (SQLException e){ e.printStackTrace(); }
			try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}

  //会員登録
  public int RegisterNewUser(String user_name, String password,boolean SameAccount)
	throws Exception {
    Statement stmt = null;
		int rs = 0;
		//バリデーション：ユーザー名は5文字以上、パスワードは8文字以上、名前の重複はない
		if(user_name.length() >=5 && password.length() >=8 && SameAccount == false){
				try{
		      stmt = conn.createStatement();
					//AESで暗号化
					PasswordUtil pass = new PasswordUtil();
					String Encodedpassword = pass.getSafetyPassword(password);
		      String strSql = "INSERT INTO user_list(user_name,password) "
		                      +" VALUES('"+user_name+"' , '"+Encodedpassword+"')";
		      rs = stmt.executeUpdate(strSql);
		    }finally{
		      try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		    }//try
		}else if(SameAccount == true){
			rs = -1;
		}//if
			return rs;
  }//public int

	//重複回避
  public boolean DepreCheck(String strUser)
	throws Exception{

    boolean SameName=false;
    Statement stmt = null;
    ResultSet rs = null;
    UserDto dto = new UserDto();

    try{
      stmt = conn.createStatement();
      String strSql = "select * from user_list "
                      + "where user_name = '"+strUser+"' ";
      rs = stmt.executeQuery(strSql);
			//もし結果が帰ってきてしまったら、同じユーザー名の人が存在するので、重複=trueを返す
      if(rs.next()){
					SameName= true;
  			}
      return SameName;
    }finally{
      try { rs.close(); } catch (SQLException e){ e.printStackTrace(); }
      try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
  }

}
