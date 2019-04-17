package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entites.Author;
import entites.Book;
import entites.BookPK;
import entites.Loan;
import entites.LoanPK;
import entites.User;
import facade.FacadeLocal;

@WebServlet("/books")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			request.setAttribute("listBooks", facade.getAllBooks());
			request.setAttribute("listLoans", facade.getAllLoans());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			if (action.equalsIgnoreCase("add")) {
				request.getRequestDispatcher("add.jsp").forward(request, response);
			} else if (action.equalsIgnoreCase("add2")) {
				request.getRequestDispatcher("add2.jsp").forward(request, response);
			} else if (action.equalsIgnoreCase("login")) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else if (action.equalsIgnoreCase("delete")) {
				try {
					BookPK id = new BookPK();
					id.setIsbn(request.getParameter("isbn"));
					id.setCopyNbr(Integer.parseInt(request.getParameter("copyNbr")));
					facade.removeBook(id);
					response.sendRedirect("books");
				} catch (Exception e) {
					request.setAttribute("error", e.getMessage());
				}
			} else if (action.equalsIgnoreCase("returnBook")) {
				try {
					LoanPK id = new LoanPK();
					id.setBookISBN(request.getParameter("bookISBN"));
					id.setBookCopy(Integer.parseInt(request.getParameter("bookCopy")));
					id.setUserID(request.getParameter("userID"));
					facade.removeLoan(id);
					response.sendRedirect("books");
				} catch (Exception e) {
					request.setAttribute("error", e.getMessage());
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("add")) {
			try {
				Book book = new Book();
				BookPK id = new BookPK();
				id.setIsbn(request.getParameter("isbn"));
				id.setCopyNbr(Integer.parseInt(request.getParameter("copyNbr")));
				book.setTitle(request.getParameter("title"));
				book.setId(id);
				Author a = new Author();
				a.setAuthorID(Integer.parseInt(request.getParameter("authorID")));
				book.setAuthor(a);
				facade.create(book);
				response.sendRedirect("books");
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("add.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("add2")) {
			try {
				Loan loan = new Loan();
				LoanPK id = new LoanPK();
				String isbn = request.getParameter("bookISBN");
				int bookCopy = Integer.parseInt(request.getParameter("bookCopy"));
				BookPK bookID = new BookPK();
				bookID.setIsbn(isbn);
				bookID.setCopyNbr(bookCopy);

				Book book = new Book();
				book.setId(bookID);
				facade.getBookById(bookID);

				id.setBookISBN(request.getParameter("bookISBN"));
				id.setBookCopy(Integer.parseInt(request.getParameter("bookCopy")));
				id.setUserID(request.getParameter("userID"));
				loan.setLoanDate(Date.valueOf(request.getParameter("loanDate")));
				loan.setExpiryDate(Date.valueOf(request.getParameter("expiryDate")));
				loan.setId(id);
				if (bookID != null) {

					facade.create(loan);
				}
				response.sendRedirect("books");
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("add2.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("add3")) {
			try {
				Loan loan = new Loan();
				LoanPK id = new LoanPK();
				id.setBookISBN(request.getParameter("bookISBN"));
				id.setBookCopy(Integer.parseInt(request.getParameter("bookCopy")));
				id.setUserID(request.getParameter("userID"));
				loan.setId(id);
				facade.create(loan);
				response.sendRedirect("books");
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("add2.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("login")) {
			try {
				String userID = request.getParameter("userID");
				String userPassword = request.getParameter("userPassword");

				User user = facade.getUserById(userID);
				if (user != null && user.getUserPassword().equals(userPassword)) {
					response.sendRedirect("books");
				} else {
					// något error msg kanske
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}
