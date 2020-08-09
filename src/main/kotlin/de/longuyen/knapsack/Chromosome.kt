package de.longuyen.knapsack

import java.lang.IllegalArgumentException
import java.lang.StringBuilder
import java.util.*

class Chromosome(private val context: Context) {
    private val random = Random()
    private val genes = BooleanArray(context.itemCount)
    var fitness: Long = 0
    var weights: Long = 0

    init {
        for(i in 0 until context.itemCount){
            genes[i] = random.nextBoolean()
        }
    }

    fun express() : String{
        val ret = StringBuilder()
        for(i in genes.indices){
            if(genes[i]){
                ret.append("1")
            }else{
                ret.append("0")
            }
        }
        return ret.toString()
    }

    fun fit(){
        fitness = 0
        weights = 0
        for(i in genes.indices){
            if(genes[i]){
                fitness += context.profits[i]
                weights += context.weights[i]
                if(weights > context.capacity){
                    fitness = 0
                    break
                }
            }
        }
    }

    fun mutate() : Chromosome{
        val child = Chromosome(context)
        for(i in 0 until context.itemCount){
            if(random.nextInt(100) < context.mutationProbability){
                child.genes[i] = genes[i].not()
            }
        }
        return child
    }


    fun crossover(partner: Chromosome) : Chromosome {
        if(this.genes.size != partner.genes.size){
            throw IllegalArgumentException("This chromosome has ${genes.size} genes. Mean while the other chromosome has ${partner.genes.size} genes")
        }
        val child = Chromosome(context)
        for(i in genes.indices){
            if(random.nextDouble() < 0.5){
                child.genes[i] = this.genes[i]
            }else{
                child.genes[i] = partner.genes[i]
            }
        }
        return child
    }
}