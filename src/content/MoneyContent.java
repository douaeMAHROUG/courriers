package content;
/**
 * 
 * @author hajar + mahroug
 *
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
		return "  "+amount;
	}

}
