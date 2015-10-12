package util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import util.DB;
public class user {
	private int id;

	private String username;

	private String password;

	private String phone;

	/*private String addr;

	private Date rdate;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/*public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}*/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public static boolean check(String phone, String password)
	 throws Exception {
     user u = null;
     Connection conn = DB.getConn();
     String sql = "select * from user where phone = '" + phone + "'";
     Statement stmt = DB.getStatement(conn);
     ResultSet rs = DB.getResultSet(stmt, sql);
    try {
	if(!rs.next()) {
		throw new Exception("用户不存在" + phone);
	  } else {
		if(!password.equals(rs.getString("password"))) {
			throw new Exception("密码不正确");
		}
		//将用户信息保存在javaBean容器中
		u = new user();
		u.setId(rs.getInt("id"));
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setPhone(rs.getString("phone"));
		/*u.setAddr(rs.getString("addr"));
		u.setRdate(rs.getTimestamp("rdate"));*/
	    
	 }
	
    } catch (SQLException e) {
	  e.printStackTrace();
    } finally {
	  //关闭数据库连接
      DB.close(rs);
	  DB.close(stmt);
	  DB.close(conn);
     }
    return true;
    }
	public static void sentdata(String username, String password, String phone) throws SQLException
	{
	     Connection conn = DB.getConn();
	     String sql = "insert into user (username,password,phone) values('"+username+"','"+password+"','"+phone+"')";
	     System.out.println(sql);
	     Statement stmt1 = DB.getStatement(conn);
	     stmt1.executeUpdate(sql);
	     
	}
	
}
