package letters;
import city.Inhabitant;
import content.*;
/**
 * 
 * @author mahroug
 *
 * This class is a Promissory Note, it contains an amount of money 
 * that's why it inherits from Letter<MoneyContent>
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
		int amount = content.getAmount();
		ThanksLetter thanksLetter = new ThanksLetter(
				new SimpleLetter(receiver,sender,new TextContent("thanks for " + description()))
				);
		sender.debit(amount);
		receiver.credit(amount);
		receiver.getCity().sendLetter(thanksLetter);
	}	
	
	@Override
	public String description() {
		return "a promissory note letter whose content is " + content.description();
	}

}
