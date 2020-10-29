package tamework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class TameWebDao {

	private Connection conn;

	public TameWebDao() throws ClassNotFoundException, SQLException {
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

	/* テスト */
	public TameWebDto getTameData() throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = conn.createStatement();
			String strSql = "select work_name,message from work_list order by id DESC limit 1";
			rs = stmt.executeQuery(strSql);
			rs.next();
			TameWebDto dto = new TameWebDto();
			dto.setWork_name(rs.getString("work_name"));
			dto.setMessage(rs.getString("message"));
			return dto;
		}finally {
			try { rs.close(); } catch (SQLException e){ e.printStackTrace(); }
			try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}

	/* テスト */
	public List<TameWebDto> getTameDataList(String keyword,String datatype) throws SQLException {
    Statement stmt = null;
    ResultSet rs = null;
    List<TameWebDto> dtosL = new ArrayList<TameWebDto>();
    try{
      stmt = conn.createStatement();
      String strSql = "select * from work_list "
                      + "where "+datatype+" like "
											+"'%"+keyword+"%'";
      rs = stmt.executeQuery(strSql);
      while(rs.next()){
        TameWebDto dto = new TameWebDto();
   			dto.setId(rs.getInt("id"));
        dto.setWork_name(rs.getString("work_name"));
        dto.setAddress(rs.getString("address"));
        dto.setStation(rs.getString("station"));
        dto.setMainlink(rs.getString("mainlink"));
        dto.setSublink(rs.getString("sublink"));
        dto.setMessage(rs.getString("message"));
        dtosL.add(dto);
      }
      return dtosL;
    }finally {
      try { rs.close(); } catch (SQLException e){ e.printStackTrace(); }
      try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
  }

	public TameWebDto getTameDataById(int id) throws SQLException {
    Statement stmt = null;
    ResultSet rs = null;
    TameWebDto byid =null;
    try{
      stmt = conn.createStatement();

      String strSql = "select * from work_list "
                      + "where id ="+ id;

      rs = stmt.executeQuery(strSql);
      if(rs.next()){
        byid = new TameWebDto();
        byid.setId(rs.getInt("id"));
        byid.setWork_name(rs.getString("work_name"));
        byid.setAddress(rs.getString("address"));
        byid.setStation(rs.getString("station"));
        byid.setMainlink(rs.getString("mainlink"));
        byid.setSublink(rs.getString("sublink"));
        byid.setMessage(rs.getString("message"));
      }
      return byid;
    }finally {
      try { rs.close(); } catch (SQLException e){ e.printStackTrace(); }
      try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
    }

  }


}
