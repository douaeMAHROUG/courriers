package content;
/**
 * 
 * @author mahroug
 *
 */
public class TextContent implements Content {
	
	protected String description;
	
	public TextContent(){
		this("bla bla");
	}
	
	public TextContent(String description){
		this.description=description;
	}

	@Override
	public String description() {
		return "text content ("+this.description+")";
	}

}
