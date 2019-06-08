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
			list.add(c);

		}
		System.out.println(2);
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
}
