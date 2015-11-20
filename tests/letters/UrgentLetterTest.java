package letters;

import static org.junit.Assert.*;

import org.junit.Test;

import content.TextContent;

public class UrgentLetterTest extends LetterTest {

	@Test
	public void testCostIsTwiceAsHigh() {
		Letter<?> testedLetter = createLetter();
		assertEquals(((Letter<?>)testedLetter.content).cost()*2, testedLetter.cost());
	}

	@Override
	public Letter<?> createLetter() {
		SimpleLetter simpleLetter = new SimpleLetter(sender, receiver, new TextContent("Bonjour"));
		return new UrgentLetter<SimpleLetter>(simpleLetter);
	}
}
