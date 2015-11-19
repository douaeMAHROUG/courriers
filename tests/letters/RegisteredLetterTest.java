package letters;

import static org.junit.Assert.*;

import org.junit.Test;

import city.BankAccount;
import city.City;
import city.Inhabitant;
import content.TextContent;

public class RegisteredLetterTest extends LetterTest {

	@Test
	public void testPriceIsFifteenEurosHigher() {
		Inhabitant sender = new Inhabitant("Sender", new City("Lille"), new BankAccount(1000));
		Inhabitant receiver = new Inhabitant("Receiver", new City("Paris"), new BankAccount(1500));
		SimpleLetter simpleLetter = new SimpleLetter(sender, receiver, new TextContent("Bonjour"));
		assertEquals(1, simpleLetter.cost());
		RegistredLetter testedLetter = new RegistredLetter(simpleLetter);
		assertEquals(16, testedLetter.cost());
	}

	@Override
	public Letter<?> createLetter() {
		Inhabitant sender = new Inhabitant("Sender", new City("Lille"), new BankAccount(1000));
		Inhabitant receiver = new Inhabitant("Receiver", new City("Paris"), new BankAccount(1500));
		SimpleLetter simpleLetter = new SimpleLetter(sender, receiver, new TextContent("Bonjour"));
		return new RegistredLetter(simpleLetter);
	}

}
