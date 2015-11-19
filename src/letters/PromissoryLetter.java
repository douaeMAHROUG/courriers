package letters;

import city.Inhabitant;
import content.Content;

public class PromissoryLetter extends Letter<Content> {

	public PromissoryLetter(Inhabitant sender, Inhabitant receiver,
			Content content) {
		super(sender, receiver, content);
	
	}

	@Override
	public void action() {
		
		
	}

	@Override
	public int cost() {
		
		return 0;
	}

	@Override
	public String description() {
		
		return null;
	}

}
