package com.happyCube;

import java.util.Arrays;
import java.util.List;

public class Piece {
	
	private boolean mirror;
	private boolean[][] bitMap;
	private boolean mirrorable;
	public static final int NUM_CELLS = 5;
	public static final int NUM_FACES = 2;
	public static final int NUM_ROTATIONS = 4;
	private enum Orientation {NORTH, SOUTH, EAST , WEST};
	
	public Piece() {}
	
	public Piece(boolean[][] bitMap) {
		this.bitMap = bitMap;	
		this.mirror = false;
		checkIfIsMirrorable();
	}
	
	public Piece(Piece piece) {
		this(piece.getBitMap());
		this.mirror = piece.isMirror();
	}

	private void checkIfIsMirrorable() {
		Piece piece = new Piece();
		piece.setBitmap(this.getBitMap());
		piece.mirror();
		this.mirrorable = true;
		for(int i = 0; i < NUM_ROTATIONS; i++) {
			if(Arrays.deepEquals(piece.getBitMap(), this.getBitMap())) {
				this.mirrorable = false;
				break;
			} else {
				piece.rotateLeft();
			}	
		}
	}
	
	public boolean[][] getBitMap() {
		return this.bitMap;
	}
	
	public boolean getMirrorIfMirrorable() {
		if(this.mirrorable) {
			this.mirror();
		}
		return this.mirrorable;
	}
	
	private void inverseOrderCol() {
		boolean[][] newBitMap = new boolean[5][5];
		for(int i = 0; i < NUM_CELLS; i++) {
			for(int j = 0; j < NUM_CELLS; j++) {
				newBitMap[i][j] = this.bitMap[i][NUM_CELLS-1-j];
			}
		}
		this.bitMap = newBitMap;
	}
	
	private void inverseOrderRow() {
		boolean[][] newBitMap = new boolean[5][5];
		for(int i = 0; i < NUM_CELLS; i++) {
			for(int j = 0; j < NUM_CELLS; j++) {
				newBitMap[i][j] = this.bitMap[NUM_CELLS-1-i][j];
			}
		}
		this.bitMap = newBitMap;
	}
	
	public boolean isMirror() {
		return this.mirror;
	}
	
	public boolean matches(List<Piece> pieces, int index) {
		if(index < 2) {
			return matchesWithPiece(pieces.get(index), Orientation.WEST);
		} else if(index == 2) {
			return matchesWithPiece(pieces.get(index), Orientation.WEST) && matchesWithPiece(pieces.get(0), Orientation.EAST); 
		} else if(index == 3) {
			if(matchesWithPiece(pieces.get(index), Orientation.SOUTH)) {
				Piece piece = new Piece(this);
				int i = index;
				while(i > 0) {
					piece.rotateLeft();
					if(!piece.matchesWithPiece(pieces.get(i-1), Orientation.SOUTH)) {
						break;
					}
					i--;
				}
				return i==0;
			}
		} else if(index == 4) {
			if(matchesWithPiece(pieces.get(index-1), Orientation.NORTH)) {
				Piece piece = new Piece(this);
				int i = index-1;
				while(i > 0) {
					piece.rotateRight();
					if(!piece.matchesWithPiece(pieces.get(i-1), Orientation.NORTH)) {
						break;
					}
					i--;
				}
				return i==0;
			}			
		}
		return false;
	}
	
	private boolean matchesWithPiece(Piece piece, Orientation orientation) {
		boolean matches = true;
		boolean[][] mapToMatch = piece.getBitMap();
		switch(orientation) { 
			case SOUTH:
				//Corner SW 
				matches = mapToMatch[0][0]!=this.bitMap[NUM_CELLS-1][0] || (!mapToMatch[0][0]&&!this.bitMap[NUM_CELLS-1][0])&&!(!mapToMatch[0][0]&&!this.bitMap[NUM_CELLS-1][0]&&mapToMatch[1][0]&&this.bitMap[NUM_CELLS-2][0]);

				for(int j = 1; matches && j < NUM_CELLS-1; j++) {
					matches = this.bitMap[NUM_CELLS-1][j]!=mapToMatch[0][j];
				}
				//Corner SE
				matches = matches&&(mapToMatch[0][NUM_CELLS-1]!=this.bitMap[NUM_CELLS-1][NUM_CELLS-1] || (!mapToMatch[0][NUM_CELLS-1]&&!this.bitMap[NUM_CELLS-1][NUM_CELLS-1])&&!(!mapToMatch[0][NUM_CELLS-1]&&!this.bitMap[NUM_CELLS-1][NUM_CELLS-1]&&mapToMatch[1][NUM_CELLS-1]&&this.bitMap[NUM_CELLS-2][NUM_CELLS-1]));
				break;
			case WEST:
				//Corner NW
				matches = mapToMatch[0][NUM_CELLS-1]!=this.bitMap[0][0] || (!mapToMatch[0][NUM_CELLS-1]&&!this.bitMap[0][0])&&!(!mapToMatch[0][NUM_CELLS-1]&&!this.bitMap[0][0]&&mapToMatch[0][NUM_CELLS-2]&&this.bitMap[0][1]);
				
				for(int i = 1; matches && i < NUM_CELLS-1; i++) {
					matches = mapToMatch[i][NUM_CELLS-1]!=this.bitMap[i][0];
				}
				//Corner SW				
				matches = matches&&(mapToMatch[NUM_CELLS-1][NUM_CELLS-1]!=this.bitMap[NUM_CELLS-1][0] || (!mapToMatch[NUM_CELLS-1][NUM_CELLS-1]&&!this.bitMap[NUM_CELLS-1][0])&&!(!mapToMatch[NUM_CELLS-1][NUM_CELLS-1]&&!this.bitMap[NUM_CELLS-1][0]&&mapToMatch[NUM_CELLS-1][NUM_CELLS-2]&&this.bitMap[NUM_CELLS-1][1]));
				break;
			case EAST:
				matches = piece.matchesWithPiece(this, Orientation.WEST);
				break;
			case NORTH:
				matches = piece.matchesWithPiece(this, Orientation.SOUTH);
				break;
		}
		return matches;
	}
	
	private void mirror() {
		this.mirror = !this.mirror;
		inverseOrderCol();
	}
	
	private void rotate(Orientation orientation) {
		switch(orientation) {
			case EAST:
				transpose();
				inverseOrderCol();
				break;
			case WEST:
				transpose();
				inverseOrderRow();
				break;
			case NORTH:
			case SOUTH:
				break;
		}
	}
	
	public void rotateLeft() {
		rotate(Orientation.WEST);
	}

	public void rotateRight() {
		rotate(Orientation.EAST);
	}
	
	private void setBitmap(boolean[][] newBitMap) {
		this.bitMap = newBitMap;
	}
	
	public void transpose() {
		boolean[][] newBitMap = new boolean[5][5];
		for(int i = 0; i < NUM_CELLS; i++) {
			for(int j = 0; j < NUM_CELLS; j++) {
				newBitMap[i][j] = bitMap[j][i];
			}
		}
		this.bitMap = newBitMap;
	}
	
}