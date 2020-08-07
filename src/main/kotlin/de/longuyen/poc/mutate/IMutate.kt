package de.longuyen.poc.mutate

import de.longuyen.poc.chromosome.IChromosome

interface IMutate<T: Comparable<T>> {
    fun<K: IChromosome<T>> mutate(chromosome: K) : K
}