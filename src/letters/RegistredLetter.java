package letters;
/**
 * 
 * @author mahroug
 *
 */

public class RegistredLetter extends LetterDecorator{

	public RegistredLetter(Letter<?> letter) {
		super(letter.getSender(), letter.getReceiver(), letter.content);
		this.letter = letter;
	}

	@Override
	public int cost() {
		return this.letter.cost() + 15;
	}


	@Override
	public void action() {
	}

	@Override
	public String description() {
		return "a registered letter whose content is " + this.letter.toString();
	}

	
}
