package com.laptrinhjava.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
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

@WebServlet("/api-web-favorite")
public class FavoriteAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FavoriteAPI() {
		super();
	}

	@Inject
	private IFavoriteService favoriteService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		favoriteService.delete(id);
		MessageUtil messageUtil = new MessageUtil();
		messageUtil.showMessage(request);
		response.sendRedirect(request.getContextPath() + "/user-product?toastTitle=title_success"
				+ "&toastColor=success&toastIcon=icon_success&toastMess=delete_success&toast=toast");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		long userId = Long.parseLong(request.getParameter("userid"));
		long newId = Long.parseLong(request.getParameter("newid"));
		String title = request.getParameter("title");
		String thumbnail = request.getParameter("thumbnail");
		String price = request.getParameter("price");
		FavoriteModel favoriteModel = new FavoriteModel();
		favoriteModel
				.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
		favoriteModel.setUser_id(userId);
		favoriteModel.setNew_id(newId);
		favoriteModel.setThumbnail(thumbnail);
		favoriteModel.setTitle(title);
		favoriteModel.setPrice(price);
		favoriteService.save(favoriteModel);
		response.sendRedirect(request.getContextPath() + "/trang-chu");

	}

}
