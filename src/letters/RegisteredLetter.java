package letters;

import content.Content;
import city.Inhabitant;

public class RegisteredLetter extends Letter
{

	public RegisteredLetter(Inhabitant sender, Inhabitant receiver,
			Content content) {
		super(sender, receiver, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return null;
	}


}
