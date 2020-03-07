package PathFinding_GA;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class Maze extends JComponent {

	// 1: Wall
	// 0: gap 
	// -1: starting point 
	// 9 : target point
	private int [][] maze = 
		{   {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1,0,9,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	        };
	
	private int[][] indexMatrix; 
	private Node[][] nodesMatrix;
	private Graph g;
	
	private int colNo;
	private int rowNo;
	
	private int blockSize;
	
	// Methods 
	
	public Maze() {
		this.blockSize = 40;
		this.rowNo = maze.length;
		this.colNo = maze[0].length;
		this.g = new Graph();
		this.nodesMatrix = new Node[this.rowNo][this.colNo];
		
		int idx = 1;
		for (int i = 0; i < this.rowNo ; i++) {
			for (int j = 0 ; j< this.colNo ; j++) {
				this.nodesMatrix[i][j] = new Node(idx);
				idx++;
			}
		}
		
		crateGraph();
		
		
	 
		
	}
	
	private void crateGraph() {
		List<Node> allNodes = new ArrayList<>();
		
		for (int i = 0; i < this.rowNo ; i++) {
			for (int j = 0 ; j< this.colNo ; j++) {
				 if (this.maze[i][j] == 1) {
					 this.nodesMatrix[i][j].setVisited(true);
				 }
				 
				 findAddNeighbours(i,j);
				 allNodes.add(nodesMatrix[i][j]);
			}
		}
		
		this.g.setAllNodes(allNodes);
		
	}
	
	
	private void findAddNeighbours(int row, int col) {
		int colNum = col;
		int rowNum = row;
		
		if( withinGrid(rowNum ,  colNum + 1 , this.rowNo, this.colNo ) ) {
			this.nodesMatrix[row][col].addNeighbour(this.nodesMatrix[rowNum][colNum+1]);
		}
		
		if(withinGrid(rowNum ,  colNum -1 , this.rowNo, this.colNo ) ) {
			this.nodesMatrix[row][col].addNeighbour(this.nodesMatrix[rowNum][colNum-1]);
		}
		
		if(withinGrid(rowNum +1,  colNum , this.rowNo, this.colNo ) ) {
			this.nodesMatrix[row][col].addNeighbour(this.nodesMatrix[rowNum+1][colNum]);
		}
		
		if(withinGrid(rowNum -1,  colNum , this.rowNo, this.colNo ) ) {
			this.nodesMatrix[row][col].addNeighbour(this.nodesMatrix[rowNum-1][colNum]);
		}
	}
	
	private boolean withinGrid(int rowNum, int colNum, int maxRow, int maxCol) {
		if(  (colNum < 0) || (rowNum < 0)   ) {
			return false;
		}
		
		if(  (colNum >= maxCol) || (rowNum >= maxRow)   ) {
			return false;
		}
		
		return true;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create(); 
		
		for (int i = 0; i < this.rowNo ; i++) {
			for (int j = 0 ; j< this.colNo ; j++) {
				Color color = null;
				switch (this.maze[i][j]) {
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
				g2.fillRect(j * this.blockSize, i * this.blockSize, this.blockSize, this.blockSize);
				g2.setColor(Color.GREEN);
				g2.drawString(this.nodesMatrix[i][j].getElement() + "" , j * this.blockSize + this.blockSize/2 , i * this.blockSize + this.blockSize/2);
				
			}
		}

		
		
	}

	public int[][] getMaze() {
		return maze;
	}

	public int[][] getIndexMatrix() {
		return indexMatrix;
	}

	public Node[][] getNodesMatrix() {
		return nodesMatrix;
	}

	public Graph getGraph() {
		return g;
	}

	public int getColNo() {
		return colNo;
	}

	public int getRowNo() {
		return rowNo;
	}

	public int getBlockSize() {
		return blockSize;
	}
	
	
	public int getStartingPoint() {
		int idx = 1;
		for (int i = 0; i < this.rowNo ; i++) {
			for (int j = 0 ; j< this.colNo ; j++) {
				if(this.maze[i][j] == -1) {
					return idx;
				}
				idx++;
			}
		}
		
		return 1;
	}
	
	
	
	public int getTargetPoint() {
		int idx = 1;
		for (int i = 0; i < this.rowNo ; i++) {
			for (int j = 0 ; j< this.colNo ; j++) {
				if(this.maze[i][j] == 9) {
					return idx;
				}
				idx++;
			}
		}
		
		return 1;
	}
	
	
	
}


