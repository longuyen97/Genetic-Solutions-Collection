package de.longuyen.drawing.mutate

import de.longuyen.drawing.poc.chromosome.IChromosome

interface IMutate<K: IChromosome> {
    fun mutate(chromosome: K)
}