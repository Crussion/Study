package board.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownAction implements Action{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filename = request.getParameter("downfile");
		String realPath = request.getServletContext().getRealPath("/boardUpload");
		
		File file = new File(realPath, filename);
		
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] b = new byte[(int)file.length()];
		bis.read(b, 0, b.length);
		bis.close();
		fis.close();
		
		response.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode(filename, "utf-8"));
		response.setHeader("Content-Length", String.valueOf(file.length()));
		
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		bos.write(b);
		bos.close();
		
		return null;
	}
}
