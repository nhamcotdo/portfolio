package Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Information;
import model.bean.Skill;
import model.bean.User;
import model.bo.UserBo;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/register.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

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

		UserBo userBo = new UserBo();
		try {
			String userId = userBo.Register(user, information, skills);
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("userName", user.getUserName());
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}
}
