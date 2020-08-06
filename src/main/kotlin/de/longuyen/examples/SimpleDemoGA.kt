package de.longuyen

import java.util.*


/**
 *
 * @author Vijini
 */
//Main class
class SimpleDemoGA {
    var population = Population()
    var fittest: Individual? = null
    var secondFittest: Individual? = null
    var generationCount = 0
    //Selection
    fun selection() { //Select the most fittest individual
        fittest = population.getFittest()
        //Select the second most fittest individual
        secondFittest = population.secondFittest
    }

    //Crossover
    fun crossover() {
        val rn = Random()
        //Select a random crossover point
        val crossOverPoint = rn.nextInt(population.individuals[0]!!.geneLength)
        //Swap values among parents
        for (i in 0 until crossOverPoint) {
            val temp = fittest!!.genes[i]
            fittest!!.genes[i] = secondFittest!!.genes[i]
            secondFittest!!.genes[i] = temp
        }
    }

    //Mutation
    fun mutation() {
        val rn = Random()
        //Select a random mutation point
        var mutationPoint = rn.nextInt(population.individuals[0]!!.geneLength)
        //Flip values at the mutation point
        if (fittest!!.genes[mutationPoint] == 0) {
            fittest!!.genes[mutationPoint] = 1
        } else {
            fittest!!.genes[mutationPoint] = 0
        }
        mutationPoint = rn.nextInt(population.individuals[0]!!.geneLength)
        if (secondFittest!!.genes[mutationPoint] == 0) {
            secondFittest!!.genes[mutationPoint] = 1
        } else {
            secondFittest!!.genes[mutationPoint] = 0
        }
    }

    //Get fittest offspring
    val fittestOffspring: Individual?
        get() = if (fittest!!.fitness > secondFittest!!.fitness) {
            fittest
        } else secondFittest

    //Replace least fittest individual from most fittest offspring
    fun addFittestOffspring() { //Update fitness values of offspring
        fittest!!.calcFitness()
        secondFittest!!.calcFitness()
        //Get index of least fit individual
        val leastFittestIndex = population.leastFittestIndex
        //Replace least fittest individual from most fittest offspring
        population.individuals[leastFittestIndex] = fittestOffspring
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val rn = Random()
            val demo = SimpleDemoGA()
            //Initialize population
            demo.population.initializePopulation(10)
            //Calculate fitness of each individual
            demo.population.calculateFitness()
            println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest)
            //While population gets an individual with maximum fitness
            while (demo.population.fittest < 5) {
                ++demo.generationCount
                //Do selection
                demo.selection()
                //Do crossover
                demo.crossover()
                //Do mutation under a random probability
                if (rn.nextInt() % 7 < 5) {
                    demo.mutation()
                }
                //Add fittest offspring to population
                demo.addFittestOffspring()
                //Calculate new fitness value
                demo.population.calculateFitness()
                println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest)
            }
            println("\nSolution found in generation " + demo.generationCount)
            println("Fitness: " + demo.population.getFittest()!!.fitness)
            print("Genes: ")
            for (i in 0..4) {
                print(demo.population.getFittest()!!.genes[i])
            }
            println("")
        }
    }
}


//Individual class
internal class Individual {
    var fitness = 0
    var genes = IntArray(5)
    var geneLength = 5
    //Calculate fitness
    fun calcFitness() {
        fitness = 0
        for (i in 0..4) {
            if (genes[i] == 1) {
                ++fitness
            }
        }
    }

    init {
        val rn = Random()
        //Set genes randomly for each individual
        for (i in genes.indices) {
            genes[i] = Math.abs(rn.nextInt() % 2)
        }
        fitness = 0
    }
}

//Population class
internal class Population {
    var popSize = 10
    var individuals = arrayOfNulls<Individual>(10)
    var fittest = 0
    //Initialize population
    fun initializePopulation(size: Int) {
        for (i in individuals.indices) {
            individuals[i] = Individual()
        }
    }

    //Get the fittest individual
    fun getFittest(): Individual? {
        var maxFit = Int.MIN_VALUE
        var maxFitIndex = 0
        for (i in individuals.indices) {
            if (maxFit <= individuals[i]!!.fitness) {
                maxFit = individuals[i]!!.fitness
                maxFitIndex = i
            }
        }
        fittest = individuals[maxFitIndex]!!.fitness
        return individuals[maxFitIndex]
    }

    //Get the second most fittest individual
    val secondFittest: Individual?
        get() {
            var maxFit1 = 0
            var maxFit2 = 0
            for (i in individuals.indices) {
                if (individuals[i]!!.fitness > individuals[maxFit1]!!.fitness) {
                    maxFit2 = maxFit1
                    maxFit1 = i
                } else if (individuals[i]!!.fitness > individuals[maxFit2]!!.fitness) {
                    maxFit2 = i
                }
            }
            return individuals[maxFit2]
        }

    //Get index of least fittest individual
    val leastFittestIndex: Int
        get() {
            var minFitVal = Int.MAX_VALUE
            var minFitIndex = 0
            for (i in individuals.indices) {
                if (minFitVal >= individuals[i]!!.fitness) {
                    minFitVal = individuals[i]!!.fitness
                    minFitIndex = i
                }
            }
            return minFitIndex
        }

    //Calculate fitness of each individual
    fun calculateFitness() {
        for (i in individuals.indices) {
            individuals[i]!!.calcFitness()
        }
        getFittest()
    }
}
