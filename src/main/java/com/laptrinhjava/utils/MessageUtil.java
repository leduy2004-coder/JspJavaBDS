package com.laptrinhjava.utils;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	public void showMessage(HttpServletRequest request) {
		if (request.getParameter("toastMess") != null) {
			String toastColor = request.getParameter("toastColor");
			String toastIcon = request.getParameter("toastIcon");
			String toastTitle = request.getParameter("toastTitle");
			String toastMess = request.getParameter("toastMess");
			String toast = request.getParameter("toast");

			if (toastColor != null && toastIcon != null && toastTitle != null && toastMess != null && toast != null) {
				request.setAttribute("toastColor", toastColor);
				request.setAttribute("toastIcon", resourceBundle.getString(toastIcon));
				request.setAttribute("toastTitle", resourceBundle.getString(toastTitle));
				request.setAttribute("toastMess", resourceBundle.getString(toastMess));
				request.setAttribute("toast", resourceBundle.getString(toast));
			}
		}
	}
}
