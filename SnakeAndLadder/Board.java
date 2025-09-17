package com.walmart.practice.webApplication.SnakeAndLadder;

import java.util.Random;

public class Board {


	Cell cells[][];
	
	public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
		
		cells=new Cell[boardSize][boardSize];
		
		for(int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++) {
				cells[i][j]=new Cell();
			}
		}
		
		addSnakesLadders(cells,numberOfSnakes,numberOfLadders);
		
	}
	
	private void addSnakesLadders(Cell[][] cells,int numberOfSnakes,int numberOfLadders) {
		
		while(numberOfSnakes>0) {
			Random random=new Random();
			int snakeHead=random.nextInt(cells.length*cells.length-1);
			int snakeTail=random.nextInt(cells.length*cells.length-1);
			
			if(snakeHead>snakeTail) {
				Jump snakeObj=new Jump();
				snakeObj.start=snakeHead;
				snakeObj.end=snakeTail;
				Cell cell=getCell(snakeHead);
				cell.jump=snakeObj;
				numberOfSnakes--;
			}
		}
		
		while(numberOfLadders>0) {
			Random random=new Random();
			int ladderStart=random.nextInt(cells.length*cells.length-1);
			int ladderEnd=random.nextInt(cells.length*cells.length-1);
			
			if(ladderStart<ladderEnd) {
				Jump ladderObj=new Jump();
				ladderObj.start=ladderStart;
				ladderObj.end=ladderEnd;
				Cell cell=getCell(ladderStart);
				cell.jump=ladderObj;
				numberOfLadders--;
			}
		}
		
	}
	
	Cell getCell(int position){
		System.out.println("Position="+position);
		int x=position / cells.length;
		int y=position % cells.length;
		System.out.println("x="+x+" y="+y);
		return cells[x][y];
	}
	

}
