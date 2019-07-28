package training.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import training.beans.OwesOwed;
import training.beans.Transaction;
import training.beans.User;
import training.dao.OwesOwedDAO;
import training.standards.IOwesOwedDAO;
import training.standards.ITransactionDAO;

@WebServlet("/AddTransaction")
public class AddTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); 
		User currentUser = (User (session.getAttribute("currentSessionUser"));
		String gName = session.getAttribute("currentGroup");
		int amount = request.getParameter("amount");
		ITransactionDAO transDAO = new TransactionDAO();
		transDAO.insertTransaction(new Transaction(5, amount, currentUser.getName(), gName));
		List<OwesOwed> groupMembers = new OwesOwedDAO().getOwesOwed(gName);
		int noOfMembers = groupMembers.size();
		BigDecimal split = amount/noOfMembers;
		for(OwesOwed temp : groupMembers) {
			if(temp.getUserName().equals(currentUser.getName())) {
				temp.setOwed(temp.getOwed() + amount - split);
			}
			else {
				temp.setOwes(temp.getOwes() + split);
			}
		}
	}
}
