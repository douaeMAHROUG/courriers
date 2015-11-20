package content;
/**
 * This class implementing Content represents a simple text represented by a String.
 */
public class TextContent implements Content {
	
	protected String text;
	
	public TextContent(String description){
		this.text=description;
	}

	@Override
	public String description() {
		return "a text content ("+text+")";
	}

}
