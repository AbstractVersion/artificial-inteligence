package GeneticAlgorithm;

public class GeneticAlgorithm {
	private int popSize;
	private int geneNo;
	private int maxGeneration;
	private int tournamentSize;
	private double crossoverRate;
	private double mutationRate;
	private boolean elitism;
	private boolean displayResults;

	public GeneticAlgorithm(int popSize, int geneNo, 
			int maxGeneration, int tournamentSize, 
			double crossoverRate, double mutationRate, boolean elitism,
			boolean displayResults) {
		this.popSize = popSize;
		this.geneNo = geneNo;
		this.maxGeneration = maxGeneration;
		this.tournamentSize = tournamentSize;
		this.crossoverRate = crossoverRate;
		this.mutationRate = mutationRate;
		this.elitism = elitism;
		this.displayResults = displayResults;
	}


	// Selection 
	private Chromosome tournamentSelection(Population pop) {
		Population tournament = new Population(this.tournamentSize,
		                                       this.geneNo);
		for (int i = 0; i < tournamentSize; i++) {
			int randomId = (int) (Math.random() * 
			                       pop.getChromosomes().length);
			tournament.add(i, pop.getSingleChromosome(randomId));
		}
		Chromosome fittest = tournament.getFittest();
		return fittest;
	}


	// Crossover 
	private Chromosome crossover(Chromosome indiv1, Chromosome indiv2) {
		Chromosome newSol = new Chromosome(indiv1.getGeneNo());

		int singlePoint = (int) Math.floor(Math.random()*newSol.getGeneNo());  
		for (int i = 0; i < singlePoint; i++) {
			newSol.setSingleGene(i, indiv1.getSingleGene(i));
		}

		for (int i = singlePoint; i < newSol.getGeneNo(); i++) {
			newSol.setSingleGene(i, indiv2.getSingleGene(i));
		}

		return newSol;
	}

	// Mutation 
	private void mutate(Chromosome indiv) {
		for (int i = 0; i < indiv.getGeneNo(); i++) {
			if (Math.random() <= this.mutationRate) {
				int gene = (int) Math.round(Math.random());
				indiv.setSingleGene(i, gene);
			}
		}
	}
	
	private Population elitism(Population currentPop , 
	                           Population newPopulation) {
		Chromosome c = currentPop.getFittest();
		newPopulation.add(0, c);
		return newPopulation;
	}

	public Chromosome search() {
		Population currentPop = new Population(this.popSize, this.geneNo);
		currentPop.initialize(0.5);
		
		Population newPopulation;
		// Main loop
		for (int t = 0 ; t < this.maxGeneration ; t++) {
			newPopulation = new Population(this.popSize, this.geneNo);
			int elitismOffset = 0;

			// Elitism
			if (elitism) {
				newPopulation = elitism(currentPop , newPopulation);
			    elitismOffset = 1;
			} 
			else {
			    elitismOffset = 0;
			}
			
			
			for (int i = elitismOffset; i < this.popSize; i++) {
				// Select
				Chromosome indiv1 = tournamentSelection(currentPop);
				Chromosome indiv2 = tournamentSelection(currentPop);
				
				// Crossover
				Chromosome newIndiv = crossover(indiv1, indiv2);
				
				// Mutation
				if(Math.random() < this.mutationRate) {
					mutate(newIndiv);
				}
				
				if(Math.random() < this.crossoverRate) {
					newPopulation.add(i, newIndiv);
				}
				else {
					if(Math.random() < 0.5) {
						newPopulation.add(i, indiv1);
					}else {
						newPopulation.add(i, indiv2);
					}
				}
			}
 
			currentPop = newPopulation ;
			
			if (displayResults) {
				System.out.println("In generation#" + t+ " Fittest"+ 
			                        currentPop.getFittest().getFitness());
			}
		}
		
		return currentPop.getFittest();
	}

}
