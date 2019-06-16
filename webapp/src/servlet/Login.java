package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ErrorBean;
import Bean.UserBean;
import Dao.ExDAO;
import tool.Page;

@WebServlet(urlPatterns= {"/servlet/login"})
public class Login extends HttpServlet{

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
		String loginid = request.getParameter("loginid");
		String password=request.getParameter("password");

		try {
			HttpSession session=request.getSession();
			ExDAO dao=new ExDAO();

			UserBean userBean=dao.searchUser(loginid,password);
			ErrorBean errorBean=new ErrorBean();
			if(loginid.length()==0 || password.length()==0) {
				errorBean.setErrorMns("パスワード又は、ログインidを入力してください。");
				request.setAttribute("error", errorBean);
				request.getRequestDispatcher("../jsp/login.jsp").
				forward(request, response);
			}


			if(userBean==null) {
				errorBean.setErrorMns("パスワード又は、ログインidを間違えています。");
				request.setAttribute("error", errorBean);
				request.getRequestDispatcher("../jsp/login.jsp").
				forward(request, response);
			}else {
				session.setAttribute("user", userBean);
				request.getRequestDispatcher("../jsp/index.jsp").
				forward(request, response);

			}
			Page.footer(out);
		}catch(Exception e) {
			e.getStackTrace();
		}

	}
}



