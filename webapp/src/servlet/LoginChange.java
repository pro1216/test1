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

@WebServlet(urlPatterns= {"/servlet/login-change"})
public class LoginChange extends HttpServlet{

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
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		System.out.println(1);
		try {
			HttpSession session=request.getSession();
			ErrorBean error = new ErrorBean();
			if(password1.length()==0 || password2.length()==0) {
				error.setErrorMns("パスワードを入力してください");
				request.setAttribute("error", error);
				request.getRequestDispatcher("../jsp/login-change.jsp")
				.forward(request, response);

			}

			if(password1.equals(password2)) {
				ExDAO dao=new ExDAO();
				UserBean user=(UserBean) session.getAttribute("user");
				System.out.println(user.getLoginid());
				dao.updateUser(password1, password2,user.getLoginid());
				request.getRequestDispatcher("../jsp/index.jsp")
				.forward(request, response);
			}else {

				error.setErrorMns("パスワードが正しくありません");
				request.setAttribute("error", error);
				request.getRequestDispatcher("../jsp/login-change.jsp")
				.forward(request, response);
			}

			Page.footer(out);
		}catch(Exception e) {
			e.getStackTrace();
		}

	}
}



