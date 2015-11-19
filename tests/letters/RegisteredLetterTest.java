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
		RegisteredLetter testedLetter = new RegisteredLetter(simpleLetter);
		assertEquals(16, testedLetter.cost());
	}
	
	@Test
	public void receiverSendsAcknowledgment() {
		Inhabitant sender = new Inhabitant("Sender", new City("Lille"), new BankAccount(1000));
		InhabitantNbLetterSent receiver = new InhabitantNbLetterSent("Receiver", new City("Paris"), new BankAccount(1500));
		
		assertEquals(0, receiver.numberOfLetterSent);
		
		SimpleLetter simpleLetter = new SimpleLetter(sender, receiver, new TextContent("Bonjour"));
		RegisteredLetterNbLetterSent registeredLetter = new RegisteredLetterNbLetterSent(simpleLetter);
		registeredLetter.action();
		
		assertEquals(1, receiver.numberOfLetterSent);
	}

	@Override
	public Letter<?> createLetter() {
		Inhabitant sender = new Inhabitant("Sender", new City("Lille"), new BankAccount(1000));
		Inhabitant receiver = new Inhabitant("Receiver", new City("Paris"), new BankAccount(1500));
		SimpleLetter simpleLetter = new SimpleLetter(sender, receiver, new TextContent("Bonjour"));
		return new RegisteredLetter(simpleLetter);
	}

}

class InhabitantNbLetterSent extends Inhabitant {
	
	protected int numberOfLetterSent = 0;

	public InhabitantNbLetterSent(String name, City city, BankAccount bankAccount) {
		super(name, city, bankAccount);
	}
}

class RegisteredLetterNbLetterSent extends RegisteredLetter {

	public RegisteredLetterNbLetterSent(Letter<?> letter) {
		super(letter);
	}
	
	@Override
	public void action() {
		super.action();
		((InhabitantNbLetterSent) receiver).numberOfLetterSent++;
	}
}

