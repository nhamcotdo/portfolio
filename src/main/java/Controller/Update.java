package Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.bean.Information;
import model.bean.Skill;
import model.bean.User;
import model.bo.UserBo;
import model.dao.InformationDao;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		try {
			User user = (new UserBo()).getUserById(userId);
			request.setAttribute("user", user);
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/update.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		User user = new User();
		user.setUserName((String) session.getAttribute("userName"));

		Information information = new Information();
		information.setTitle(request.getParameter("title"));
		information.setName(request.getParameter("name"));
		information.setBio(request.getParameter("bio"));
		information.setBirthday(Date.valueOf(request.getParameter("birthday")));
		information.setWebsite(request.getParameter("website"));
		information.setDegree(request.getParameter("degree"));
		information.setFreelance(request.getParameter("freelance"));
		information.setEmail(request.getParameter("email"));
		information.setPhone(request.getParameter("phone"));
		information.setAddress(request.getParameter("address"));
		information.setDescription(request.getParameter("description"));
		information.setFacebook(request.getParameter("facebook"));
		information.setInstagram(request.getParameter("instagram"));
		information.setSkype(request.getParameter("skype"));
		information.setInstagram(request.getParameter("instagram"));


		ObjectMapper objectMapper = new ObjectMapper();
		String s = request.getParameter("skills");
		List<Skill> skills = Arrays.asList(objectMapper.readValue(s, Skill[].class));
		
		information.setSkills(skills);
		InformationDao informationDao = new InformationDao();
		try {
			informationDao.Update(userId, information);
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}

}
