package GeneticAlgorithm;

public class Population {
	private Chromosome[] chromosomes;
	
	public Population(int chromNo , int geneNo) {
		chromosomes = new Chromosome[chromNo];
		for(int i = 0; i<chromNo ; i++) {
			chromosomes[i] = new Chromosome(geneNo);
		}
	}
	
	public void initialize(double p) {
		for(int i = 0; i<this.chromosomes.length ; i++) {
			chromosomes[i].initialize(0.5);
		}
	}
	
	public Chromosome getFittest() {
		double min = Double.MAX_VALUE;
		Chromosome bestChrom = null;
		
		for(int i = 0; i<this.chromosomes.length ; i++) {
			if(this.chromosomes[i].getFitness() < min) {
				min = this.chromosomes[i].getFitness();
				bestChrom = this.chromosomes[i];
			}
		}
		return bestChrom;
	}
	
	public Chromosome[] getChromosomes() {
		return this.chromosomes;
	}
	
	public Chromosome getSingleChromosome(int i) {
		return this.chromosomes[i];
	}
	
	public void add(int i, Chromosome c) {
		c.setFitness(FitnessFunction.evaluate(c.getGenes()));
		this.chromosomes[i] = c;
	}
}
