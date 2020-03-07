package PathFinding_GA;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class FinalPath extends JComponent {
	
	private List<Node> nodeVisited;
	private Maze maze;
	
	public FinalPath(Maze maze, List<Node> nodeVisited) {
		this.nodeVisited = nodeVisited;
		this.maze = maze;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create(); 
		int mazeColNo = maze.getColNo();
		int mazeRowNo = maze.getRowNo();
		int blockSize = maze.getBlockSize();
		
		// Visualize the maze
		for (int i = 0; i < mazeRowNo ; i++) {
			for (int j = 0 ; j< mazeColNo ; j++) {
				Color color = null;
				switch (maze.getMaze()[i][j]) {
				case 1: 
					color = color.GRAY;
					break;
				case -1: 
					color = color.RED;
					break;
				case 9: 
					color = color.BLUE;
					break;
				default:
					color = color.WHITE;
						
				}
				
				g2.setColor(color);
				g2.fillRect(j * blockSize, i * blockSize, blockSize, blockSize);
			
				
			}
		}

		
		// Visualize the path obtained by GA
		
		int idx , i, j;
		int nodeOrder = 0;
		
		for(Node n : nodeVisited) {
			idx = (int) n.getElement();
			i = idx / mazeColNo;
			j = idx % (mazeColNo) - 1;
			
			g2.setColor(Color.ORANGE);
			g2.fillRect(j*blockSize, i*blockSize, blockSize, blockSize);
			
			g2.setColor(Color.BLACK);
			g2.drawString(nodeOrder + "", j*blockSize + blockSize/2,
					i*blockSize + blockSize/2);
			nodeOrder++;
		}
		
		Node n = nodeVisited.get(0);
		idx = (int) n.getElement();
		i = idx / mazeColNo;
		j = idx % (mazeColNo) - 1;
		g2.setColor(Color.RED);
		g2.fillRect(j*blockSize, i*blockSize, blockSize, blockSize);
		
		
		
	}

}
