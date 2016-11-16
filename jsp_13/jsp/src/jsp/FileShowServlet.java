package jsp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileShowServlet extends HttpServlet{

	private static final long serialVersionUID = -1149549377293310756L;
	
	public FileShowServlet() {
		
	}
	
	
	// show file:
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File file = new File("D://user.txt");
		
		try(FileInputStream fileInputStream  = new FileInputStream(file);
			ServletOutputStream servletOutputStream = response.getOutputStream();) {
			
			byte [] out = new byte [1024];
			
			while(fileInputStream.read(out, 0, 1024) != -1){
				
				servletOutputStream.write(out, 0, 1024);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
