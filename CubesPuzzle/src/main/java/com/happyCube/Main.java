package com.happyCube;


public class Main {

	public static void main(String[] args) {
		
		boolean[][] bluePiece1 = {{false, false, true, false, false}, 
									{false, true, true, true, false},
									{true, true, true, true, true},
									{false, true, true, true, false},
									{false, false, true, false, false}};
		boolean[][] bluePiece2 = {{true, false, true, false, true}, 
									{true, true, true, true, true},
									{false, true, true, true, false},
									{true, true, true, true, true},
									{true, false, true, false, true}};
		boolean[][] bluePiece3 = {{false, false, true, false, false}, 
									{false, true, true, true, true},
									{true, true, true, true, false},
									{false, true, true, true, true},
									{false, false, true, false, false}};		
		boolean[][] bluePiece4 = {{false, true, false, true, false}, 
									{true, true, true, true, false},
									{false, true, true, true, true},
									{true, true, true, true, false},
									{true, true, false, true, false}};
		boolean[][] bluePiece5 = {{false, true, false, true, false}, 
									{true, true, true, true, true},
									{false, true, true, true, false},
									{true, true, true, true, true},
									{true, false, true, false, false}};
		boolean[][] bluePiece6 = {{false, true, false, true, false}, 
									{false, true, true, true, true},
									{true, true, true, true, false},
									{false, true, true, true, true},
									{true, true, false, true, true}};
		
		Model modelBlue = new Model("Blue");
		modelBlue.addPiece(new Piece(bluePiece1));
		modelBlue.addPiece(new Piece(bluePiece2));
		modelBlue.addPiece(new Piece(bluePiece3));
		modelBlue.addPiece(new Piece(bluePiece4));
		modelBlue.addPiece(new Piece(bluePiece5));
		modelBlue.addPiece(new Piece(bluePiece6));
		HappyCube hCubeBlue = new HappyCube(modelBlue);
		
		boolean[][] redPiece1 = {{false, false, false, true, true}, 
								{false, true, true, true, false},
								{true, true, true, true, true},
								{false, true, true, true, false},
								{false, true, false, true, true}};
		boolean[][] redPiece2 = {{false, true, false, true, false}, 
								{true, true, true, true, false},
								{false, true, true, true, true},
								{true, true, true, true, false},
								{false, true, false, false, false}};
		boolean[][] redPiece3 = {{false, true, true, false, true}, 
								{true, true, true, true, true},
								{false, true, true, true, false},
								{true, true, true, true, true},
								{true, false, false, true, true}};		
		boolean[][] redPiece4 = {{false, false, true, false, false}, 
								{true, true, true, true, false},
								{false, true, true, true, true},
								{true, true, true, true, false},
								{false, false, true, false, false}};
		boolean[][] redPiece5 = {{false, false, true, true, false}, 
								{true, true, true, true, true},
								{false, true, true, true, false},
								{true, true, true, true, true},
								{true, false, true, false, false}};
		boolean[][] redPiece6 = {{false, true, true, false, false}, 
								{false, true, true, true, false},
								{true, true, true, true, true},
								{false, true, true, true, false},
								{true, true, false, true, true}};
		
		Model modelRed = new Model("Red");
		modelRed.addPiece(new Piece(redPiece1));
		modelRed.addPiece(new Piece(redPiece2));
		modelRed.addPiece(new Piece(redPiece3));
		modelRed.addPiece(new Piece(redPiece4));
		modelRed.addPiece(new Piece(redPiece5));
		modelRed.addPiece(new Piece(redPiece6));
		HappyCube hCubeRed = new HappyCube(modelRed);
		
		boolean[][] purplePiece1 = {{true, true, false, true, false}, 
									{true, true, true, true, false},
									{true, true, true, true, false},
									{false, true, true, true, true},
									{false, false, true, false, false}};		
		boolean[][] purplePiece2 = {{false, false, false, true, true}, 
									{true, true, true, true, false},
									{true, true, true, true, true},
									{false, true, true, true, false},
									{false, true, false, true, false}};
		boolean[][] purplePiece3 = {{false, true, false, false, false}, 
									{true, true, true, true, false},
									{false, true, true, true, true},
									{true, true, true, true, false},
									{false, false, true, false, false}};		
		boolean[][] purplePiece4 = {{true, true, false, true, true}, 
									{false, true, true, true, true},
									{true, true, true, true, false},
									{false, true, true, true, false},
									{false, true, false, true, false}};
		boolean[][] purplePiece5 = {{false, false, true, false, true}, 
									{false, true, true, true, true},
									{true, true, true, true, true},
									{true, true, true, true, false},
									{true, false, true, true, false}};
		boolean[][] purplePiece6 = {{false, true, false, true, true}, 
									{false, true, true, true, false},
									{false, true, true, true, true},
									{true, true, true, true, false},
									{true, true, false, true, false}};
		
		Model modelPurple = new Model("Purple");
		modelPurple.addPiece(new Piece(purplePiece1));
		modelPurple.addPiece(new Piece(purplePiece2));
		modelPurple.addPiece(new Piece(purplePiece3));
		modelPurple.addPiece(new Piece(purplePiece4));
		modelPurple.addPiece(new Piece(purplePiece5));
		modelPurple.addPiece(new Piece(purplePiece6));
		HappyCube hCubePurple = new HappyCube(modelPurple);
		
		boolean[][] yellowPiece1 = {{false, false, true, false, false}, 
									{true, true, true, true, false},
									{false, true, true, true, true},
									{true, true, true, true, false},
									{false, true, false, true, false}};

		boolean[][] yellowPiece2 = {{false, false, true, false, true}, 
									{true, true, true, true, true},
									{false, true, true, true, false},
									{true, true, true, true, false},
									{false, true, false, true, false}};		

		boolean[][] yellowPiece3 = {{false, false, true, false, true}, 
									{false, true, true, true, true},
									{true, true, true, true, false},
									{true, true, true, true, true},
									{true, false, true, false, false}};
		
		boolean[][] yellowPiece4 = {{true, false, true, false, true}, 
									{true, true, true, true, true},
									{false, true, true, true, false},
									{true, true, true, true, true},
									{true, false, true, false, false}};
		
		boolean[][] yellowPiece5 = {{false, false, true, false, false}, 
									{false, true, true, true, true},
									{true, true, true, true, false},
									{false, true, true, true, true},
									{true, true, false, true, false}};

		boolean[][] yellowPiece6 = {{false, true, false, true, false}, 
									{false, true, true, true, false},
									{true, true, true, true, true},
									{false, true, true, true, false},
									{false, true, false, true, true}};
		
		Model modelYellow = new Model("Yellow");
		modelYellow.addPiece(new Piece(yellowPiece1));
		modelYellow.addPiece(new Piece(yellowPiece2));
		modelYellow.addPiece(new Piece(yellowPiece3));
		modelYellow.addPiece(new Piece(yellowPiece4));
		modelYellow.addPiece(new Piece(yellowPiece5));
		modelYellow.addPiece(new Piece(yellowPiece6));
		HappyCube hCubeYellow = new HappyCube(modelYellow);	
		
		boolean[][] orangePiece1 = {{true, true, false, true, false}, 
									{false, true, true, true, true},
									{true, true, true, true, false},
									{false, true, true, true, false},
									{true, true, false, true, true}};
		boolean[][] orangePiece2 = {{false, false, true, false, false}, 
									{false, true, true, true, false},
									{true, true, true, true, true},
									{true, true, true, true, true},
									{false, false, true, false, false}};
		boolean[][] orangePiece3 = {{false, true, false, true, true}, 
									{true, true, true, true, false},
									{false, true, true, true, true},
									{true, true, true, true, false},
									{false, true, true, false, false}};		
		boolean[][] orangePiece4 = {{true, false, true, false, true}, 
									{true, true, true, true, true},
									{false, true, true, true, false},
									{false, true, true, true, true},
									{false, true, false, true, false}};
		boolean[][] orangePiece5 = {{false, false, true, false, false}, 
									{true, true, true, true, true},
									{false, true, true, true, false},
									{true, true, true, true, true},
									{true, false, true, false, true}};
		boolean[][] orangePiece6 = {{false, false, true, false, false}, 
									{false, true, true, true, false},
									{false, true, true, true, true},
									{true, true, true, true, false},
									{false, true, false, true, false}};
		
		Model modelOrange = new Model("Orange");
		modelOrange.addPiece(new Piece(orangePiece1));
		modelOrange.addPiece(new Piece(orangePiece2));
		modelOrange.addPiece(new Piece(orangePiece3));
		modelOrange.addPiece(new Piece(orangePiece4));
		modelOrange.addPiece(new Piece(orangePiece5));
		modelOrange.addPiece(new Piece(orangePiece6));
		HappyCube hCubeOrange = new HappyCube(modelOrange);
		
		hCubeBlue.solve();
		hCubeBlue.printSolutions();
		hCubeRed.solve();
		hCubeRed.printSolutions();
		hCubePurple.solve();
		hCubePurple.printSolutions();
		hCubeYellow.solve();
		hCubeYellow.printSolutions();
		hCubeOrange.solve();
		hCubeOrange.printSolutions();
	}
	
}
