package member.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.action.Action;


/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Object> map = new HashMap<String, Object>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	String realFolder = config.getServletContext().getRealPath("/property");
		String realPath = realFolder + "/command.properties";
		
		Properties properties = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(realPath);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Iterator<?> iterator = properties.keySet().iterator();
		
		while(iterator.hasNext()) {
			String command = iterator.next().toString();
			String className = properties.getProperty(command);
			
			try {
				Class<?> commandClass = Class.forName(className);
				Object instance = commandClass.newInstance();
				
				map.put(command, instance);
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = null;
		
		if(request.getParameter("req") == null) {
			String command = request.getRequestURI();
			String contextPath = request.getContextPath();
			int contextPathLength = request.getContextPath().length();
			
			if(command.indexOf(contextPath) == 0) {
				command = command.substring(contextPathLength);
			}
			System.out.println("command = " + command);
			action = (Action)map.get(command);
		}else {
			String req = "/" + request.getParameter("req") + ".do";
			System.out.println("req = " + req);
			action = (Action)map.get(req);
		}
		
		String view = null;
		try {
			view = action.process(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(view);
		if(view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

}
