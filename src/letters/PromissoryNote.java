package letters;
import city.Inhabitant;
import content.*;
/**
 * 
 * @author mahroug
 *
 */
public class PromissoryNote extends Letter<MoneyContent> {


	public PromissoryNote(Inhabitant sender, Inhabitant receiver,MoneyContent content) {
		super(sender, receiver, content);
	}

	@Override
	public int cost() {
		return ( 1 + ((Integer)this.content.getAmount())/100);
	}

	@Override
	public void action() {
		int amount = ((Integer)this.content.getAmount());
		SimpleLetter thanksLetter = new SimpleLetter(this.receiver,this.sender,new TextContent("Thank you for money)"));
		this.sender.debit(amount);
		this.receiver.credit(amount);
		this.receiver.getCity().sendLetter(thanksLetter);
	}	
	
	@Override
	public String description() {
		return "an promissory letter whose content is a money content";
	}

}
