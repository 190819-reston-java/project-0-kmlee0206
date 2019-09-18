package com.revature.controller;

import java.text.NumberFormat;
import java.util.Scanner;
import org.apache.log4j.Logger;


import com.revature.service.Transactions;

public class UserScreen {
	
	private static Scanner sc = new Scanner(System.in);
	private static Logger logger = Logger.getLogger(UserScreen.class);
	private static NumberFormat toCurrency = NumberFormat.getCurrencyInstance();
	
	private static int invalidOptionCounter = 0;
	private static int invalidPwdCounter = 0;
	
	static String inputedUsername = null;
	
	public static void app() {
		logger.info("User started the app");
		login();
	}
	
	//Used nested if, is that efficient or okay?
	public static void login() {
		logger.info("User login started");
		System.out.println("-------Welcome to KM Banking!-------");
		System.out.print("Please enter your username: ");
		inputedUsername = sc.nextLine();
		if(inputedUsername.equals(Transactions.pullUsername(inputedUsername))) {
			while (invalidPwdCounter < 3) {
				System.out.print("Please enter your password: ");
				String inputedUserPwd = sc.nextLine();
				if(inputedUserPwd.equals(Transactions.pullUserpwd(inputedUsername))) {
					System.out.println("");
					System.out.println("Login successful!");
					System.out.println("");
					logger.info("User successfully logged in");
					menu();
				} else {
					invalidPwdCounter++;
					if (invalidPwdCounter == 3) {
						System.out.println("");
						System.out.println("You have failed to enter you password 3 times!");
						System.out.println("Exiting the app!");
						logger.debug("User entered wrong password 3 times, app terminated");
					} else {
						System.out.println("");
						System.out.println("Wrong password!");
						System.out.println("You have " + (3-invalidPwdCounter) + " attemps left");
						System.out.println("");
						logger.debug("User entered wrong password " + invalidPwdCounter + " time(s)");
					}
				}
			}
		} else {
			System.out.println("Can't find that username!");
		}
	}
	
	public static void menu() {
		logger.info("Menu started");
		System.out.println("-------" + "Hello, " + Transactions.pullName(inputedUsername) + "-------");
		System.out.println("Please select an option below:");
		System.out.println("1 - View my balance");
		System.out.println("2 - Withdraw");
		System.out.println("3 - Deposit");
		System.out.println("4 - Logout & Exit");
		
		System.out.print("Enter your option -> ");
		String userOption = sc.nextLine();
		
		logger.debug("Received user input: " + userOption);
		System.out.println("");
		
		switch(userOption) {
		case "1": //show balance
			System.out.println("Your balance is: " + toCurrency.format(Transactions.viewBalance(inputedUsername)));
			System.out.println("");
			logger.info("User viewed balance of " + toCurrency.format(Transactions.viewBalance(inputedUsername)));
			break;
		case "2":  //withdraw
			System.out.print("Enter amount to withdraw: $");
			double withdrawAmt = Double.parseDouble(sc.nextLine());
			toCurrency.format(withdrawAmt);
			Transactions.withdraw(withdrawAmt, inputedUsername);
			System.out.println("Your balance after withdraw is: " + toCurrency.format(Transactions.viewBalance(inputedUsername)));
			System.out.println("");
			logger.info("User made a withdrawal of " + withdrawAmt);
			break;
		case "3": //deposit
			System.out.print("Enter amount to deposit: $");
			//double depositAmt = sc.nextDouble(); //the loop that breaks invalid option counter
			double depositAmt = Double.parseDouble(sc.nextLine());
			toCurrency.format(depositAmt);
			Transactions.deposit(depositAmt, inputedUsername);
			System.out.println("Your balance after deposit is: " + toCurrency.format(Transactions.viewBalance(inputedUsername)));
			System.out.println("");
			logger.info("User made a deposit of " + depositAmt);
			break;
		case "4":
			logger.info("User exited out of the menu");
			System.out.println("Goodbye");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option!");
			invalidOptionCounter++;
			
			if(invalidOptionCounter == 5) {
				System.out.println("You have entered invalid option 5 times, exiting the app!");
				logger.fatal("Failed to recognize user's option 5 times, exiting");
				System.exit(1);
			} else {
				logger.debug("User entered an invalid option: " + userOption);
				logger.debug("User inputed invalid option " + invalidOptionCounter + " times");
				System.out.println("You have " + (5 - invalidOptionCounter) + " attempts left before app crashes!");
				System.out.println("");
			}
			
			break;
		}
		menu();
	}

}
