package ricoweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class RicoWebDao {

	private Connection conn;

	public RicoWebDao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String strConn = "jdbc:mysql://localhost:3306/ricoweb"
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
	public RicoWebDto getRicoData() throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = conn.createStatement();
			String strSql = "select company_name,accessinf from company_list order by id DESC limit 1";
			rs = stmt.executeQuery(strSql);
			rs.next();
			RicoWebDto dto = new RicoWebDto();
			dto.setCompany_name(rs.getString("company_name"));
			dto.setAccessinf(rs.getString("accessinf"));
			return dto;
		}finally {
			try { rs.close(); } catch (SQLException e){ e.printStackTrace(); }
			try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}

	/* テスト */
	public List<RicoWebDto> getRicoDataList(String keyword,String datatype) throws SQLException {
    Statement stmt = null;
    ResultSet rs = null;
    List<RicoWebDto> dtosL = new ArrayList<RicoWebDto>();
    try{
      stmt = conn.createStatement();
      String strSql = "select * from company_list "
                      + "where "+datatype+" like "
											+"'%"+keyword+"%'";
      rs = stmt.executeQuery(strSql);
      while(rs.next()){
        RicoWebDto dto = new RicoWebDto();
   			dto.setId(rs.getInt("id"));
        dto.setCompany_name(rs.getString("company_name"));
        dto.setAddress(rs.getString("address"));
        dto.setStation(rs.getString("station"));
        dto.setMainlink(rs.getString("mainlink"));
        dto.setSublink(rs.getString("sublink"));
        dto.setAccessinf(rs.getString("accessinf"));
        dto.setMessage(rs.getString("message"));
        dtosL.add(dto);
      }
      return dtosL;
    }finally {
      try { rs.close(); } catch (SQLException e){ e.printStackTrace(); }
      try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
  }

	public RicoWebDto getRicoDataById(int id) throws SQLException {
    Statement stmt = null;
    ResultSet rs = null;
    RicoWebDto byid =null;
    try{
      stmt = conn.createStatement();

      String strSql = "select * from company_list "
                      + "where id ="+ id;

      rs = stmt.executeQuery(strSql);
      if(rs.next()){
        byid = new RicoWebDto();
        byid.setId(rs.getInt("id"));
        byid.setCompany_name(rs.getString("company_name"));
        byid.setAddress(rs.getString("address"));
        byid.setStation(rs.getString("station"));
        byid.setMainlink(rs.getString("mainlink"));
        byid.setSublink(rs.getString("sublink"));
        byid.setAccessinf(rs.getString("accessinf"));
        byid.setMessage(rs.getString("message"));
      }
      return byid;
    }finally {
      try { rs.close(); } catch (SQLException e){ e.printStackTrace(); }
      try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
    }

  }


}
