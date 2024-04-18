package com.laptrinhjava.controller.admin.api;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.laptrinhjava.model.HotNewModel;
import com.laptrinhjava.model.NewModel;
import com.laptrinhjava.service.IHotNewService;
import com.laptrinhjava.service.INewService;

@WebServlet(urlPatterns = { "/api-file-new" })
public class FileAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private INewService newService;
	@Inject
	private IHotNewService hotNewService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String folder = getServletContext().getRealPath("img");
			int maxFileSize = 5000 * 1024;
			int maxMemSize = 5000 * 1024;
			long id = 0L;
			String fileName = null;
			String hotnew = null;
			String contentType = request.getContentType();
			if (contentType.indexOf(contentType) >= 0) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// Quy định dung lượng tối đa cho file
				factory.setSizeThreshold(maxMemSize);
				// Tạo file
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(maxFileSize);

				List<FileItem> files = upload.parseRequest(request);

				for (FileItem fileItem : files) {
					if (!fileItem.isFormField()) {
						fileName = System.currentTimeMillis() + fileItem.getName();
						System.out.println(fileName);
						String path = folder + "\\" + fileName;
						System.out.println(path);
						File file = new File(path);
						fileItem.write(file);
					} else {
						if (fileItem.getFieldName().equals("id")) {
							id = Long.parseLong(fileItem.getString());
						}
						if (fileItem.getFieldName().equals("hotnew")) {
							hotnew = fileItem.getString();
						}
					}

				}
				if (hotnew != null) {
					HotNewModel hotNewModel = hotNewService.findOneImg(id);
					hotNewService.delete(id);
					hotNewModel.setThumbnail(fileName);
					id = hotNewService.saveImg(hotNewModel);
				} else {
					NewModel newModel = newService.findOneImg(id);
					newService.delete(id);
					newModel.setThumbnail(fileName);
					id = newService.saveImg(newModel);
				}

			}
			response.sendRedirect(request.getContextPath() + "/admin-home");
		} catch (Exception e) {
		}
	}

}
