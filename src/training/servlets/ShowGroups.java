package training.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowGroups")
public class ShowGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<OwesOwed> owesOwed = new OwesOwedDAO().getOwesOwed(request.getParameter(gName));
		List<Transaction> trans = new TransactionDAO().getAllTransactions(gName);
		String path = "WEB-INF/Views/showgroup.jsp";
//		request.setAttribute("Trans", trans);
//		request.setAttribute("OO", owesOwed);
		request.getRequestDispatcher(path).forward(request, response);
	}
}
