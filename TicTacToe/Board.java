package com.walmart.practice.webApplication.TicTacToe;

public class Board {
	PlayingPiece board[][];
	int size;
	
	public Board(int size) {
		this.size=size;
		board=new PlayingPiece[size][size];
	}
	
	void addPiece(int row,int col,PlayingPiece playingPiece) {
		board[row][col]=playingPiece;
	}
	
	public void printBoard() {
		System.out.println("Current Board state is ");
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==null) {
					System.out.print("	"+"|");
				}
				else {
					System.out.print(board[i][j].pieceType.toString()+"	|");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public Boolean isFreeCell() {
		int cnt=0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==null) {
					cnt++;
				}
			}
		}
		if(cnt==0)return false;
		return true;
	}
}
