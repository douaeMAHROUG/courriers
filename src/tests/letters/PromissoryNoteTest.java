package tests.letters;

import static org.junit.Assert.*;

import org.junit.Test;

import city.BankAccount;
import city.City;
import city.Inhabitant;
import content.MoneyContent;
import letters.Letter;
import letters.PromissoryNote;

public class PromissoryNoteTest extends LetterTest {

	@Test
	public void testCostIsGreaterThanOne() {
		Letter<?> testedLetter = createLetter();
		assertTrue(testedLetter.cost() >= 1);
	}
	
	@Test
	public void testContentIsMoneyContent() {
		Letter<?> testedLetter = createLetter();
		assertTrue(testedLetter.getContent() instanceof MoneyContent);
	}

	@Override
	public Letter<?> createLetter() {
		Inhabitant sender = new Inhabitant("Sender", new City("Lille"), new BankAccount(1000));
		Inhabitant receiver = new Inhabitant("Receiver", new City("Paris"), new BankAccount(1500));
		return new PromissoryNote(sender, receiver, new MoneyContent(10));
	}

}
