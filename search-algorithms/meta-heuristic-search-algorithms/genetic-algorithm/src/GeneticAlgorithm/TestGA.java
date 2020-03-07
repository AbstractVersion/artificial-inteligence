package GeneticAlgorithm;

public class TestGA {
	public static void main(String[] args) {
		GeneticAlgorithm GA_engine = new GeneticAlgorithm(
				50, 
				200, 
				1000, 
				10, 
				0.90, 
				0.05, 
				true,
				true);
		
		GA_engine.search();
	}

}
