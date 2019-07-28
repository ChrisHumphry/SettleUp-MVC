package training.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import training.beans.OwesOwed;
import training.beans.Transaction;
import training.dao.OwesOwedDAO;
import training.dao.TransactionDAO;

@WebServlet("/ShowGroups")
public class ShowGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("currentGroup", request.getParameter("gName");
		List<OwesOwed> owesOwed = new OwesOwedDAO().getOwesOwed(request.getParameter("gName"));
		List<Transaction> trans = new TransactionDAO().getTransactionsByGroup("gName");
		String path = "WEB-INF/view/showgroup.jsp";
		request.setAttribute("Trans", trans);
		request.setAttribute("OO", owesOwed);
		request.getRequestDispatcher(path).include(request, response);
	}
}
