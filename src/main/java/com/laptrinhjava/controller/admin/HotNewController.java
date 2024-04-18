package com.laptrinhjava.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjava.constant.SystemConstant;
import com.laptrinhjava.model.HotNewModel;
import com.laptrinhjava.paging.PageRequest;
import com.laptrinhjava.paging.Pageble;
import com.laptrinhjava.service.ICategoryService;
import com.laptrinhjava.service.IHotNewService;
import com.laptrinhjava.sort.Sorter;
import com.laptrinhjava.utils.FormUtil;
import com.laptrinhjava.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-hot-new" })
public class HotNewController extends HttpServlet {

	private static final long serialVersionUID = -92748804710254529L;
	@Inject
	private IHotNewService hotNewService;
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HotNewModel model = FormUtil.toModel(HotNewModel.class, request);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(hotNewService.findAll(pageble));
			model.setTotalItem(hotNewService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/hotnew/list.jsp";

		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = hotNewService.findOne(model.getId());
			}
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/hotnew/edit.jsp";

		}
		MessageUtil messageUtil = new MessageUtil();
		messageUtil.showMessage(request);
		request.setAttribute(SystemConstant.HOTMODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
