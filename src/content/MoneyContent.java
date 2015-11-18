package content;

public class MoneyContent implements Content {
	
	private int amount;
	
	public MoneyContent(int amount) {
		this.amount = amount;
	}
	
	
	
	public String getContentDescription() {
		return "";
	}
	
	
	
	public int getAmount() {
		return this.amount;
	}

}
