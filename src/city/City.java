package city;
import java.util.ArrayList;
import java.util.List;
import letters.*;
/**
 * 
 * @author mahroug
 *
 *This class represents a city, each city has a name and contains a set of letters and a set of inhabitants
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
		while(!this.postBox.isEmpty()){
			this.postBox.get(0).getReceiver().receiveLetter((this.postBox.get(0)));
			this.postBox.remove(0);
		}	
	}
	
	public boolean isEmpty(){
		return this.postBox.isEmpty();
	}
	
	public List<Inhabitant> getInhabitants(){
		return inhabitants;
	}
	
	public void addInhabitant(Inhabitant i){
		this.inhabitants.add(i);
	}
	
	public String toString() {
		return this.name + " city";
	}
}
