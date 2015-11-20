package letters;
import city.Inhabitant;
import content.*;
/**
 * 
 *
 * This class is a Promissory Note, it contains an amount of money 
 * that's why it inherits from Letter<MoneyContent>
 * The cost of this letter is 1 + 1% of the amount
 * When the note is received, the sender credits the amount to the receiver's account.
 * Then, the receiver sends a ThanksLetter.
 */
public class PromissoryNote extends Letter<MoneyContent> {


	public PromissoryNote(Inhabitant sender, Inhabitant receiver,MoneyContent content) {
		super(sender, receiver, content);
	}

	/**
	 * It returns 1 + 1% of the amount
	 */
	@Override
	public int cost() {
		return ( 1 + ((Integer)this.content.getAmount())/100);
	}

	/**
	 * It debits the sender, credits the receiver and makes him send a ThanksLetter.
	 */
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
