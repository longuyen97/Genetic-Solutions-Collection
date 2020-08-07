package de.longuyen.poc

import java.lang.StringBuilder
import java.util.*

class Chromosome(var genes: CharArray) : Comparable<Chromosome> {
    fun mate(chromosome: Chromosome) : Chromosome   {
        val child = StringBuilder()
        val rn = Random()
        for(i in 0..genes.size){
            val p = rn.nextInt(100)
            if(p < 0.45){
                child.append(genes[i])
            }else{
                child.append(chromosome.genes[i])
            }
        }
        return Chromosome(child.toString().toCharArray())
    }

    fun fitness() : Int {
        var ret = 0
        for(i in genes.indices){
            if(genes[i] == TARGET[i]){
                ++ret
            }
        }
        return ret
    }

    override fun compareTo(other: Chromosome): Int {
        return this.fitness().compareTo(other.fitness())
    }
}