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
import Dao.ExDAO;
import tool.Page;

@WebServlet(urlPatterns= {"/servlet/reference"})
public class Reference extends HttpServlet{

	public void doGet(
		HttpServletRequest request,HttpServletResponse response
		)throws ServletException,IOException{
		request.setCharacterEncoding("text/html; charset=UTF-8");


		PrintWriter out = response.getWriter();

		Page.header(out);

		try {
			HttpSession session=request.getSession();
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
