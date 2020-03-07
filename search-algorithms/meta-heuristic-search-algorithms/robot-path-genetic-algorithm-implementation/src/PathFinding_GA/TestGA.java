package PathFinding_GA;


import javax.swing.*; // new
import java.awt.*; // new
import java.util.*; // new
import java.util.List; // new


public class TestGA {
	public static void main(String[] args) {
		
				//New
		// Draw the maze
		JFrame f = new JFrame("The lovely maze");
		f.setSize(1000, 1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Maze maze = new Maze();
		f.add(maze);
		f.setVisible(true);
		
		
		GeneticAlgorithm GA_engine = new GeneticAlgorithm(
				100, 
				100, 
				100, 
				10, 
				0.90, 
				0.05, 
				true,
				true);
		
		GA_engine.search();
		

		
	}

}
