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

import com.laptrinhjava.model.CommentModel;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.ICommentService;
import com.laptrinhjava.utils.SessionUtil;

@WebServlet(urlPatterns = { "/api-web-comment" })
public class CommentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ICommentService commentService;

	public CommentAPI() {
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
		if (action.equals("comment")) {
			String content = request.getParameter("content");
			long newId = Long.parseLong(request.getParameter("newId"));
			long userId = Long.parseLong(request.getParameter("userId"));
			if (!content.equals("")) {
				CommentModel comment = new CommentModel();
				comment.setCreatedBy(
						((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
				comment.setContent(content);
				comment.setNew_id(newId);
				comment.setUser_id(userId);
				long id = commentService.save(comment);
			}
			UserModel userModel = new UserModel();
			userModel.setThumbnail(
					((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getThumbnail());
			userModel.setFullName(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getFullName());
			List<CommentModel> list = commentService.findAllNewId(newId);
			request.setAttribute("model", userModel);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/comment.jsp");
			rd.forward(request, response);
		}

	}
}
