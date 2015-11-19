package city;
/**
 * 
 * @author mahroug
 * 
 *This class represents the bank account of an inhabitant and the possible transactions on the account
 */
public class BankAccount {

	protected int total;

	public BankAccount(int total) {
		this.total = total;
	}

	public void credit(int amount) throws IllegalArgumentException {
		if(amount < 0)
			throw new IllegalArgumentException("amount must be >= 0");
		this.total += amount;
	}

	public void debit(int amount) {
		if(amount < 0)
			throw new IllegalArgumentException("amount must be >= 0");
		this.total -= amount;
	}
	
	public int getTotal() {
		return total;
	}
	
	public String toString() {
		return this.total + " euros";
	}
}
