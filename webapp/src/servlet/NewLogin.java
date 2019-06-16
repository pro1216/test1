package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ErrorBean;
import Dao.ExDAO;
import tool.Page;

@WebServlet(urlPatterns= {"/servlet/new-login"})
public class NewLogin extends HttpServlet{
	public void doPost(
			HttpServletRequest request,HttpServletResponse response
			)throws ServletException,IOException{
		request.setCharacterEncoding("text/html; charset=UTF-8");


		PrintWriter out = response.getWriter();

		Page.header(out);

		try {
			String userLastName = request.getParameter("userLastName");
			String userFirstName = request.getParameter("userFirstName");
			String address = request.getParameter("address");
			String loginid = request.getParameter("loginid");
			String password=request.getParameter("password");

			if(userFirstName.length()==0 || userLastName.length()==0 ||
					address.length()==0 || loginid.length()==0 || password.length()==0) {
				ErrorBean bean=new ErrorBean();
				bean.setErrorMns("抜けている部分があります");
				request.setAttribute("error", bean);
				request.getRequestDispatcher("../jsp/new-login.jsp").
				forward(request, response);
			}

			ExDAO dao=new ExDAO();
			int line=dao.insertUser(userLastName,userFirstName,loginid,password,address);
			request.getRequestDispatcher("../jsp/login.jsp").
			forward(request, response);

			Page.footer(out);
		}catch(Exception e) {
			e.getStackTrace();
		}

	}
}

