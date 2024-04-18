package com.laptrinhjava.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.model.FavoriteModel;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.IFavoriteService;
import com.laptrinhjava.utils.MessageUtil;
import com.laptrinhjava.utils.SessionUtil;

@WebServlet("/user-product")
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private IFavoriteService favoriteService;

	public ProductsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		if (model != null) {
			List<FavoriteModel> favoriteModels = favoriteService.findAllByUserId(model.getId());
			request.setAttribute("listFa", favoriteModels);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/products.jsp");
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

		doGet(request, response);
	}

}
