package GeneticAlgorithm;

public class FitnessFunction {
	public static double evaluate(Object[] genes) {
		double sum = 0;
		
		for(Object g : genes) {
			sum = sum + (int) g;
		}
		
		return sum;
	}
}
