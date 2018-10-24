package imcs.webapp;



import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class LoanProcess
 */
public class LoanProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoanProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorMessage= validateData(request);
		if(StringUtils.isNoneBlank(errorMessage)) {
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd=  request.getRequestDispatcher("/pages/request.jsp");
			rd.include(request, response);
			return;
		}
		Customer customer = prepareCustomer(request);
		
		//c. Call the respective business services to process business logic
		String loanResponse = loanRequest(customer);
		
//		d. Prepare / forword respones to response view pages.
		request.setAttribute("loanResponse", loanResponse);
		
		//e. forword the request to JSP
		RequestDispatcher rd = request.getRequestDispatcher("/pages/response.jsp");
		rd.forward(request, response);
		return;
	
	}
	private String loanRequest(Customer customer) {
		if (customer.getAmount()> 100000) {
			return "Approval";
		} else {
			return "Rejected";
		}
	}

	public Customer prepareCustomer(HttpServletRequest request) {
		String fname=request.getParameter("firstName");
		String lname=request.getParameter("lastName");
		String address=request.getParameter("address");
		String country=request.getParameter("country");
		String rent=request.getParameter("rent");
		Integer monthlyrent= Integer.parseInt(request.getParameter("monthlyRent"));
		return new Customer(fname,lname,address,country,rent,monthlyrent);
	
	}
	public String validateData(HttpServletRequest request) {
		String fname=request.getParameter("firstName");
		String lname=request.getParameter("lastName");
		String address=request.getParameter("address");
		String country=request.getParameter("country");
		String rent=request.getParameter("rent");
		String monthlyrent= request.getParameter("monthlyRent");
		if(StringUtils.isBlank(fname)) {
			return"enter fname";
		}
		if(StringUtils.isBlank(lname)) {
			return"enter lname";
		}
		if(StringUtils.isBlank(address)) {
			return"enter address";
		}
		if(StringUtils.isBlank(country)) {
			return"enter country";
		}
		if(StringUtils.isBlank(rent)) {
			return"enter rent";
		}
		if(StringUtils.isBlank(monthlyrent)) {
			return"enter mmonthlyrent";
		}
		return null;


	}

}
