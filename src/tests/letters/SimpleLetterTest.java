package tests.letters;

import static org.junit.Assert.*;

import org.junit.Test;

import city.BankAccount;
import city.City;
import city.Inhabitant;
import content.Text;
import letters.Letter;
import letters.SimpleLetter;

public class SimpleLetterTest extends LetterTest {

	@Test
	public void testCostEqualsOne() {
		Letter<?> testedLetter = createLetter();
		assertEquals(1, testedLetter.cost());
	}

	@Override
	public Letter<?> createLetter() {
		Inhabitant sender = new Inhabitant("Sender", new City("Lille"), new BankAccount(1000));
		Inhabitant receiver = new Inhabitant("Receiver", new City("Paris"), new BankAccount(1500));
		return new SimpleLetter(sender, receiver, new Text("Bonjour"));
	}

}
