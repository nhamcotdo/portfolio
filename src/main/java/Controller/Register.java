package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Information;
import model.bean.Skill;
import model.bean.User;

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
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.SetUserName(request.getParameter("username"));
		user.SetPassword(request.getParameter("password"));

		Information information = new Information();
		information.SetTitle(request.getParameter("title"));
		information.SetBio(request.getParameter("bio"));
		try {
			information.SetBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		information.SetWebsite(request.getParameter("website"));
		information.SetDegree(request.getParameter("degree"));
		information.SetFreelance(request.getParameter("freelance"));
		information.SetEmail(request.getParameter("email"));
		information.SetPhone(request.getParameter("phone"));
		information.SetAddress(request.getParameter("address"));
		information.SetDescription(request.getParameter("description"));

		ObjectMapper objectMapper = new ObjectMapper();
		String s = request.getParameter("skills");
		List<Skill> skills = Arrays.asList(objectMapper.readValue(s, Skill[].class));
	}
}
