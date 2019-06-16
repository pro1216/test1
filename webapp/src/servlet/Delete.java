package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.CityBean;
import Bean.ErrorBean;
import Dao.CityDAO;
import Dao.ExDAO;
import tool.Page;

@WebServlet(urlPatterns= {"/servlet/delete"})
public class Delete extends HttpServlet{

	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		this.doPost(request, response);
	}

	public void doPost(
		HttpServletRequest request,HttpServletResponse response
		)throws ServletException,IOException{
		request.setCharacterEncoding("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		Page.header(out);

		try {
			HttpSession session=request.getSession();
			String[] city_ids=request.getParameterValues("city_id");
			if(city_ids==null) {
				ErrorBean error = new ErrorBean();
				error.setErrorMns("一つ以上チェックをつけて下さい");
				request.setAttribute("error", error);
				request.getRequestDispatcher("../jsp/reference.jsp").
				forward(request, response);
			}
			CityDAO city=new CityDAO();
			for(int i=0; i<city_ids.length; i++) {
				int city_id=Integer.parseInt(city_ids[i]);
				city.deleteCity(city_id);
			}
			ExDAO dao=new ExDAO();
			List<CityBean> list=dao.search();
			session.setAttribute("list", list);
			request.getRequestDispatcher("../jsp/reference.jsp").
				forward(request, response);

		}catch(Exception e) {
			e.getStackTrace();
		}
		Page.footer(out);

	}
}
