package de.longuyen.shapespearemonkey

import java.lang.IllegalArgumentException
import java.util.*


class Chromosome(private val length: Int, initialGenes: String? = null){
    private val genes : CharArray = CharArray(length)
    private val random : Random = Random()
    var fitness: Float = 0f

    init {
        if(initialGenes == null) {
            for (i in 0 until length) {
                genes[i] = ALPHABET[random.nextInt(ALPHABET.size)]
            }
        }else{
            for (i in 0 until length) {
                genes[i] = initialGenes[i]
            }
        }
    }

    fun geneExpression(): String{
        return genes.concatToString()
    }

    fun fit(target: String) {
        if(target.length != genes.size){
            throw IllegalArgumentException("The target string can not be matched because of unmatched size")
        }
        fitness = 0f
        for(i in target.indices){
            if(target[i] == genes[i]){
                fitness += 1f
            }
        }
    }

    fun crossover(partner: Chromosome) : Chromosome {
        if(this.length != partner.length){
            throw IllegalArgumentException("This chromosome has $length genes. Mean while the other chromosome has ${partner.length} genes")
        }
        val child = Chromosome(this.length)

        for(i in genes.indices){
            if(random.nextDouble() < 0.5){
                child.genes[i] = this.genes[i]
            }else{
                child.genes[i] = partner.genes[i]
            }
        }

        return child
    }

    fun mutate(rate: Int) : Chromosome {
        val mutated = Chromosome(length)
        for(i in genes.indices){
            if(random.nextInt(100) < rate){
                mutated.genes[i] = ALPHABET[random.nextInt(ALPHABET.size)]
            }else{
                mutated.genes[i] = genes[i]
            }
        }
        return mutated
    }
}