package de.longuyen.poc.crossover

import de.longuyen.poc.chromosome.IChromosome

interface ICrossover<K: IChromosome> {
    fun  mate(a: K, b: K) : K
}