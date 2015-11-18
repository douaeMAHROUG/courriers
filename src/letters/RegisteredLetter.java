package letters;

import entity.Inhabitant;

public class RegisteredLetter extends Letter
{

	public RegisteredLetter(Inhabitant sender, Inhabitant receiver, Letter content) {
		super(sender, receiver, content);
	}


	public String getContentDescription() {
		return null;
	}

	@Override
	public void action() {
		
	}
	
	@Override
	public String toString() {
		return "a registered letter";
	}

}
