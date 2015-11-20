package letters;
/**
 * 
 * @author mahroug
 *
 */

public class UrgentLetter extends LetterDecorator {
	
	public UrgentLetter(Letter<?> letter) {
		super(letter);
	}
	
	@Override
	public int cost() {
		return content.cost() * 2;
	}
	@Override
	public void action() {
		content.action();
	}

	@Override
	public String description() {
		return "an urgent letter whose content is "+ content.description();
	}
}
