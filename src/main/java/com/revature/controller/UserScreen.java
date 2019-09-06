package com.revature.controller;

import java.util.Scanner;

import com.revature.model.Password;
import com.revature.model.Username;
import com.revature.service.Balance;
import com.revature.service.Deposit;
import com.revature.service.Withdraw;

//import org.apache.log4j.Logger;

public class UserScreen {
	
	private static Scanner sc = new Scanner(System.in);
	
	private static int invalidOptionCounter = 0;
	//private static int invalidPwdCounter = 0;
	
	public static void App() {
		Login();
	}
	
	//Used nested if, is that efficient or okay?
	public static void Login() {
		System.out.print("Please enter your username: ");
		String inputedUserID = sc.nextLine();
		if(inputedUserID.equals(Username.getUserID())) {
			System.out.print("Please enter your password: ");
			String inputedUserPwd = sc.nextLine();
			if(inputedUserPwd.equals(Password.getUserPwd())) {
				System.out.println("");
				System.out.println("Login successful!");
				System.out.println("");
				Menu();
			} else {
				System.out.println("Wrong password!");
			}
		} else {
			System.out.println("Can't find that username!");
		}
	}
	
	public static void Menu() {
		//logger.info("Menu started");
		System.out.println("-------Welcome to KM Banking!-------");
		System.out.println("Please select an option below:");
		System.out.println("1 - View my balance");
		System.out.println("2 - Withdraw");
		System.out.println("3 - Deposit");
		System.out.println("4 - Exit");
		
		System.out.print("Enter your option -> ");
		String userOption = sc.nextLine();
		
		//logger.debug("Received user input: " + userOption);
		System.out.println("");
		
		switch(userOption) {
		case "1": //show balance
			System.out.println("Your balance is: $" + Balance.currentBalance());
			System.out.println("");
			break;
		case "2":  //withdraw
			System.out.print("Enter amount to withdraw: $");
			double withdrawAmt = Double.parseDouble(sc.nextLine());
			Withdraw.withdraw(withdrawAmt);
			System.out.println("Your balance after withdraw is: $" + Balance.currentBalance());
			System.out.println("");
			break;
		case "3": //deposit
			System.out.print("Enter amount to deposit: $");
			//double depositAmt = sc.nextDouble(); //the loop that breaks invalid option counter
			double depositAmt = Double.parseDouble(sc.nextLine());
			Deposit.deposit(depositAmt);
			System.out.println("Your balance after deposit is: $" + Balance.currentBalance());
			System.out.println("");
			break;
		case "4":
			System.out.println("Goodbye");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option!");
			invalidOptionCounter++;
			//logger.debug(userOption + " is an invalid option");
			//logger.debug("User inputed invalid option " + invalidOptionCounter + "times");
			
			System.out.println("You have " + (5 - invalidOptionCounter) + " attempts left before app crashes!");
			System.out.println("");
			
			if(invalidOptionCounter > 4) {
				System.out.println("You have entered invalid option 5 times, exiting the app!");
				//logger.fatal("failed to recognize option 5 times, exiting");
				System.exit(1);
			}
			//Menu();
			break;
		}
		Menu();
	}

}
