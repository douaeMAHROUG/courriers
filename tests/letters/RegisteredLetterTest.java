package letters;

import static org.junit.Assert.*;

import org.junit.Test;

import city.BankAccount;
import city.City;
import city.Inhabitant;
import content.TextContent;

public class RegisteredLetterTest extends LetterTest {
	
	Inhabitant receiver = new InhabitantNbLetterSent("Receiver", new City("Paris"), new BankAccount(1500));

	@Test
	public void testPriceIsFifteenEurosHigher() {
		Letter<?> testedLetter = createLetter();
		assertEquals(((Letter<?>)testedLetter.content).cost()+15, testedLetter.cost());
	}
	
	@Test
	public void receiverSendsAcknowledgment() {
		assertEquals(0, ((InhabitantNbLetterSent)receiver).numberOfLetterSent);
		createLetter().action();	
		assertEquals(1, ((InhabitantNbLetterSent)receiver).numberOfLetterSent);
	}

	@Override
	public Letter<?> createLetter() {
		SimpleLetter simpleLetter = new SimpleLetter(sender, receiver, new TextContent("Bonjour"));
		return new RegisteredLetterNbLetterSent(simpleLetter);
	}

}

class InhabitantNbLetterSent extends Inhabitant {
	
	protected int numberOfLetterSent = 0;

	public InhabitantNbLetterSent(String name, City city, BankAccount bankAccount) {
		super(name, city, bankAccount);
	}
}

class RegisteredLetterNbLetterSent extends RegisteredLetter<Letter<?>> {

	public RegisteredLetterNbLetterSent(Letter<?> letter) {
		super(letter);
	}
	
	@Override
	public void action() {
		super.action();
		((InhabitantNbLetterSent) receiver).numberOfLetterSent++;
	}
}

