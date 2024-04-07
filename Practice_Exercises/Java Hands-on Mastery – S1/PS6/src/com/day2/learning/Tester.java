package com.day2.learning;

import java.util.Scanner;

//Custom Exception class
class NotEligibleException extends Exception {
	public NotEligibleException(String message) {
		super(message);
	}
}

//CricketRating class
class CricketRating {
	// Field Names
	private String playerName;
	private float critic1;
	private float critic2;
	private float critic3;
	private float avgRating;
	private String coins;

	// Constructor
	public CricketRating(String playerName, float critic1, float critic2, float critic3) throws NotEligibleException {
		this.playerName = playerName;
		this.critic1 = critic1;
		this.critic2 = critic2;
		this.critic3 = critic3;
		calculateAverageRating(critic1, critic2);
		calculateAverageRating(critic1, critic2, critic3);
		calculateCoins();
	}

	// Method to calculate average rating based on two critics
	public void calculateAverageRating(float c1, float c2) {
		avgRating = (c1 + c2) / 2;
	}

	// Method to calculate average rating based on three critics
	public void calculateAverageRating(float c1, float c2, float c3) {
		avgRating = (c1 + c2 + c3) / 3;
	}

	// Method to calculate coins based on average rating
	public String calculateCoins() throws NotEligibleException {
		if (avgRating >= 7)
			coins = "Gold";
		else if (avgRating >= 5)
			coins = "Silver";
		else if (avgRating >= 2)
			coins = "Copper";
		else
			throw new NotEligibleException("Not Eligible");
		return coins;

	}

	// Method to display information
	public void display() {
		System.out.println("Player Name: " + playerName);
		System.out.println("Average Rating: " + String.format("%.2f",avgRating));
		System.out.println("Coins: " + coins);
	}
}

//Tester class
public class Tester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
      try {
		// Input player information
		System.out.println("Enter player name:");
		String playerName = scanner.nextLine();
		System.out.println("Enter critic 1 rating:");
		float critic1 = scanner.nextFloat();
		System.out.println("Enter critic 2 rating:");
		float critic2 = scanner.nextFloat();
		System.out.println("Enter critic 3 rating:");
		float critic3 = scanner.nextFloat();

		// Create CricketRating object
		CricketRating player = new CricketRating(playerName, critic1, critic2, critic3);

		// Display player information
		player.display();
      }catch(NotEligibleException e) {
    	  e.printStackTrace();
      }

	}
}
