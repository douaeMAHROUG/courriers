package letters;

import content.Content;
import entity.Inhabitant;

public class PromissoryLetter extends Letter {

	public PromissoryLetter(Inhabitant sender, Inhabitant receiver, Content content) 
	{
		super(sender, receiver, content);
	}

	/**
	 * @see Content#getDescription()
	 */
	public String getContentDescription() {
		return null;
	}

	@Override
	public String toString() {
		return "a promissory letter";
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}
}
