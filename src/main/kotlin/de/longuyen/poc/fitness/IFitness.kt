package de.longuyen.poc.fitness

import de.longuyen.poc.chromosome.IChromosome

interface IFitness<K: IChromosome>{
    fun  compute(chromosome: K) : Double
}