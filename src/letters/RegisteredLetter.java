package letters;
import content.TextContent;
import letters.SimpleLetter;

/**
 * 
 * @author mahroug
 *
 * This class represents the RegisteredLetter is a concrete decorator
 */

public class RegisteredLetter extends LetterDecorator{

	public RegisteredLetter(Letter<?> letter) {
		super(letter.getSender(), letter.getReceiver(), letter.content);
		this.letter = letter;
	}

	@Override
	public int cost() {
		return this.letter.cost() + 15;
	}

	@Override
	public void action() {
		SimpleLetter simpleLetter = new SimpleLetter(sender, receiver,new TextContent("Aknowledgment of receipt"));
		this.getReceiver().getCity().sendLetter(simpleLetter);
	}

	@Override
	public String description() {
		return "a registered letter whose content is " + this.letter.toString();
	}
}
