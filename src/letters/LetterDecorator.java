package letters;

import letters.Letter;
/**
 * 
 * @author mahroug
 *
 * This class represents the LetterDecorator
 */

public abstract class LetterDecorator extends Letter<Letter<?>> {

	public LetterDecorator(Letter<?> letter) {
		super(letter.getSender(), letter.getReceiver(), letter);
	}
}
