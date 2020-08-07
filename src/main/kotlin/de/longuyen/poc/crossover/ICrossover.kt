package de.longuyen.poc.crossover

import de.longuyen.poc.chromosome.IChromosome

interface ICrossover<T : Comparable<T>> {
    fun<K: IChromosome<T>>  crossover(a: K, b: K) : K
}