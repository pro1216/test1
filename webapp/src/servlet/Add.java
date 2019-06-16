package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ErrorBean;
import Dao.CityDAO;
import tool.Page;

@WebServlet(urlPatterns= {"/servlet/add"})
public class Add extends HttpServlet{

	public void doGet(
			HttpServletRequest request,HttpServletResponse response
			)throws ServletException,IOException{
		request.setCharacterEncoding("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		Page.header(out);

		try {
			String city = request.getParameter("city");
			String cityName=request.getParameter("cityName");
			String strPopulation=request.getParameter("population");

			ErrorBean errorBean=new ErrorBean();

			if(city.length()==0 || cityName.length()==0 || strPopulation.length()==0) {
				errorBean.setErrorMns("入力していない部分があります");
				request.setAttribute("error", errorBean);
				request.getRequestDispatcher("../jsp/add.jsp").
				forward(request, response);
			}else if(ChecPopulation.checkMath(strPopulation)==false) {
				errorBean.setErrorMns("人口には数値を入力してください");
				request.setAttribute("error", errorBean);
				request.getRequestDispatcher("../jsp/add.jsp").
				forward(request, response);
			}

				int population=Integer.parseInt(strPopulation);
				CityDAO dao=new CityDAO();
				dao.insertCity(city, cityName, population);

				request.getRequestDispatcher("../jsp/index.jsp").
				forward(request, response);


				Page.footer(out);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.getStackTrace();
			}


	}
}






