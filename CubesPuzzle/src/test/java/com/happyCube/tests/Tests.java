package com.happyCube.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.happyCube.HappyCube;
import com.happyCube.Model;
import com.happyCube.Piece;

public class Tests {

	@Test
	public void test() {
		boolean[][] testPiece1 = {{true, true, false, false, false}, 
									{true, true, true, true, true},
									{false, true, true, true, false},
									{false, true, true, true, true},
									{false, true, false, true, false}};

		boolean[][] testPiece2 = {{false, false, true, true, false}, 
									{true, true, true, true, false},
									{true, true, true, true, false},
									{false, true, true, true, true},
									{false, false, true, false, true}};		
		
		boolean[][] testPiece3 = {{true, false, true, false, true}, 
									{true, true, true, true, true},
									{false, true, true, true, false},
									{false, true, true, true, false},
									{false, false, true, true, false}};
		
		boolean[][] testPiece4 = {{false, true, false, true, false}, 
									{false, true, true, true, false},
									{true, true, true, true, false},
									{true, true, true, true, true},									
									{false, false, true, true, true}};		
		
		boolean[][] testPiece5 = { { false, true, false, true, false },
									{ false, true, true, true, true },
									{ true, true, true, true, false },
									{ false, true, true, true, true },
									{ true, true, false, false, true } };
		
		boolean[][] testPiece6 = {{false, false, true, true, false}, 
									{false, true, true, true, false},
									{true, true, true, true, true},
									{false, true, true, true, false},									
									{true, true, true, false, false}};		
					
		Model modelTest = new Model("Test");
		modelTest.addPiece(new Piece(testPiece1));
		modelTest.addPiece(new Piece(testPiece2));
		modelTest.addPiece(new Piece(testPiece3));
		modelTest.addPiece(new Piece(testPiece4));
		modelTest.addPiece(new Piece(testPiece5));
		modelTest.addPiece(new Piece(testPiece6));
		HappyCube hCubeTest = new HappyCube(modelTest);
		hCubeTest.solve();
		
		boolean[][] solutionTest1 = {{true, true, false, false, false},
									 {true, true, true, true, true},
									 {false, true, true, true, false},
									 {false, true, true, true, true},
									 {false, true, false, true, false}};
		
		boolean[][] solutionTest2 = {{false, false, true, true, false},
									 {false, true, true, true, false},
									 {true, true, true, true, true},
									 {false, true, true, true, true},
									 {true, true, false, false, false}};
		
		boolean[][] solutionTest3 = {{true, false, true, false, false},
									 {true, true, true, true, true},
									 {false, true, true, true, false},
									 {false, true, true, true, true},
									 {true, true, false, true, false}};
		
		boolean[][] solutionTest4 = {{true, true, false, false, false},
									 {false, true, true, true, false},
									 {true, true, true, true, true},
									 {false, true, true, true, true},
									 {true, true, false, false, false}};
		
		boolean[][] solutionTest5 = {{false, false, false, true, true},
									 {true, true, true, true, true},
									 {false, true, true, true, true},
									 {true, true, true, true, false},
									 {false, false, true, true, false}};
		
		boolean[][] solutionTest6 = {{false, false, true, true, true},
									 {false, true, true, true, false},
									 {true, true, true, true, true},
									 {false, true, true, true, false},
									 {false, true, true, false, false}};		
		
		List<Model> solutionsCubeTest = hCubeTest.getSolutions();
		if(solutionsCubeTest.size() == 2) {
			Model model1 = solutionsCubeTest.get(0);
			assertTrue("First piece OK",Arrays.deepEquals(model1.get(0).getBitMap(), solutionTest1));
			assertTrue("Second piece OK",Arrays.deepEquals(model1.get(1).getBitMap(), solutionTest2));
			assertTrue("Third piece OK",Arrays.deepEquals(model1.get(2).getBitMap(), solutionTest3));
			assertTrue("Fourth piece OK",Arrays.deepEquals(model1.get(3).getBitMap(), solutionTest4));
			assertTrue("Fifth piece OK",Arrays.deepEquals(model1.get(4).getBitMap(), solutionTest5));
			assertTrue("Sixth piece OK",Arrays.deepEquals(model1.get(5).getBitMap(), solutionTest6));
		} else {
			fail("Test has failed");
		}
	}

}
