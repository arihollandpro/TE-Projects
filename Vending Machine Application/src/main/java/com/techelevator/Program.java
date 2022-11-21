package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	private BigDecimal balance = BigDecimal.valueOf(0.00);

	public BigDecimal getBalance() {
		return balance;
	}

	public static void main(String[] args) throws IOException {
		Clock clock = Clock.systemUTC();
		//System.out.println(clock.instant().toString());


//		System.out.println("(1) Display Vending Machine Items ");
//		System.out.println("(2) Purchase ");
//		System.out.println("(3) Exit ");

		Scanner userInput = new Scanner(System.in);
		File salesLog = new File("salesLog.txt");
		if (salesLog.exists()) {
			salesLog.delete();
		}
		PrintWriter salesLogWriter = new PrintWriter(salesLog);
		salesLogWriter.println("Test Print Plz");
		salesLogWriter.flush();


//		System.out.println("Please make a selection: ");

		List<Items> inventory = new ArrayList();
		File vendList = new File("vendingmachine.csv");
		try (Scanner fileScanner = new Scanner(vendList)) {
			fileScanner.useDelimiter(",|\n");

			while (fileScanner.hasNext()) {
				String slotNumber = fileScanner.next();
				String name = fileScanner.next();
				BigDecimal price = BigDecimal.valueOf(Double.parseDouble(fileScanner.next()));
				String type = fileScanner.next();
				int quantity = 5;

				Items item = new Items(slotNumber, name, price, type, quantity);
				inventory.add(item);

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		//MAIN MENU
		BigDecimal balance = BigDecimal.valueOf(0.00);
		while (!userInput.equals("3")) {
			System.out.println();
			System.out.println("(1) Display Vending Machine Items ");
			System.out.println("(2) Purchase ");
			System.out.println("(3) Exit ");
			System.out.println();
			System.out.println("Please make a selection: ");


			String choice = userInput.nextLine();

			//////Input 1 from Main Menu

			if (choice.contains("1")) {
				for (int i = 0; i < inventory.size(); i++) {
					System.out.println(inventory.get(i).getSlotNumber() + ": " + inventory.get(i).getName() + ", " + "$" + inventory.get(i).getPrice() + ", " + inventory.get(i).getQuantity() + " Remaining");
				}
			}

			//choice = userInput.nextLine();

			///// Purchase Menu

			if (choice.contains("2")) {
				while (!userInput.equals("3")) {
					System.out.println("Current Balance: $" + balance);
					System.out.println();
					System.out.println("(1) Feed Money");
					System.out.println("(2) Select Product");
					System.out.println("(3) Finish Transaction");
					String choice2;
					choice2 = userInput.nextLine();

					///Input 1 from Purchase Menu

					if (choice2.contains("1")) {
						System.out.println("How much money would you like to input? (1, 5, 10) ");
						choice2 = userInput.nextLine();
						String moneyFed = choice2;

						if (choice2.contentEquals("1")) {
							balance = balance.add(BigDecimal.valueOf(1.0));
							salesLogWriter.println(clock.instant().toString() + " FEED MONEY: " + moneyFed + " $" + balance);
							salesLogWriter.flush();
						} else if (choice2.contentEquals("5")) {
							balance = balance.add(BigDecimal.valueOf(5));
							salesLogWriter.println(clock.instant().toString() + " FEED MONEY: " + moneyFed + " $" + balance);
						} else if (choice2.contentEquals("10")) {
							balance = balance.add(BigDecimal.valueOf(10));
							salesLogWriter.println(clock.instant().toString() + " FEED MONEY: " + moneyFed + " $" + balance);
						} else System.out.println("Not a valid Dollar amount!!!");

					}

					//}

					//choice = userInput.nextLine();

					if (choice2.contains("2")) {
						for (int i = 0; i < inventory.size(); i++) {
							System.out.println(inventory.get(i).getSlotNumber() + ": " + inventory.get(i).getName() + ", " + "$" + inventory.get(i).getPrice() + ", " + inventory.get(i).getQuantity() + " Remaining");
						}
						System.out.println("Select Item using Slot Number");
						choice2 = userInput.nextLine();
						Items myChoice = null;
						for (int i = 0; i < inventory.size(); i++) {
							if (choice2.equalsIgnoreCase(inventory.get(i).getSlotNumber())) { //TODO add && statement for balance
								myChoice = inventory.get(i);
								break;
							}

						}

						if (myChoice == null) {
							System.out.println("Item Does Not Exist");
						}

						try {
							if (balance.compareTo(myChoice.getPrice()) == -1) {
								System.out.println("Not Enough Available Funds");
							} else {


								if (myChoice.isSoldOut()) {
									System.out.println("Item Is Sold Out. Your remaining balance is still; " + balance);
								} else {
									if (myChoice.getSlotNumber().contains("B") && !myChoice.isSoldOut()) {
										System.out.println();
										System.out.println(myChoice.getName() + " $" + myChoice.getPrice());
										System.out.println("Munch Munch, Yum!");
									} else if (myChoice.getSlotNumber().contains("A") && !myChoice.isSoldOut()) {
										System.out.println();
										System.out.println(myChoice.getName() + " $" + myChoice.getPrice());
										System.out.println("Crunchy Crunchy, Yum!");
									} else if (myChoice.getSlotNumber().contains("C") && !myChoice.isSoldOut()) {
										System.out.println();
										System.out.println(myChoice.getName() + " $" + myChoice.getPrice());
										System.out.println("Slurp Slurp, Yum!");
									} else if (myChoice.getSlotNumber().contains("D") && !myChoice.isSoldOut()) {
										System.out.println();
										System.out.println(myChoice.getName() + " $" + myChoice.getPrice());
										System.out.println("Chewy Chewy, Yum!");
									}
									balance = myChoice.purchase(balance);
									salesLogWriter.println(clock.instant().toString() + " " + myChoice.getName() + " " + myChoice.getSlotNumber() +
											" $" + myChoice.getPrice() + " $" + balance);
								}
							}

						} catch (NullPointerException e) {
							System.out.println("no way jose");
						}
					}


					if (choice2.equals("3")) {
						System.out.println("Your Change is $" + balance);

						BigDecimal q= new BigDecimal(".25");
						BigDecimal d= new BigDecimal(".1");
						BigDecimal n= new BigDecimal(".05");
						BigDecimal none= new BigDecimal("0");

						int quarters = 0;
						int nickels = 0;
						int dimes = 0;

						while(balance.compareTo(none) > 0){
							if (balance.compareTo(q) >= 0) {
								quarters++;
								balance= balance.subtract(q);
							}
							else if (balance.compareTo(d) >= 0) {
								dimes++;
								balance= balance.subtract(d);
							}
							else if (balance.compareTo(n) >= 0) {
								nickels++;
								balance= balance.subtract(n);
							}
						}
						//Prints labeled output of the while loop
						System.out.println("Your change is : " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.");
						salesLogWriter.println(clock.instant().toString() + " GIVE CHANGE: $" + balance + " $0.00");
						balance = BigDecimal.valueOf(0);
						break;
					}
				}

			}

			if (choice.equals("3")) {
				break;
			}
		}

		salesLogWriter.flush();
		salesLogWriter.close();
		userInput.close();
		System.exit(1);

	}


//	public BigDecimal returnChange(BigDecimal balance) {
//		BigDecimal totalCents = balance.multiply(BigDecimal.valueOf(100));
//
//		BigDecimal quarters = totalCents.divide(BigDecimal.valueOf(25));
//		BigDecimal remaining = quarters.remainder(totalCents);
//
//		BigDecimal dimes = remaining.divide(BigDecimal.valueOf(10));
//		BigDecimal remaining2 = dimes.remainder(remaining);
//
//		BigDecimal nickels = remaining2.divide(BigDecimal.valueOf(5));
//
//		return remaining;
//	}
////	 System.out.println("Your change is : " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.");
}



























