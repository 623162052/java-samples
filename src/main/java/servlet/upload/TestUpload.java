package servlet.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * 测试上传附件
 * 
 * @author Matthew
 */
public class TestUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestUpload() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uploadFile(request, response);
	}

	/**
	 * 上传文件
	 */
	private void uploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");

		// 在isMultipartContent方法中同时检测了是否是post提交 ,如果不是post提交则返回false
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// DiskFileItemFactory:Apache文件上传组件的核心类
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 设置最大内存占用
			// factory.setSizeThreshold(1024000);
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置单个文件最大值
			// upload.setFileSizeMax(102400000);
			// 设置所有上传文件总和最大值
			// upload.setSizeMax(204800000);
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					
					// 文件保存到服务器
					BufferedInputStream in = new BufferedInputStream(item.getInputStream());
					
					String fileName = fixFileName(item.getName());
					// String fileName = fixFileName(item.getFieldName());
					
					String filePath = this.getServletContext().getRealPath("/jsp/upload/file/") + "\\" + fileName;
					
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
					Streams.copy(in, out, true);
					in.close();
					out.flush();
					out.close();
				}
				
				PrintWriter out = response.getWriter();
				out.print("12121212");
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * 文件名替换
	 */
	private static String fixFileName(String pFileName) {
		int aLastPos = pFileName.lastIndexOf('\\');
		int tmpLastPos = pFileName.lastIndexOf('/');
		if (tmpLastPos > aLastPos)
			aLastPos = tmpLastPos;
		if (aLastPos >= 0)
			pFileName = pFileName.substring(aLastPos + 1, pFileName.length());
		return pFileName;
	}
}

/**
 * 页面form中必须添加的enctype="multipart/form-data" type="file"的input必须有name属性，否则取不到值
 * Apache上传组件的核心类：ServletFileUpload、FileItem、FileUploadException
 * 上传乱码：设置 request.setCharacterEncoding("UTF-8");
 */

