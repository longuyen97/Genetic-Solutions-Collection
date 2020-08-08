package de.longuyen.drawing.initializer

import de.longuyen.drawing.poc.chromosome.IChromosome

interface IIinitializer<K: IChromosome>{
    fun generate() : K
}