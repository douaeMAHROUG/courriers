package letters;

import static org.junit.Assert.*;

import org.junit.Test;

import city.BankAccount;
import city.City;
import city.Inhabitant;
import content.TextContent;

public class UrgentLetterTest extends LetterTest {

	@Test
	public void testCostIsTwiceAsHigh() {
		Inhabitant sender = new Inhabitant("Sender", new City("Lille"), new BankAccount(1000));
		Inhabitant receiver = new Inhabitant("Receiver", new City("Paris"), new BankAccount(1500));
		SimpleLetter simpleLetter = new SimpleLetter(sender, receiver, new TextContent("Bonjour"));
		assertEquals(1, simpleLetter.cost());
		UrgentLetter testedLetter = new UrgentLetter(simpleLetter);
		assertEquals(2, testedLetter.cost());
	}

	@Override
	public Letter<?> createLetter() {
		Inhabitant sender = new Inhabitant("Sender", new City("Lille"), new BankAccount(1000));
		Inhabitant receiver = new Inhabitant("Receiver", new City("Paris"), new BankAccount(1500));
		SimpleLetter simpleLetter = new SimpleLetter(sender, receiver, new TextContent("Bonjour"));
		return new UrgentLetter(simpleLetter);
	}

}
