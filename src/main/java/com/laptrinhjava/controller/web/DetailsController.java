package com.laptrinhjava.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.INewService;
import com.laptrinhjava.utils.MessageUtil;
import com.laptrinhjava.utils.SessionUtil;

@WebServlet("/user-detail")
public class DetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Inject
	private INewService newService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		if (model != null) {
			long newId = Long.parseLong(request.getParameter("id"));
			NewModel newModel = newService.findOne(newId);
			request.setAttribute("user", model);
			request.setAttribute("list", newModel);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/details.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&toastTitle=title_error"
					+ "&toastColor=danger&toastIcon=icon_error&toastMess=not_login&toast=toast");
		}
		MessageUtil messageUtil = new MessageUtil();
		messageUtil.showMessage(request);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
