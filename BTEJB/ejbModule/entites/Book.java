package entites;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Books database table.
 * 
 */
@Entity
@Table(name = "Books")
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BookPK id;

	@Column(name = "Title")
	private String title;

	// bi-directional many-to-one association to Author
	@ManyToOne
	@JoinColumn(name = "AuthorID")
	private Author author;

	// bi-directional one-to-one association to Loan
//	@OneToOne

/*	@JoinColumns({

			@JoinColumn(name = "CopyNbr", referencedColumnName = "BookCopy"),
			@JoinColumn(name = "ISBN", referencedColumnName = "BookISBN") })
*/
	//private Loan loan;

	public Book() {
	}

	public BookPK getId() {
		return this.id;
	}

	public void setId(BookPK id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

/*	public Loan getLoan() {
		return this.loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
*/
}