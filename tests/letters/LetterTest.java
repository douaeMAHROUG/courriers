package letters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import city.BankAccount;
import city.City;
import city.Inhabitant;
import letters.Letter;

public abstract class LetterTest {
	
	protected City city = new City("Lille");
	protected Inhabitant sender = new Inhabitant("Sender", city, new BankAccount(1000));
	protected Inhabitant receiver = new Inhabitant("Receiver", city, new BankAccount(1500));
	
	public abstract Letter<?> createLetter();

	@Before
	public void testIsInstantiated() {
		Letter<?> testedLetter = createLetter();
		assertNotNull(testedLetter);
	}

	@Test
	public void testIsSent() {
		Letter<?> testedLetter = createLetter();
		city.sendLetter(testedLetter);
		assertTrue(!city.isEmpty());
	}
}
