package com.walmart.practice.webApplication.SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
	Board board;
	Dice dice;
	Deque<Player> playersList=new LinkedList<>();
	Player winner;
	
	public  Game(){
		initializeGame();
	}
	
	public void initializeGame(){
		board=new Board(10,5,4);
		dice=new Dice(1);
		winner=null;
		addPlayers();
	}
	
	private void addPlayers() {
		Player player1=new Player("p1",0);
		Player player2=new Player("p2",0);
		playersList.add(player1);
		playersList.add(player2);
	}
	
	public void beginGame(){
		System.out.println(Thread.currentThread().getName());
		while(winner==null) {
			
			Player playerTurn=findPlayerTurn();
			System.out.println("Player turn is: "+playerTurn.id);
			
			int diceNumbers=dice.rollDice();
			
			int playerNewPosition=playerTurn.currentPosition+diceNumbers;
			if(playerNewPosition>=board.cells.length*board.cells.length-1) {
				winner=playerTurn;
				break;
			}
			System.out.println("playerNewPosition "+playerNewPosition);
			playerNewPosition=checkForJump(playerNewPosition);
			 playerTurn.currentPosition = playerNewPosition;
			
			
			
			
		}
		System.out.println("WINNER IS:" + winner.id);
		
	}
	
	int checkForJump(int playerPos){
		
		Cell cell=board.getCell(playerPos);
		if(cell.jump!=null && cell.jump.start==playerPos) {
			String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
		}
		return playerPos;
	}
	
	public Player findPlayerTurn(){
		Player player=playersList.removeFirst();
		playersList.addLast(player);
		return player;
	}
}
