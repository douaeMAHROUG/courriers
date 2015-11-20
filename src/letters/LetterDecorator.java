package letters;

import letters.Letter;
/**
 * 
 *
 * A LetterDecorator can be used to add certain properties to a letter.
 */

public abstract class LetterDecorator extends Letter<Letter<?>> {

	public LetterDecorator(Letter<?> letter) {
		super(letter.getSender(), letter.getReceiver(), letter);
	}
}
