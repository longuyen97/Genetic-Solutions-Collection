package de.longuyen.poc.mutate

import de.longuyen.poc.chromosome.CharChromosome
import java.util.*

const val ALPHABET = "abcdefghijklmnopqrstuvwxyz "

class CharMutate : IMutate<CharChromosome> {
    override fun mutate(chromosome: CharChromosome) {
        val random = Random()
        val start = random.nextInt(chromosome.genes.size)
        for(i in start until chromosome.genes.size){
            chromosome.genes[i] = ALPHABET[(ALPHABET.indexOf(chromosome.genes[i]) + 1) % ALPHABET.length]
        }
    }
}