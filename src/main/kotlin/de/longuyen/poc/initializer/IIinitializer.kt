package de.longuyen.poc.initializer

import de.longuyen.poc.chromosome.IChromosome

interface IIinitializer<K: IChromosome>{
    fun generate() : K
}