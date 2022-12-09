package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.UserBo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if(userName == null || password == null)
		{
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		try {
			UserBo userBo = new UserBo();
			String userId = userBo.Login(userName, password);
			if (userId != null) {
				String role = userBo.role(userId);
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("userName",userName);
				session.setAttribute("role", role);
				
				response.sendRedirect(request.getContextPath() + "/Index");
			} else {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}

}
