package content;
/**
 * This class implementing content represents an amount of money. It can be used for promissory notes.
 */
public class MoneyContent implements Content {
	
	protected int amount;
	
	public MoneyContent(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}

	@Override
	public String description() {
		return "a money content ("+amount+")";
	}

}
