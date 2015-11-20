package letters;

import content.TextContent;
import letters.SimpleLetter;

/**
 * 
 *
 * This class represents the RegisteredLetter is a concrete decorator A
 * RegisteredLetter costs the decorated letter's cost plus 15 euros When it's
 * received, the receiver sends an acknoledgement of receipt to the sender.
 */
public class RegisteredLetter<T extends Letter<?>> extends LetterDecorator {

	public RegisteredLetter(Letter<?> letter) {
		super(letter);
	}

	@Override
	public int cost() {
		return content.cost() + 15;
	}

	@Override
	public void action() {
		AcknowledgementOfReceipt acknowledgement = new AcknowledgementOfReceipt(
				new SimpleLetter(receiver, sender, new TextContent("acknowledgement of receipt for " + description())));
		getReceiver().getCity().sendLetter(acknowledgement);
	}

	@Override
	public String description() {
		return "a registered letter whose content is " + content.description();
	}
}
