package com.happyCube;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Model extends ArrayList<Piece> {
	
	private String nameModel;
	
	public Model(String nameModel){
		this.nameModel = nameModel;
	}

	public Model(List<Piece> pieces) {
		super.addAll(pieces);
	}
	
	public Model(int size) {
		new ArrayList<Piece>(size);
	}

	public void addPiece(Piece piece) {
		super.add(piece);
	}
	
	public String getNamemodel() {
		return nameModel;
	}
	
	public Model clone() {
		return (Model) super.clone();		
	}
	
	public static Model cloneListOfPieces(List<Piece> pieceList) {
	    Model clone = new Model(pieceList.size());
	    for (Piece piece: pieceList) {
	        clone.add(new Piece(piece));
	    }
	    return clone;
	}
	
}