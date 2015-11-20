package city;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import content.TextContent;
import letters.SimpleLetter;

public class CityTest {
	
	protected City city;
	
	@Before
	public void createCity() {
		city = new City("Lille");
	}

	@Test
	public void testAddInhabitant() {
		Inhabitant inhabitant = new Inhabitant("Inhabitant", city, new BankAccount(1000));
		
		assertEquals(0, city.size());
		city.addInhabitant(inhabitant);
		assertEquals(1, city.size());
		assertTrue(city.getInhabitants().contains(inhabitant));
	}
	
	@Test
	public void testDistributeLetters() {
		Inhabitant sender = new Inhabitant("Inhabitant1", city, new BankAccount(1000));
		Inhabitant receiver = new Inhabitant("Inhabitant", city, new BankAccount(1000));
		SimpleLetter letter = new SimpleLetter(sender, receiver, new TextContent("Bonjour"));
		city.sendLetter(letter);
		
		assertFalse(city.isEmpty());
		city.distributeLetters();
		assertTrue(city.isEmpty());
	}
}
