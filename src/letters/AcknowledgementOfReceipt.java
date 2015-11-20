package letters;

public class AcknowledgementOfReceipt extends LetterDecorator {

	public AcknowledgementOfReceipt(SimpleLetter letter) {
		super(letter);
	}

	@Override
	public void action() {
		content.action();
	}

	@Override
	public int cost() {
		return content.cost();
	}

	@Override
	public String description() {
		return "an acknowledgement of receipt which is " + content.description();
	}

}
