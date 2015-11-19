package letters;
import content.Content;
import city.Inhabitant;
import letters.Letter;
/**
 * 
 * @author mahroug
 *
 */

public abstract class LetterDecorator extends Letter<Content> {

	protected Letter<?> letter;
	
	public LetterDecorator(Inhabitant sender, Inhabitant receiver,Content content) {
		super(sender, receiver, content);
	}
}
