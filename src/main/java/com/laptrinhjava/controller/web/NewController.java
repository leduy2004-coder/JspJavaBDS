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
import com.laptrinhjava.model.HotNewModel;
import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.model.StatusModel;
import com.laptrinhjava.service.IFavoriteService;
import com.laptrinhjava.service.IHotNewService;
import com.laptrinhjava.service.INewService;
import com.laptrinhjava.service.IStatusService;

@WebServlet(urlPatterns = { "/user-new" })
public class NewController extends HttpServlet {

	private static final long serialVersionUID = 7253508122648689956L;

	@Inject
	private INewService newService;
	@Inject
	private IHotNewService hotNewService;
	@Inject
	private IFavoriteService favoriteService;
	@Inject
	private IStatusService statusService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<NewModel> list = newService.findAllItem();
		List<HotNewModel> listNew = hotNewService.findAllItem();
		List<StatusModel> status = statusService.findAll();
		List<FavoriteModel> favorite = favoriteService.findAllItem();
		List<NewModel> favoriteNone = favoriteService.findAllNone();
		request.setAttribute("favoriteNone", favoriteNone);
		request.setAttribute("favorite", favorite);
		request.setAttribute("listNew", listNew);
		request.setAttribute("list", list);
		request.setAttribute("status", status);

		for (int i = 0; i < listNew.size(); i++) {
			request.setAttribute("topNew", listNew.get(listNew.size() - 1));
			continue;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
