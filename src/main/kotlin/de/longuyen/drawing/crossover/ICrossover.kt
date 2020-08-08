package de.longuyen.drawing.crossover

import de.longuyen.drawing.poc.chromosome.IChromosome

interface ICrossover<K: IChromosome> {
    fun  mate(a: K, b: K) : K
}