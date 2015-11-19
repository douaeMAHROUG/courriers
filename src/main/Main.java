package main;
import java.util.ArrayList;
import city.*;
/**
 * 
 * @author mahroug
 *
 */
public class Main {
	
	public static void main (String[] args){
	    
		City myCity = new City("scientifique");
		System.out.println("Creating scientifique city");
		for(int i = 0 ; i < 100 ; i++){
			Inhabitant inhabitant = new Inhabitant("Inabitant-"+i, myCity, new BankAccount(5000));
			myCity.addInhabitant(inhabitant);
		}
		System.out.println("Creating 100 inhabitants");
		System.out.println("Mailing letters for 6 days");
		
		ArrayList<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
		
		for(int i = 0 ; i < 6 ; i++){
			System.out.println("**********************************************************");
			System.out.println("Day " +(i+1));
			myCity.distributeLetters();
		}
	}
}