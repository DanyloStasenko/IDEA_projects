package jsp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FileLoadServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1149549377293310756L;

	
	public FileLoadServlet() {
		
	}

	
	@SuppressWarnings("deprecation")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// download file with data:
		File file = new File("D://user.txt");
		String fileName =  file.getName();
		
		try(PrintWriter out = response.getWriter();
			 InputStream inputStream = new FileInputStream(file);
			 BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			 DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);) {
			
			response.setContentType("application/force-download");
			response.setContentLength((int)file.length());
			
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Content-Disposition","attachment; filename=\"" + fileName);

			while(dataInputStream.available() > 0){
			    out.print(dataInputStream.readLine());
			    out.print("\n");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* 
		// FIXME: downloaded file is empty - BUG
		File file = new File("D://user.txt");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=user.txt");
		*/
		
	}
}
