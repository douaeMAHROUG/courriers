package letters;
/**
 * 
 * @author mahroug
 *
 * This class represents the UrgentLetter, it is a concrete decorator.
 */

public class UrgentLetter extends LetterDecorator {
	
	public UrgentLetter(Letter<?> letter) {
		super(letter.getSender(), letter.getReceiver(), letter);
		this.letter = letter;
	}
	
	@Override
	public int cost() {
		return this.letter.cost() * 2;
	}
	@Override
	public void action() {
		this.letter.action();
	}

	@Override
	public String description() {
		return "an urgent letter whose content is a "+ this.letter.description();
	}
}
