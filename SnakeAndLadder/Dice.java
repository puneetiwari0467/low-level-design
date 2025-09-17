package com.walmart.practice.webApplication.SnakeAndLadder;

import java.util.Random;

public class Dice {
	int diceCount;
	int min=1;
	int max=6;
	
	public Dice(int diceCount) {
		this.diceCount=diceCount;
	}

	public int rollDice() {
		Random rand=new Random();
		int sum=0;
		int currentDice=0;
		while(currentDice<diceCount) {
			sum += rand.nextInt((max - min) + 1) + min;
			currentDice++;
		}
		System.out.println("Random number is "+sum);
		return sum;		
	}
	
}
