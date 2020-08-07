package de.longuyen.poc.fitness

import de.longuyen.poc.Chromosome
import de.longuyen.poc.chromosome.IChromosome

interface IFitness<T: Comparable<T>> {
    fun<K: IChromosome<T>>  fitness(chromosome: K) : Double
}