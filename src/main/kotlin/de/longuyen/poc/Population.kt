package de.longuyen.poc

import java.lang.StringBuilder
import java.util.*

const val GENES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890, .-;:_!%&/()=?@"
const val TARGET = "Failure is a step to success"

class Population {
    var chromosomes = arrayOfNulls<Chromosome>(100)

    init {
        for(i in chromosomes.indices){
            val gene = StringBuilder()
            val rn = Random()
            for(i in TARGET.indices){
                gene.append(GENES[rn.nextInt(GENES.length)])
            }
            chromosomes[i] = Chromosome(gene.toString().toCharArray())
        }
    }

    fun fittest() : Chromosome  {
        Arrays.sort(chromosomes)
        return chromosomes.last()!!
    }

    fun secondFittest() : Chromosome {
        Arrays.sort(chromosomes)
        return chromosomes[chromosomes.size - 2]!!
    }

    fun leastFit() : Chromosome {
        Arrays.sort(chromosomes)
        return chromosomes[0]!!
    }

}