package letters;

import static org.junit.Assert.*;

import org.junit.Test;
import content.TextContent;
import letters.Letter;
import letters.SimpleLetter;

public class SimpleLetterTest extends LetterTest {

	@Test
	public void testCostEqualsOne() {
		Letter<?> testedLetter = createLetter();
		assertEquals(1, testedLetter.cost());
	}
	
	@Test
	public void testContentIsTextContent() {
		Letter<?> testedLetter = createLetter();
		assertTrue(testedLetter.getContent() instanceof TextContent);
	}

	@Override
	public Letter<?> createLetter() {
		return new SimpleLetter(sender, receiver, new TextContent("Bonjour"));
	}

}
