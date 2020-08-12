package de.longuyen.travelingsalesman

const val SANITY_CHECK = false

fun main(){
    val graph = CompleteGraph(10, 50, 100)
    val population = Population(100, graph)
    population.fitAndSort()
    println(graph)
    for(i in 0 until 1000){
        population.evolve()
        population.fitAndSort()
    }
    println("Genetic algorithm's solution: Shortest path ${population.fittest().fitness} - Longest path ${population.worst().fitness}")
}