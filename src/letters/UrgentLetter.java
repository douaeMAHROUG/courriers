package letters;
/**
* author hajar
*/
import entity.Inhabitant;

public class UrgentLetter extends Letter {
	
	public UrgentLetter(Inhabitant sender, Inhabitant receiver, Letter content) {
		super(sender, receiver, content);
		
	}

	@Override
	public String getContentDescription() {
		return null;
	}

	@Override
	public void action() {
		
	}
	
	@Override
	public String toString() {
		return "an urgent letter";
	}
}
