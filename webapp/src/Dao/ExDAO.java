package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bean.CityBean;
import Bean.UserBean;

public class ExDAO extends DAO{

	public List<CityBean> search() throws Exception{
		List<CityBean> list=new ArrayList<CityBean>();
		Connection con =getConnection();
		PreparedStatement st=con.prepareStatement(
				"select * from city");

		ResultSet rs=st.executeQuery();

		while(rs.next()) {
			CityBean c=new CityBean();
			c.setCity_id(rs.getInt("city_id"));
			c.setCity(rs.getString("city"));
			c.setCityName(rs.getString("cityName"));
			c.setPopulation(rs.getInt("population"));
			list.add(c);

		}
		st.close();
		con.close();
		return list;

	}

	public UserBean searchUser(String loginid,String password) throws Exception{

		Connection con =getConnection();
		PreparedStatement st=con.prepareStatement(
				"select * from user where loginid=? and password=?");
		st.setString(1, loginid);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		UserBean bean=null;
		while(rs.next()) {
			bean=new UserBean();
			bean.setUserLastName(rs.getString("userLastName"));
			bean.setUserFirstName(rs.getString("userfirstName"));
			bean.setUserid(rs.getInt("userid"));
			bean.setLoginid(rs.getString("loginid"));
			bean.setPassword(rs.getString("password"));
			bean.setAddress(rs.getString("address"));
		}
		st.close();
		con.close();
		return bean;

	}
	public int insertUser(String userLastName,String userFirstName,
			String loginid, String password,String address) throws Exception {
		Connection con =getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into user(userLastName,userFirstName,loginid,password,address)" +
				"values(?,?,?,?,?)");

		st.setString(1, userLastName);
		st.setString(2, userFirstName);
		st.setString(3, loginid);
		st.setString(4, password);
		st.setString(5, address);

		UserBean bean=new UserBean();
		bean.setUserLastName(userLastName);
		bean.setUserFirstName(userFirstName);
		bean.setLoginid(loginid);
		bean.setPassword(password);
		bean.setAddress(address);

		int line=st.executeUpdate();
		if(line != 1) {
			con.rollback();

		}else {
			con.commit();

		}
		st.close();
		con.close();

		return line;
	}

	public  int updateUser(String password1,String password2,String loginid) throws Exception {
		Connection con=getConnection();

		PreparedStatement st = con.prepareStatement(
				"update user set password = ? where loginid=?");

		st.setString(1, password1);
		st.setString(2, loginid);

		int line =st.executeUpdate();

		con.commit();

		st.close();
		con.close();
		return line;
	}
}
