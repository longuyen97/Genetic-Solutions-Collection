package de.longuyen.drawing.fitness

import de.longuyen.drawing.poc.chromosome.IChromosome

interface IFitness<K: IChromosome>{
    fun  compute(chromosome: K) : Double
}