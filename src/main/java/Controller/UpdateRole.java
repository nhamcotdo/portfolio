package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Role;
import model.bo.RoleBo;
import model.bo.UserBo;

/**
 * Servlet implementation class UpdateRole
 */
@WebServlet("/UpdateRole")
public class UpdateRole extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateRole() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("id");

		if (userId == null) {
			throw new ServletException("Id isn't exist!");
		}

		RoleBo roleBo = new RoleBo();
		UserBo userBo = new UserBo();

		try {
			List<Role> roles = roleBo.getList();
			Role userRole = userBo.role(userId);
			String userName = userBo.getName(userId);

			request.setAttribute("roles", roles);
			request.setAttribute("userRole", userRole);
			request.setAttribute("userName", userName);
			request.setAttribute("_userId", userId);

			RequestDispatcher rd = request.getRequestDispatcher("/edit-role-modal.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("id");
		String userRoleId = request.getParameter("role");
		UserBo userBo = new UserBo();
		try {
			userBo.updateRole(userId, userRoleId);
			response.sendRedirect(request.getContextPath() + "/Users");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
