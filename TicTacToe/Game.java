package com.walmart.practice.webApplication.TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
	
	Deque<Player>players;
	Board gameBoard;
	
	public void initializaGame() {
		
		Player player1=new Player("china", new PlayingPieceX());
		Player player2=new Player("india", new PlayingPieceO());
		
		players=new LinkedList<>();
		players.add(player1);
		players.add(player2);
		
		gameBoard=new Board(3);
	}
	
	public String playGame() {
		boolean winner=false;
		while(winner==false) {
			Player currentPlayer=players.removeFirst();
			players.addLast(currentPlayer);
			
			gameBoard.printBoard();
			System.out.println("Turn of Player "+currentPlayer.name+" provide input (X,Y)");
			Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values=s.split(",");
            int inputRow=Integer.valueOf(values[0]);
            int inputColumn=Integer.valueOf(values[1]);
            
            gameBoard.addPiece(inputRow, inputColumn,currentPlayer.playingPiece);
            gameBoard.printBoard();
            winner=isSomeWinner();
            if(winner==true) {
            	return currentPlayer.name;
            }
			if(!gameBoard.isFreeCell()) {
				break;
			}
		}
		return "tie";
	}
	
	private Boolean isSomeWinner() {
		//row check 
		for(int i=0;i<gameBoard.size;i++) {
			int cntx=0,cnto=0;
			for(int j=0;j<gameBoard.size;j++) {
				
				if(gameBoard.board[i][j]!=null &&gameBoard.board[i][j].pieceType == PieceType.X) {
					cntx++;
				}
				
				if(gameBoard.board[i][j]!=null &&gameBoard.board[i][j].pieceType == PieceType.O) {
					cnto++;
				}
			}
			if(cntx==gameBoard.size) {
				return true;
			}
			if(cntx==gameBoard.size) {
				return true;
			}
		}
		//column check 
		for(int j=0;j<gameBoard.size;j++) {
			int cntx=0,cnto=0;
			for(int i=0;i<gameBoard.size;i++) {
				
				if(gameBoard.board[i][j]!=null &&gameBoard.board[i][j].pieceType == PieceType.X) {
					cntx++;
				}
				
				if(gameBoard.board[i][j]!=null &&gameBoard.board[i][j].pieceType == PieceType.O) {
					cnto++;
				}
			}
			if(cntx==gameBoard.size) {
				return true;
			}
			if(cntx==gameBoard.size) {
				return true;
			}
		}
		
		//diagonal check
		int cntxR=0,cntoR=0;
		int cntxF=0,cntoF=0;
		for(int i=0;i<gameBoard.size;i++) {
			
			for(int j=0;j<gameBoard.size;j++) {
				
				if(gameBoard.board[i][j]!=null && i+j==gameBoard.size-1 && gameBoard.board[i][j].pieceType == PieceType.X) {
					cntxR++;
				}
				
				if(gameBoard.board[i][j]!=null && i+j==gameBoard.size-1 && gameBoard.board[i][j].pieceType == PieceType.O) {
					cntoR++;
				}
				if(gameBoard.board[i][j]!=null && i==j && gameBoard.board[i][j].pieceType == PieceType.X) {
					cntxF++;
				}
				if(gameBoard.board[i][j]!=null &&i==j && gameBoard.board[i][j].pieceType == PieceType.O) {
					cntoF++;
				}
			}

		}
		if(cntxR==gameBoard.size ||cntoR==gameBoard.size ||cntxF==gameBoard.size ||cntoF==gameBoard.size ) {
			return true;
		}
		return false;
	}
}
