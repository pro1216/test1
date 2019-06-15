package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bean.CityBean;

public class CityDAO extends DAO{

	public void insertCity(String city,String cityName,int population) throws Exception{
		Connection con =getConnection();
		PreparedStatement st = con.prepareStatement(
				"insert into city(city,cityName,population) values(?,?,?)");
		st.setString(1, city);
		st.setString(2, cityName);
		st.setInt(3, population);

		st.executeUpdate();

		con.commit();

		st.close();
		con.close();
	}
	public void deleteCity(int city_id) throws Exception{
		Connection con =getConnection();
		PreparedStatement st = con.prepareStatement(
				"delete from city where city_id=?");

		st.setInt(1, city_id);

		st.executeUpdate();

		con.commit();
		st.close();
		con.close();
	}
	public List<CityBean> SearchCity(String keyword)throws Exception{
		List<CityBean> list=new ArrayList<CityBean>();
		Connection con =getConnection();
		PreparedStatement st=con.prepareStatement(
				"select * from city where city like ?");
		st.setString(1, "%"+keyword+"%");

		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			CityBean city =new CityBean();
			city.setCity(rs.getString("city"));
			city.setCity_id(rs.getInt("city_id"));
			city.setCityName(rs.getString("cityName"));
			city.setPopulation(rs.getInt("population"));
			list.add(city);
		}
		return list;
	}
}
