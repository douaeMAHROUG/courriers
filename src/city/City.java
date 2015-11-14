package city;
import java.util.ArrayList;
import java.util.List;
import letters.*;
/**
 * 
 * @author mahroug
 *
 */
public class City {

	protected String name;
	protected List<Letter<?>> postBox;
	protected List<Inhabitant> inhabitants;

	public City(String name) {
		this.name = name;
		this.postBox = new ArrayList<Letter<?>>();
		this.inhabitants=new ArrayList<Inhabitant>();
	}

	public void sendLetter(Letter<?> letter) {
		letter.getSender().debit(letter.cost());
		this.postBox.add(letter);
	}

	public void distributeLetters() {
		// à revoir: faut peut etre ajouter cette liste : distibutorTmp 
		//List<Letter<?>> distributorTmp = new ArrayList<Letter<?>>();
		while(!this.postBox.isEmpty()){
			this.postBox.get(0).getReceiver().receiveLetter((this.postBox.get(0)));
			this.postBox.remove(0);
		}	
	}
	
	public boolean isEmpty(){
		return this.postBox.isEmpty();
	}
	
	public String toString() {
		return this.name + " city";
	}
}
