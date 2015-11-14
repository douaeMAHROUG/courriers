package content;
/**
 * 
 * @author mahroug
 *
 */
public class Text implements Content {
	
	protected String description;
	
	public Text(){
		this("bla bla");
	}
	
	public Text(String description){
		this.description=description;
	}

	@Override
	public String description() {
		return "text content ("+this.description+")";
	}

}
