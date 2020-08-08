package de.longuyen.drawing.crossover

import de.longuyen.drawing.poc.chromosome.CharChromosome
import java.lang.RuntimeException
import java.util.*
import kotlin.math.min

class CharCrossover : ICrossover<CharChromosome> {
    override fun mate(a: CharChromosome, b: CharChromosome) : CharChromosome {
        if(a.genes.size != b.genes.size){
            throw RuntimeException("Gene's size of chromosome a ${a.genes.size} is not the same as b's gene's size ${b.genes.size}.")
        }
        val random = Random()
        val crossPoint = min((random.nextInt(a.genes.size) + a.genes.size / 2), a.genes.size)
        val ret = CharChromosome(a.genes.copyOf(a.genes.size))
        for(i in a.genes.indices){
            if(i < crossPoint){
                ret.genes[i] = a.genes[i]
            }else{
                ret.genes[i] = b.genes[i]
            }
        }
        return ret
    }
}