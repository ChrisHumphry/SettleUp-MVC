
package training.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import training.beans.User;
import training.dao.UserDAO;
import training.standards.IUserDAO;

@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		User user = new User(userName,password);
		IUserDAO userDAO = new UserDAO();
		User dbUser = userDAO.getUser(userName);
		System.out.println(dbUser);
		if(dbUser!=null) {
			
			if(dbUser.getPassword().equals(password)) {
				HttpSession session = request.getSession(true); 
				session.setAttribute("currentSessionUser",user); 
				response.sendRedirect("entergroup.jsp");
			}else {System.out.println("Failed wrong password "+password);
				response.setContentType("text/html");
				request.getRequestDispatcher("Failure").include(request, response);
				request.getRequestDispatcher("/Login.html").include(request, response);
			}
		}else {
			userDAO.insertUser(user);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	

}