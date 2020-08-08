package de.longuyen.drawing.select

import de.longuyen.drawing.poc.chromosome.CharChromosome

class CharSurvivorSelection : ISurvivorSelection<CharChromosome> {
    override fun select(population: List<CharChromosome>): List<Int> {
        return listOf(0, 1)

    }

    override fun sortOut(population: List<CharChromosome>): List<Int> {
        val size = population.size
        val ret = mutableListOf<Int>()
        for(i in size - 100 until size){
            ret.add(i)
        }
        return ret
    }

    override fun mutate(population: List<CharChromosome>): List<Int> {
        val size = population.size
        val ret = mutableListOf<Int>()
        for(i in size - 200 until size - 100){
            ret.add(i)
        }
        return ret
    }
}