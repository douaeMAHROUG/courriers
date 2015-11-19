package letters;

import static org.junit.Assert.*;

import org.junit.Test;

import letters.Letter;

public abstract class LetterTest {
	
	abstract public Letter<?> createLetter();

	@Test
	public void testIsInstantiated() {
		Letter<?> testedLetter = createLetter();
		assertNotNull(testedLetter);
	}

}
