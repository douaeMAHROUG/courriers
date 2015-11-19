package city;

import static org.junit.Assert.*;

import org.junit.Test;

import city.BankAccount;

public class BankAccountTest {

	@Test
	public void testIsInstantiated() {
		BankAccount testedBankAccount = new BankAccount(0);
		assertNotNull(testedBankAccount);
		assertEquals(0, testedBankAccount.getTotal());
	}

	@Test
	public void testCredit() {
		BankAccount testedBankAccount = new BankAccount(0);
		testedBankAccount.credit(10);
		assertEquals(10, testedBankAccount.getTotal());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreditException() {
		BankAccount testedBankAccount = new BankAccount(0);
		testedBankAccount.credit(-10);
	}
	
	@Test
	public void testDebit() {
		BankAccount testedBankAccount = new BankAccount(10);
		testedBankAccount.debit(10);
		assertEquals(0, testedBankAccount.getTotal());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDebitException() {
		BankAccount testedBankAccount = new BankAccount(10);
		testedBankAccount.debit(-10);
	}
}
