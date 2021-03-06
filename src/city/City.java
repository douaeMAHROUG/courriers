package city;

import java.util.ArrayList;
import java.util.List;
import letters.*;

/**
 *
 * This class represents a city, each city has a name and contains a set of
 * letters and a set of inhabitants
 */
public class City {

	protected String name;
	protected List<Letter<?>> postBox;
	protected List<Inhabitant> inhabitants;

	public City(String name) {
		this.name = name;
		this.postBox = new ArrayList<Letter<?>>();
		this.inhabitants = new ArrayList<Inhabitant>();
	}

	/**
	 * This method debits the sender's BankAccount, then it adds the letter to
	 * the postbox and prints a message
	 * 
	 * @param letter
	 */
	public void sendLetter(Letter<?> letter) {
		letter.getSender().debit(letter.cost());
		this.postBox.add(letter);
		System.out.println("-> " + letter.getSender() + " mails " + letter.description() + " to " + letter.getReceiver()
				+ " for a cost of " + letter.cost() + " euros");
		System.out.println(" - " + letter.cost() + " are debited from " + letter.getSender() + " whose balance is now "
				+ letter.getSender().getBalance());
	}

	/**
	 * This method distributes every letter in the postbox until it's empty
	 */
	public void distributeLetters() {
		List<Letter<?>> lettersToBeSent = new ArrayList<>(postBox);
		postBox.clear();
		while (!lettersToBeSent.isEmpty()) {
			lettersToBeSent.get(0).getReceiver().receiveLetter(lettersToBeSent.get(0));
			lettersToBeSent.remove(0);
		}
	}

	public boolean isEmpty() {
		return this.postBox.isEmpty();
	}

	public List<Inhabitant> getInhabitants() {
		return inhabitants;
	}

	public int size() {
		return inhabitants.size();
	}

	public void addInhabitant(Inhabitant i) {
		this.inhabitants.add(i);
	}

	public String toString() {
		return this.name + " city";
	}
}
