package city;
import letters.*;

/**
 *
 * This class represents an inhabitant.
 * An inhabitant possesses a bank account and he belongs to a city.
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

	/**
	 * This method prints a message and triggers the letter's action method
	 * @param letter
	 */
	public void receiveLetter(Letter<?> letter) {
		System.out.println("<- " + this + " receives " + letter.description() + " from " + letter.getSender());
		letter.action();
	}

	public void credit(int amount) {
		this.bankAccount.credit(amount);
	}

	public void debit(int amount) {
		this.bankAccount.debit(amount);
	}
	
	public int getBalance() {
		return bankAccount.total;
	}

	public String toString() {
		return name;
	}
	
	public City getCity() {
		return city;
	}
}
