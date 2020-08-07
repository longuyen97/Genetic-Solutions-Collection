package de.longuyen.poc.mutate

import de.longuyen.poc.chromosome.IChromosome

interface IMutate<K: IChromosome> {
    fun mutate(chromosome: K)
}