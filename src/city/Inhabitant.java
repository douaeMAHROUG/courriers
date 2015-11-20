package city;
import letters.*;

public class Inhabitant {

	protected String name;
	protected City city;
	protected BankAccount bankAccount;
	
	public Inhabitant(String name,City city, BankAccount bankAccount) {
		this.name = name;
		this.city = city;
		this.bankAccount = bankAccount;
	}

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
