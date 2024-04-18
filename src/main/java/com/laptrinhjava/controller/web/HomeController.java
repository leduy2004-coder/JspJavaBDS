package com.laptrinhjava.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.ICategoryService;
import com.laptrinhjava.service.IUserService;
import com.laptrinhjava.utils.FormUtil;
import com.laptrinhjava.utils.MessageUtil;
import com.laptrinhjava.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/dang-ki", "/thoat" })
public class HomeController extends HttpServlet {
	@Inject
	private IUserService userService;
	@Inject
	private ICategoryService categoryService;

	private static final long serialVersionUID = 7253508122648689956L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			MessageUtil messageUtil = new MessageUtil();
			messageUtil.showMessage(request);
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("register")) {
			MessageUtil messageUtil = new MessageUtil();
			messageUtil.showMessage(request);
			RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
			if (request.getParameter("authen") != null) {
				request.setAttribute("authen", "authen");
				request.setAttribute("authenid", request.getParameter("id"));
			}

			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		} else if (action != null && action.equals("authen")) {
			String authen = request.getParameter("authentication");
			String email = request.getParameter("id");
			authen.trim();
			UserModel user = userService.findEmail(email);
			if (user.getAuthentication().equals(authen)) {
				user.setStatusAuthen(1);
				userService.updateAuthen(user);
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&toastTitle=title_success"
						+ "&toastColor=success&toastIcon=icon_success&toastMess=register_success&toast=toast");
			} else {
				response.sendRedirect(request.getContextPath() + "/dang-ki?action=register&toastTitle=title_error"
						+ "&toastColor=danger&toastIcon=icon_error&toastMess=mess&toast=toast");
			}
		} else {
			request.setAttribute("categories", categoryService.findAll());
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			if (action != null && action.equals("login")) {
				UserModel model = FormUtil.toModel(UserModel.class, request);
				model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1, 1);
				if (model != null) {
					SessionUtil.getInstance().putValue(request, "USERMODEL", model);
					if (model.getRole().getCode().equals("ADMIN")) {
						response.sendRedirect(request.getContextPath() + "/admin-home");
					} else if (model.getRole().getCode().equals("USER")) {
						response.sendRedirect(request.getContextPath() + "/trang-chu");
					} else if (model.getRole().getCode().equals("CREATOR")) {
						response.sendRedirect(request.getContextPath() + "/trang-chu");
					}

				} else {
					response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&toastTitle=title_error"
							+ "&toastColor=danger&toastIcon=icon_error&toastMess=mess&toast=toast");
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
}
