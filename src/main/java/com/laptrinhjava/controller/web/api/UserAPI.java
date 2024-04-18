package com.laptrinhjava.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.IUserService;
import com.laptrinhjava.utils.Email;
import com.laptrinhjava.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-user" })
public class UserAPI extends HttpServlet {

	@Inject
	private IUserService userService;

	private static final long serialVersionUID = 5675865316838864718L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// tu json chuyen sang model.
		UserModel userModel = HttpUtil.of(request.getReader()).toModel(UserModel.class);
		userModel = userService.save(userModel);
		if (userModel != null) {
			userService.updateAuthen(userModel);
			try {
				Email.sendEmail(userModel.getEmail(), "Xác thực tài khoản tại BDS LD",
						"<p>BDS LD xin chào bạn <strong>" + userModel.getFullName() + "</strong>,</p>\r\n"
								+ "<p>Vui lòng xác thực tài khoản của bạn bằng cách nhập mã <strong>"
								+ userModel.getAuthentication() + "</strong></p>\r\n" + "<p>Trân trọng cảm ơn.</p>");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

		// chuyen tu string sang json
		mapper.writeValue(response.getOutputStream(), userModel);
	}
}