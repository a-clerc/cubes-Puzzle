package com.happyCube;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class HappyCube {
	
	private Model model;
	private static final int NUM_FACES = 6;
	private static final String space = "   ";
	private static final String pieceFlipped = "[x]";
	private static final String pieceNotFlipped = "[ ]";
	private List<Model> solutions = new ArrayList<Model>(0);

	public HappyCube(Model model) {
		this.model = model;
	}
	
	private void algorithm(Model model, List<Piece> matchedPieces, int counter) {
		if(model.isEmpty()) {			
			solutions.add(Model.cloneListOfPieces(matchedPieces));
		} else {
			for(Piece piece: model) {				
				int i = 0;
				do {
					for(int j = 0 ; j < Piece.NUM_ROTATIONS; j++) {
						if(piece.matches(matchedPieces, counter)) {
							matchedPieces.add(piece);
							Model modelC = model.clone();
							modelC.remove(piece);
							algorithm(modelC, matchedPieces, counter+1);
							matchedPieces.remove(piece);
						}
						piece.rotateLeft();
					}
					i++;
				} while(piece.getMirrorIfMirrorable() && i < Piece.NUM_FACES);
			}
		}
	}
	
	private void apendSubList(StringBuffer sb, List<Piece> subList) {	
		for(int rowToPrint = 0; rowToPrint < Piece.NUM_CELLS; rowToPrint++) {
			for(Piece piece:subList) {
				boolean isMirror = piece.isMirror();
				for(boolean bit: piece.getBitMap()[rowToPrint]) {
					if(bit) {
						sb.append(isMirror?pieceNotFlipped:pieceFlipped);
					} else {
						sb.append(space);	
					}
				}
			}
			sb.append("\n");
		}
		sb.append("\n");
	}	
	
	private void appendPiece(StringBuffer sb, Piece piece, int offsetPiece) {
		boolean isMirror = piece.isMirror();
		StringBuffer sbSpace = new StringBuffer();
		
		for(int i = 0; i < Piece.NUM_CELLS*(offsetPiece-1); i++) {
			sbSpace.insert(i, space);
		}
		for(int rowToPrint = 0; rowToPrint < Piece.NUM_CELLS; rowToPrint++) {
			sb.append(sbSpace.toString());
			for(boolean bit: piece.getBitMap()[rowToPrint]) {
				if(bit) {
					sb.append(isMirror?pieceNotFlipped:pieceFlipped);
				} else {
					sb.append(space);	
				}
			}
			sb.append("\n");	
		}
		sb.append("\n");
	} 
	
	public List<Model> getSolutions() {
		return this.solutions;
	}
	
	public void printSolutions() {
		try {	
			FileOutputStream fos = new FileOutputStream(new File("output/"+this.model.getNamemodel()+"Output.txt"));
			OutputStreamWriter os = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(os);
			try {
				for(Model solution: solutions) {
					Piece piece4 = solution.get(NUM_FACES-2);
					StringBuffer sbFinal = new StringBuffer();
					appendPiece(sbFinal, piece4, NUM_FACES-2);
					List<Piece> subList1 = solution.subList(0, NUM_FACES-2);
					apendSubList(sbFinal, subList1);
					Piece piece5 = solution.get(NUM_FACES-1);
					appendPiece(sbFinal, piece5, NUM_FACES-2);
					bw.write(sbFinal.toString());
				}
				System.out.println("Output at folder output/"+this.model.getNamemodel()+"Output.txt");
			} catch(IOException e) {
			} finally {
				bw.close();
			}
		} catch(IOException e) {}
	}
	
	public void solve() {
		System.out.println("Solving model "+model.getNamemodel());
		
		Piece currentPiece = model.remove(0);
		List<Piece> matchedPieces = new ArrayList<Piece>(NUM_FACES);
		matchedPieces.add(currentPiece);
		algorithm(model, matchedPieces, 0);
		
		System.out.println("Solved model "+model.getNamemodel());
	}
}
