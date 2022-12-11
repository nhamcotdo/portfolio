package Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class CommonFunction {
	public static String getContentFormData(HttpServletRequest request, String name)
			throws IOException, ServletException {
		Part part = request.getPart(name);

		// read your StringBody type
		BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream()));
		String line = "";

		while ((line = reader.readLine()) != null) {
			return line;
		}
		return null;
	}
}
