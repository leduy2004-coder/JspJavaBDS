package com.laptrinhjava.controller.web.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.service.INewService;

@WebServlet(urlPatterns = { "/api-web-search" })
public class SearchAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	INewService newService;

	public SearchAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("search")) {
			String content = request.getParameter("name");
			content = content.trim();
			if (!content.equals("")) {
				List<NewModel> list = newService.findSearch(content);
				request.setAttribute("list", list);

			}
			RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
			rd.forward(request, response);

		}

	}
}
