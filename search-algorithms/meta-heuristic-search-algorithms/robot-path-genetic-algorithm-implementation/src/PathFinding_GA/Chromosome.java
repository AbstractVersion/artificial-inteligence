package PathFinding_GA;

public class Chromosome {
	private Object[] genes;
	private double fitness;
	private int geneNo;
	
	// Constructors 
	public Chromosome(int geneNo) {
		this.genes = new Object[geneNo];
		this.geneNo = geneNo;
	}
	
	public Chromosome() {
		this.genes = new Object[geneNo];
	}
	
	// Methods
	public void initialize(double p) {
		for(int i = 0 ; i<this.geneNo;i++) {
			if (Math.random() < p ) {
				genes[i] = 0;
			}
			else {
				genes[i] = 1;
			}
		}
		
		this.setFitness(FitnessFunction.evaluate(this.genes));
		
	}

	public Object getSingleGene(int i) {
		return this.genes[i];
	}
	
	public void setSingleGene(int i, Object o) {
		this.genes[i] = o;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public int getGeneNo() {
		return geneNo;
	}
	
	public Object[] getGenes() {
		return this.genes;
	}
}
