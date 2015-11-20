package letters;

/**
 * This is sent whenever a promissory note was received.
 */
public class ThanksLetter extends LetterDecorator {

	public ThanksLetter(SimpleLetter letter) {
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
		return "a thanks letter which is " + content.description();
	}

}
