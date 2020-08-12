package de.longuyen.nqueen

import java.lang.StringBuilder
import java.util.*

class Chromosome {
    private var genes = mutableListOf<Int>()
    var fitness = 0.0

    init {
        val random = Random()
        for (i in ALPHABET.indices) {
            genes.add(ALPHABET[random.nextInt(ALPHABET.size)])
        }
        genes.shuffle()
    }

    fun evaluate(): Double {
        fitness = 0.0
        for (i in 0 until genes.size) {
            for (j in i + 1 until genes.size) {
                if (genes[i] == genes[j]) {
                    fitness -= 1.0
                } else if (genes[j] - genes[i] == j - i || genes[i] - genes[j] == i - j) {
                    fitness -= 1.0
                } else {
                    fitness += 1.0
                }
            }
        }
        return fitness
    }

    fun mutate(prob: Int = 5): Chromosome {
        val child = Chromosome()
        val random = Random()
        for (i in child.genes.indices) {
            if (random.nextInt(100) < prob) {
                child.genes[i] = ALPHABET[random.nextInt(ALPHABET.size)]
            }
        }
        return child
    }


    fun crossover(partner: Chromosome): Chromosome {
        val child = Chromosome()
        val random = Random()
        for (i in genes.indices) {
            if (random.nextDouble() < 0.5) {
                child.genes[i] = this.genes[i]
            } else {
                child.genes[i] = partner.genes[i]
            }
        }
        return child
    }

    override fun toString(): String {
        val ret = StringBuilder()
        ret.append(genes.joinToString(" "))
        ret.append("\n")
        for (y in 0 until 8) {
            for (x in 0 until 8) {
                if (genes[y] == x + 1) {
                    ret.append("1")
                } else {
                    ret.append("0")
                }
            }
            ret.append("\n")
        }
        return ret.toString()
    }
}