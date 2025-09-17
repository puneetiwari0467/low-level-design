package com.walmart.practice.webApplication.TicTacToe;

public class MainClass {
	
	public static void main(String []args) {
		Game game=new Game();
		game.initializaGame();
		
		System.out.println("Game ended and winner is"+ game.playGame());
	}
}
