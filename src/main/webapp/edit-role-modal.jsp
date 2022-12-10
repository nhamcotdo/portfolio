<%@page import="model.bean.Role"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.String"%>
<%@ page import="java.util.List"%>
<%
String userName = (String) request.getAttribute("userName");
String _userId = (String) request.getAttribute("_userId");
Role userRole = (Role) request.getAttribute("userRole");
List<Role> roles = (List<Role>) request.getAttribute("roles");
%>
<form class="login100-form validate-form" action="UpdateRole?id=<%=_userId%>" method="post">
	<div class="container-login100" style="min-height: 50vh;">
		<div class="wrap-login100">
			<span class="login100-form-title p-b-34 p-t-27"> Update Role
				for <%=userName%></span>

			<div class="wrap-input100 validate-input">
				<select class="input100" name="role">
					<%
					for (Role role : roles) {
						if (userRole != null && userRole.getId().equals(role.getId())) {
							out.print("<option style=\"color:black\" value=\"" + role.getId() + "\" >" + role.getName() + "</option>");
						} else {
							out.print("<option style=\"color:black\" value=\"" + role.getId() + "\">" + role.getName() + "</option>");
						}
					}
					%>

				</select>
			</div>

		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-secondary"
				data-bs-dismiss="modal">Close</button>
			<button type="submit" class="btn btn-primary">Save</button>
		</div>
	</div>
</form>