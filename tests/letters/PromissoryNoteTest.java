package letters;

import static org.junit.Assert.*;

import org.junit.Test;
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

	@Test
	public void testMoneyIsDebitedAndCredited() {
		Letter<?> testedLetter = createLetter();
		testedLetter.action();
		assertEquals(990, sender.getBalance());
		// The receiver's balance should be 1509 since he sent a thanks letter
		// for 1€
		assertEquals(1509, receiver.getBalance());
	}

	@Override
	public Letter<?> createLetter() {
		return new PromissoryNote(sender, receiver, new MoneyContent(10));
	}

}
