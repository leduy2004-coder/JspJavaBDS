package com.laptrinhjava.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjava.model.HotNewModel;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.IHotNewService;
import com.laptrinhjava.utils.HttpUtil;
import com.laptrinhjava.utils.SessionUtil;

@WebServlet(urlPatterns = { "/api-admin-hotnew" })
public class HotNewAPI extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = -1607954927335565282L;
	@Inject
	private IHotNewService hotNewService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// tu json chuyen sang model.
		HotNewModel hotNewModel = HttpUtil.of(request.getReader()).toModel(HotNewModel.class);
		hotNewModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
		hotNewModel = hotNewService.save(hotNewModel);
		// chuyen tu string sang json
		mapper.writeValue(response.getOutputStream(), hotNewModel);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		HotNewModel updateNew = HttpUtil.of(request.getReader()).toModel(HotNewModel.class);
		updateNew.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
		updateNew = hotNewService.update(updateNew);
		mapper.writeValue(response.getOutputStream(), updateNew);

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		HotNewModel hotNewModel = HttpUtil.of(request.getReader()).toModel(HotNewModel.class);
		hotNewService.delete(hotNewModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}

}
