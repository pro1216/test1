package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Page;

@WebServlet(urlPatterns= {"/servlet/log-off"})
public class Logoff extends HttpServlet{

	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		this.doPost(request, response);
	}
	public void doPost(
			HttpServletRequest request,HttpServletResponse response
			)throws ServletException,IOException{
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		Page.header(out);

		try {
			HttpSession session=request.getSession();

			session.removeAttribute("user");

			request.getRequestDispatcher("../jsp/login.jsp")
			.forward(request, response);
			Page.footer(out);
		}catch(Exception e) {
			e.getStackTrace();
		}

	}
}



