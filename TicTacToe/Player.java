package com.walmart.practice.webApplication.TicTacToe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
	String name;
	PlayingPiece playingPiece;
	
	public Player(String name,PlayingPiece playingPiece) {
		this.name=name;
		this.playingPiece=playingPiece;
	}
	
}
