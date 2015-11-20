package letters;
import content.TextContent;
import letters.SimpleLetter;

public class RegisteredLetter extends LetterDecorator{

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
				new SimpleLetter(receiver, sender, new TextContent("acknowledgement of receipt for " + description()))
				);
		getReceiver().getCity().sendLetter(acknowledgement);
	}

	@Override
	public String description() {
		return "a registered letter whose content is " + content.description();
	}
}
