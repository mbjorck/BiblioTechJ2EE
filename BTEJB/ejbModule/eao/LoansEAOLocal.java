package eao;

import java.util.List;

import javax.ejb.Local;

import entites.Loan;
import entites.LoanPK;


@Local
public interface LoansEAOLocal {
	public Loan create(Loan loans);

	public Loan update(Loan loans);

	public void removeLoan(LoanPK id);

	public Loan getLoanById(LoanPK id);

	public List<Loan> getAllLoans();

}
