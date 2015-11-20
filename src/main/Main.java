package main;

import java.util.Random;

import city.*;
import content.MoneyContent;
import content.TextContent;
import letters.Letter;
import letters.PromissoryNote;
import letters.RegisteredLetter;
import letters.SimpleLetter;
import letters.UrgentLetter;

/**
 * This main class simulates how a city works. It first creates a city, then 100
 * inhabitants are created and added to it. Every day, during k days (randomly
 * picked between 1 and 7), a random number of inhabitants (from 1 to 7 again)
 * send a letter (of a random type) to a random inhabitant. Eventually, this
 * simulation can last for more than k days as these letters can trigger replies
 * which are distributed the next day.
 */
public class Main {

	private static Random r = new Random();
	private static City city;

	public static void main(String[] args) {
		city = new City("Lille");
		System.out.println("Creating Lille city");

		for (int i = 0; i < 100; i++) {
			Inhabitant inhabitant = new Inhabitant("inhabitant-" + i, city, new BankAccount(5000));
			city.addInhabitant(inhabitant);
		}
		System.out.println("Creating 100 inhabitants");

		int days = r.nextInt(7) + 1;

		System.out.println("Mailing letters for " + days + " days");

		int currentDay = 1;

		do {
			System.out.println("**********************************************************");
			System.out.println("Day " + currentDay);
			city.distributeLetters();
			if (currentDay <= days)
				sendRandomLetters();
			currentDay++;
		} while (!city.isEmpty());
	}

	private static void sendRandomLetters() {
		for (int i = 0; i < r.nextInt(7) + 1; i++) {
			Letter<?> letterToSend = createRandomLetter();
			city.sendLetter(letterToSend);
		}
	}

	private static Letter<?> createRandomLetter() {
		int randomNumber = r.nextInt(4);
		Inhabitant randomSender = city.getInhabitants().get(r.nextInt(city.size()));
		Inhabitant randomReceiver = city.getInhabitants().get(r.nextInt(city.size()));
		Letter<?> letter = null;
		;
		if (randomNumber == 0) {
			letter = createSimpleLetter(randomSender, randomReceiver);
		} else if (randomNumber == 1) {
			letter = createPromissoryNote(randomSender, randomReceiver);
		} else if (randomNumber == 2) {
			letter = createRegisteredLetter(randomSender, randomReceiver);
		} else if (randomNumber == 3) {
			letter = createUrgentLetter(randomSender, randomReceiver);
		}
		return letter;
	}

	private static SimpleLetter createSimpleLetter(Inhabitant randomSender, Inhabitant randomReceiver) {
		return new SimpleLetter(randomSender, randomReceiver, new TextContent("bla bla"));
	}

	private static PromissoryNote createPromissoryNote(Inhabitant randomSender, Inhabitant randomReceiver) {
		return new PromissoryNote(randomSender, randomReceiver, new MoneyContent(r.nextInt(1000) + 1));
	}

	private static RegisteredLetter<Letter<?>> createRegisteredLetter(Inhabitant randomSender,
			Inhabitant randomReceiver) {
		int randomNumber = r.nextInt(2);
		Letter<?> contentLetter = null;
		if (randomNumber == 0) {
			contentLetter = createSimpleLetter(randomSender, randomReceiver);
		} else if (randomNumber == 1) {
			contentLetter = createPromissoryNote(randomSender, randomReceiver);
		}
		return new RegisteredLetter<Letter<?>>(contentLetter);
	}

	private static UrgentLetter<Letter<?>> createUrgentLetter(Inhabitant randomSender, Inhabitant randomReceiver) {
		int randomNumber = r.nextInt(3);
		Letter<?> contentLetter = null;
		if (randomNumber == 0) {
			contentLetter = createSimpleLetter(randomSender, randomReceiver);
		} else if (randomNumber == 1) {
			contentLetter = createPromissoryNote(randomSender, randomReceiver);
		} else if (randomNumber == 2) {
			contentLetter = createRegisteredLetter(randomSender, randomReceiver);
		}
		return new UrgentLetter<Letter<?>>(contentLetter);
	}
}