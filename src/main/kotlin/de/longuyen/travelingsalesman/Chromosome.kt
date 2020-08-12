package de.longuyen.travelingsalesman

import java.util.*

class Chromosome(private val graph: CompleteGraph) {
    private val genes = mutableListOf<Vertex>()
    var fitness: Double = 0.0

    init {
        genes.addAll(graph.vertices.shuffled())
    }

    fun evaluate(): Double {
        fitness = 0.0
        for (i in 0 until genes.size - 1) {
            fitness += graph.distances[Edge(genes[i], genes[i + 1])]!!
        }
        fitness += graph.distances[Edge(genes.first(), genes.last())]!!
        return fitness
    }

    fun mutate(rate: Int = 5): Chromosome {
        val random = Random()
        val ret = Chromosome(graph)
        for (i in 0 until ret.genes.size) {
            if (random.nextInt(100) < rate) {
                while (true) {
                    val j = random.nextInt(ret.genes.size)
                    if (j != i) {
                        val temp = ret.genes[i]
                        ret.genes[i] = ret.genes[j]
                        ret.genes[j] = temp
                        break
                    }
                }
            }
        }
        if (SANITY_CHECK) {
            if (!ret.genes.containsAll(graph.vertices)) {
                throw Error("Loss of function. Child has ${HashSet(ret.genes).size} genes while the gene pool has ${graph.vertices.size} genes")
            }
        }
        return ret
    }

    fun crossover(chromosome: Chromosome): Chromosome {
        val random = Random()
        val ret = Chromosome(graph)
        if (random.nextInt() < 50) {
            for (i in 0 until genes.size) {
                ret.genes[i] = genes[i]
            }
            for (i in 0 until genes.size) {
                if (random.nextInt() < 5) {
                    val vertex = ret.genes[i]
                    val partnerIndex = chromosome.genes.indexOf(vertex)
                    ret.genes[i] = genes[partnerIndex]
                    ret.genes[partnerIndex] = vertex
                }
            }
        } else {
            for (i in 0 until chromosome.genes.size) {
                ret.genes[i] = chromosome.genes[i]
            }
            for (i in 0 until genes.size) {
                if (random.nextInt() < 5) {
                    val vertex = ret.genes[i]
                    val partnerIndex = genes.indexOf(vertex)
                    ret.genes[i] = genes[partnerIndex]
                    ret.genes[partnerIndex] = vertex
                }
            }
        }
        if (SANITY_CHECK) {
            if (!ret.genes.containsAll(graph.vertices)) {
                throw Error("Loss of function. Child has ${HashSet(ret.genes).size} genes while the gene pool has ${graph.vertices.size} genes")
            }
        }
        return ret
    }
}