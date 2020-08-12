package de.longuyen.travelingsalesman

const val SANITY_CHECK = false

fun main(){
    val graph = CompleteGraph(4, 50, 100)
    val population = Population(100, graph)
    population.fitAndSort()

    for(i in 0 until 100000){
        population.evolve()
        population.fitAndSort()
        println("Fittest ${population.fittest().fitness} - Worst ${population.worst().fitness}")
    }
}