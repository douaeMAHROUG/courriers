package letters;

/**
 * 
 *
 * This class represents the UrgentLetter, it is a concrete decorator.
 * Any letter can be changed as an UrgentLetter, the action doesn't change and the cost is doubled.
 */

public class UrgentLetter<T extends Letter<?>> extends LetterDecorator {
	
	public UrgentLetter(T letter) {
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
