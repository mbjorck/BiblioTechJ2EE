package entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the Loans database table.
 * 
 */
@Entity
@Table(name = "Loans")
@NamedQuery(name = "Loan.findAll", query = "SELECT l FROM Loan l")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LoanPK id;

	@Column(name = "ExpiryDate")
	private Date expiryDate;

	@Column(name = "LoanDate")
	private Date loanDate;

	// bi-directional one-to-one association to Book
	//@OneToOne //(mappedBy = "loan")
	//private Book book;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "UserID", insertable = false, updatable = false)
	private User user;

	public Loan() {
	}

	public LoanPK getId() {
		return this.id;
	}

	public void setId(LoanPK id) {
		this.id = id;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getLoanDate() {
		return this.loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

/*	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
*/
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}