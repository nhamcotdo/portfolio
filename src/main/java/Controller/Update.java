package Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import Common.CommonFunction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10, // 10 MB
maxRequestSize = 1024 * 1024 * 100 // 100 MB
)

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

		
		String pathToFolder = "Portfolio\\src\\main\\webapp\\assets\\upload\\avatar";
		String uploadPath = request.getServletContext().getRealPath("");// for eclipse use this code
		String uploadPathRelative = uploadPath.split(".metadata")[0] + pathToFolder;
		File dir = new File(uploadPathRelative);
		if (!dir.exists()) {
			dir.mkdirs();
		}

				
		Part avatarPart = request.getPart("avatar");
		String fileName = user.getUserName() + "." + avatarPart.getContentType().split("/")[1];
		InputStream is = avatarPart.getInputStream();
		Files.copy(is, Paths.get(uploadPathRelative + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
		Information information = new Information();
		information.setTitle(CommonFunction.getContentFormData(request, "title"));
		information.setName(CommonFunction.getContentFormData(request, "name"));
		information.setBio(CommonFunction.getContentFormData(request, "bio"));
		information.setBirthday(Date.valueOf(CommonFunction.getContentFormData(request, "birthday")));
		information.setWebsite(CommonFunction.getContentFormData(request, "website"));
		information.setDegree(CommonFunction.getContentFormData(request, "degree"));
		information.setFreelance(CommonFunction.getContentFormData(request, "freelance"));
		information.setEmail(CommonFunction.getContentFormData(request, "email"));
		information.setPhone(CommonFunction.getContentFormData(request, "phone"));
		information.setAddress(CommonFunction.getContentFormData(request, "address"));
		information.setDescription(CommonFunction.getContentFormData(request, "description"));
		information.setFacebook(CommonFunction.getContentFormData(request, "facebook"));
		information.setInstagram(CommonFunction.getContentFormData(request, "instagram"));
		information.setSkype(CommonFunction.getContentFormData(request, "skype"));
		information.setInstagram(CommonFunction.getContentFormData(request, "instagram"));
		information.setAvatarUrl("assets\\upload\\avatar\\" + fileName);


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
