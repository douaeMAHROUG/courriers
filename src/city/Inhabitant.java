package city;
import letters.*;
/**
 * 
 * @author mahroug
 *
 */
public class Inhabitant {

	protected String name;
	protected City city;
	protected BankAccount bankAccount;
	
	public Inhabitant(String name,City city, BankAccount bankAccount) {
		this.name = name;
		this.city = city;
		this.bankAccount = bankAccount;
	}
	// a revoir
	public void receiveLetter(Letter<?> letter) {
		letter.action();
	}

	public void credit(int amount) {
		this.bankAccount.credit(amount);
	}

	public void debit(int amount) {
		this.bankAccount.debit(amount);
	}

	public String toString() {
		return "Inhabitant: "+this.name;
	}

}
