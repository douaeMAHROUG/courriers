package letters;
import city.*;
import content.TextContent;
/**
 * 
 * @author mahroug
 *
 */
public class SimpleLetter extends Letter<TextContent> {

	public final int costOfSP = 1;

	public SimpleLetter(Inhabitant sender, Inhabitant receiver, TextContent content) {
		super(sender, receiver, content);
	}
	
	@Override
	public void action() {
	}

	@Override
	public int cost() {
		return this.costOfSP;
	}
	
	@Override
	public String description() {
		return "a simple letter whose content is " + this.content;
	}
}
